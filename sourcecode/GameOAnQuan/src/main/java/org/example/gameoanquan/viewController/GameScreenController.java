package org.example.gameoanquan.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.gameoanquan.GameApplication;

import java.awt.event.ActionEvent;

public class GameScreenController {
    @FXML
    private ImageView gamePlayBG;
    @FXML
    private ImageView directionR1;
    @FXML
    private ImageView directionR2;
    @FXML
    private ImageView directionR3;
    @FXML
    private ImageView directionR4;
    @FXML
    private ImageView directionR5;
    @FXML
    private ImageView directionR7;
    @FXML
    private ImageView directionR8;
    @FXML
    private ImageView directionR9;
    @FXML
    private ImageView directionR10;
    @FXML
    private ImageView directionR11;
    @FXML
    private ImageView directionL1;
    @FXML
    private ImageView directionL2;
    @FXML
    private ImageView directionL3;
    @FXML
    private ImageView directionL4;
    @FXML
    private ImageView directionL5;
    @FXML
    private ImageView directionL7;
    @FXML
    private ImageView directionL8;
    @FXML
    private ImageView directionL9;
    @FXML
    private ImageView directionL10;
    @FXML
    private ImageView directionL11;
    @FXML
    private Button rightButton1;
    @FXML
    private Button rightButton2;
    @FXML
    private Button rightButton3;
    @FXML
    private Button rightButton4;
    @FXML
    private Button rightButton5;
    @FXML
    private Button rightButton7;
    @FXML
    private Button rightButton8;
    @FXML
    private Button rightButton9;
    @FXML
    private Button rightButton10;
    @FXML
    private Button rightButton11;
    @FXML
    private Button leftButton1;
    @FXML
    private Button leftButton2;
    @FXML
    private Button leftButton3;
    @FXML
    private Button leftButton4;
    @FXML
    private Button leftButton5;
    @FXML
    private Button leftButton7;
    @FXML
    private Button leftButton8;
    @FXML
    private Button leftButton9;
    @FXML
    private Button leftButton10;
    @FXML
    private Button leftButton11;
    @FXML
    private Pane square0;
    @FXML
    private Pane square1;
    @FXML
    private Pane square2;
    @FXML
    private Pane square3;
    @FXML
    private Pane square4;
    @FXML
    private Pane square5;
    @FXML
    private Pane square6;
    @FXML
    private Pane square7;
    @FXML
    private Pane square8;
    @FXML
    private Pane square9;
    @FXML
    private Pane square10;
    @FXML
    private Pane square11;
    @FXML
    private Label squarePoint0;
    @FXML
    private Label squarePoint1;
    @FXML
    private Label squarePoint2;
    @FXML
    private Label squarePoint3;
    @FXML
    private Label squarePoint4;
    @FXML
    private Label squarePoint5;
    @FXML
    private Label squarePoint6;
    @FXML
    private Label squarePoint7;
    @FXML
    private Label squarePoint8;
    @FXML
    private Label squarePoint9;
    @FXML
    private Label squarePoint10;
    @FXML
    private Label squarePoint11;
    @FXML
    private Label playerPoint1;
    @FXML
    private Label playerPoint2;
    @FXML
    private Button exitGame;

    @FXML
    public void exitGame(ActionEvent event)
    {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle("Xác nhận thoát");
        confirmationDialog.setHeaderText(null);
        confirmationDialog.setContentText("Bạn có chắc muốn thoát game không?");


        ButtonType yesButton = new ButtonType("Có");
        ButtonType noButton = new ButtonType("Không");


        confirmationDialog.getButtonTypes().setAll(yesButton, noButton);


        confirmationDialog.showAndWait().ifPresent(response -> {
            if (response == yesButton) {
                GameApplication.getInstance().showGameScreen();
            }

        });
    }
}
