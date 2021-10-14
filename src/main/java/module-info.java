module assignments.a2code {
    requires javafx.controls;
    requires javafx.fxml;


    opens assignments.a2code to javafx.fxml;
    exports assignments.a2code;
}