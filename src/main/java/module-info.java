module javafx.guiproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens javafx.guiproject to javafx.fxml;
    exports javafx.guiproject;
}
