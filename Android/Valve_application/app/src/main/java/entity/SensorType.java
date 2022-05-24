package entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ivaylo Ivanov
 */
public class SensorType implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer sensorTypeId;
    private String sensorType;
    private String dataType;

    public SensorType() {}

    public SensorType(Integer sensorTypeId) {
        this.sensorTypeId = sensorTypeId;
    }

    public SensorType(Integer sensorTypeId, String sensorType, String dataType) {
        this.sensorTypeId = sensorTypeId;
        this.sensorType = sensorType;
        this.dataType = dataType;
    }

    public Integer getSensorTypeId() {
        return sensorTypeId;
    }

    public void setSensorTypeId(Integer sensorTypeId) {
        this.sensorTypeId = sensorTypeId;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sensorTypeId != null ? sensorTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SensorType)) {
            return false;
        }

        SensorType other = (SensorType) object;

        if ((this.sensorTypeId == null && other.sensorTypeId != null) || (this.sensorTypeId != null && !this.sensorTypeId.equals(other.sensorTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.watering_system.data.entity.watering_system.resources.SensorType[ sensorTypeId=" + sensorTypeId + " ]";
    }

}