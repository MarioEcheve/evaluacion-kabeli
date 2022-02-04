package com.kabeli.evaluacion.mario.echeverria.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "phone")
public class Phone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_phone")
	private Integer idPhone;

	@Column(name = "number_phone")
	private String number;

	@Column(name = "citycode")
	private String citycode;

	@Column(name = "contrycode")
	private String contrycode;


	public Integer getIdPhone() {
		return idPhone;
	}

	public void setIdPhone(Integer idPhone) {
		this.idPhone = idPhone;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getContrycode() {
		return contrycode;
	}

	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
