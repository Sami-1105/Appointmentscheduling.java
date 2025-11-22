import reporting.ReportService;
import user.User;
import user.UserService;

import java.time.LocalDateTime;
import java.util.List;

import appointment.Appointment;
import appointment.AppointmentService;

/**
 * Main application entry point.
 */
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        AppointmentService appointmentService = new AppointmentService();
        ReportService reportService = new ReportService();

        // Register and authenticate user
        userService.register("alice", "password123", "customer");
        User user = userService.authenticate("alice", "password123");

        if (user != null) {
            System.out.println("User logged in: " + user.getUsername());

            // Schedule an appointment
            boolean added = appointmentService.addAppointment(
                user.getId(),
                LocalDateTime.of(2025, 11, 25, 9, 0),
                LocalDateTime.of(2025, 11, 25, 10, 0),
                "Dental Checkup"
            );

            if (added) {
                System.out.println("Appointment scheduled successfully.");
            } else {
                System.out.println("Failed to schedule appointment due to conflict.");
            }

            // Retrieve and print appointments
            List<Appointment> appointments = appointmentService.getUserAppointments(user.getId());
            reportService.printUserReport(appointments);
        } else {
            System.out.println("Authentication failed.");
        }
    }
}
