package assignments.a2_381;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TTrack extends Application {
    @Override
    public void start(Stage stage)  {
        TTrackController controller = new TTrackController();
        Project project = new Project();

        NewProjectView view1 = new NewProjectView();
        PauseView view2 = new PauseView();
        SummaryView view3 = new SummaryView();
        MainView mainView = new MainView();

        view1.setModel(project);
        view1.setController(controller);
        view2.setModel(project);
        view2.setController(controller);
        view3.setModel(project);
        view3.setController(controller);

        Scene main_scene = new Scene(mainView, 280, 320);
        Scene NP_scene = new Scene(view1, 425,250);
        Scene Pause_scene = new Scene(view2, 425, 250);
        Scene Summary_scene = new Scene(view3, 880, 500);

        stage.setTitle("TTrack");
        stage.setScene(main_scene);
        mainView.getAdd_project().setOnAction(e -> stage.setScene(NP_scene));
//        mainView.getView_projects().;
        mainView.getExit().setOnAction(e -> stage.close());
        view1.getAddProject().setOnAction(e -> stage.setScene(Pause_scene));
        view2.getFinishButton().setOnAction(e -> stage.setScene(Summary_scene));

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}