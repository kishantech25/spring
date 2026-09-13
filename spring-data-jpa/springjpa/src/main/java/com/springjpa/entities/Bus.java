package com.springjpa.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "bus")
@Builder
@Data
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bus_no")
	private int busNo;
	@Column(name = "rta_registration_no")
	private String rtaRegistrationNo;
	@Column(name = "chasis_no")
	private String chasisNo;
	@Column(name = "engine_no")
	private String engineNo;
	@Column(name = "date_of_registration")
	private LocalDate dateOfRegistration;
	private String model;
	private String manufacturer;
	private double price;

}
