package com.example.watering_system.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
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

/**
 * @author halo3
 */
@Entity
@Table(name = "watering_hours")
@NamedQueries({
        @NamedQuery(name = "WateringHour.findAll", query = "SELECT w FROM WateringHour w"),
        @NamedQuery(name = "WateringHour.findByWateringHoursId", query = "SELECT w FROM WateringHour w WHERE w.wateringHoursId = :wateringHoursId"),
        @NamedQuery(name = "WateringHour.findByTime", query = "SELECT w FROM WateringHour w WHERE w.time = :time")})
public class WateringHour implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "watering_hours_id")
    private Integer wateringHoursId;
    @Basic(optional = false)
    @Column(name = "time")
    private String time;

    @JoinColumn(name = "configuration_id", referencedColumnName = "configuration_id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("")
    private Configuration configurationId;

    public WateringHour() {}

    public WateringHour(Integer wateringHoursId) {
        this.wateringHoursId = wateringHoursId;
    }

    public WateringHour(Integer wateringHoursId, String time) {
        this.wateringHoursId = wateringHoursId;
        this.time = time;
    }

    public Integer getWateringHoursId() {
        return wateringHoursId;
    }

    public void setWateringHoursId(Integer wateringHoursId) {
        this.wateringHoursId = wateringHoursId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Configuration getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(Configuration configurationId) {
        this.configurationId = configurationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wateringHoursId != null ? wateringHoursId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WateringHour)) {
            return false;
        }

        WateringHour other = (WateringHour) object;

        if ((this.wateringHoursId == null && other.wateringHoursId != null) || (this.wateringHoursId != null && !this.wateringHoursId.equals(other.wateringHoursId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.watering_system.data.entity.watering_system.resources.WateringHour[ wateringHoursId=" + wateringHoursId + " ]";
    }

}