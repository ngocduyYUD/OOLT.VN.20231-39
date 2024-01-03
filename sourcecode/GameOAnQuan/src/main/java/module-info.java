module org.example.gameoanquan {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.gameoanquan to javafx.fxml;
    exports org.example.gameoanquan;
    exports org.example.gameoanquan.AppController;
    opens org.example.gameoanquan.AppController to javafx.fxml;
    exports org.example.gameoanquan.entity;
    opens org.example.gameoanquan.entity to javafx.fxml;
}