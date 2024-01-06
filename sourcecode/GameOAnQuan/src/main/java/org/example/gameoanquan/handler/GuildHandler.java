package org.example.gameoanquan.handler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class GuildHandler {
    @FXML
    private Button closeButton;

    @FXML
    void handleClose(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();


        stage.close();
    }

}
