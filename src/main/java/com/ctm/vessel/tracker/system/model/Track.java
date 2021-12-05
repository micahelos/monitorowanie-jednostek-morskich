
package com.ctm.vessel.tracker.system.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "timeStamp",
    "sog",
    "rot",
    "navstat",
    "mmsi",
    "cog",
    "geometry",
    "shipType",
    "name",
    "imo",
    "callsign",
    "country",
    "eta",
    "destination",
    "isSurvey",
    "heading",
    "draught",
    "a",
    "b",
    "c",
    "d"
})
@Generated("jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Track {

    @JsonProperty("timeStamp")
    private String timeStamp;
    @JsonProperty("sog")
    private int sog;
    @JsonProperty("rot")
    private Object rot;
    @JsonProperty("navstat")
    private int navstat;
    @JsonProperty("mmsi")
    private int mmsi;
    @JsonProperty("cog")
    private Object cog;
    @JsonProperty("geometry")
    private Geometry geometry;
    @JsonProperty("shipType")
    private int shipType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("imo")
    private Object imo;
    @JsonProperty("callsign")
    private String callsign;
    @JsonProperty("country")
    private String country;
    @JsonProperty("eta")
    private String eta;
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("isSurvey")
    private boolean isSurvey;
    @JsonProperty("heading")
    private Object heading;
    @JsonProperty("draught")
    private double draught;
    @JsonProperty("a")
    private int a;
    @JsonProperty("b")
    private int b;
    @JsonProperty("c")
    private int c;
    @JsonProperty("d")
    private int d;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("timeStamp")
    public String getTimeStamp() {
        return timeStamp;
    }

    @JsonProperty("timeStamp")
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @JsonProperty("sog")
    public int getSog() {
        return sog;
    }

    @JsonProperty("sog")
    public void setSog(int sog) {
        this.sog = sog;
    }

    @JsonProperty("rot")
    public Object getRot() {
        return rot;
    }

    @JsonProperty("rot")
    public void setRot(Object rot) {
        this.rot = rot;
    }

    @JsonProperty("navstat")
    public int getNavstat() {
        return navstat;
    }

    @JsonProperty("navstat")
    public void setNavstat(int navstat) {
        this.navstat = navstat;
    }

    @JsonProperty("mmsi")
    public int getMmsi() {
        return mmsi;
    }

    @JsonProperty("mmsi")
    public void setMmsi(int mmsi) {
        this.mmsi = mmsi;
    }

    @JsonProperty("cog")
    public Object getCog() {
        return cog;
    }

    @JsonProperty("cog")
    public void setCog(Object cog) {
        this.cog = cog;
    }

    @JsonProperty("geometry")
    public Geometry getGeometry() {
        return geometry;
    }

    @JsonProperty("geometry")
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @JsonProperty("shipType")
    public int getShipType() {
        return shipType;
    }

    @JsonProperty("shipType")
    public void setShipType(int shipType) {
        this.shipType = shipType;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("imo")
    public Object getImo() {
        return imo;
    }

    @JsonProperty("imo")
    public void setImo(Object imo) {
        this.imo = imo;
    }

    @JsonProperty("callsign")
    public String getCallsign() {
        return callsign;
    }

    @JsonProperty("callsign")
    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("eta")
    public String getEta() {
        return eta;
    }

    @JsonProperty("eta")
    public void setEta(String eta) {
        this.eta = eta;
    }

    @JsonProperty("destination")
    public String getDestination() {
        return destination;
    }

    @JsonProperty("destination")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @JsonProperty("isSurvey")
    public boolean isIsSurvey() {
        return isSurvey;
    }

    @JsonProperty("isSurvey")
    public void setIsSurvey(boolean isSurvey) {
        this.isSurvey = isSurvey;
    }

    @JsonProperty("heading")
    public Object getHeading() {
        return heading;
    }

    @JsonProperty("heading")
    public void setHeading(Object heading) {
        this.heading = heading;
    }

    @JsonProperty("draught")
    public double getDraught() {
        return draught;
    }

    @JsonProperty("draught")
    public void setDraught(double draught) {
        this.draught = draught;
    }

    @JsonProperty("a")
    public int getA() {
        return a;
    }

    @JsonProperty("a")
    public void setA(int a) {
        this.a = a;
    }

    @JsonProperty("b")
    public int getB() {
        return b;
    }

    @JsonProperty("b")
    public void setB(int b) {
        this.b = b;
    }

    @JsonProperty("c")
    public int getC() {
        return c;
    }

    @JsonProperty("c")
    public void setC(int c) {
        this.c = c;
    }

    @JsonProperty("d")
    public int getD() {
        return d;
    }

    @JsonProperty("d")
    public void setD(int d) {
        this.d = d;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "Track [timeStamp=" + timeStamp + ", sog=" + sog + ", rot=" + rot + ", navstat=" + navstat + ", mmsi="
				+ mmsi + ", cog=" + cog + ", geometry=" + geometry + ", shipType=" + shipType + ", name=" + name
				+ ", imo=" + imo + ", callsign=" + callsign + ", country=" + country + ", eta=" + eta + ", destination="
				+ destination + ", isSurvey=" + isSurvey + ", heading=" + heading + ", draught=" + draught + ", a=" + a
				+ ", b=" + b + ", c=" + c + ", d=" + d + ", additionalProperties=" + additionalProperties + "]";
	}
}
