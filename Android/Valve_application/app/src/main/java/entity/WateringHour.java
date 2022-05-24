package entity;

import java.io.Serializable;

/**
 * @author Ivaylo Ivanov
 */
public class WateringHour implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer wateringHoursId;
    private String time;

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