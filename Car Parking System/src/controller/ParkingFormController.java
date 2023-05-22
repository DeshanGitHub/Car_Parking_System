package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Driver;
import model.ParkingSlot;
import model.Vehicle;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static controller.AddDriverFormController.driverArrayList;
import static controller.AddVehicleFormController.vehicleList;
import static controller.AddDriverFormController.parkingSlots;

public class ParkingFormController {
    public AnchorPane ParkingContext;
    public ChoiceBox<String> cmbSelectYourVehicle;
    public TextField txtVehicleType;
    public TextField txtDriver;
    public TextField txtParkedTime;
    public Label lblParkingSlotNo;

    private ArrayList<String> vehicleNumbers=new ArrayList<>();

    public void initialize(){
        filVehicleNumbersArray();
        cmbSelectYourVehicle.getItems().addAll(vehicleNumbers);
    }

    private void filVehicleNumbersArray(){
        for (Vehicle v:vehicleList
             ) {
            if(v.getIsParked()==false){
                vehicleNumbers.add(v.getVehicleNumber());
            }
        }
    }

    public void openDashBoardFormWindowOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        Stage window =(Stage) ParkingContext.getScene().getWindow();
        window.setScene(scene);

    }

    public int findSlot(String vehicleType){
        for (ParkingSlot temp:parkingSlots
        ) {
            for (Vehicle v:vehicleList
                 ) {
                if(temp.getVehicleType()==vehicleType && temp.getIsParked()==false && temp.getParkingSlotA()!=v.getParkingSlot()){
                    temp.setIsParked(true);
                    return temp.getParkingSlotA();
                }
            }
        }
        return 0;
    }

    public String findTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        return formatter.format(date);
    }

    public void getSlotButtonOnAction(ActionEvent actionEvent) {
        for (Vehicle v:vehicleList
             ) {
            if(v.getVehicleNumber()==cmbSelectYourVehicle.getValue()){
                v.setIsParked(true);
                v.setParkingSlot(findSlot(v.getVehicleType()));
                v.setParkingTime(findTime());
                txtVehicleType.setText(v.getVehicleType());
                txtDriver.setText(v.getVehicleDriverName());
                txtParkedTime.setText(v.getParkingTime());
                lblParkingSlotNo.setText(Integer.toString(v.getParkingSlot()));

                for (Driver d:driverArrayList
                ) {
                    if(v.getVehicleDriverName()==d.getDriverName()){
                        d.setAvailableDriver(true);
                    }
                }
            }
        }
    }
}
