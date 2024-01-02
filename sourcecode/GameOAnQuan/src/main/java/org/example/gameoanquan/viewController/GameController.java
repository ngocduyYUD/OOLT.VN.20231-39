package org.example.gameoanquan.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


// this is screen for play game, have a button for exit , when click exit, beck to home screen
public class GameController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}