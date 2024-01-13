package org.example.gameoanquan.AppController;
import org.example.gameoanquan.entity.Gem.BigGem;
import org.example.gameoanquan.entity.Gem.Gem;
import org.example.gameoanquan.entity.Gem.SmallGem;
import org.example.gameoanquan.entity.broad.Broad;
import org.example.gameoanquan.entity.player.Player;
import org.example.gameoanquan.entity.broad.Square;

import java.util.ArrayList;
import java.util.List;


// this is screen for play game, have a button for exit , when click exit, beck to home screen
public class GameController {
    private Player player1;
    private Player player2;
    private Broad broad;
    private boolean turn;

    public GameController() {
        this.player1 = new Player(1);
        this.player2 = new Player(2);
        broad = new Broad();
        this.turn = true;
        setTurn();
    }
    /*
    player sẽ rải đá hết phần đá sau đó sẽ chạy hàm point để xem có ăn điểm hay không
     */
    public void gameMethod(Player player, int direction, int pickedSquare)
    {
        if(broad.getSquareList().get(pickedSquare).getGemsInSquare() == null)
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
                if(playerTakeGem(currentSquareId, player, direction))  //neu co su thay doi ve diem so
                {
                    break;
                }
            }while (stopSpreadGem(currentSquareId));   //neu khong the rai da nua
            printBroad();
                System.out.println("change turn");
                changeTurn();
                System.out.println(isTurn());
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
        if(broad.getSquareList().get(currentSquareId).getGemsInSquare().isEmpty() && broad.getSquareList().get(nextSquareId).getGemsInSquare().isEmpty())
        {
            return false;
        }
        if(broad.getSquareList().get(currentSquareId).getGemsInSquare().isEmpty() && broad.getSquareList().get(prevSquareId).getGemsInSquare().isEmpty())
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
    public boolean playerTakeGem(int currentSquareId, Player player, int direction)   // nguoi choi an Gem
    {
        if(!broad.getSquareList().get(currentSquareId).getGemsInSquare().isEmpty())
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
                if (broad.getSquareList().get(currentSquareId).getGemsInSquare().isEmpty() && !broad.getSquareList().get(prevSquareId).getGemsInSquare().isEmpty()) {
                    player.takeGem(broad.getSquareList().get(prevSquareId).getGemsInSquare());
                    broad.getSquareList().get(prevSquareId).getGemsInSquare().clear();
                    currentSquareId = currentSquareId - 2;
                    if (currentSquareId == -1)
                    {
                        currentSquareId = 11;
                    }
                    if(currentSquareId == -2)
                    {
                        currentSquareId = 10;
                    }
                    System.out.println(prevSquareId);
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
                if (broad.getSquareList().get(currentSquareId).getGemsInSquare().isEmpty() && !broad.getSquareList().get(nextSquareId).getGemsInSquare().isEmpty()) {
                    player.takeGem(broad.getSquareList().get(nextSquareId).getGemsInSquare());
                    broad.getSquareList().get(nextSquareId).getGemsInSquare().clear();
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
        List<Gem> playerSmallGems = new ArrayList<>();
        for(Gem gem: player.getGems())
        {
            if(gem.getPoint() == 1)
            {
                playerSmallGems.add(gem);
            }
        }
        if(playerSmallGems.size() < 5)
        {
            int gemNeedBorrow = 5 - playerSmallGems.size();
            if(player.getPlayerId() == 1)
            {
                for (Gem gem: player2.getGems()) {
                    if(gem.getPoint() == 1)
                    {
                        player.borrowGem(gem);
                        gemNeedBorrow--;
                    }
                    if (gemNeedBorrow == 0)
                    {
                        break;
                    }
                }
            } else if (player.getPlayerId() == 2) {
                for (Gem gem: player1.getGems()) {
                    if(gem.getPoint() == 1)
                    {
                        player.borrowGem(gem);
                        gemNeedBorrow--;
                    }
                    if (gemNeedBorrow == 0)
                    {
                        break;
                    }
                }
            }
        }
        else
        {
            if(player.getPlayerId() == 1){
                int squareId = 5;
                for(int i = 0; i < player.getGems().size(); i++)
                {
                    if(player.getGems().get(i).getPoint() == 1)
                    {
                        broad.getSquareList().get(squareId).gemDrop(player.getGems().get(i));
                        player.getGems().remove(i);
                        squareId--;
                    }
                    if (squareId == 0)
                    {
                        break;
                    }
                }
            }
            else {
                int squareId = 11;
                for(int i = 0; i < player.getGems().size(); i++)
                {
                    if(player.getGems().get(i).getPoint() == 1)
                    {
                        broad.getSquareList().get(squareId).gemDrop(player.getGems().get(i));
                        player.getGems().remove(i);
                        squareId--;
                    }
                    if (squareId == 6)
                    {
                        break;
                    }
                }
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
    public Broad getBroad()
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
        if(broad.getSquareList().get(0).getGemsInSquare().isEmpty() && broad.getSquareList().get(6).getGemsInSquare().isEmpty())     //khi het ca 2 quan, dan ben nao thi la diem ben do
        {
            return true;
        }
        return false;
    }
    public int endGame()
    {
        if(playerPointCaculate(player1) > playerPointCaculate(player2))
        {
            return player1.getPlayerId();
        }
        return player2.getPlayerId();
    }

    public int playerPointCaculate(Player player)
    {
        int playerPoint = 0;
        for (Gem gem: player.getGems())
        {
            playerPoint = playerPoint + gem.getPoint();
        }
        for(Gem gem: player.getBorrowedGems())
        {
            playerPoint = playerPoint - gem.getPoint();
        }
        return playerPoint;
    }
    public boolean isPlayerSquareEmpty(Player player)
    {
        int playerSquareGems = 0;
        if(player.getPlayerId() == 1)
        {
            for (int i = 1; i < 6; i++) {
                if(!broad.getSquareList().get(i).getGemsInSquare().isEmpty()){
                    return false;
                }
            }
        }
        if(player.getPlayerId() == 2)
        {
            for (int i = 7; i < 12; i++) {
                if(!broad.getSquareList().get(i).getGemsInSquare().isEmpty())
                {
                    return false;
                }
            }
        }
        return true;
    }

    public void setTurn()
    {
        turn = Math.random()< 0.5;
    }
    public void printBroad()
    {
        System.out.print("  ");
        for (int i = 1; i < 6; i++) {
            System.out.print("|"+broad.getSquareList().get(i).getGemsInSquare().size() + "|");
        }
        System.out.print("\n|"+ broad.getSquareList().get(0).getGemsInSquare().size() + "|" + "              " + "|"+broad.getSquareList().get(6).getGemsInSquare().size() + "|\n");
        System.out.print("  ");
        for (int i = 11; i > 6; i--) {
            System.out.print("|"+broad.getSquareList().get(i).getGemsInSquare().size() + "|");
        }
    }

}