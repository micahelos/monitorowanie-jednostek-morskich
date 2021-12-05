package com.ctm.vessel.tracker.system.ports.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "wld_trs_ports_wfp")
public class Port {
	@Id
	private String fid;
	private String portname;
	private String code;
	private String prttype;
	private String prtsize;
	private String status;
	private Integer maxdepth;
	private Integer maxlength;
	private Integer annualcapacitymt;
	private String humuse;
	private String locprecision;
	private Double latitude;
	private Double longitude;
	private String iso3;
	private String iso3_op;
	private String lastcheckdate;
	private String remarks;
	private String url_lca;
	private String source;
	private Date createdate;
	private Date updatedate ;
	private Integer geonameid;
	private String gdb_geomattr_data;
	private String shape;
	private String country;
	
	
}
