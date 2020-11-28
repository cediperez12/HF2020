package com.iced.hf2020.Utilities;

public class Symptom {

    private String symptom;
    private long dateTime;

    public Symptom() {
    }

    public Symptom(String symptom, long dateTime) {
        this.symptom = symptom;
        this.dateTime = dateTime;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }
}
