package entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Ivaylo Ivanov
 */
public class    SensorData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer sensorDataId;
    private String sensorValue;
    private Date sensorValueDate;
    private Sensor sensorId;

    public SensorData() {}

    public SensorData(Integer sensorDataId) {
        this.sensorDataId = sensorDataId;
    }

    public SensorData(Sensor sensorId, String sensorValue, Date sensorValueDate) {
        this.sensorId = sensorId;
        this.sensorValue = sensorValue;
        this.sensorValueDate = sensorValueDate;
    }

    public Integer getSensorDataId() {
        return sensorDataId;
    }

    public void setSensorDataId(Integer sensorDataId) {
        this.sensorDataId = sensorDataId;
    }

    public String getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(String sensorValue) {
        this.sensorValue = sensorValue;
    }

    public Date getSensorValueDate() {
        return sensorValueDate;
    }

    public void setSensorValueDate(Date sensorValueDate) {
        this.sensorValueDate = sensorValueDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sensorDataId != null ? sensorDataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SensorData)) {
            return false;
        }

        SensorData other = (SensorData) object;

        if ((this.sensorDataId == null && other.sensorDataId != null) || (this.sensorDataId != null && !this.sensorDataId.equals(other.sensorDataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return sensorId + " " + sensorValue;
    }

}