package week5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class AppointmentTest { 
	
    private Date parseDate(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.parse(date);
    }

    @Test
	void testAppointment() throws ParseException {
    	Date appointmentDate = parseDate("06/21/2024");
        Appointment appointment = new Appointment("123456", appointmentDate, "doctors appointment");
        assertTrue(appointment.getAppointmentId().equals("123456"));
        assertTrue(appointment.getApptTime().equals(appointmentDate));
        assertTrue(appointment.getApptDescr().equals("doctors appointment"));
    }
    @Test
	void testAppointmentAppointmentIdToLong(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date appointmentDate = parseDate("06/21/2024");
			new Appointment("1234567891011", appointmentDate, "doctors appointment"); 
		});
	}
    @Test
	void testAppointmentAppointmentIdNull(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date appointmentDate = parseDate("06/21/2024");
			new Appointment(null, appointmentDate, "doctors appointment"); 
		});
	}
    @Test
    void testAppointmentApptTimePast(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	Date pastDate = parseDate("06/21/2021");
        	new Appointment("123456", pastDate, "doctors appointment");
        });
    }
    @Test
    void testAppointmentApptTimeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123456", null, "doctors appointment");
        });
    }
    @Test
    void testAppointmentApptDescrToLong(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	Date appointmentDate = parseDate("06/21/2024");
        	new Appointment("123456", appointmentDate, "doctors appointment for pain in ankle X-rays will likely be need and ankle brace");
        });
    }
}
