package com.jotakinhan.Palvelinprojekti.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Device {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // auto-generated id
	private String type; // type of the device(phone, tablet, laptop)
	private String model; // model number of the device
	private String defect; // description of the problem with device
	private String date; // date the device arrived
	private String state; // current state of the repair
	private double price; // overall costs of repair
	
	public Device() {
		super();
		this.type = null;
		this.model = null;
		this.defect = null;
		this.date = null;
		this.state = null;
		this.price = 0;
	}
	
	public Device(String type, String model, String defect, String date, String state, double price) {
		super();
		this.type = type;
		this.model = model;
		this.defect = defect;
		this.date = date;
		this.state = state;
		this.price = price;
	}
	
	public Long getId() { // setters and getters
		return id;
	}

	public String getType() {
		return type;
	}

	public String getModel() {
		return model;
	}

	public String getDefect() {
		return defect;
	}

	public String getDate() {
		return date;
	}
	
	public String getState() {
		return state;
	}

	public double getPrice() {
		return price;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setDefect(String defect) {
		this.defect = defect;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public void setState(String state) {
		this.state = state;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}