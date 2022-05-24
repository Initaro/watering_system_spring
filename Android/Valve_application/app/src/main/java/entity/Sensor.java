package entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ivaylo Ivanov
 */
public class Sensor implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer sensorId;
    private Device deviceId;
    private SensorType sensorTypeId;

    public Sensor() {}

    public Sensor(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Device getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Device deviceId) {
        this.deviceId = deviceId;
    }

    public SensorType getSensorTypeId() {
        return sensorTypeId;
    }

    public void setSensorTypeId(SensorType sensorTypeId) {
        this.sensorTypeId = sensorTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sensorId != null ? sensorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sensor)) {
            return false;
        }

        Sensor other = (Sensor) object;

        if ((this.sensorId == null && other.sensorId != null) || (this.sensorId != null && !this.sensorId.equals(other.sensorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sensorId = " + sensorId;
    }

}