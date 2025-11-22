package reporting;

import java.util.List;

import appointment.Appointment;

/**
 * Generates reports from appointment data.
 */
public class ReportService {
    public void printUserReport(List<Appointment> appointments) {
        System.out.println("User Appointment Report:");
        for (Appointment a : appointments) {
            System.out.println("ID: " + a.getId() + ", Time: " + a.getStartTime() + " to " + a.getEndTime() +
                ", Status: " + a.getStatus() + ", Description: " + a.getDescription());
        }
        System.out.println("Total Appointments: " + appointments.size());
    }
}
