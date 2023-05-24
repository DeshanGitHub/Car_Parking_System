package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Driver;
import model.ParkingSlot;
import model.Vehicle;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static controller.AddDriverFormController.driverArrayList;
import static controller.AddDriverFormController.parkingSlots;
import static controller.AddVehicleFormController.vehicleList;

public class OnDeliveryShiftFormController {
    public AnchorPane onDeliveryShiftContext;
    public ChoiceBox<String> cmbSelectYourVehicle;
    public ChoiceBox<String> cmbSelectDriverName;
    public TextField txtVehicleTypeId;
    public TextField txtLeftTimeId;

    private ArrayList<String> vehicleNumbers = new ArrayList<>();
    private ArrayList<String> driverNames = new ArrayList<>();

    public void initialize() {
        filVehicleNumbersArray();
        cmbSelectYourVehicle.getItems().addAll(vehicleNumbers);

        filDriverNamesArray();
        cmbSelectDriverName.getItems().addAll(driverNames);
    }

    public String findTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        return formatter.format(date);
    }

    public void filDriverNamesArray() {
        for (Driver d : driverArrayList
        ) {
            if(d.getIsAvailableDriver()==true){
                driverNames.add(d.getDriverName());
            }
        }
    }

    public void filVehicleNumbersArray() {
        for (Vehicle v : vehicleList
        ) {
            if(v.getIsParked()==true){
                vehicleNumbers.add(v.getVehicleNumber());
            }
        }
    }

    public void openDashBoardWindowOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage window = (Stage) onDeliveryShiftContext.getScene().getWindow();
        window.setScene(scene);
    }

    public void onDeliveryShiftButtonOnAction(ActionEvent actionEvent) {
        for (Vehicle v:vehicleList
             ) {
            if(cmbSelectYourVehicle.getValue()==v.getVehicleNumber()){
                v.setIsParked(false);
                v.setVehicleDriverName(cmbSelectDriverName.getValue());
                v.setLeftTime(findTime());
                txtVehicleTypeId.setText(v.getVehicleType());
                txtLeftTimeId.setText(v.getLeftTime());
                for (ParkingSlot ps:parkingSlots
                ) {
                    if(ps.getParkingSlotA()==v.getParkingSlot()){
                        ps.setIsParked(false);
                        v.setParkingSlot(0);
                    }
                }
            }
        }
        for (Driver d:driverArrayList
             ) {
            if(cmbSelectDriverName.getValue()==d.getDriverName()){
                d.setAvailableDriver(false);
            }
        }
    }
}
