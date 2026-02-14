package com.assignmentt1_14thfeb;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedicalRecord {
	
	@Id
	private int medical_id;
	private String blood_group;
	private String allergies;
	public int getMedical_id() {
		return medical_id;
	}
	public void setMedical_id(int medical_id) {
		this.medical_id = medical_id;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	@Override
	public String toString() {
		return "MedicalRecord [medical_id=" + medical_id + ", blood_group=" + blood_group + ", allergies=" + allergies
				+ "]";
	}
	

}
