module com.vluv {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.vluv to javafx.fxml;
    exports com.vluv;
}