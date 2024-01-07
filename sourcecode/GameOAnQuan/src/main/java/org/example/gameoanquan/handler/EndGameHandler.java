package org.example.gameoanquan.handler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.example.gameoanquan.AppController.GameController;
import org.example.gameoanquan.GameApplication;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class EndGameHandler {
    @FXML
    private ImageView endBG;
    @FXML
    private ImageView player1Avatar;
    @FXML
    private ImageView player2Avatar;
    @FXML
    private Label notify;
    @FXML
    private Button buttonBack;

    private int winner;
    public void initialize()
    {
        if(winner == 1)
        {
            player1Avatar.setVisible(true);
            player2Avatar.setVisible(false);
            notify.setText("RIVEN IS WINNER!!");
        }
        else {
            player1Avatar.setVisible(false);
            player2Avatar.setVisible(true);
            notify.setText("AHRI IS WINNER!!");
        }
    }
    public void initData(int winner)
    {
        this.winner = winner;
    }

    public void backMenu(ActionEvent actionEvent) throws Exception {
        GameApplication.getInstance().pauseMusic();
        GameApplication.getInstance().backToMenu();
    }
}
