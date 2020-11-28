package com.iced.hf2020.Utilities;

public class Patient {

    private String firstName, lastName, middleName, maritalStatus, contactNumber,relativeFullName, relativeContactNumber;
    private MedicalCondition condition;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String middleName, String maritalStatus, String contactNumber, String relativeFullName, String relativeContactNumber, MedicalCondition condition) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.maritalStatus = maritalStatus;
        this.contactNumber = contactNumber;
        this.relativeFullName = relativeFullName;
        this.relativeContactNumber = relativeContactNumber;
        this.condition = condition;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getRelativeFullName() {
        return relativeFullName;
    }

    public void setRelativeFullName(String relativeFullName) {
        this.relativeFullName = relativeFullName;
    }

    public String getRelativeContactNumber() {
        return relativeContactNumber;
    }

    public void setRelativeContactNumber(String relativeContactNumber) {
        this.relativeContactNumber = relativeContactNumber;
    }

    public MedicalCondition getCondition() {
        return condition;
    }

    public void setCondition(MedicalCondition condition) {
        this.condition = condition;
    }
}
