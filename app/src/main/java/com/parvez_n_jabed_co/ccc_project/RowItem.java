package com.parvez_n_jabed_co.ccc_project;

public class RowItem {

	private String hospital_name;
	private int hospital_pic_id;
	private String hospital_email;
	private String hospital_mobile;

	public RowItem(String hospital_name, int hospital_pic_id, String hospital_email, String hospital_mobile) {

		this.hospital_name = hospital_name;
		this.hospital_pic_id = hospital_pic_id;
		this.hospital_email = hospital_email;
		this.hospital_mobile = hospital_mobile;
	}

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	public int getHospital_pic_id() {
		return hospital_pic_id;
	}

	public void setHospital_pic_id(int hospital_pic_id) {
		this.hospital_pic_id = hospital_pic_id;
	}

	public String getHospital_email() {
		return hospital_email;
	}

	public void setHospital_email(String hospital_email) {
		this.hospital_email = hospital_email;
	}

	public String getHospital_mobile() {
		return hospital_mobile;
	}

	public void setHospital_mobile(String hospital_mobile) {
		this.hospital_mobile = hospital_mobile;
	}

}