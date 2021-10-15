package assignments.a2code;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PauseView extends Pane implements TTrackSubscriber {
    private VBox root;

    private HBox buttons;
    private Label title_name;
    private Label total_hrs;
    private Label tracking_status;
    private Label paused_dur;

    private Button pause_resume_btn;
    private Button finish_btn;

    public PauseView() {
        title_name = new Label("Title: MySQL Project");
        title_name.setFont(Font.font(20));

        total_hrs = new Label("Total hours: 10h 23m");
        total_hrs.setFont(Font.font(20));

        tracking_status = new Label("Tracking Status: Tracking");
        tracking_status.setFont(Font.font(20));

        paused_dur = new Label("Paused Duration: 00h 00m");
        paused_dur.setFont(Font.font(20));

//        pause_resume_btn = new Button("Pause");
        pause_resume_btn.setOnAction(e -> {
            if (pause_resume_btn.getText().equals("Pause")) {
                pause_resume_btn.setText("Resume");
            }
            else if (pause_resume_btn.getText().equals("Resume")) {
                pause_resume_btn.setText("Pause");
            }

            if (tracking_status.getText().equals("Tracking Status: Tracking")) {
                tracking_status.setText("Tracking Status: Paused");
            }
            else if (tracking_status.getText().equals("Tracking Status: Paused")) {
                tracking_status.setText("Tracking Status: Tracking");
            }
            if (paused_dur.getText().equals("Paused Duration: 00h 00m")) {
                paused_dur.setText("Paused Duration: 01h 23m");
            }

        });
        finish_btn = new Button("Finish");
        buttons = new HBox(pause_resume_btn, finish_btn);
        buttons.setSpacing(60);
        buttons.setPadding(new Insets(0,0,0,40));

        root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.getChildren().addAll(title_name, total_hrs, tracking_status, paused_dur, buttons);
        root.setSpacing(20);
        root.setPadding(new Insets(10, 0, 0, 90));
        this.getChildren().add(root);
    }

    public Button getFinishButton() { return finish_btn; }

    public void setController (NPController newController) {}

    public void setModel(Project newProject) {}

    @Override
    public void modelUpdated() {

    }
}
