package org.example.gameoanquan.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class GamePanelController {

    @FXML
    private Button exitButtonGame;
    @FXML
    private Button newGame;


    @FXML
    public void handleExitButton(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../../../resources/org/example/gameoanquan/GameMenu.fxml"));
            Parent root = loader.load();


            Stage stage = (Stage) exitButtonGame.getScene().getWindow();


            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void handleGame(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../../../resources/org/example/gameoanquan/GameScreen.fxml"));
            Parent root = loader.load();


            Stage stage = (Stage) exitButtonGame.getScene().getWindow();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
