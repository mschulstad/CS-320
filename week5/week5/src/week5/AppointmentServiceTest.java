package week5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class AppointmentServiceTest {
	private AppointmentService appointmentService;
	private Appointment validAppointment;
	
    @BeforeEach
    void setUp() throws ParseException {
    appointmentService = new AppointmentService();
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date appointmentDate = dateFormat.parse("06/21/2024");
    validAppointment = new Appointment("12345", appointmentDate, "Dentist appointment");
}
    @Test
    void testAddAppointment(){ 
        appointmentService.addAppointment(validAppointment);
        assertEquals( validAppointment, appointmentService.getAppointment("1234567"));
    }
    @Test
    void testAddAppointmentDupId(){
    	appointmentService.addAppointment(validAppointment);
    	 SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
         Date anotherDate = new Date(System.currentTimeMillis() + 200000);
         Appointment dupAppointment = new Appointment("12345", anotherDate, "Doctor appointment");

        appointmentService.addAppointment(validAppointment);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(dupAppointment);
        });
    }
    @Test
    void testDeleteAppointment(){
    	appointmentService.addAppointment(validAppointment);
        appointmentService.deleteAppointment("12345");
        assertNull(appointmentService.getAppointment("12345"));
    }
    @Test
    void testDeleteNonexistentAppointment() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("1234");
        });
    }
    
}
