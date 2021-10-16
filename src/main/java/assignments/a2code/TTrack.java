package assignments.a2code;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.stage.Stage;

public class TTrack extends Application {
    @Override
    public void start(Stage stage)  {
        NewProjectController NPController = new NewProjectController();
        ListController listController = new ListController();
        ProjectModel project_list = new ProjectModel();

        NewProjectView projectView = new NewProjectView();
        ProjectListView projectListView = new ProjectListView();

//        PauseView view2 = new PauseView();
//        SummaryView view3 = new SummaryView();
        MainView mainView = new MainView();

        projectView.setModel(project_list);
        projectView.setController(NPController);
        NPController.setModel(project_list);
        project_list.addSubscriber(projectView);
//
//        projectListView.setModel(project_list);
//        project_list.addSubscriber(projectListView);

//        view2.setModel(project);
//        view2.setController(controller);
//        view3.setModel(project);
//        view3.setController(controller);

        Scene main_scene = new Scene(mainView, 280, 320);
        Scene NP_scene = new Scene(projectView, 425,285);
//        Scene PL_scene = new Scene(projectListView, 200, 400);
//        Scene Pause_scene = new Scene(view2, 425, 250);
//        Scene Summary_scene = new Scene(view3, 880, 500);

        stage.setTitle("TTrack");
        stage.setScene(main_scene);
        mainView.getAdd_project().setOnAction(e -> stage.setScene(NP_scene));
        projectView.getAddProject().setOnAction(e -> stage.setScene(main_scene));
//        mainView.getView_projects().setOnAction(e -> stage.setScene(PL_scene));

        mainView.getExit().setOnAction(e -> stage.close());
//        projectView.getAddProject().setOnAction(e -> stage.setScene(Pause_scene));
//        view2.getFinishButton().setOnAction(e -> stage.setScene(Summary_scene));

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}