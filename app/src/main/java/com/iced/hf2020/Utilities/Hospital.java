package com.iced.hf2020.Utilities;

import java.util.List;

public class Hospital {
    private String pushId;
    private String hospitalName;
    private String managerUid;
    private List<String> nurse;
    private List<String> doctors;

    public Hospital() {
    }

    public Hospital(String pushId, String hospitalName, String managerUid, List<String> nurse, List<String> doctors) {
        this.pushId = pushId;
        this.hospitalName = hospitalName;
        this.managerUid = managerUid;
        this.nurse = nurse;
        this.doctors = doctors;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getManagerUid() {
        return managerUid;
    }

    public void setManagerUid(String managerUid) {
        this.managerUid = managerUid;
    }

    public List<String> getNurse() {
        return nurse;
    }

    public void setNurse(List<String> nurse) {
        this.nurse = nurse;
    }

    public List<String> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<String> doctors) {
        this.doctors = doctors;
    }
}
