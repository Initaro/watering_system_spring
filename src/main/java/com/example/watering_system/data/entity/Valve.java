package com.example.watering_system.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "valve_id")
    private Integer valveId;
    @Basic(optional = false)
    @Column(name = "valve_name")
    private String valveName;
    @Basic(optional = false)
    @Column(name = "valve_failed_operation")
    private boolean valveFailedOperation;
    @Basic(optional = false)
    @Column(name = "valve_failed_endpoint")
    private String valveFailedEndPoint;
    @Basic(optional = false)
    @Column(name = "valve_running")
    private boolean valveRunning;
    @Basic(optional = false)
    @Column(name = "valve_failed_counter")
    private Integer valveFailedCounter;
    @Basic(optional = false)
    @Column(name = "valve_on_endpoint")
    private String valveOnEndpoint;
    @Basic(optional = false)
    @Column(name = "valve_off_endpoint")
    private String valveOffEndpoint;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "valveId")
    @JsonIgnore
    @Transient
    private List<Configuration> configurationList;

    public Valve() {}

    public Valve(Integer valveId) {
        this.valveId = valveId;
    }

    public Valve(Integer valveId, String valveName, boolean valveFailedOperation, String valveFailedEndPoint, boolean valveRunning, Integer valveFailedCounter, String valveOnEndpoint, String valveOffEndpoint, List<Configuration> configurationList) {
        this.valveId = valveId;
        this.valveName = valveName;
        this.valveFailedOperation = valveFailedOperation;
        this.valveFailedEndPoint = valveFailedEndPoint;
        this.valveRunning = valveRunning;
        this.valveFailedCounter = valveFailedCounter;
        this.valveOnEndpoint = valveOnEndpoint;
        this.valveOffEndpoint = valveOffEndpoint;
        this.configurationList = configurationList;
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

    public boolean isFailedOperation() {
        return valveFailedOperation;
    }

    public void setValveFailedOperation(boolean valveFailedOperation) {
        this.valveFailedOperation = valveFailedOperation;
    }

    public String getValveFailedEndPoint() {
        return valveFailedEndPoint;
    }

    public void setValveFailedEndPoint(String valveFailedEndPoint) {
        this.valveFailedEndPoint = valveFailedEndPoint;
    }

    public boolean isValveFailedOperation() {
        return valveFailedOperation;
    }

    public boolean isValveRunning() {
        return valveRunning;
    }

    public void setValveRunning(boolean valveRunning) {
        this.valveRunning = valveRunning;
    }

    public Integer getValveFailedCounter() {
        return valveFailedCounter;
    }

    public void setValveFailedCounter(Integer valveFailedCounter) {
        this.valveFailedCounter = valveFailedCounter;
    }

    public String getValveOnEndpoint() {
        return valveOnEndpoint;
    }

    public void setValveOnEndpoint(String valveOnEndpoint) {
        this.valveOnEndpoint = valveOnEndpoint;
    }

    public String getValveOffEndpoint() {
        return valveOffEndpoint;
    }

    public void setValveOffEndpoint(String valveOffEndpoint) {
        this.valveOffEndpoint = valveOffEndpoint;
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
        return "Valve{" +
                "valveId=" + valveId +
                ", valveName='" + valveName + '\'' +
                ", valveFailedOperation=" + valveFailedOperation +
                ", valveFailedEndPoint='" + valveFailedEndPoint + '\'' +
                ", valveRunning=" + valveRunning +
                ", valveFailedCounter=" + valveFailedCounter +
                ", valveOnEndpoint='" + valveOnEndpoint + '\'' +
                ", valveOffEndpoint='" + valveOffEndpoint + '\'' +
           //     ", configurationList=" + configurationList +
                '}';
    }
}