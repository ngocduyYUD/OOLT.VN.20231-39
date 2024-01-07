package org.example.gameoanquan.entity;

import java.util.List;

public class Player {
    private int playerId;           //player 1 and player 2
    private int playerPoint;        // player point, when start point = 0
    private int playerSquarePoint;  // player have 5 Square, this attribute save current point of square
                                    // when game start square point = 25 ( 1 square = 5 point)
    private int borrowedGem;        // when game start, borrowed gem = 0

    private int[] bigGemOwn = new int[2];          //  Squareid 1 and 6 . when start = 0

    public Player(int playerId) {
        this.playerId = playerId;
        this.playerPoint = 0;
        this.playerSquarePoint = 25;
        this.borrowedGem = 0;
        for (int i = 0; i < 2; i++) {
            this.bigGemOwn[i] = 0;
        }
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
        return this.bigGemOwn.length * 5;
    }

    public int spreadGem(int direction, int squareId, List<Square> broad) // tra ve square sau o duoc rai da cuoi cung
    {
        int spreadPoint = broad.get(squareId).getSquarePoint();
        int currentSquareId = broad.get(squareId).getSquareId();
        broad.get(squareId).setSquarePoint(0);
        if(direction == 0) // nguoc kim dong ho
        {
            currentSquareId = currentSquareId - 1;
            while(spreadPoint > 0)
            {
                if(currentSquareId >= 1 && currentSquareId <= 5)
                {
                    for (; spreadPoint > 0; spreadPoint--) {
                        broad.get(currentSquareId).gemDrop();
                        if(currentSquareId == 0 && spreadPoint > 1)
                        {
                            currentSquareId = 11;
                            break;
                        }
                        currentSquareId --;
                    }
                }
                if(currentSquareId <= 11 && currentSquareId >= 7)
                {
                    for (; spreadPoint > 0; spreadPoint--) {
                        broad.get(currentSquareId).gemDrop();
                        if(currentSquareId == 6 && spreadPoint > 1)
                        {
                            currentSquareId = 5;
                            break;
                        }
                        currentSquareId --;
                    }
                }
            }
        }
        else if(direction == 1)   //cung chieu kim dong ho
        {
            currentSquareId = currentSquareId +1;
            while(spreadPoint > 0)
            {
                if(currentSquareId >= 1 && currentSquareId <= 5)
                {
                    for (; spreadPoint > 0; spreadPoint--) {
                        broad.get(currentSquareId).gemDrop();
                        if(currentSquareId == 6 && spreadPoint > 1)
                        {
                            currentSquareId = 7;
                            break;
                        }
                        currentSquareId ++;
                    }
                }
                if(currentSquareId <= 11 && currentSquareId >= 7)
                {
                    for (; spreadPoint > 0; spreadPoint--) {
                        broad.get(currentSquareId).gemDrop();
                        if(currentSquareId == 0 && spreadPoint > 1)
                        {
                            currentSquareId = 1;
                            break;
                        }
                        currentSquareId ++;
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
