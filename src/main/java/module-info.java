module assignments.a2code {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens assignments.a2code to javafx.fxml;
    exports assignments.a2code;
}