package org.example.gameoanquan.handler;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.gameoanquan.AppController.GameController;
import org.example.gameoanquan.GameApplication;
import org.example.gameoanquan.entity.broad.Broad;
import org.example.gameoanquan.entity.player.Player;
import org.example.gameoanquan.entity.broad.Square;
import javafx.scene.input.MouseEvent;

import java.util.Arrays;
import java.util.List;

public class GamePlayHandler {
    @FXML
    private ImageView directionR01;
    @FXML
    private ImageView directionR02;
    @FXML
    private ImageView directionR03;
    @FXML
    private ImageView directionR04;
    @FXML
    private ImageView directionR05;
    @FXML
    private ImageView directionR07;
    @FXML
    private ImageView directionR08;
    @FXML
    private ImageView directionR09;
    @FXML
    private ImageView directionR10;
    @FXML
    private ImageView directionR11;
    @FXML
    private ImageView directionL01;
    @FXML
    private ImageView directionL02;
    @FXML
    private ImageView directionL03;
    @FXML
    private ImageView directionL04;
    @FXML
    private ImageView directionL05;
    @FXML
    private ImageView directionL07;
    @FXML
    private ImageView directionL08;
    @FXML
    private ImageView directionL09;
    @FXML
    private ImageView directionL10;
    @FXML
    private ImageView directionL11;
    @FXML
    private ImageView player1Avatar;
    @FXML
    private ImageView player2Avatar;
    @FXML
    private ImageView flag1;
    @FXML
    private ImageView flag2;
    @FXML
    private Button rightButton1;
    @FXML
    private Button rightButton2;
    @FXML
    private Button rightButton3;
    @FXML
    private Button rightButton4;
    @FXML
    private Button rightButton5;
    @FXML
    private Button rightButton7;
    @FXML
    private Button rightButton8;
    @FXML
    private Button rightButton9;
    @FXML
    private Button rightButton10;
    @FXML
    private Button rightButton11;
    @FXML
    private Button leftButton1;
    @FXML
    private Button leftButton2;
    @FXML
    private Button leftButton3;
    @FXML
    private Button leftButton4;
    @FXML
    private Button leftButton5;
    @FXML
    private Button leftButton7;
    @FXML
    private Button leftButton8;
    @FXML
    private Button leftButton9;
    @FXML
    private Button leftButton10;
    @FXML
    private Button leftButton11;
    @FXML
    private Pane square01;
    @FXML
    private Pane square02;
    @FXML
    private Pane square03;
    @FXML
    private Pane square04;
    @FXML
    private Pane square05;
    @FXML
    private Pane square07;
    @FXML
    private Pane square08;
    @FXML
    private Pane square09;
    @FXML
    private Pane square10;
    @FXML
    private Pane square11;
    @FXML
    private Label squarePoint0 = new Label();
    @FXML
    private Label squarePoint1 = new Label();
    @FXML
    private Label squarePoint2 = new Label();
    @FXML
    private Label squarePoint3 = new Label();
    @FXML
    private Label squarePoint4 = new Label();
    @FXML
    private Label squarePoint5 = new Label();
    @FXML
    private Label squarePoint6 = new Label();
    @FXML
    private Label squarePoint7 = new Label();
    @FXML
    private Label squarePoint8 = new Label();
    @FXML
    private Label squarePoint9=new Label();
    @FXML
    private Label squarePoint10=new Label();
    @FXML
    private Label squarePoint11=new Label();

    @FXML
    private Label playerGems1 = new Label();

    @FXML
    private Label playerGems2 = new Label();
    @FXML
    private Label player1Score = new Label();
    @FXML
    private Label player2Score = new Label();

    @FXML
    private Button exitGame;
    @FXML
    private ImageView gemIcon1;
    @FXML
    private ImageView gemIcon2;
    @FXML
    private ImageView broad;
    @FXML
    private ImageView xIcon1;
    @FXML
    private ImageView xIcon2;
    @FXML
    private ImageView exitButtonImage;
    private Player player1;
    private Player player2;
    private Broad broadGame;
    private static GameController gameController;

    @FXML
    public void exitBroad(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) exitGame.getScene().getWindow();
        stage.close();
        GameApplication.getInstance().pauseMusic();
        GameApplication.getInstance().backToMenu();
    }

    @FXML
    public void initialize()
    {
        gameController = new GameController();
        if(gameController.isTurn()  == true)          //turn player 1
        {
            for(Pane square : Arrays.asList(square01, square02, square03, square04,square05))
            {
                square.setDisable(false);
            }
            for(Pane square: Arrays.asList(square07, square08, square09, square10,square11))
            {
                square.setDisable(true);
            }
            flag1.setVisible(true);
            flag2.setVisible(false);
        }else                               // turn player 2
        {
            for(Pane square : Arrays.asList(square01, square02, square03, square04,square05))
            {
                square.setDisable(true);
            }
            for(Pane square: Arrays.asList(square07, square08, square09, square10,square11))
            {
                square.setDisable(false);
            }
            flag1.setVisible(false);
            flag2.setVisible(true);
        }
//        player1 = gameController.getPlayer(1);
//        player2 = gameController.getPlayer(2);
//        broadGame = gameController.getBroad();
        setSquareGem();
        setPlayerDetail();
        System.out.println("Khoi tao thanh cong");
    }

    @FXML
    void squareChoose(MouseEvent mouseEvent) {
        System.out.println("choose square");
        Pane squarePane = (Pane) mouseEvent.getPickResult().getIntersectedNode();
        ObservableList<Node> childrenElements = squarePane.getChildren();

        String squareId = squarePane.getId();
        System.out.println(squareId);
        int square_num = Integer.parseInt(squareId.substring(squareId.length()-2));
        System.out.println(square_num);

        for(ImageView imageArrow: Arrays.asList(directionL01, directionL02, directionL03, directionL04, directionL05, directionL07
                ,directionL08,directionL09,directionL10,directionL11,directionR01,directionR02, directionR03, directionR04
                ,directionR05,directionR07,directionR08,directionR09,directionR10,directionR11))
        {
                imageArrow.setVisible(false);
        }

        for(Button directionButton: Arrays.asList(leftButton1, leftButton2, leftButton3,leftButton4,leftButton5,leftButton7
                ,leftButton8,leftButton9,leftButton10,leftButton11,rightButton1, rightButton2,rightButton3,rightButton4
                ,rightButton5,rightButton7,rightButton8,rightButton9,rightButton10,rightButton11))
        {
                directionButton.setVisible(false);
        }
        for(Node node:childrenElements) {
            node.setVisible(true);
        }
    }

    @FXML
    public void chooseRight(ActionEvent event) {
        System.out.println("choose right direction");
        Pane squareChoose = (Pane) ((Node) event.getTarget()).getParent();
        String squareId = squareChoose.getId();
        int index = Integer.parseInt(squareId.substring(squareId.length()-2));
        System.out.println(gameController.isTurn());
        if(gameController.isTurn())
        {
            gameController.gameMethod(gameController.getPlayer(1), 1, index);  //cùng chiều kim dh
        }else
        {
            gameController.gameMethod(gameController.getPlayer(2), 0, index);  // ngược
        }
        reload();
    }

    @FXML
    public void chooseLeft(ActionEvent event) {
        System.out.println("choose left direction");
        Pane squareChoose = (Pane) ((Node) event.getTarget()).getParent();
        String squareId = squareChoose.getId();
        int index = Integer.parseInt(squareId.substring(squareId.length()-2));
        System.out.println(gameController.isTurn());
        if(gameController.isTurn())
        {
            gameController.gameMethod(gameController.getPlayer(1), 0, index);    //ngược
        }else
        {
            System.out.println("player2");
            gameController.gameMethod(gameController.getPlayer(2), 1, index);   // cùng chiều
        }
        reload();
    }

    public void setSquareGem()
    {
        squarePoint0.setText(Integer.toString(gameController.getBroad().getSquareList().get(0).getGemsInSquare().size()));
        squarePoint1.setText(Integer.toString(gameController.getBroad().getSquareList().get(1).getGemsInSquare().size()));
        squarePoint2.setText(Integer.toString(gameController.getBroad().getSquareList().get(2).getGemsInSquare().size()));
        squarePoint3.setText(Integer.toString(gameController.getBroad().getSquareList().get(3).getGemsInSquare().size()));
        squarePoint4.setText(Integer.toString(gameController.getBroad().getSquareList().get(4).getGemsInSquare().size()));
        squarePoint5.setText(Integer.toString(gameController.getBroad().getSquareList().get(5).getGemsInSquare().size()));
        squarePoint6.setText(Integer.toString(gameController.getBroad().getSquareList().get(6).getGemsInSquare().size()));
        squarePoint7.setText(Integer.toString(gameController.getBroad().getSquareList().get(7).getGemsInSquare().size()));
        squarePoint8.setText(Integer.toString(gameController.getBroad().getSquareList().get(8).getGemsInSquare().size()));
        squarePoint9.setText(Integer.toString(gameController.getBroad().getSquareList().get(9).getGemsInSquare().size()));
        squarePoint10.setText(Integer.toString(gameController.getBroad().getSquareList().get(10).getGemsInSquare().size()));
        squarePoint11.setText(Integer.toString(gameController.getBroad().getSquareList().get(11).getGemsInSquare().size()));
    }

    public void setPlayerDetail()
    {
        playerGems1.setText(Integer.toString(gameController.getPlayer(1).getGems().size()));
        playerGems2.setText(Integer.toString(gameController.getPlayer(2).getGems().size()));
        player1Score.setText(Integer.toString(gameController.playerPointCaculate(gameController.getPlayer(1))));
        player2Score.setText(Integer.toString(gameController.playerPointCaculate(gameController.getPlayer(2))));
    }
    public void reload()
    {
        if(gameController.isTurn())          //turn player 1
        {
            for(Pane square : Arrays.asList(square01, square02, square03, square04,square05))
            {
                square.setDisable(false);
            }
            for(Pane square: Arrays.asList(square07, square08, square09, square10,square11))
            {
                square.setDisable(true);
            }
            flag1.setVisible(true);
            flag2.setVisible(false);
            if(gameController.endGameCheck())
            {
                GameApplication.getInstance().pauseMusic();
                GameApplication.getInstance().endGameScreen(gameController.endGame());
            }
            else if(gameController.isPlayerSquareEmpty(gameController.getPlayer(1)))
            {
                gameController.autoAddGem(gameController.getPlayer(1));
            }
            setSquareGem();
            setPlayerDetail();
            System.out.println("reload broad successfull");
        }else                               // turn player 2
        {
            for(Pane square : Arrays.asList(square01, square02, square03, square04,square05))
            {
                square.setDisable(true);
            }
            for(Pane square: Arrays.asList(square07, square08, square09, square10,square11))
            {
                square.setDisable(false);
            }
            flag1.setVisible(false);
            flag2.setVisible(true);
            if(gameController.endGameCheck())
            {
                GameApplication.getInstance().pauseMusic();
                GameApplication.getInstance().endGameScreen(gameController.endGame());
            }
            else if(gameController.isPlayerSquareEmpty(gameController.getPlayer(2)))
            {
                gameController.autoAddGem(gameController.getPlayer(2));
            }
            setSquareGem();
            setPlayerDetail();
            System.out.println("reload broad successfull");
        }
    }

}
