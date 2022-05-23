package com.example.watering_system.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author halo3
 */
@Entity
@Table(name = "sensor_data")
@NamedQueries({
        @NamedQuery(name = "SensorData.findAll", query = "SELECT s FROM SensorData s"),
        @NamedQuery(name = "SensorData.findBySensorDataId", query = "SELECT s FROM SensorData s WHERE s.sensorDataId = :sensorDataId"),
        @NamedQuery(name = "SensorData.findBySensorValue", query = "SELECT s FROM SensorData s WHERE s.sensorValue = :sensorValue"),
        @NamedQuery(name = "SensorData.findBySensorValueDate", query = "SELECT s FROM SensorData s WHERE s.sensorValueDate = :sensorValueDate")})
public class SensorData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sensor_data_id")
    private Integer sensorDataId;
    @Basic(optional = false)
    @Column(name = "sensor_value")
    private String sensorValue;
    @Basic(optional = false)
    @Column(name = "sensor_value_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sensorValueDate;

    @JoinColumn(name = "sensor_id", referencedColumnName = "sensor_id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("")
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

    public Sensor getSensorId() {
        return sensorId;
    }

    public void setSensorId(Sensor sensorId) {
        this.sensorId = sensorId;
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
        return "com.example.watering_system.data.entity.watering_system.resources.SensorData[ sensorDataId=" + sensorDataId + " ]";
    }

}