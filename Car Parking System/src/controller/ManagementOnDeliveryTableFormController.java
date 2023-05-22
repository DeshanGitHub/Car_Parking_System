package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Vehicle;
import view.tm.OnDeliveryTM;

import static controller.AddVehicleFormController.vehicleList;

public class ManagementOnDeliveryTableFormController {
    public TableView tblOnDelivery;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colDriverName;
    public TableColumn colLeftTime;

    public void initialize(){
        colVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory<>("leftTime"));

        loadOnDeliveryVehicle();
    }

    public void loadOnDeliveryVehicle(){
        ObservableList<OnDeliveryTM> onDeliveryTMObservableList= FXCollections.observableArrayList();
        for (Vehicle v:vehicleList
             ) {
            if(v.getIsParked()==false){
                onDeliveryTMObservableList.add(
                        new OnDeliveryTM(v.getVehicleNumber(),v.getVehicleType(),v.getVehicleDriverName(),v.getLeftTime())
                );
            }
        }

        tblOnDelivery.setItems(onDeliveryTMObservableList);
    }
}
