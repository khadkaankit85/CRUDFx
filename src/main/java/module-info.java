module com.example.sqlfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.sqlfx to javafx.fxml; // Open the main package to JavaFX
    opens com.example.model to javafx.fxml; // Open the model package to JavaFX
    exports com.example.sqlfx; // Export the main package
    exports com.example.model; // Export the model package containing the University class
}
