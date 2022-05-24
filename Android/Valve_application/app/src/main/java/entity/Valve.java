package entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ivaylo Ivanov
 */
public class Valve implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer valveId;
    private String valveName;
    private boolean valveFailedOperation;
    private String valveFailedEndPoint;
    private boolean valveRunning;
    private Integer valveFailedCounter;
    private String valveOnEndpoint;
    private String valveOffEndpoint;

    public Valve() {}

    public Valve(Integer valveId) {
        this.valveId = valveId;
    }

    public Valve(Integer valveId, String valveName, boolean valveFailedOperation, String valveFailedEndPoint, boolean valveRunning, Integer valveFailedCounter, String valveOnEndpoint, String valveOffEndpoint) {
        this.valveId = valveId;
        this.valveName = valveName;
        this.valveFailedOperation = valveFailedOperation;
        this.valveFailedEndPoint = valveFailedEndPoint;
        this.valveRunning = valveRunning;
        this.valveFailedCounter = valveFailedCounter;
        this.valveOnEndpoint = valveOnEndpoint;
        this.valveOffEndpoint = valveOffEndpoint;
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
                ", valveOffEndpoint='" + valveOffEndpoint + '}';
    }
}