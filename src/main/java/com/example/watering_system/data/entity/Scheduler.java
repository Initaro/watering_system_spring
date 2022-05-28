package com.example.watering_system.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "scheduler")
public class Scheduler {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "scheduler_id")
    private Integer schedulerId;
    @Basic(optional = false)
    @Column(name = "state")
    private boolean state;

    public Scheduler() {}

    public Scheduler(Integer schedulerId, boolean state) {
        this.schedulerId = schedulerId;
        this.state = state;
    }

    public Integer getSchedulerId() {
        return schedulerId;
    }

    public void setSchedulerId(Integer schedulerId) {
        this.schedulerId = schedulerId;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (schedulerId != null ? schedulerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Scheduler)) {
            return false;
        }

        Scheduler other = (Scheduler) object;

        if ((this.schedulerId == null && other.schedulerId != null) || (this.schedulerId != null && !this.schedulerId.equals(other.schedulerId))) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "com.example.watering_system.data.entity.watering_system.resources.Scheduler[ schedulerId=" + schedulerId + " ]";
    }
}