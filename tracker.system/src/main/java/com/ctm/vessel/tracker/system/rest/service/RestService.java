package com.ctm.vessel.tracker.system.rest.service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.ctm.vessel.tracker.system.model.MapBounds;
import com.ctm.vessel.tracker.system.model.Token;
import com.ctm.vessel.tracker.system.model.Track;
import com.ctm.vessel.tracker.system.model.Vessel;
import com.ctm.vessel.tracker.system.model.googlesearch.CseImage;
import com.ctm.vessel.tracker.system.model.googlesearch.Example;
import com.ctm.vessel.tracker.system.model.googlesearch.Item;
import com.ctm.vessel.tracker.system.model.googlesearch.Pagemap;

@Service
public class RestService {
	private static final Logger log = LogManager.getLogger(RestService.class);
	private static final String API_AIS_URL = "https://www.barentswatch.no/bwapi/";
	private static final String OPEN_VESSELS_POSITIONS = API_AIS_URL + "v2/geodata/ais/openpositions"; 
	private static final String TOKEN_REFRESH_URL = "https://id.barentswatch.no/connect/token";
	private static final String OPEN_VESSEL_URL = "https://www.barentswatch.no/bwapi/v1/geodata/vessel/open/";
	private static final String GOOGLE_SEARCH_API_KEY = "AIzaSyCV5i-5j-5bm6GZkD2tFNRLmX5jliqMqsI";
	
	private RestTemplate restTemplate = new RestTemplate();
	private String token;

	@Value("${api.clientId}")
	private String clientId;
	@Value("${api.clientSecret}")
	private String clientSecret;

	public RestService() {}

	public boolean refreshToken() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("client_id", clientId);
		body.add("client_secret", clientSecret);
		body.add("grant_type", "client_credentials");
		body.add("scope", "api");

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(body, headers);

		ResponseEntity<Token> response = restTemplate.postForEntity(TOKEN_REFRESH_URL, entity, Token.class);

		Optional<Token> token = Optional.ofNullable(response.getBody());
		Optional<String> accesToken = Optional.ofNullable(response.getBody().getAccessToken());
		accesToken.ifPresentOrElse(
			ok -> {
				log.info("Response:{}", token.get().toString());
				setToken(accesToken.get());
				}, 
			() -> log.error("Error while getting new tokken: {}", token.get().toString()));

		return accesToken.isPresent();
	}

	public Track[] getRequestForVesselsPositions(Optional<MapBounds> mapBounds) {
		refreshToken();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(body, headers);

		String url = OPEN_VESSELS_POSITIONS + "?Xmin=10.09094&Xmax=10.97047&Ymin=59.3989&Ymax=61.58645";
		if (mapBounds.isPresent()) {
			UriComponentsBuilder.newInstance();
			UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(OPEN_VESSELS_POSITIONS)
					.queryParam("Xmin", formatDouble(mapBounds.get().getMinX()))
					.queryParam("Xmax", formatDouble(mapBounds.get().getMaxX()))
					.queryParam("Ymin", formatDouble(mapBounds.get().getMinY()))
					.queryParam("Ymax", formatDouble(mapBounds.get().getMaxY())).build();
			url = uriBuilder.toString();
		}
		log.info("Strzelam do: " + url);
		ResponseEntity<Track[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, Track[].class);
		Stream.of(response.getBody()).forEach(e -> log.info(e.toString()));
		return response.getBody();
	}
	
	public Vessel getVesselByMMSI(Long mmsi) {
		refreshToken();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(body, headers);
		String url = OPEN_VESSEL_URL + mmsi;
		log.info("Request to: " + url);
		ResponseEntity<Vessel> response = restTemplate.exchange(url, HttpMethod.GET, entity, Vessel.class);
		Stream.of(response.getBody()).forEach(e -> log.info(e.toString()));
		return response.getBody();
	}
	
	public String getGoogleSearchEngineForImagePathOfQuery(String query) {
		refreshToken();
		String url = "https://customsearch.googleapis.com/customsearch/v1?cx=9de8e229296fe6e53&q=" +  query + "&key=" + GOOGLE_SEARCH_API_KEY;
		log.info("Request to: " + url);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(body, headers);
		ResponseEntity<Example> response = restTemplate.exchange(url, HttpMethod.GET, entity, Example.class);
		Optional<Item> item = Optional.ofNullable(response.getBody().getItems().get(0));
		
		String srcPath ="";
		if(item.isPresent()) {
			Optional<Pagemap> pageMap = Optional.ofNullable(item.get().getPagemap());
			if(pageMap.isPresent()) {
				Optional<List<CseImage>> cseImage = Optional.ofNullable(pageMap.get().getCseImage());
				if(cseImage.isPresent() && cseImage.get().size() >= 1) {
					srcPath = cseImage.get().get(0).getSrc();
				}
			}
		}
		return srcPath;
	}
	
	protected Double formatDouble (Double x) {
		DecimalFormat df = new DecimalFormat("#.#####");
    	df.setRoundingMode(RoundingMode.CEILING);
    	try {
        	return Double.valueOf(df.format(x));
    	} catch (Exception e) {
    		log.error("", e);
    		return x;
    	}
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
