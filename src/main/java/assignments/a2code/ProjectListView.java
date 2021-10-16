package assignments.a2code;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ProjectListView extends Pane implements TTrackSubscriber {
    private ListView<Project> project_list;
    private Button mainMenu_btn;
    private HBox root;
    private VBox buttons;
    private ProjectModel model;
    public ProjectListView() {
        project_list = new ListView<>();

        root = new HBox(10);
        buttons = new VBox(10);
        buttons.setAlignment(Pos.TOP_CENTER);

        mainMenu_btn = new Button("Main Menu");
        buttons.getChildren().addAll(mainMenu_btn);
        root.getChildren().addAll(project_list, buttons);
        this.getChildren().add(root);
    }

    public void setModel(ProjectModel model) { this.model = model; }

    public void setController() {}

    @Override
    public void modelUpdated() {
        project_list.setItems(model.getProjectList());
    }
}
