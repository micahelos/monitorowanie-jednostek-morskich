package com.ctm.vessel.tracker.system.shiptype.entity;

import javax.persistence.*;

@Entity
@Table(name = "shiptype")
public class Shiptype {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "id_group")
	private String idGroup;
	private String classification;
	
	public Shiptype() {
		super();
	}

	public Shiptype(long id, String idGroup, String classification) {
		this.id = id;
		this.idGroup = idGroup;
		this.classification = classification;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(String idGroup) {
		this.idGroup = idGroup;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	@Override
	public String toString() {
		return "Shiptype [id=" + id + ", idGroup=" + idGroup + ", classification=" + classification + "]";
	}
}
