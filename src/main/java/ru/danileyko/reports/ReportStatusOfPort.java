package ru.danileyko.reports;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by danil on 15.09.2017.
 */

public class ReportStatusOfPort {
    private String devName;
    private String devIp;
    private String ifName;
    private String adminStatus;
    private String operationalStatus;
    private LocalDateTime updTime;

    public   ReportStatusOfPort(String devName ,String devIp,String ifName,String adminStatus,String operationalStatus,LocalDateTime updTime){
        this.devName = devName;
        this.devIp = devIp;
        this.ifName = ifName;
        this.adminStatus = adminStatus;
        this.operationalStatus = operationalStatus;
        this.updTime = updTime;
    }

    public String getDevName() {
        return devName;
    }

    public String getDevIp() {
        return devIp;
    }

    public String getIfName() {
        return ifName;
    }

    public String getAdminStatus() {
        return adminStatus;
    }

    public String getOperationalStatus() {
        return operationalStatus;
    }

    public LocalDateTime getUpdTime() {
        return updTime;
    }
}