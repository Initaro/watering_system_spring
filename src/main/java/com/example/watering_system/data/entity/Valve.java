package com.example.watering_system.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author halo3
 */
@Entity
@Table(name = "valves")
@NamedQueries({
        @NamedQuery(name = "Valve.findAll", query = "SELECT v FROM Valve v"),
        @NamedQuery(name = "Valve.findByValveId", query = "SELECT v FROM Valve v WHERE v.valveId = :valveId"),
        @NamedQuery(name = "Valve.findByValveName", query = "SELECT v FROM Valve v WHERE v.valveName = :valveName")})
public class Valve implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "valve_id")
    private Integer valveId;
    @Basic(optional = false)
    @Column(name = "valve_name")
    private String valveName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "valveId")
    @JsonIgnoreProperties("")
    private List<Configuration> configurationList;

    public Valve() {}

    public Valve(Integer valveId) {
        this.valveId = valveId;
    }

    public Valve(Integer valveId, String valveName) {
        this.valveId = valveId;
        this.valveName = valveName;
    }

    public Integer getValveId() {
        return valveId;
    }

    public void setValveId(Integer valveId) {
        this.valveId = valveId;
    }

    public String getValveName() {
        return valveName;
    }

    public void setValveName(String valveName) {
        this.valveName = valveName;
    }

    public List<Configuration> getConfigurationList() {
        return configurationList;
    }

    public void setConfigurationList(List<Configuration> configurationList) {
        this.configurationList = configurationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valveId != null ? valveId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valve)) {
            return false;
        }
        Valve other = (Valve) object;
        if ((this.valveId == null && other.valveId != null) || (this.valveId != null && !this.valveId.equals(other.valveId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.watering_system.data.entity.watering_system.Valve[ valveId=" + valveId + " ]";
    }

}