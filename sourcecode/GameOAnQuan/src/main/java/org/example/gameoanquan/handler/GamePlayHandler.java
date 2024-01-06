package org.example.gameoanquan.handler;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.gameoanquan.AppController.GameController;
import org.example.gameoanquan.GameApplication;
import org.example.gameoanquan.entity.Player;
import org.example.gameoanquan.entity.Square;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

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
    private Label playerPoint1 = new Label();

    @FXML
    private Label playerPoint2 = new Label();

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

    private Player player1;
    private Player player2;
    private List<Square> broadGame;
    private static final GameController gameController = new GameController();

    public void exitBroad(ActionEvent actionEvent) throws Exception {
        GameApplication.getInstance().backToMenu();
    }

//    public GamePlayHandler() {
//        this.initialize();
//    }

    public void initialize()
    {
        if(gameController.isTurn())          //turn player 1
        {
            gameController.changeTurn();
            for(Pane square : Arrays.asList(square01, square02, square03, square04,square05))
            {
                square.setDisable(false);
            }
            for(Pane square: Arrays.asList(square07, square08, square09, square10,square11))
            {
                square.setDisable(true);
            }
            player1Avatar.setVisible(false);
            player1Avatar.setVisible(true);
        }else                               // turn player 2
        {
            gameController.changeTurn();
            for(Pane square : Arrays.asList(square01, square02, square03, square04,square05))
            {
                square.setDisable(true);
            }
            for(Pane square: Arrays.asList(square07, square08, square09, square10,square11))
            {
                square.setDisable(false);
            }
            player1Avatar.setVisible(true);
            player1Avatar.setVisible(false);
        }
        player1 = gameController.getPlayer(1);
        player2 = gameController.getPlayer(2);
        broadGame = gameController.getBroad();
        setSquareGem();
        setPlayerPoint();
        System.out.println("Khoi tao thanh cong");
    }

    @FXML
    void squareChoose(MouseEvent mouseEvent) {
        System.out.println("choose square");
        Pane squarePane = (Pane) mouseEvent.getPickResult().getIntersectedNode();
        ObservableList<Node> childrenElements = squarePane.getChildren();

        String squareId = squarePane.getId();
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
        Pane squareChoose = (Pane) ((Node) event.getTarget()).getParent();
        String squareId = squareChoose.getId();
        int index = Integer.parseInt(squareId.substring(squareId.length()-2));
        if(gameController.isTurn())
        {
            gameController.gameMethod(gameController.getPlayer(1), 1, index);  //cùng chiều kim dh
        }else
        {
            gameController.gameMethod(gameController.getPlayer(2), 0, index);  // ngược
        }
        player1 = gameController.getPlayer(1);
        player2 = gameController.getPlayer(2);
        broadGame = gameController.getBroad();
        setSquareGem();
        setPlayerPoint();
        if(gameController.endGameCheck())
        {
            GameApplication.getInstance().endGameScreen(gameController.endGame());
        }
    }

    @FXML
    public void chooseLeft(ActionEvent event) {
        Pane squareChoose = (Pane) ((Node) event.getTarget()).getParent();
        String squareId = squareChoose.getId();
        int index = Integer.parseInt(squareId.substring(squareId.length()-2));
        if(gameController.isTurn())
        {
            gameController.gameMethod(gameController.getPlayer(1), 0, index);    //ngược
        }else
        {
            gameController.gameMethod(gameController.getPlayer(2), 1, index);   // cùng chiều
        }
        player1 = gameController.getPlayer(1);
        player2 = gameController.getPlayer(2);
        broadGame = gameController.getBroad();
        setSquareGem();
        setPlayerPoint();
        if(gameController.endGameCheck())
        {
            GameApplication.getInstance().endGameScreen(gameController.endGame());
        }
    }

    public void setSquareGem()
    {
        for (int i = 0; i < 12; i++) {
            squarePoint0.setText(Integer.toString(broadGame.get(i).getSquarePoint()));
            squarePoint1.setText(Integer.toString(broadGame.get(i).getSquarePoint()));
            squarePoint2.setText(Integer.toString(broadGame.get(i).getSquarePoint()));
            squarePoint3.setText(Integer.toString(broadGame.get(i).getSquarePoint()));
            squarePoint4.setText(Integer.toString(broadGame.get(i).getSquarePoint()));
            squarePoint5.setText(Integer.toString(broadGame.get(i).getSquarePoint()));
            squarePoint6.setText(Integer.toString(broadGame.get(i).getSquarePoint()));
            squarePoint7.setText(Integer.toString(broadGame.get(i).getSquarePoint()));
            squarePoint8.setText(Integer.toString(broadGame.get(i).getSquarePoint()));
            squarePoint9.setText(Integer.toString(broadGame.get(i).getSquarePoint()));
            squarePoint10.setText(Integer.toString(broadGame.get(i).getSquarePoint()));
            squarePoint11.setText(Integer.toString(broadGame.get(i).getSquarePoint()));
        }
    }

    public void setPlayerPoint()
    {
        playerPoint1.setText(Integer.toString(player1.getPlayerPoint()));
        playerPoint2.setText(Integer.toString(player2.getPlayerPoint()));
    }


}
