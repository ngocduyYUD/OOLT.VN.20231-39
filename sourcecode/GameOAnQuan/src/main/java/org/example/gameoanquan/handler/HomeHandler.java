package org.example.gameoanquan.handler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.example.gameoanquan.GameApplication;

import java.nio.file.Paths;

public class HomeHandler {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button helpButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button playButton;
    @FXML
    private ImageView playButtonImage;
    @FXML
    private ImageView helpButtonImage;
    @FXML
    private ImageView quitButtonImage;
    @FXML
    private void playGame(ActionEvent event)
    {
        GameApplication.getInstance().pauseMusic();
        GameApplication.getInstance().showGameScreen();
    }
    @FXML
    public void exitGame(ActionEvent event) {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle("Xác nhận thoát");
        confirmationDialog.setHeaderText(null);
        confirmationDialog.setContentText("Bạn có chắc muốn thoát game không?");


        ButtonType yesButton = new ButtonType("Có");
        ButtonType noButton = new ButtonType("Không");


        confirmationDialog.getButtonTypes().setAll(yesButton, noButton);


        confirmationDialog.showAndWait().ifPresent(response -> {
            if (response == yesButton) {

                Stage stage = (Stage) exitButton.getScene().getWindow();
                stage.close();
            }

        });
    }

    @FXML
    public void openGuild(ActionEvent event) {
        GameApplication.getInstance().showHelp();
    }

}