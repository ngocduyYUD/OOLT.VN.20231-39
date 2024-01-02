package org.example.gameoanquan.entity;

public class Square {
    private int squareId; //squareId = 0  and 6 is Big Gem
    private int squarePoint; // 1 square = 5 point when game start

    public Square(int squareId) {
        this.squareId = squareId;
        this.squarePoint = 5;
    }

    public int getSquareId() {
        return squareId;
    }

    public int getSquarePoint() {
        return squarePoint;
    }

    public void setSquarePoint(int squarePoint) {
        this.squarePoint = squarePoint;
    }
}
