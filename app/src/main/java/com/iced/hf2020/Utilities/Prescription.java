package com.iced.hf2020.Utilities;

public class Prescription {
    private String medicaiton;
    private String dosage;

    public Prescription() {
    }

    public Prescription(String medicaiton, String dosage) {
        this.medicaiton = medicaiton;
        this.dosage = dosage;
    }

    public String getMedicaiton() {
        return medicaiton;
    }

    public void setMedicaiton(String medicaiton) {
        this.medicaiton = medicaiton;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
}
