package view.tm;

import javafx.scene.control.Button;

public class VehicleTM {
    private String vehicleNumber;
    private String maximumWeight;
    private String noOfPassengers;
    private String vehicleType;
    private Button btn;

    public VehicleTM() {
    }

    public VehicleTM(String vehicleNumber, String maximumWeight, String noOfPassengers, String vehicleType, Button btn) {
        this.setVehicleNumber(vehicleNumber);
        this.setMaximumWeight(maximumWeight);
        this.setNoOfPassengers(noOfPassengers);
        this.setVehicleType(vehicleType);
        this.setBtn(btn);
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(String maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public String getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(String noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
