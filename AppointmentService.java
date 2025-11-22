package appointment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages appointment creation and retrieval.
 */
public class AppointmentService {
    private List<Appointment> appointments = new ArrayList<>();

    // Add appointment if no time conflict exists for the user
    public boolean addAppointment(int userId, LocalDateTime start, LocalDateTime end, String description) {
        for (Appointment a : appointments) {
            if (a.getUserId() == userId &&
                a.getStartTime().isBefore(end) &&
                a.getEndTime().isAfter(start)) {
                return false; // Conflict detected
            }
        }
        appointments.add(new Appointment(appointments.size() + 1, userId, start, end, description));
        return true;
    }

    // Get all appointments of a user
    public List<Appointment> getUserAppointments(int userId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getUserId() == userId) {
                result.add(a);
            }
        }
        return result;
    }
}
