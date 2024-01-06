package org.example.gameoanquan.AppController;
import org.example.gameoanquan.entity.Player;
import org.example.gameoanquan.entity.Square;

import java.util.ArrayList;
import java.util.List;


// this is screen for play game, have a button for exit , when click exit, beck to home screen
public class GameController {
    private Player player1;
    private Player player2;
    private List<Square> broad = new ArrayList<>();
    private boolean turn;

    public GameController() {
        this.player1 = new Player(1);
        this.player2 = new Player(2);
        for (int i = 0; i <= 11; i++) {
            broad.add(new Square(i));
        }
        this.turn = true;
    }
    /*
    player sẽ rải đá hết phần đá sau đó sẽ chạy hàm point để xem có ăn điểm hay không
     */
    public void gameMethod(Player player, int direction, int pickedSquare) //
    {
        int currentSquareId = pickedSquare;
        do{
            currentSquareId = player.spreadGem(direction, currentSquareId, broad);
            if(playerPointCaculate(currentSquareId, player) == true)  //neu co su thay doi ve diem so
            {
                break;
            }
        }while (stopSpreadGem(currentSquareId));
        if(!endGameCheck())
        {
            changeTurn();
        }
    }

    public boolean stopSpreadGem(int currentSquareId)  //kiem tra xem co phai dung vi gap o quan hay 2 ô trống liên tiếp
    {
        if(broad.get(currentSquareId).getSquareId() == 0 || broad.get(currentSquareId).getSquareId() == 6)
        {
            return false;
        }
        if(broad.get(currentSquareId).getSquarePoint() == 0 && broad.get(currentSquareId + 1).getSquarePoint() == 0)
        {
            return false;
        }
        return true;
    }


    /*
        nếu current (tưc là ô liền kề ô đá rải tới) = 0 và ô tiếp theo current + 1 có đá => ăn. current + 2 vì xét phía sau
        ô vừa ăn.
        vòng while chạy để kiểm tra xem còn ăn được nữa không.
     */
    public boolean playerPointCaculate(int currentSquareId, Player player)   // tinh toan diem nguoi choi sau mot lan an quan
    {
        boolean check = false;
        while(true) {
            if (broad.get(currentSquareId).getSquarePoint() == 0 && broad.get(currentSquareId + 1).getSquarePoint() != 0) {
                player.setPlayerPoint(player.getPlayerPoint() + broad.get(currentSquareId).getSquarePoint());
                broad.get(currentSquareId + 1).setSquarePoint(0);
                currentSquareId = currentSquareId + 2;
                check = true;
            }else {
                break;
            }
        }
        return check;
    }

    public void autoAddGem(Player player)            //tu dong them da khi nguoi choi het da trong square
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

    public Player getPlayer(int playerId)
    {
        if(playerId == 1)
        {
            return this.player1;
        }
        return this.player2;
    }
    public List<Square> getBroad()
    {
        return this.broad;
    }

    public boolean isTurn() {
        return turn;
    }

    public void changeTurn()
    {
        if(turn == true)
        {
            turn = false;
        }
        else turn = true;
    }

    public boolean endGameCheck()
    {
        if(player1.getBigGemOwnPoint() + player2.getBigGemOwnPoint() == 10)     //khi het ca 2 quan, dan ben nao thi la diem ben do
        {
            player1.setPlayerPoint(player1.getPlayerPoint() + player1.getPlayerSquarePoint());
            player2.setPlayerPoint(player2.getPlayerPoint()+player2.getPlayerSquarePoint());
            return true;
        }
        return false;
    }
    public int endGame()
    {
        if(player1.getPlayerPoint() > player2.getPlayerPoint())
        {
            return 1;
        }
        return 2;
    }

}