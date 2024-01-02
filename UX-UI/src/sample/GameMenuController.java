package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GameMenuController {
    @FXML
    private Button helpButton;
    @FXML
    private Button exitButtonHome;
    @FXML
    private void playGame(ActionEvent event) {
        Main.getInstance().showGamePanel();
    }

    @FXML
    private void exitHome(ActionEvent event) {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle("Xác nhận thoát");
        confirmationDialog.setHeaderText(null);
        confirmationDialog.setContentText("Bạn có chắc muốn thoát game không?");

        
        ButtonType yesButton = new ButtonType("Có");
        ButtonType noButton = new ButtonType("Không");

        
        confirmationDialog.getButtonTypes().setAll(yesButton, noButton);

        
        confirmationDialog.showAndWait().ifPresent(response -> {
            if (response == yesButton) {
                
                Stage stage = (Stage) exitButtonHome.getScene().getWindow();
                stage.close();
            }
            
        });
    }
    
    @FXML
    void help(ActionEvent event) {
        try {
            // Tạo FXMLLoader để tải màn hình Help từ tệp FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("help.fxml"));
            Parent root = loader.load();

            // Tạo Stage mới để hiển thị màn hình Help
            Stage helpStage = new Stage();
            helpStage.initModality(Modality.APPLICATION_MODAL); // Đặt chế độ modal
            helpStage.setTitle("Game Help");
            helpStage.setScene(new Scene(root));
            helpStage.showAndWait(); // Hiển thị và chờ đến khi cửa sổ Help đóng đi để quay lại GameMenu
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
