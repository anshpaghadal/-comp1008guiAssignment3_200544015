module com.example.anshfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.anshfx to javafx.fxml;
    exports com.example.anshfx;
}