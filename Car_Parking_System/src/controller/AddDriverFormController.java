package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Driver;
import model.ParkingSlot;
import view.tm.DriverTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class AddDriverFormController {
    public JFXButton backBtn;
    public TableView tblDrivers;
    public TableColumn colDriverName;

    public TableColumn colDrivingLicenseNo;
    public TableColumn colAddress;
    public TableColumn colContactNo;
    public TableColumn colDelete;
    public JFXTextField txtDriverName;
    public JFXTextField txtNIC;
    public JFXTextField txtDriverLicenseNo;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;

    private static boolean temp1;

    static ArrayList<Driver> driverArrayList=new ArrayList();
    public TableColumn colNIC;

    static ParkingSlot[] parkingSlots=new ParkingSlot[14];

    public void initialize(){
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        colDrivingLicenseNo.setCellValueFactory(new PropertyValueFactory<>("drivingLicenseNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));

        loadAllDrivers();
        if(temp1==false){
            loadParkingSlotArray();
            temp1=true;
        }
    }

    private void loadParkingSlotArray(){
        parkingSlots[0]=new ParkingSlot("Van",1);
        parkingSlots[1]=new ParkingSlot("Van",2);
        parkingSlots[2]=new ParkingSlot("Van",3);
        parkingSlots[3]=new ParkingSlot("Van",4);
        parkingSlots[4]=new ParkingSlot("Cargo Lorry",5);
        parkingSlots[5]=new ParkingSlot("Cargo Lorry",6);
        parkingSlots[6]=new ParkingSlot("Cargo Lorry",7);
        parkingSlots[7]=new ParkingSlot("Cargo Lorry",8);
        parkingSlots[8]=new ParkingSlot("Cargo Lorry",9);
        parkingSlots[9]=new ParkingSlot("Cargo Lorry",10);
        parkingSlots[10]=new ParkingSlot("Cargo Lorry",11);
        parkingSlots[11]=new ParkingSlot("Van",12);
        parkingSlots[12]=new ParkingSlot("Van",13);
        parkingSlots[13]=new ParkingSlot("Bus",14);
    }

    public void openManagementWindowFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ManagementDashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.setScene(scene);
    }

    public void saveUpdateOnAction(ActionEvent actionEvent) {
        Driver driver=new Driver(txtDriverName.getText(),txtNIC.getText(),txtDriverLicenseNo.getText(),txtAddress.getText(),txtContactNo.getText(),true);
        txtDriverName.clear();
        txtNIC.clear();
        txtDriverLicenseNo.clear();
        txtAddress.clear();
        txtContactNo.clear();

        if (driverArrayList.add(driver)){
            loadAllDrivers();
            new Alert(Alert.AlertType.CONFIRMATION,"Saved..", ButtonType.CLOSE).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try Again..",ButtonType.CLOSE).show();
        }
    }

    private void loadAllDrivers(){
        ObservableList<DriverTM> tmObservableList= FXCollections.observableArrayList();
        for (Driver temp: driverArrayList
             ) {
            Button btn=new Button("Delete");
            tmObservableList.add(new DriverTM(temp.getDriverName(),temp.getNIC(),temp.getDrivingLicenseNo(),temp.getAddress(),temp.getContactNo(),btn));

            btn.setOnAction((e)->{
                ButtonType yes=new ButtonType("Yes",ButtonBar.ButtonData.OK_DONE);
                ButtonType no=new ButtonType("No",ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure Whether You Want to Delete This Driver?",yes,no);
                alert.setTitle("Confirmation Alert");

                Optional<ButtonType> result=alert.showAndWait();

                if(result.orElse(no)==yes){
                    driverArrayList.remove(temp);
                    loadAllDrivers();
                }else{

                }
            });
        }

        tblDrivers.setItems(tmObservableList);
    }
}
