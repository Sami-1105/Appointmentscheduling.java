package appointment;

import java.time.LocalDateTime;

/**
 * Represents an appointment entity.
 */
public class Appointment {
    private int id;
    private int userId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;
    private String status; // e.g., scheduled, finished, canceled, etc.

    public Appointment(int id, int userId, LocalDateTime startTime, LocalDateTime endTime, String description) {
        this.id = id;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.status = "scheduled";
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
