package entity;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Ivaylo Ivanov
 */
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer logId;
    private Date logDate;
    private String logDescription;
    private String logLevel;

    public Log() {}

    public Log(Integer logId) {
        this.logId = logId;
    }

    public Log(Integer logId, Date logDate, String logDescription, String logLevel) {
        this.logId = logId;
        this.logDate = logDate;
        this.logDescription = logDescription;
        this.logLevel = logLevel;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getLogDescription() {
        return logDescription;
    }

    public void setLogDescription(String logDescription) {
        this.logDescription = logDescription;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }

        Log other = (Log) object;

        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", logDate=" + logDate +
                ", logDescription='" + logDescription + '\'' +
                ", logLevel='" + logLevel + '}';
    }

}