package org.example.gameoanquan.entity;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int playerId;           //player 1 and player 2
    private int playerPoint;        // player point, when start point = 0
    private int playerSquarePoint;  // player have 5 Square, this attribute save current point of square
                                    // when game start square point = 25 ( 1 square = 5 point)
    private int borrowedGem;        // when game start, borrowed gem = 0

    private int bigGemOwn;          //  Squareid 1 and 6 . when start = 0

    public Player(int playerId) {
        this.playerId = playerId;
        this.playerPoint = 0;
        this.playerSquarePoint = 25;
        this.borrowedGem = 0;
        this.bigGemOwn = 0;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getPlayerPoint() {
        return playerPoint;
    }

    public void setPlayerPoint(int playerPoint) {
        this.playerPoint = playerPoint;
    }

    public int getPlayerSquarePoint() {
        return playerSquarePoint;
    }

    public void setPlayerSquarePoint(int playerSquarePoint) {
        this.playerSquarePoint = playerSquarePoint;
    }

    public int getBorrowedGem() {
        return borrowedGem;
    }

    public int getBigGemOwnPoint() {
        return bigGemOwn * 5;
    }
    public void setBigGemOwn()
    {
        bigGemOwn ++;
    }



    public int spreadGem(int direction, int squareId, List<Square> broad) // tra ve square sau o duoc rai da cuoi cung
    {
        int spreadPoint = broad.get(squareId).getSquarePoint();
        int currentSquareId = squareId;
        broad.get(squareId).setSquarePoint(0);
        System.out.println("O lay len de rai: "+ squareId);
        System.out.println(direction);
        if(direction == 0) // nguoc kim dong ho
        {
            currentSquareId = currentSquareId - 1;
            while(spreadPoint > 0)
            {
                if(currentSquareId >= 0 && currentSquareId <= 4)
                {
                    for (; spreadPoint > 0; spreadPoint--) {
                        System.out.println("o duoc rai: " + currentSquareId);
                        System.out.println("luong da con tren tay truoc khi rai: "+ spreadPoint);
                        System.out.println("luong da con tren tay sau khi rai: "+ (spreadPoint - 1));
                        broad.get(currentSquareId).gemDrop();
                        currentSquareId --;
                        if(currentSquareId == -1 && spreadPoint > 0)
                        {
                            currentSquareId = 11;
                        }
                    }
                }
                if(currentSquareId <= 10 && currentSquareId >= 6)
                {
                    for (; spreadPoint > 0; spreadPoint--) {
                        System.out.println("o duoc rai: " + currentSquareId);
                        System.out.println("luong da con tren tay truoc khi rai: "+ spreadPoint);
                        System.out.println("luong da con tren tay sau khi rai: "+ (spreadPoint - 1));
                        broad.get(currentSquareId).gemDrop();
                        currentSquareId --;
                        if(currentSquareId == -1 && spreadPoint > 0)
                        {
                            currentSquareId = 11;
                        }
                    }
                }
            }
        }
        else if(direction == 1)   //cung chieu kim dong ho
        {
            currentSquareId = currentSquareId +1;
            while(spreadPoint > 0)
            {
                if(currentSquareId >= 2 && currentSquareId <= 6)
                {
                    for (; spreadPoint > 0; spreadPoint--) {
                        System.out.println("o duoc rai: " + currentSquareId);
                        System.out.println("luong da con tren tay truoc khi rai: "+ spreadPoint);
                        System.out.println("luong da con tren tay sau khi rai: "+ (spreadPoint - 1));
                        broad.get(currentSquareId).gemDrop();
                        currentSquareId ++;
                        if(currentSquareId == 12 && spreadPoint > 0)
                        {
                            currentSquareId = 0;
                        }
                    }
                }
                if(currentSquareId <= 12 && currentSquareId >= 8)
                {
                    if(currentSquareId == 12){
                        currentSquareId = 0;
                    }
                    for (; spreadPoint > 0; spreadPoint--) {
                        System.out.println("o duoc rai: " + currentSquareId);
                        System.out.println("luong da con tren tay truoc khi rai: "+ spreadPoint);
                        System.out.println("luong da con tren tay sau khi rai: "+ (spreadPoint - 1));
                        broad.get(currentSquareId).gemDrop();
                        currentSquareId ++;
                        if(currentSquareId == 12 && spreadPoint > 0)
                        {
                            currentSquareId = 0;
                        }
                    }
                }
            }
        }
        return currentSquareId;
    }

    public void borrowGem(int playerId, int borrowGem)
    {
        this.borrowedGem += borrowGem;
    }
}
