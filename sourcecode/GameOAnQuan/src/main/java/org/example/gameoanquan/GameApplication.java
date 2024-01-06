package org.example.gameoanquan;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.gameoanquan.handler.EndGameHandler;
import org.example.gameoanquan.handler.GamePlayHandler;
import org.example.gameoanquan.handler.HomeHandler;
import org.example.gameoanquan.utlis.Configs;

import java.io.*;


public class GameApplication extends Application {

    private static GameApplication instance;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        instance = this;
        this.primaryStage = primaryStage;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("homeScreen.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
    public static GameApplication getInstance() {
        return instance;
    }
    public void showHelp(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("help.fxml"));
            Parent root = loader.load();

            // Tạo Stage mới để hiển thị màn hình Help
            Stage helpStage = new Stage();
            helpStage.initModality(Modality.APPLICATION_MODAL); // Đặt chế độ model
            helpStage.setTitle("Game Help");
            helpStage.setScene(new Scene(root));
            helpStage.showAndWait(); // Hiển thị và chờ đến khi cửa sổ Help đóng đi để quay lại GameMenu
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showGameScreen(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gameScreen.fxml"));
            System.out.println("aa");
            //GamePlayHandler gamePlayHandler = new GamePlayHandler();
            //loader.getController();
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void backToMenu() throws Exception {
        start(primaryStage);
    }
    public void endGameScreen(int winner)
    {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("endGameScreen.fxml"));

            Stage endStage = new Stage();
            endStage.setScene(new Scene(loader.load()));
            EndGameHandler endGameHandler = loader.getController();
            endGameHandler.initData(winner);
            endStage.initModality(Modality.APPLICATION_MODAL); // Đặt chế độ model
            endStage.showAndWait(); // Hiển thị và chờ đến khi cửa sổ Help đóng đi để quay lại GameMenu
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}