package entity;

import java.io.Serializable;

/**
 * @author Ivaylo Ivanov
 */
public class Configuration implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer configurationId;
    private int activeTime;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;
    private Integer wateringActiveCounter;
    private int configurationChangedBy;

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

    public Integer getWateringActiveCounter() {
        return wateringActiveCounter;
    }

    public void setWateringActiveCounter(Integer wateringActiveCounter) {
        this.wateringActiveCounter = wateringActiveCounter;
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
        return "Configuration " + configurationId;
    }

}