package ru.danileyko.reports;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by danil on 06.10.2017.
 */
public class UserPorts {
    private String puser;
    private String mac;
    private String deviceIp;
    private String ifName;
    private String clientIp;
    private String status;
    private String adminStatus;
    private String hostel;
    private Timestamp lastDateUpdate;

    public String getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus;
    }

    public String getHostel() {
        return hostel;
    }

    public void setHostel(String hostel) {
        this.hostel = hostel;
    }

    public void setPuser(String puser) {
        this.puser = puser;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    public void setIfName(String ifName) {
        this.ifName = ifName;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLastDateUpdate(Timestamp lastDateUpdate) {
        this.lastDateUpdate = lastDateUpdate;
    }

    public String getPuser() {
        return puser;
    }

    public String getMac() {
        return mac;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public String getIfName() {
        return ifName;
    }

    public String getClientIp() {
        return clientIp;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getLastDateUpdate() {
        return lastDateUpdate;
    }
}
