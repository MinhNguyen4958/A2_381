package assignments.a2code;

import javafx.event.ActionEvent;

import java.time.LocalDate;
import java.time.LocalTime;

public class NewProjectController {
    Project model;
    public NewProjectController() {}

    public void setModel(Project newModel) { model = newModel; }

    public void handleTitle(ActionEvent event, String title) { model.addTitle(title); }
    public void handleTime(ActionEvent event, LocalTime timer) { model.addTime(timer); }
    public void handleStartDate(ActionEvent event, LocalDate date) { model.addStartDate(date); }
    public void handleEndDate(ActionEvent event, LocalDate date) { model.addEndDate(date); }
}
