package controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.ParkingSlot;
import model.Vehicle;
import view.tm.InParkingTM;


import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import static controller.AddVehicleFormController.vehicleList;

public class ManagementDashboardFormController {
    public AnchorPane InParkingContext;
    public AnchorPane inParkingContext;
    public JFXButton addVehicleBtn;
    public JFXButton addDriverBtn;
    public JFXButton logOutBtn;
    public TableView tblInParking;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colParkingTime;



    public void initialize(){
        colVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colParkingSlot.setCellValueFactory(new PropertyValueFactory<>("parkingSlot"));
        colParkingTime.setCellValueFactory(new PropertyValueFactory<>("parkingTime"));

        loadAllVehicles();

    }



//    public int findSlot(String vehicleType){
//        for (ParkingSlot temp:parkingSlots
//             ) {
//            if(temp.getVehicleType()==vehicleType && temp.getIsParked()==false){
//                temp.setIsParked(true);
//                return temp.getParkingSlotA();
//            }
//        }
//        return 0;
//    }

    public void loadAllVehicles(){

        ObservableList<InParkingTM> inParkingTMObservableList= FXCollections.observableArrayList();
        for (Vehicle v:vehicleList
             ) {
            if(v.getIsParked()==true){
                inParkingTMObservableList.add(
                        new InParkingTM(v.getVehicleNumber(),v.getVehicleType(),v.getParkingSlot(),v.getParkingTime())
                );
            }
        }
        tblInParking.setItems(inParkingTMObservableList);
    }

    public void openManagementOnDeliveryTableOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ManagementOnDeliveryTableForm.fxml");
        Parent load = FXMLLoader.load(resource);
        InParkingContext.getChildren().clear();
        InParkingContext.getChildren().add(load);
    }

    public void openManagementInParkingOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ManagementDashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        inParkingContext.getChildren().clear();
        inParkingContext.getChildren().add(load);
    }

    public void openAddVehicleWindowOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        Stage stage=(Stage) addVehicleBtn.getScene().getWindow();
        stage.setScene(scene);
    }

    public void openAddDriverWindowOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriverForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        Stage stage=(Stage) addDriverBtn.getScene().getWindow();
        stage.setScene(scene);
    }

    public void openDashBoardWindowOnAction(ActionEvent actionEvent) throws IOException {
        ButtonType yes=new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no=new ButtonType("No",ButtonBar.ButtonData.CANCEL_CLOSE);

        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure Whether You Want To Log Out?",yes,no);
        alert.setTitle("Confirmation Alert");
        Optional<ButtonType> result= alert.showAndWait();

        if(result.orElse(no)==yes){

            URL resource = getClass().getResource("../view/DashBoardForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Scene scene=new Scene(load);
            Stage stage=(Stage) logOutBtn.getScene().getWindow();
            stage.setScene(scene);
        }else{

        }
    }
}
