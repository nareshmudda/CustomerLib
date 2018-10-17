package com.citibank.CustomerJpaLibrary.Entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateTs;

	@Version
	private Long version;

	@Access(AccessType.PROPERTY)
	public Date getLastUpdateTs() {
		return new Date();
	}
}
