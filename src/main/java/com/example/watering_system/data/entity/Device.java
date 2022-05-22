package com.example.watering_system.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author halo3
 */
@Entity
@Table(name = "devices")
@NamedQueries({
        @NamedQuery(name = "Device.findAll", query = "SELECT d FROM Device d"),
        @NamedQuery(name = "Device.findByDeviceName", query = "SELECT d FROM Device d WHERE d.deviceName = :deviceName"),
        @NamedQuery(name = "Device.findByDeviceLocation", query = "SELECT d FROM Device d WHERE d.deviceLocation = :deviceLocation"),
        @NamedQuery(name = "Device.findByDeviceId", query = "SELECT d FROM Device d WHERE d.deviceId = :deviceId")})
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "device_id")
    private Integer deviceId;
    @Basic(optional = false)
    @Column(name = "device_name")
    private String deviceName;
    @Basic(optional = false)
    @Column(name = "device_location")
    private String deviceLocation;
    @Basic(optional = false)
    @Column(name = "device_endpoint")
    private String deviceEndpoint;

    @OneToMany(mappedBy = "deviceId")
    @JsonIgnore
    private List<Sensor> sensorList;

    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    @JsonIgnoreProperties("")
    private User userId;

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

    public List<Sensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList(List<Sensor> sensorList) {
        this.sensorList = sensorList;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
                ", deviceEndpoint='" + deviceEndpoint + '\'' +
                //   ", sensorList=" + sensorList +
                ", userId=" + userId +
                '}';
    }
}