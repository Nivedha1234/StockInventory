package com.kossine.ims.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
@NamedQueries({
@NamedQuery(query = "Select e from PowerSupply e where e.powerSupplyTag= :tag", name = "PowerSupply.getByTag")
})
@Entity
@Table(name="powersupply")
public class PowerSupply extends Inventory {
	@Column(name = "powersupply_tag", unique = true, nullable = false)
	@Pattern(regexp = "^PWS/\\w+/\\w+/\\d+$")
	private String powerSupplyTag;
	private String brand;
	@Column(name = "serial_num")
	private String serialNum;
	private String location;
	private Boolean used;
	@OneToOne(mappedBy="powersupply")
	@Transient
	private Pc pc;
	public PowerSupply() {
		super("PowerSupply", PowerSupply.class);
	}

	public String getPowersupplyTag() {
		return powerSupplyTag;
	}

	public void setPowersupplyTag(String powersupplyTag) {
		this.powerSupplyTag = powersupplyTag;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}

	@Override
	public String toString() {
		return "PowerSupply [powersupplyTag=" + powerSupplyTag + ", brand=" + brand + ", serialNum=" + serialNum
				+ ", location=" + location + ", used=" + used + "]";
	}
}
