package org.example.gameoanquan.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.gameoanquan.entity.Player;
import org.example.gameoanquan.entity.Square;

import java.util.List;


// this is screen for play game, have a button for exit , when click exit, beck to home screen
public class GameController {
    private Player player1;
    private Player player2;
    private List<Square> broad;
    public void initalizaBoard()   // khoi tao cac entity
    {
        player1 = new Player(1);
        player2 = new Player(2);
        for (int i = 0; i <= 11; i++) {
            broad.add(new Square(i));
        }
    }

    public GameController() {
    }

    public int playerPointCaculate()   // tinh toan diem nguoi choi
    {

        return 1;
    }

    public void autoAddGem(Player player)            //
    {
        int playerSmallGemPoint = player.getPlayerPoint() - player.getBigGemOwnPoint();
        if(player.getPlayerId() == 1)
        {
            for (int i = 1; i < 6; i++) {
                this.broad.get(i).setSquarePoint(1);
            }
        } else if (player.getPlayerId() == 2) {
            for (int i = 7; i < 11; i++) {
                this.broad.get(i).setSquarePoint(1);
            }
        }
        if(playerSmallGemPoint < 5)
        {
            if(player.getPlayerId() == 1)
            {
                player.borrowGem(2, 5 - playerSmallGemPoint);
                this.player2.setPlayerPoint(this.player2.getPlayerPoint() +5 - playerSmallGemPoint);
            } else if (player.getPlayerId() == 2) {
                player.borrowGem(1, 5 - playerSmallGemPoint);
                this.player1.setPlayerPoint(this.player1.getPlayerPoint() +5 - playerSmallGemPoint);
            }
        }
    }

    public void changeTurn()
    {

    }
}