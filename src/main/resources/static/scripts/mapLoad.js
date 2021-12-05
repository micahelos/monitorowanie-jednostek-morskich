  	var map = L.map('map').setView([59.911491, 10.757933], 10);
	
	var leafletIcon = L.icon ({
		iconUrl: '/ship.png',
		iconSize: [30, 30],
		iconAnchor: [15,10],
	})
	
	var leafletPort = L.icon ({
		iconUrl: '/port.png',
		iconSize: [30, 30],
		iconAnchor: [15,5],
	})
	
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);
	L.control.zoom({ position: "bottomright" }).addTo(map);
   
	
	var locations = [
		['AB11 5HW','17','A',57.147701,-2.085442 ] ,
		['AB11 8DG','3','B',57.129372,-2.090916 ]
		];


		

	
	
    var markers = new L.FeatureGroup();
    var portsmarkers = new L.FeatureGroup();
	//background tile set
	var tileLayer = {'Vessel group:' : L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        		attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
			})
	};
	var overlayMaps = {};


    map.on("zoomend", readVessel); 
    map.on("moveend", readVessel); 
    
    readVessel();
	var layerscontrol = L.control.layers(tileLayer, overlayMaps, {position:'topleft'}).addTo(map);

 	function readVessel() { 
    	const bounds = map.getBounds();
    	const zoom = map.getZoom();
    	console.log(bounds);
    	var tracks = httpGetTracks("/map?xMin=" +  bounds.getSouthWest().lng + "&xMax=" + bounds.getNorthEast().lng 
    			+ "&yMin=" +  bounds.getSouthWest().lat + "&yMax=" + bounds.getNorthEast().lat + "&zoom=" + zoom);
    	var ports = httpGetPorts("/portsbybound?xMin=" +  bounds.getSouthWest().lng + "&xMax=" + bounds.getNorthEast().lng 
    			+ "&yMin=" +  bounds.getSouthWest().lat + "&yMax=" + bounds.getNorthEast().lat + "&zoom=" + zoom);		
    }


    function readVesselsMarkers(obj) {
//      map.addLayer(markers);
    	//add the groups of markers to layerGroups
		var markersA = [];
		var markersB = [];

    	obj.forEach(value => {
            var polygon;
            var marker = L.marker([value.x, value.y], {icon:leafletIcon});
                marker.bindPopup('<b>Vessel Name:</b> ' + value.name + '<br/>' +
                '<b>Ship Type:</b> '+ value.shipType + '<br/>' +
                '<b>Destination:</b> ' + value.destinationPortname + '/' + value.destinationPortCountry + '<br/>' +
                '<a href=/vessels/' + value.mmsi + '><b>About this vessel... </b></a>' + '<br/>' + 
                '<a href=' + '"javascript:void(0)" ' + ' onClick="center(['+ value.destinationX + ',' + value.destinationY + '],10,[' + value.x +',' +value.y + ']);">See destination... </a>')
                .openPopup()
                .on('mouseover', () => {
                    polygon = L.polygon([
                        [value.x, value.y],
                        [value.destinationX, value.destinationY],
                    ]).addTo(map);
                })
                .on('mouseout', () => {
                    map.removeLayer(polygon);
                });
//                markers.addLayer(marker);
                if (value.destinationPortname.toLowerCase().indexOf("unknown") === -1) {
                	console.log("addToA" + value.destinationPortname.toLowerCase());
                	markersA.push(marker);
                } else {
                	console.log("addToB" + value.destinationPortname.toLowerCase());
                	markersB.push(marker);
                }
        })
    	//Control on the Top Left that handles the switching between A and B
    	var groupA = L.layerGroup(markersA);
        var groupB = L.layerGroup(markersB);
        map.addLayer(groupA);
        overlayMaps = {
    	    "With destination port": groupA,
    	    "Unknown destination port": groupB
    	};
        if(layerscontrol != undefined) {
        	layerscontrol.remove();
        }
        layerscontrol = L.control.layers(tileLayer, overlayMaps, {position:'topleft'}).addTo(map);
        
    }
   
   function center(x, zoom, value) { 
   	  console.log("center " + x + " " + zoom + " ", value);
      var polygon;
	  polygon = L.polygon([
	        [value[0], value[1]],
	        [x[0], x[1]],
	    ]).addTo(map);
   	  map.setView(x,zoom).on('click', () => { map.removeLayer(polygon);});
   }
   
   function readPortMarkers(obj) {
   		obj.forEach(value => {
   		var portMarker = L.marker([value.latitude, value.longitude], {icon:leafletPort});
   		portMarker.bindPopup('<b>Port Name:</b> ' + value.portname + '<br/>' +
	            '<b>Port Type:</b> '+ value.prttype + '<br/>' + 
	            '<a href=/port/' + value.fid + '> About this Port... </a>' )
	            .openPopup();
			portsmarkers.addLayer(portMarker);
		});
   		map.addLayer(portsmarkers);
   } 
   
    
    function removeAllMarkers(toRemove){
        map.removeLayer(toRemove);
    }
    
    function httpGetTracks(url)
    {
    	removeAllMarkers(markers);
    	fetch(url)
    	.then(res => res.json())
    	.then(out =>
    		readVesselsMarkers(out));
    } 
    
     function httpGetPorts(url)
    {
    	removeAllMarkers(portsmarkers);
    	fetch(url)
    	.then(res => res.json())
    	.then(out =>
    		readPortMarkers(out));
    } 