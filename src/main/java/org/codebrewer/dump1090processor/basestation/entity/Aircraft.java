package org.codebrewer.dump1090processor.basestation.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aircraft {

    @Id
    private String icaoAddress;

    private double latitude;

    private double longitude;

    public Aircraft() {
        super();
    }

    public Aircraft(String icaoAddress, double latitude, double longitude) {
        super();
        this.icaoAddress = icaoAddress;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getIcaoAddress() {
        return icaoAddress;
    }

    public void setIcaoAddress(String icaoAddress) {
        this.icaoAddress = icaoAddress;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Aircraft [icaoAddress=" + icaoAddress + ", latitude=" + latitude + ", longitude=" + longitude + "]";
    }


}
