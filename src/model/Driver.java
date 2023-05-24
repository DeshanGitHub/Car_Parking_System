package model;

public class Driver {
        private String driverName;
        private String NIC;
        private String drivingLicenseNo;
        private String address;
        private String contactNo;
        private boolean isAvailableDriver;

    public Driver() {}

    public Driver(String driverName, String NIC, String drivingLicenseNo, String address, String contactNo, boolean isAvailableDriver) {
        this.setDriverName(driverName);
        this.setNIC(NIC);
        this.setDrivingLicenseNo(drivingLicenseNo);
        this.setAddress(address);
        this.setContactNo(contactNo);
        this.setAvailableDriver(isAvailableDriver);
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getDrivingLicenseNo() {
        return drivingLicenseNo;
    }

    public void setDrivingLicenseNo(String drivingLicenseNo) {
        this.drivingLicenseNo = drivingLicenseNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public boolean getIsAvailableDriver() {
        return isAvailableDriver;
    }

    public void setAvailableDriver(boolean availableDriver) {
        isAvailableDriver = availableDriver;
    }
}
