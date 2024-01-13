package org.example.gameoanquan.entity.player;

import org.example.gameoanquan.entity.Gem.Gem;
import org.example.gameoanquan.entity.broad.Broad;
import org.example.gameoanquan.entity.broad.Square;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int playerId;           //player 1 and player 2
    private List<Gem> gems = new ArrayList<>();
    private List<Gem> borrowedGems = new ArrayList<>();

    public Player(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public List<Gem> getGems() {
        return gems;
    }

    public void setGems(List<Gem> gems) {
        this.gems = gems;
    }

    public List<Gem> getBorrowedGems() {
        return borrowedGems;
    }

    public void setBorrowedGems(List<Gem> borrowedGems) {
        this.borrowedGems = borrowedGems;
    }

    public int spreadGem(int direction, int squareId, Broad broad) // tra ve square sau o duoc rai da cuoi cung
    {
        int spreadPoint = broad.getSquareList().get(squareId).getGemsInSquare().size();
        int currentSquareId = squareId;
        List<Gem> spreadGems = new ArrayList<>();
        spreadGems.addAll(broad.getSquareList().get(squareId).getGemsInSquare());
        broad.getSquareList().get(squareId).getGemsInSquare().clear();  //khi nhat len roi thi ko con gi nua
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
                        broad.getSquareList().get(currentSquareId).gemDrop(spreadGems.get(spreadPoint - 1));
                        spreadGems.remove(spreadPoint -1);
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
                        broad.getSquareList().get(currentSquareId).gemDrop(spreadGems.get(spreadPoint - 1));
                        spreadGems.remove(spreadPoint -1);
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
                        broad.getSquareList().get(currentSquareId).gemDrop(spreadGems.get(spreadPoint - 1));
                        spreadGems.remove(spreadPoint -1);
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
                        broad.getSquareList().get(currentSquareId).gemDrop(spreadGems.get(spreadPoint - 1));
                        spreadGems.remove(spreadPoint -1);
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

    public void borrowGem(Gem gem)
    {
        borrowedGems.add(gem);
        gems.add(gem);
    }
    public void takeGem(List<Gem> gems)
    {
        this.gems.addAll(gems);
    }
}
