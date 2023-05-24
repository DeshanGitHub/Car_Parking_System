package model;

public class ParkingSlot {
    private String vehicleType;
    private int parkingSlot;
    private boolean isParked;


    public ParkingSlot() {}

    public ParkingSlot(String vehicleType, int parkingSlot) {
        this.setVehicleType(vehicleType);
        this.setParkingSlot(parkingSlot);

    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getParkingSlotA() {
        return parkingSlot;
    }

    public void setParkingSlot(int parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public boolean getIsParked() {
        return isParked;
    }

    public void setIsParked(boolean parked) {
        isParked = parked;
    }

}
