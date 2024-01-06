package org.example.gameoanquan.handler;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import org.example.gameoanquan.AppController.GameController;

import java.awt.*;

public class EndGameHandler {
    @FXML
    private ImageView endBG;
    @FXML
    private ImageView player1Avatar;
    @FXML
    private ImageView player2Avatar;
    @FXML
    private Label notifyWinner;
    @FXML
    private Button okButton;

    private int winner;
    public void initialize()
    {
        if(winner == 1)
        {
            player1Avatar.setVisible(false);
            player2Avatar.setVisible(true);
            if(notifyWinner == null)
            {
                notifyWinner = new Label();
            }
            notifyWinner.setText("RIVEN IS WINNER!!");
        }
        else {
            player1Avatar.setVisible(true);
            player2Avatar.setVisible(false);
            if(notifyWinner == null)
            {
                notifyWinner = new Label();
            }
            notifyWinner.setText("AHRI IS WINNER!!");
        }
    }
    public void initData(int winner)
    {
        this.winner = winner;
    }


}
