package assignments.a2code;

import javafx.event.ActionEvent;

import java.time.LocalDate;
import java.time.LocalTime;

public class NewProjectController {
    private ProjectModel model;
    public NewProjectController() {}

    public void setModel(ProjectModel newModel) { model = newModel; }

    public void addProject() { model.addProject(); }

    public void handleDescription(String desc) {model.addDescription(desc); }

    public void handleTitle(String title) { model.addTitle(title); }

    public void handleTime(LocalTime timer) { model.addTracker(timer); }

    public void handleStartDate(LocalDate date) { model.addStartDate(date); }

    public void handleEndDate(ActionEvent event, LocalDate date) { model.addEndDate(date); }
}
