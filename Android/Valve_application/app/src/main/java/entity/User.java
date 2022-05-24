package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Ivaylo Ivanov
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;
    private String userFullName;
    private String userLogin;
    private String userPass;
    private Date userCreateDate;
    private boolean userAdmin;

    public User() {}

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String userFullName, String userLogin, String userPass, boolean userAdmin) {
        this.userId = userId;
        this.userFullName = userFullName;
        this.userLogin = userLogin;
        this.userPass = userPass;
        this.userAdmin = userAdmin;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public Date getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(Date userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public boolean getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(boolean userAdmin) {
        this.userAdmin = userAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }

        User other = (User) object;

        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.watering_system.data.entity.watering_system.resources.User[ userId=" + userId + " ]";
    }

}