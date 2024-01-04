package org.example.gameoanquan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.gameoanquan.viewController.GameMenuController;

import java.io.*;


public class GameApplication extends Application {
    private static GameApplication instance;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        instance = this;
        this.primaryStage = primaryStage;

        showHomePanel();
    }

    public static GameApplication getInstance() {
        return instance;
    }

    public void showHomePanel() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GameMenu.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showGamePanel() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GamePanel.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScreen.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}