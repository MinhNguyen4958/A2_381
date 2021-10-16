package assignments.a2code;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.time.LocalTime;

public class NewProjectView extends Pane implements TTrackSubscriber {
    private VBox root;

    private HBox second_root;
    private VBox NP_Title;
    private VBox Date_Time;

    private HBox buttons;

    private Label New_Project;

    private Label title;
    private TextField title_box;
    private TextArea desc_box;

    private Label pick_time;
    private ToggleGroup timerGroup;
    private RadioButton currentTimeBtn;
    private RadioButton customTimeBtn;
    private DatePicker calendar;

    private Button AddProject;
    private Button back_btn;

    //model
    ProjectModel projectList;

    //controller
    NewProjectController controller;

    public Button getAddProject() {
        return AddProject;
    }

    public NewProjectView() {

        //Initializes all the boxes
        root = new VBox(10);
        root.setPadding(new Insets(10, 0, 0,0));
        root.setAlignment(Pos.BASELINE_CENTER);

        second_root = new HBox(5);
        NP_Title = new VBox(5);
        NP_Title.setPadding(new Insets(0,0,0,10));
        NP_Title.setAlignment(Pos.TOP_CENTER);

        Date_Time = new VBox(10);

        buttons = new HBox(40);
        buttons.setAlignment(Pos.CENTER);


        New_Project = new Label("New Project");
        New_Project.setFont(Font.font(25.0));
        title = new Label("Project's title:");
        Label desc_title = new Label("Description");
        title_box = new TextField();

        desc_box = new TextArea();
        desc_box.setWrapText(true);
        desc_box.setPrefSize(200, 100);



        pick_time = new Label("Pick a time:");

        timerGroup = new ToggleGroup();
        currentTimeBtn = new RadioButton("Current time");
        customTimeBtn = new RadioButton("Custom date");
        currentTimeBtn.setToggleGroup(timerGroup);
        AddProject = new Button("Add Project");
        calendar = new DatePicker();
        // initially set the calendar's visibility to false
        calendar.setVisible(false);

        currentTimeBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            calendar.setVisible(false);
        });

        customTimeBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            calendar.setVisible(true);
        });


        AddProject.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
            // add the tile typed in the box to the project
            controller.handleTitle(title_box.getText());
            controller.handleDescription(desc_box.getText());
            //If the current time button is selected then add the current time to the tracker
            if (currentTimeBtn.isSelected()) {
                controller.handleTime(LocalTime.now());
            } else {
                controller.handleTime(LocalTime.now());
                controller.handleStartDate(calendar.getValue());
            }

            controller.addProject();
            title_box.clear();
            desc_box.clear();

            //clear all txt
            if (currentTimeBtn.isSelected()) {
                currentTimeBtn.setSelected(false);
            } else {
                customTimeBtn.setSelected(false);
            }
            calendar.setValue(null);
            calendar.setVisible(false);
        });


        NP_Title.getChildren().addAll(New_Project, title, title_box, desc_title, desc_box);

        Date_Time.setPadding(new Insets(0, 0, 0, 30));
        Date_Time.getChildren().addAll(pick_time, currentTimeBtn, customTimeBtn, calendar);
        second_root.getChildren().addAll(NP_Title, Date_Time);

        root.getChildren().addAll(second_root, AddProject);

        this.getChildren().add(root);
    }

    public void setModel(ProjectModel newModel) { projectList = newModel; }
    public void setController (NewProjectController NPController) { this.controller = NPController; }

    @Override
    public void modelUpdated() {

    }
}
