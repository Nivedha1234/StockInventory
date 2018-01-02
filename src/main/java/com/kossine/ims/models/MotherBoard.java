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
@NamedQuery(query = "Select e from MotherBoard e where e.motherBoardTag= :tag", name = "MotherBoard.getByTag")
})
@Entity
@Table(name="motherboard")
public class MotherBoard extends Inventory {
	@Column(name = "motherboard_tag", unique = true, nullable = false)
	@Pattern(regexp = "^MTB/\\w+/\\w+/\\d+$")
	private String motherBoardTag;
	private String brand;
	@Column(name = "serial_num")
	private String serialNum;
	@Column(name = "model_num")
	private String modelNum;
	private Boolean vt;
	private String location;
	private Boolean used;
	@OneToOne(mappedBy="motherboard")
	@Transient
	private Pc pc;
	public MotherBoard() {
		super("MotherBoard", MotherBoard.class);
	}

	public String getMotherboardTag() {
		return motherBoardTag;
	}

	public void setMotherboardTag(String motherBoardTag) {
		this.motherBoardTag = motherBoardTag;
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

	public String getModelNum() {
		return modelNum;
	}

	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}

	public Boolean getVt() {
		return vt;
	}

	public void setVt(Boolean vt) {
		this.vt = vt;
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
		return "MotherBoard [motherboardTag=" + motherBoardTag + ", brand=" + brand + ", serialNum=" + serialNum
				+ ", modelNum=" + modelNum + ", vt=" + vt + ", location=" + location + ", used=" + used + "]";
	}
}
