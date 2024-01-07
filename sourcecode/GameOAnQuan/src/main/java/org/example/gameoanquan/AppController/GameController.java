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
    private boolean bigGem1Check;
    private boolean bigGem2Check;
    public GameController() {
        this.player1 = new Player(1);
        this.player2 = new Player(2);
        for (int i = 0; i <= 11; i++) {
            broad.add(new Square(i));
        }
        this.turn = true;
        this.bigGem1Check = true;
        this.bigGem2Check = true;
        setTurn();
    }
    /*
    player sẽ rải đá hết phần đá sau đó sẽ chạy hàm point để xem có ăn điểm hay không
     */
    public void gameMethod(Player player, int direction, int pickedSquare)
    {
        if(broad.get(pickedSquare).getSquarePoint() == 0)
        {
            System.out.println("cant pick empty square");
        }
        else {
            int currentSquareId;
            int spreadSquare = pickedSquare;
            do{
                currentSquareId = player.spreadGem(direction, spreadSquare, broad);
                spreadSquare = currentSquareId;
                System.out.println("square tiep theo (current): " + currentSquareId);
                if(playerPointCaculate(currentSquareId, player, direction) == true)  //neu co su thay doi ve diem so
                {
                    break;
                }
            }while (stopSpreadGem(currentSquareId));   //neu khong the rai da nua
            updateSquarePoint();                       // sau moi lan rai da, update lai tong diem ben phan o cua nguoi choi
            printBroad();
            if(!endGameCheck())
            {
                System.out.println("change turn");
                changeTurn();
                System.out.println(isTurn());
            }
        }
    }

    public boolean stopSpreadGem(int currentSquareId)  //kiem tra xem co phai dung vi gap o quan hay 2 ô trống liên tiếp
    {
        if(currentSquareId == 0 || currentSquareId == 6)
        {
            return false;
        }
        int nextSquareId = currentSquareId + 1;
        int prevSquareId = currentSquareId - 1;
        if(nextSquareId == 12)
        {
            nextSquareId = 0;
        }
        if(broad.get(currentSquareId).getSquarePoint() == 0 && broad.get(nextSquareId).getSquarePoint() == 0)
        {
            return false;
        }
        if(broad.get(currentSquareId).getSquarePoint() == 0 && broad.get(prevSquareId).getSquarePoint() == 0)
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
    public boolean playerPointCaculate(int currentSquareId, Player player, int direction)   // tinh toan diem nguoi choi sau mot lan an quan
    {
        if(broad.get(currentSquareId).getSquarePoint() != 0)
        {
            return false;
        }
        boolean check = false;
        int nextSquareId;
        int prevSquareId;
        if(direction == 0)
        {
            while(true) {
                prevSquareId = currentSquareId - 1;
                if(prevSquareId == -1)
                {
                    prevSquareId = 11;
                }
                if (broad.get(currentSquareId).getSquarePoint() == 0 && broad.get(prevSquareId).getSquarePoint() != 0) {
                    player.setPlayerPoint(player.getPlayerPoint() + broad.get(prevSquareId).getSquarePoint());
                    broad.get(prevSquareId).setSquarePoint(0);
                    if(prevSquareId == 0 && bigGem1Check)
                    {
                        player.setBigGemOwn();
                        bigGem1Check = false;
                    }
                    if(prevSquareId == 6 && bigGem2Check)
                    {
                        player.setBigGemOwn();
                        bigGem2Check = false;
                    }
                    currentSquareId = currentSquareId - 2;
                    if (currentSquareId == -1)
                    {
                        currentSquareId = 11;
                    }
                    if(currentSquareId == -2)
                    {
                        currentSquareId = 10;
                    }
                    check = true;
                }else {
                    break;
                }
            }
        }
        else if(direction == 1)
        {
            while(true) {
                nextSquareId = currentSquareId + 1;
                if(nextSquareId == 12)
                {
                    nextSquareId = 0;
                }
                if (broad.get(currentSquareId).getSquarePoint() == 0 && broad.get(nextSquareId).getSquarePoint() != 0) {
                    player.setPlayerPoint(player.getPlayerPoint() + broad.get(nextSquareId).getSquarePoint());
                    broad.get(nextSquareId).setSquarePoint(0);
                    System.out.println("asd");
                    if(nextSquareId == 0 && bigGem1Check)
                    {
                        player.setBigGemOwn();
                        bigGem1Check = false;
                    }
                    if(nextSquareId == 6 && bigGem2Check)
                    {
                        player.setBigGemOwn();
                        bigGem2Check = false;
                    }
                    currentSquareId = currentSquareId + 2;
                    if(currentSquareId == 12)
                    {
                        currentSquareId = 0;
                    }
                    if(currentSquareId == 13)
                    {
                        currentSquareId = 1;
                    }
                    check = true;
                }else {
                    break;
                }
            }
        }
        System.out.println(check);
        return check;
    }

    public void autoAddGem(Player player)            //tu dong them da khi nguoi choi het da trong square
    {
        int playerSmallGemPoint = player.getPlayerPoint() - player.getBigGemOwnPoint();
        if(player.getPlayerId() == 1)
        {
            for (int i = 1; i < 6; i++) {
                broad.get(i).setSquarePoint(1);
            }
        } else if (player.getPlayerId() == 2) {
            for (int i = 7; i < 12; i++) {
                broad.get(i).setSquarePoint(1);
            }
        }
        if(playerSmallGemPoint < 5)
        {
            if(player.getPlayerId() == 1)
            {
                player.borrowGem(2, 5 - playerSmallGemPoint);
                player2.borrowGem(1, - 5 + playerSmallGemPoint);
                player.setPlayerPoint(player.getPlayerPoint() - playerSmallGemPoint);
                player2.setPlayerPoint(player2.getPlayerPoint() +5 - playerSmallGemPoint);
            } else if (player.getPlayerId() == 2) {
                player.borrowGem(1, 5 - playerSmallGemPoint);
                player1.borrowGem(2, - 5 + playerSmallGemPoint);
                player.setPlayerPoint(player.getPlayerPoint() - playerSmallGemPoint);
                player1.setPlayerPoint(player1.getPlayerPoint() +5 - playerSmallGemPoint);
            }
        }
        else
        {
            player.setPlayerPoint(player.getPlayerPoint() - 5);
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
        if(broad.get(0).getSquarePoint() == 0 && broad.get(6).getSquarePoint() == 0)     //khi het ca 2 quan, dan ben nao thi la diem ben do
        {
            player1.setPlayerPoint(player1.getPlayerPoint() + player1.getPlayerSquarePoint() - player1.getBorrowedGem());
            player2.setPlayerPoint(player2.getPlayerPoint()+player2.getPlayerSquarePoint() - player2.getBorrowedGem());
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
    public void updateSquarePoint()
    {
        int total1 = 0;
        int total2 = 0;
        for (int i = 1; i < 6; i++) {
            total1 = total1 + broad.get(i).getSquarePoint();
        }
        for (int i = 7; i <12 ; i++) {
            total2 = total2 + broad.get(i).getSquarePoint();
        }
        player1.setPlayerSquarePoint(total1);
        player2.setPlayerSquarePoint(total2);
    }

    public void setTurn()
    {
        turn = Math.random()< 0.5;
    }
    public void printBroad()
    {
        System.out.print("  ");
        for (int i = 1; i < 6; i++) {
            System.out.print("|"+broad.get(i).getSquarePoint() + "|");
        }
        System.out.print("\n|"+ broad.get(0).getSquarePoint() + "|" + "              " + "|"+broad.get(6).getSquarePoint() + "|\n");
        System.out.print("  ");
        for (int i = 11; i > 6; i--) {
            System.out.print("|"+broad.get(i).getSquarePoint() + "|");
        }

        System.out.println("\nplayer1 = " + player1.getPlayerPoint());
        System.out.println("player2 = " + player2.getPlayerPoint());
    }

}