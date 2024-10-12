package com.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedEntity {

    @Id
    private String medicationName;
    private String category;
    private String legality;
    private String dosageRestriction;
    private String requiredDocuments;
    private String source;
    private String countryImage;
    private String medicationImage;
    private String countryName;
	public MedEntity() {
    	
    }
	public MedEntity(String medicationName, String category, String legality, String dosageRestriction,
			String requiredDocuments, String source, String countryImage, String medicationImage,String countryName) {
		super();
		this.medicationName = medicationName;
		this.category = category;
		this.legality = legality;
		this.dosageRestriction = dosageRestriction;
		this.requiredDocuments = requiredDocuments;
		this.source = source;
		this.countryImage = countryImage;
		this.medicationImage=medicationImage;
		this.countryName=countryName;
	}
	public String getMedicationName() {
		return medicationName;
	}
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLegality() {
		return legality;
	}
	public void setLegality(String legality) {
		this.legality = legality;
	}
	public String getDosageRestriction() {
		return dosageRestriction;
	}
	public void setDosageRestriction(String dosageRestriction) {
		this.dosageRestriction = dosageRestriction;
	}
	public String getRequiredDocuments() {
		return requiredDocuments;
	}
	public void setRequiredDocuments(String requiredDocuments) {
		this.requiredDocuments = requiredDocuments;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getCountryImage() {
		return countryImage;
	}
	public void setCountryImage(String countryImage) {
		this.countryImage = countryImage;
	}
	 public String getMedicationImage() {
			return medicationImage;
		}
		public void setMedicationImage(String medicationImage) {
			this.medicationImage = medicationImage;
		}
		public String getCountryName() {
			return countryName;
		}
		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}
		

}
