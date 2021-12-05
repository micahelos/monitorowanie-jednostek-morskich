package com.ctm.vessel.tracker.system.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "sog", "navstat", "mmsi", "cog", "shipType", "name", "imo", "country", "isSurvey", "draught", "a",
		"b", "c", "d", "shipRegister", "aisName", "ircs", "shipRegisterName", "ais", "isWellBoat" })
@Generated("jsonschema2pojo")
public class Vessel {

	@JsonProperty("sog")
	private Integer sog;
	@JsonProperty("navstat")
	private Integer navstat;
	@JsonProperty("mmsi")
	private Integer mmsi;
	@JsonProperty("cog")
	private Double cog;
	@JsonProperty("shipType")
	private Integer shipType;
	@JsonProperty("name")
	private String name;
	@JsonProperty("imo")
	private Integer imo;
	@JsonProperty("country")
	private String country;
	@JsonProperty("isSurvey")
	private Boolean isSurvey;
	@JsonProperty("draught")
	private Double draught;
	@JsonProperty("a")
	private Integer a;
	@JsonProperty("b")
	private Integer b;
	@JsonProperty("c")
	private Integer c;
	@JsonProperty("d")
	private Integer d;
	@JsonProperty("shipRegister")
	private Boolean shipRegister;
	@JsonProperty("aisName")
	private String aisName;
	@JsonProperty("ircs")
	private String ircs;
	@JsonProperty("shipRegisterName")
	private String shipRegisterName;
	@JsonProperty("ais")
	private Boolean ais;
	@JsonProperty("isWellBoat")
	private Boolean isWellBoat;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("sog")
	public Integer getSog() {
		return sog;
	}

	@JsonProperty("sog")
	public void setSog(Integer sog) {
		this.sog = sog;
	}

	@JsonProperty("navstat")
	public Integer getNavstat() {
		return navstat;
	}

	@JsonProperty("navstat")
	public void setNavstat(Integer navstat) {
		this.navstat = navstat;
	}

	@JsonProperty("mmsi")
	public Integer getMmsi() {
		return mmsi;
	}

	@JsonProperty("mmsi")
	public void setMmsi(Integer mmsi) {
		this.mmsi = mmsi;
	}

	@JsonProperty("cog")
	public Double getCog() {
		return cog;
	}

	@JsonProperty("cog")
	public void setCog(Double cog) {
		this.cog = cog;
	}

	@JsonProperty("shipType")
	public Integer getShipType() {
		return shipType;
	}

	@JsonProperty("shipType")
	public void setShipType(Integer shipType) {
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
	public Integer getImo() {
		return imo;
	}

	@JsonProperty("imo")
	public void setImo(Integer imo) {
		this.imo = imo;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("isSurvey")
	public Boolean getIsSurvey() {
		return isSurvey;
	}

	@JsonProperty("isSurvey")
	public void setIsSurvey(Boolean isSurvey) {
		this.isSurvey = isSurvey;
	}

	@JsonProperty("draught")
	public Double getDraught() {
		return draught;
	}

	@JsonProperty("draught")
	public void setDraught(Double draught) {
		this.draught = draught;
	}

	@JsonProperty("a")
	public Integer getA() {
		return a;
	}

	@JsonProperty("a")
	public void setA(Integer a) {
		this.a = a;
	}

	@JsonProperty("b")
	public Integer getB() {
		return b;
	}

	@JsonProperty("b")
	public void setB(Integer b) {
		this.b = b;
	}

	@JsonProperty("c")
	public Integer getC() {
		return c;
	}

	@JsonProperty("c")
	public void setC(Integer c) {
		this.c = c;
	}

	@JsonProperty("d")
	public Integer getD() {
		return d;
	}

	@JsonProperty("d")
	public void setD(Integer d) {
		this.d = d;
	}

	@JsonProperty("shipRegister")
	public Boolean getShipRegister() {
		return shipRegister;
	}

	@JsonProperty("shipRegister")
	public void setShipRegister(Boolean shipRegister) {
		this.shipRegister = shipRegister;
	}

	@JsonProperty("aisName")
	public String getAisName() {
		return aisName;
	}

	@JsonProperty("aisName")
	public void setAisName(String aisName) {
		this.aisName = aisName;
	}

	@JsonProperty("ircs")
	public String getIrcs() {
		return ircs;
	}

	@JsonProperty("ircs")
	public void setIrcs(String ircs) {
		this.ircs = ircs;
	}

	@JsonProperty("shipRegisterName")
	public String getShipRegisterName() {
		return shipRegisterName;
	}

	@JsonProperty("shipRegisterName")
	public void setShipRegisterName(String shipRegisterName) {
		this.shipRegisterName = shipRegisterName;
	}

	@JsonProperty("ais")
	public Boolean getAis() {
		return ais;
	}

	@JsonProperty("ais")
	public void setAis(Boolean ais) {
		this.ais = ais;
	}

	@JsonProperty("isWellBoat")
	public Boolean getIsWellBoat() {
		return isWellBoat;
	}

	@JsonProperty("isWellBoat")
	public void setIsWellBoat(Boolean isWellBoat) {
		this.isWellBoat = isWellBoat;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}