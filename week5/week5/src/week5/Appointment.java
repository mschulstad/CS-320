package week5;

import java.util.Date;

public class Appointment{
    private final String appointmentId;
    private Date apptTime; 
    private String apptDescr; 

    public Appointment(String appointmentId, Date apptTime, String apptDescr){
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        if (apptTime == null || apptTime.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment time");
        }
        if (apptDescr == null || apptDescr.length() > 50) {
            throw new IllegalArgumentException("Invalid appointment description");
        }

        this.appointmentId = appointmentId;
        this.apptTime = apptTime;
        this.apptDescr = apptDescr;
    }

    public String getAppointmentId(){
        return appointmentId;
    }

    public Date getApptTime(){
        return apptTime;
    }

    public void setApptTime(Date apptTime){
        if (apptTime == null || apptTime.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment time");
        }
        this.apptTime = apptTime;
    }

    public String getApptDescr(){
        return apptDescr;
    }

    public void setApptDescr(String apptDescr){
        if (apptDescr == null || apptDescr.length() > 50) {
            throw new IllegalArgumentException("Invalid appointment description");
        }
        this.apptDescr = apptDescr;
    }

}
