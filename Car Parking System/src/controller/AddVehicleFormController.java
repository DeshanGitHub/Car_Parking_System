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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Vehicle;
import view.tm.VehicleTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class AddVehicleFormController {
    public JFXButton backBtn;
    public AnchorPane vehicleFormContext;
    public TableView<VehicleTM> tblVehicle;
    public TableColumn colVehicleNumber;
    public TableColumn colMaximumWeight;
    public TableColumn colNoOfPassengers;
    public TableColumn colVehicleType;
    public TableColumn colDelete;
    public TableColumn colUpdate;
    public JFXTextField txtVehicleNumber;
    public ComboBox<String> comBoxVehicleType;
    public JFXTextField txtNoOfPassengers;
    public JFXTextField txtMaximumWeight;

    private String[] cmbVehicleTypes={"Bus","Van","Cargo Lorry"};

    static ArrayList<Vehicle> vehicleList= new ArrayList();

    private String cmbNewValue;

    public void initialize(){
        comBoxVehicleType.getItems().addAll(cmbVehicleTypes);

        comBoxVehicleType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            cmbNewValue=newValue;
        });

        colVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colMaximumWeight.setCellValueFactory(new PropertyValueFactory<>("maximumWeight"));
        colNoOfPassengers.setCellValueFactory(new PropertyValueFactory<>("noOfPassengers"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));

        loadAllVehicles();
    }

    public void openManagementDashBoardFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ManagementDashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        Stage stage =(Stage) backBtn.getScene().getWindow();
        stage.setScene(scene);
    }

    public void saveUpdateButtonOnAction(ActionEvent actionEvent) {
        Vehicle vehicle= new Vehicle(txtVehicleNumber.getText(),txtMaximumWeight.getText(),txtNoOfPassengers.getText(),cmbNewValue,true);
        txtVehicleNumber.clear();
        txtMaximumWeight.clear();
        txtNoOfPassengers.clear();

        if(vehicleList.add(vehicle)){
            loadAllVehicles();
            new Alert(Alert.AlertType.CONFIRMATION,"Saved..", ButtonType.CLOSE).show();
        }else{
            new Alert(Alert.AlertType.WARNING,"Try Again..", ButtonType.CLOSE).show();
        }
    }

    private void loadAllVehicles(){
        ObservableList<VehicleTM> tmObservableList= FXCollections.observableArrayList();
        for (Vehicle v:vehicleList
             ) {
            Button btn=new Button("Delete");
            tmObservableList.add(
                    new VehicleTM(v.getVehicleNumber(),v.getMaximumWeight(),v.getNoOfPassengers(),v.getVehicleType(),btn)
            );

            btn.setOnAction((event)->{

                ButtonType yes=new ButtonType("Yes",ButtonBar.ButtonData.OK_DONE);
                ButtonType no=new ButtonType("No",ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure Whether You Want To Delete This Vehicle?",yes,no);
                alert.setTitle("Confirmation Alert");
                Optional<ButtonType> result= alert.showAndWait();

                if(result.orElse(no)==yes){
                    vehicleList.remove(v);
                    loadAllVehicles();
                }else{

                }
            });
        }

        tblVehicle.setItems(tmObservableList);

    }
}
