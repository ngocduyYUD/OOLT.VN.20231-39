package org.example.gameoanquan.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class HelpController {
    @FXML
    private Button closeButton;

    @FXML
    void handleClose(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();


        stage.close();
    }

}
