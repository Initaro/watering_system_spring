package com.example.watering_system.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * @author halo3
 */
@Entity
@Table(name = "sensor_types")
@NamedQueries({
        @NamedQuery(name = "SensorType.findAll", query = "SELECT s FROM SensorType s"),
        @NamedQuery(name = "SensorType.findBySensorTypeId", query = "SELECT s FROM SensorType s WHERE s.sensorTypeId = :sensorTypeId"),
        @NamedQuery(name = "SensorType.findBySensorType", query = "SELECT s FROM SensorType s WHERE s.sensorType = :sensorType"),
        @NamedQuery(name = "SensorType.findByDataType", query = "SELECT s FROM SensorType s WHERE s.dataType = :dataType")})
public class SensorType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sensor_type_id")
    private Integer sensorTypeId;
    @Basic(optional = false)
    @Column(name = "sensor_type")
    private String sensorType;
    @Basic(optional = false)
    @Column(name = "data_type")
    private String dataType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sensorTypeId")
    @JsonIgnore
    private List<Sensor> sensorList;

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

    public List<Sensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList(List<Sensor> sensorList) {
        this.sensorList = sensorList;
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
        return "com.example.watering_system.data.entity.watering_system.SensorType[ sensorTypeId=" + sensorTypeId + " ]";
    }

}