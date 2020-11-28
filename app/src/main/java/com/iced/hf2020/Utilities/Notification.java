package com.iced.hf2020.Utilities;

public class Notification {

    private String fromUid;
    private String notificationMessage;
    private String notificationType;

    private String hospitalId;


    public class Type{
        public static final int DOCTOR_INVITE = 0;
        public static final int NURSE_INVITE = 1;
        public static final int PATIENT_ADMIT = 2;
        public static final int PATIENT_RELEASE = 3;
        public static final int RUNNER_JOB = 4;
        public static final int NORMAL_NOTIFICATION = 5;
    }

    public Notification(String fromUid, String notificationMessage, String notificationType) {
        this.fromUid = fromUid;
        this.notificationMessage = notificationMessage;
        this.notificationType = notificationType;
    }

    public String getFromUid() {
        return fromUid;
    }

    public void setFromUid(String fromUid) {
        this.fromUid = fromUid;
    }

    public String getNotificationMessage() {
        return notificationMessage;
    }

    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }
}
