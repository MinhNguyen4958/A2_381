package assignments.a2code;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MainView extends Pane implements TTrackSubscriber {
    private Label main_menu;
    private Button add_project;
    private Button view_projects;
    private Button app_settings;
    private Button exit;

    private VBox root;
    public MainView() {
        main_menu = new Label("Main Menu");
        main_menu.setFont(Font.font(50));

        add_project = new Button("Add Project");

        view_projects = new Button("View Projects");

        app_settings = new Button("App Settings");


        exit = new Button("Exit ");


        root = new VBox(main_menu, add_project, view_projects, app_settings, exit);
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(30);
        root.setPadding(new Insets(10, 10, 10, 10));
        this.getChildren().add(root);
    }

    public Button getAdd_project() {
        return add_project;
    }

    public Button getView_projects() {
        return view_projects;
    }

    public Button getApp_settings() {
        return app_settings;
    }

    public Button getExit() {
        return exit;
    }

    @Override
    public void modelUpdated() {

    }

    public void setController (TTrackController newController) {}

    public void setModel(Project newProject) { }
}
