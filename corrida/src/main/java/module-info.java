module com.corrida {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.corrida to javafx.fxml;
    exports com.corrida;
}
