module src.nim {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens src.nim to javafx.fxml;
    exports src.nim;
}