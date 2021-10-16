package assignments.a2code;

import javafx.scene.control.ListView;

public class ListController {
//    private ListView<Project> listView;

    private ProjectModel model;
    public ListController() {
        model = new ProjectModel();
    }

//    public ListView<Project> getListView() { return listView; }

    public void setModel(ProjectModel model) {
        this.model = model;
//        listView.setItems(model.getProjectList());
    }

}
