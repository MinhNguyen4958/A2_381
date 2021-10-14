package assignments.a2code;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class SummaryView extends Pane implements TTrackSub {
    private VBox left_vbox;
    private VBox right_vbox;
    private HBox pay_total_box;
    private VBox root;
    private HBox second_root;
    private VBox payrate_box;
    private VBox totalBill_box;


    private Label summary_label;

    private PieChart hrs_chart;
    private Label title;
    private Label total_time;



    private Label world_build;
    private Label character_design;
    private Label game_physics;
    private Label off_work;
    private Label pay_rate_labl;
    private TextField rate_box;
    private Label total_bill_title;
    private Label total_bill_amount;
    private double total_bill = 0;
    private double payrate = 0;

    private Button main_menu;

    public SummaryView() {
        //initialize all boxes
        root = new VBox();
        second_root = new HBox(15);

        left_vbox = new VBox();
        left_vbox.setPadding(new Insets(0, 0, 0, 10));
        right_vbox = new VBox(20);
        right_vbox.setAlignment(Pos.CENTER);
        pay_total_box = new HBox(20);

        payrate_box = new VBox(40);
        totalBill_box = new VBox(20);


        summary_label = new Label("Summary | Sep 22nd - Oct 11th");
        summary_label.setFont(Font.font(25));

        title = new Label("Title: Witcher 4");
        title.setFont(Font.font(25));

        total_time = new Label("Total time: 80h 42m");
        total_time.setFont(Font.font(25));

        world_build = new Label("World building: 45h 21m");
        world_build.setFont(Font.font(25));

        character_design = new Label("Character design: 21h 14m");
        character_design.setFont(Font.font(25));

        game_physics = new Label("Game physics: 10h 7m");
        game_physics.setFont(Font.font(25));

        off_work = new Label("Off-work: 04h 00m");
        off_work.setFont(Font.font(25));

        pay_rate_labl = new Label("pay rate");
        pay_rate_labl.setFont(Font.font(25));
        rate_box = new TextField("Enter rate here");

        total_bill_title = new Label("Total");
        total_bill_title.setFont(Font.font(25));
        total_bill_amount = new Label("4836$");
        total_bill_amount.setFont(Font.font(40));

        main_menu = new Button("Main Menu");

        payrate_box.getChildren().addAll(pay_rate_labl, rate_box);
        totalBill_box.getChildren().addAll(total_bill_title, total_bill_amount);
        pay_total_box.getChildren().addAll(payrate_box, totalBill_box);

        right_vbox.getChildren().addAll(world_build, character_design, game_physics, off_work, pay_total_box, main_menu);

        hrs_chart = new PieChart();
        PieChart.Data slice1 = new PieChart.Data("World building", 45);
        PieChart.Data slice2 = new PieChart.Data("Character Design", 21);
        PieChart.Data slice3 = new PieChart.Data("Game physics", 10);
        PieChart.Data slice4 = new PieChart.Data("Off-Work", 4);
        hrs_chart.getData().addAll(slice1, slice2, slice3, slice4);

        left_vbox.getChildren().addAll(title, total_time, hrs_chart);
        second_root.getChildren().addAll(left_vbox, right_vbox);

        HBox summary_box = new HBox(summary_label);
        summary_box.setAlignment(Pos.CENTER);
        root.getChildren().addAll(summary_box, second_root);

        this.getChildren().add(root);
    }

    @Override
    public void modelUpdated() {}

    public void setModel(Project newProject) { }

    public void setController (TTrackController newController) {}

}
