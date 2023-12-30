package org.example.gameoanquan.entity;

public class Player {
    private int playerId;           //player 1 and player 2
    private int playerPoint;        // player point, when start point = 0
    private int playerSquarePoint;  // player have 5 Square, this attribute save current point of square
                                    // when game start square point = 25 ( 1 square = 5 point)

    public Player(int playerId) {
        this.playerId = playerId;
        this.playerPoint = 0;
        this.playerSquarePoint = 25;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
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
}
