package org.example.gameoanquan.entity.broad;

import org.example.gameoanquan.entity.Gem.BigGem;
import org.example.gameoanquan.entity.Gem.Gem;
import org.example.gameoanquan.entity.Gem.SmallGem;

import java.util.ArrayList;
import java.util.List;

public class Square {
    private int squareId; //squareId = 0  and 6 is Big Gem
    private List<Gem> gemsInSquare= new ArrayList<>();

    public Square(int squareId) {
        this.squareId = squareId;
        if(squareId == 0 || squareId == 6)
        {
            this.gemsInSquare.add(new BigGem(squareId));
        }
        else
        {
            this.gemsInSquare.add(new SmallGem(squareId));
            this.gemsInSquare.add(new SmallGem(squareId));
            this.gemsInSquare.add(new SmallGem(squareId));
            this.gemsInSquare.add(new SmallGem(squareId));
            this.gemsInSquare.add(new SmallGem(squareId));
        }
    }

    public int getSquareId() {
        return squareId;
    }

    public void setSquareId(int squareId) {
        this.squareId = squareId;
    }

    public List<Gem> getGemsInSquare() {
        return gemsInSquare;
    }

    public void setGemsInSquare(List<Gem> gemsInSquare) {
        this.gemsInSquare = gemsInSquare;
    }

    public void gemDrop(Gem gem)
    {
        gem.setLocate(squareId);    // chuyen locate cho gem
        gemsInSquare.add(gem);
    }

}
