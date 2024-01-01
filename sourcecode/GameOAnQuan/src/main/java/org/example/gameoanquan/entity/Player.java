package org.example.gameoanquan.entity;

import java.util.List;

public class Player {
    private int playerId;           //player 1 and player 2
    private int playerPoint;        // player point, when start point = 0
    private int playerSquarePoint;  // player have 5 Square, this attribute save current point of square
                                    // when game start square point = 25 ( 1 square = 5 point)
    private int borrowedGem;        // when game start, borrowed gem = 0

    private int[] bigGemOwn;          //  Squareid 1 and 6 . when start = 0

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

    public void spreadGem(int direction, int squareId, List<Square> broad) // direction = 0 = ben trai
    {

    }

    public void borrowGem(int playerId, int borrowGem)
    {
        this.borrowedGem += borrowGem;
    }
}
