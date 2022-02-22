package com.example.watering_system.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author halo3
 */
@Entity
@Table(name = "logs")
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
    @NamedQuery(name = "Log.findByLogDate", query = "SELECT l FROM Log l WHERE l.logDate = :logDate"),
    @NamedQuery(name = "Log.findByLogDescription", query = "SELECT l FROM Log l WHERE l.logDescription = :logDescription"),
    @NamedQuery(name = "Log.findByLogLevel", query = "SELECT l FROM Log l WHERE l.logLevel = :logLevel"),
    @NamedQuery(name = "Log.findByLogId", query = "SELECT l FROM Log l WHERE l.logId = :logId")})
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "log_id")
    private Integer logId;
    //@Basic(optional = false)
    @Column(name = "log_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logDate;
    @Basic(optional = false)
    @Column(name = "log_description")
    private String logDescription;
    @Basic(optional = false)
    @Column(name = "log_level")
    private String logLevel;

    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("logList")
    private User userId;

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

    public User getUser() {
        return userId;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
                ", logLevel='" + logLevel + '\'' +
                ", userId=" + userId +
                '}';
    }
}