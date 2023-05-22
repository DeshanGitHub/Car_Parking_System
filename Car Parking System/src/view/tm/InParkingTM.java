package view.tm;

public class InParkingTM {
        private String vehicleNumber;
        private String vehicleType;
        private int parkingSlot;
        private String parkingTime;

        public InParkingTM() {}

        public InParkingTM(String vehicleNumber, String vehicleType, int parkingSlot, String parkingTime) {
                this.setVehicleNumber(vehicleNumber);
                this.setVehicleType(vehicleType);
                this.setParkingSlot(parkingSlot);
                this.setParkingTime(parkingTime);
        }

        public String getVehicleNumber() {
                return vehicleNumber;
        }

        public void setVehicleNumber(String vehicleNumber) {
                this.vehicleNumber = vehicleNumber;
        }

        public String getVehicleType() {
                return vehicleType;
        }

        public void setVehicleType(String vehicleType) {
                this.vehicleType = vehicleType;
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
}
