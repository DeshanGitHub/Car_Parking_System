package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class DashBoardFormController {
    public AnchorPane context;
    public AnchorPane dashBoardWindowContext;
    public AnchorPane loginPageContext;
    public JFXButton cancelButton;
    public JFXButton logInButton;
    public TextField txtUserName;
    public PasswordField txtPassword;

    public void initialize() {
        loginPageContext.setVisible(false);
    }

    public void openParkingWindowOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ParkingForm.fxml");
        Parent load = FXMLLoader.load(resource);
        context.getChildren().clear();
        context.getChildren().add(load);
    }

    public void openOnDeliveryShiftWindowOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/OnDeliveryShiftForm.fxml");
        Parent load = FXMLLoader.load(resource);
        context.getChildren().clear();
        context.getChildren().add(load);
    }

    public void openManagementLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        loginPageContext.setVisible(true);
    }

    public void cancelManagementLoginFormOnAction(ActionEvent actionEvent) {
        loginPageContext.setVisible(false);
    }

    public void openManagementDashBoardFormOnAction(ActionEvent actionEvent) throws IOException {
        if(txtUserName.getText().equals("admin") && txtPassword.getText().equals("123")){
            URL resource = getClass().getResource("../view/ManagementDashboardForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Scene scene = new Scene(load);
            Stage stage=(Stage) logInButton.getScene().getWindow();
            stage.setScene(scene);
        }else{
            txtPassword.clear();
            txtUserName.clear();
            new Alert(Alert.AlertType.WARNING,"Incorrect Username Or Password,Try Again..", ButtonType.CLOSE).show();
        }
    }
}
