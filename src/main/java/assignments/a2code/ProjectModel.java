package assignments.a2code;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class ProjectModel {
    private  Project currentProject;
    private ArrayList<TTrackSubscriber> subs = new ArrayList<>();


    private  ObservableList<Project> projectList = FXCollections.observableArrayList();

    public ProjectModel() {}


    public Project getCurrentProject() { return currentProject; }

    public ObservableList<Project> getProjectList() { return projectList; }

    public void setCurrentProject(Project project) { currentProject = project; }
    /** Add the current selected project to the list*/
    public void addProject() {
        projectList.add(currentProject);
        notifySubs();
    }
    public void addTitle(String title) {
        currentProject = new Project();
        currentProject.setTitle_name(title);
        notifySubs();
    }

    public void addTracker(LocalTime tracker) {
        currentProject.setTracker_timer(tracker);
        notifySubs();
    }

    public void addStartDate(LocalDate start_date) {
        currentProject.setStart_date(start_date);
        notifySubs();
    }

    public void addEndDate(LocalDate end_date) {
        currentProject.setEnd_date(end_date);
        notifySubs();
    }
    public void addDescription(String desc) {
        currentProject.setDescription(desc);
        notifySubs();
    }



    public void addSubscriber(TTrackSubscriber newSub) { subs.add(newSub); }

    private void notifySubs() { subs.forEach(TTrackSubscriber::modelUpdated); }

}
