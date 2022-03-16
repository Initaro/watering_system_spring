package com.example.watering_system.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "configurations")
@NamedQueries({
        @NamedQuery(name = "Configuration.findAll", query = "SELECT c FROM Configuration c"),
        @NamedQuery(name = "Configuration.findByActiveTime", query = "SELECT c FROM Configuration c WHERE c.activeTime = :activeTime"),
        @NamedQuery(name = "Configuration.findByMonday", query = "SELECT c FROM Configuration c WHERE c.monday = :monday"),
        @NamedQuery(name = "Configuration.findByTuesday", query = "SELECT c FROM Configuration c WHERE c.tuesday = :tuesday"),
        @NamedQuery(name = "Configuration.findByWednesday", query = "SELECT c FROM Configuration c WHERE c.wednesday = :wednesday"),
        @NamedQuery(name = "Configuration.findByThursday", query = "SELECT c FROM Configuration c WHERE c.thursday = :thursday"),
        @NamedQuery(name = "Configuration.findByFriday", query = "SELECT c FROM Configuration c WHERE c.friday = :friday"),
        @NamedQuery(name = "Configuration.findBySaturday", query = "SELECT c FROM Configuration c WHERE c.saturday = :saturday"),
        @NamedQuery(name = "Configuration.findBySunday", query = "SELECT c FROM Configuration c WHERE c.sunday = :sunday"),
        @NamedQuery(name = "Configuration.findByConfigurationChangedBy", query = "SELECT c FROM Configuration c WHERE c.configurationChangedBy = :configurationChangedBy"),
        @NamedQuery(name = "Configuration.findByConfigurationId", query = "SELECT c FROM Configuration c WHERE c.configurationId = :configurationId")})
public class Configuration implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "configuration_id")
    private Integer configurationId;
    @Basic(optional = false)
    @Column(name = "active_time")
    private int activeTime;
    @Column(name = "monday")
    private String monday;
    @Column(name = "tuesday")
    private String tuesday;
    @Column(name = "wednesday")
    private String wednesday;
    @Column(name = "thursday")
    private String thursday;
    @Column(name = "friday")
    private String friday;
    @Column(name = "saturday")
    private String saturday;
    @Column(name = "sunday")
    private String sunday;
    @Basic(optional = false)
    @Column(name = "configuration_changed_by")
    private int configurationChangedBy;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "configurationId")
    @JsonIgnore
    private List<WateringHour> wateringHourList;

    @JoinColumn(name = "valve_id", referencedColumnName = "valve_id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("")
    private Valve valveId;

    public Configuration() {}

    public Configuration(Integer configurationId) {
        this.configurationId = configurationId;
    }

    public Configuration(Integer configurationId, int activeTime, int configurationChangedBy) {
        this.configurationId = configurationId;
        this.activeTime = activeTime;
        this.configurationChangedBy = configurationChangedBy;
    }

    public int getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(int activeTime) {
        this.activeTime = activeTime;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public int getConfigurationChangedBy() {
        return configurationChangedBy;
    }

    public void setConfigurationChangedBy(int configurationChangedBy) {
        this.configurationChangedBy = configurationChangedBy;
    }

    public Integer getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(Integer configurationId) {
        this.configurationId = configurationId;
    }

    public List<WateringHour> getWateringHourList() {
        return wateringHourList;
    }

    public void setWateringHourList(List<WateringHour> wateringHourList) {
        this.wateringHourList = wateringHourList;
    }

    public Valve getValveId() {
        return valveId;
    }

    public void setValveId(Valve valveId) {
        this.valveId = valveId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (configurationId != null ? configurationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuration)) {
            return false;
        }

        Configuration other = (Configuration) object;

        if ((this.configurationId == null && other.configurationId != null) || (this.configurationId != null && !this.configurationId.equals(other.configurationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.watering_system.data.entity.watering_system.resources.Configuration[ configurationId=" + configurationId + " ]";
    }

}