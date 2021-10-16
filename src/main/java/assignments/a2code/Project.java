package assignments.a2code;

import javafx.util.Duration;
import java.time.LocalDate;
import java.time.LocalTime;


public class Project {
    private String title_name;
    private String description;
    private LocalTime tracker_timer;
    private LocalDate start_date;
    private LocalDate end_date;

    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }

    public void setDescription(String description) { this.description = description; }

    public void setTracker_timer(LocalTime tracker_timer) {
        this.tracker_timer = tracker_timer;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }
}
