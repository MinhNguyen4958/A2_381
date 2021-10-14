package assignments.a2code;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class NewProjectView extends Pane implements TTrackSubscriber {
    private VBox root;

    private HBox second_root;
    private VBox NP_Title;
    private VBox Date_Time;

    private Label New_Project;

    private Label title;
    private TextArea project_box;

    private Label pick_time;

    private ToggleGroup timerGroup;
    private RadioButton currentTimeBtn;
    private RadioButton customTimeBtn;
    private DatePicker calendar;
    private TextField custom_time_txt;

    private Button AddProject;

    Project project;

    public Button getAddProject() {
        return AddProject;
    }

    public NewProjectView() {
        root = new VBox(10);
        root.setPadding(new Insets(10, 0, 0,0));
        second_root = new HBox(5);
        NP_Title = new VBox(10);
        Date_Time = new VBox(10);


        New_Project = new Label("New Project");
        New_Project.setFont(Font.font(25.0));
        title = new Label("Project's title:");
        project_box = new TextArea();
        project_box.setWrapText(true);
        project_box.setPrefSize(200, 100);

        pick_time = new Label("Pick a time:");
        custom_time_txt = new TextField("Type a time here");
        custom_time_txt.setVisible(false);
        custom_time_txt.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> custom_time_txt.clear());
        timerGroup = new ToggleGroup();
        currentTimeBtn = new RadioButton("Current time\nOctober 13th @ 10:48pm");
        customTimeBtn = new RadioButton("Custom date and time");
        currentTimeBtn.setToggleGroup(timerGroup);
        currentTimeBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            calendar.setVisible(false);
            custom_time_txt.setVisible(false);
        });

        customTimeBtn.setToggleGroup(timerGroup);
        calendar = new DatePicker();
        // initially set the calendar's visibility to false
        calendar.setVisible(false);
        customTimeBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            calendar.setVisible(true);
            custom_time_txt.setVisible(true);
        });

        AddProject = new Button("Add Project");

        NP_Title.setPadding(new Insets(0,0,0,10));
        NP_Title.setAlignment(Pos.TOP_CENTER);
        NP_Title.getChildren().addAll(New_Project, title, project_box);

        Date_Time.setPadding(new Insets(0, 0, 0, 30));
        Date_Time.getChildren().addAll(pick_time, currentTimeBtn, customTimeBtn,custom_time_txt, calendar);
        second_root.getChildren().addAll(NP_Title, Date_Time);
        root.setAlignment(Pos.BASELINE_CENTER);
        root.getChildren().addAll(second_root, AddProject);

        this.getChildren().add(root);
    }

    public void setModel(Project newProject) { project = newProject; }
    public void setController (TTrackController newController) {}

    @Override
    public void modelUpdated() {

    }
}
