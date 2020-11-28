package com.iced.hf2020.Utilities;

import java.util.List;

public class MedicalCondition {

    private String medicalHistory, sickness, status;
    private List<Symptom> symptoms;

    public MedicalCondition() {
    }

    public MedicalCondition(String medicalHistory, String sickness, String status, List<Symptom> symptoms) {
        this.medicalHistory = medicalHistory;
        this.sickness = sickness;
        this.status = status;
        this.symptoms = symptoms;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getSickness() {
        return sickness;
    }

    public void setSickness(String sickness) {
        this.sickness = sickness;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }
}
