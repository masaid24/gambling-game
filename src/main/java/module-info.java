module com.example.gamblinggame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gamblinggame to javafx.fxml;
    exports com.example.gamblinggame;
}