package model;

public class Vehicle {
    private String vehicleNumber;
    private String maximumWeight;
    private String noOfPassengers;
    private String vehicleType;
    private boolean isParked;

    private int parkingSlot;
    private String parkingTime;
    private String vehicleDriverName;
    private String leftTime;

    public String getVehicleDriverName() {
        return vehicleDriverName;
    }

    public void setVehicleDriverName(String vehicleDriverName) {
        this.vehicleDriverName = vehicleDriverName;
    }

    public int getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(int parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(String parkingTime) {
        this.parkingTime = parkingTime;
    }



    public Vehicle() {

    }

    public Vehicle(String vehicleNumber, String maximumWeight, String noOfPassengers, String vehicleType , boolean isParked) {
        this.setVehicleNumber(vehicleNumber);
        this.setMaximumWeight(maximumWeight);
        this.setNoOfPassengers(noOfPassengers);
        this.setVehicleType(vehicleType);
        this.setIsParked(isParked);
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

    public boolean getIsParked(){return isParked;}

    public void setIsParked(boolean isParked){
        this.isParked=isParked;
    }

    public String getLeftTime() {
        return leftTime;
    }

    public void setLeftTime(String leftTime) {
        this.leftTime = leftTime;
    }
}
