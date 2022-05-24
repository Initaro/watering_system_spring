package entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ivaylo Ivanov
 */
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer deviceId;
    private String deviceName;
    private String deviceLocation;
    private String deviceEndpoint;

    public Device() {}

    public Device(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Device(Integer deviceId, String deviceName, String deviceLocation, String deviceEndpoint) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceLocation = deviceLocation;
        //this.deviceEndpoint = deviceEndpoint;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceLocation() {
        return deviceLocation;
    }

    public void setDeviceLocation(String deviceLocation) {
        this.deviceLocation = deviceLocation;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceEndpoint() {
        return deviceEndpoint;
    }

    public void setDeviceEndpoint(String deviceEndpoint) {
        this.deviceEndpoint = deviceEndpoint;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deviceId != null ? deviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Device)) {
            return false;
        }

        Device other = (Device) object;

        if ((this.deviceId == null && other.deviceId != null) || (this.deviceId != null && !this.deviceId.equals(other.deviceId))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", deviceName='" + deviceName + '\'' +
                ", deviceLocation='" + deviceLocation + '\'' +
                ", deviceEndpoint='" + deviceEndpoint + '}';
    }
}