package sample;

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
    void handleExitButton(ActionEvent event) {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GameMenu.fxml"));
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
    void handleGame(ActionEvent event) {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScreen.fxml"));
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


