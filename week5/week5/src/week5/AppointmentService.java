package week5;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

    private final Map<String, Appointment> appointments = new HashMap<>();

    // Add a new appointment with a unique ID
    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    // Delete an appointment by appointment ID
    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID does not exist");
        }
        appointments.remove(appointmentId);
    }
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}

