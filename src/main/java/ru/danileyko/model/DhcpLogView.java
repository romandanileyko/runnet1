package ru.danileyko.model;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by danil on 30.10.2017.
 */
@Entity
@Table(name = "DHCP_LOG_V")
public class DhcpLogView implements Serializable{
    @Id
    private long id;
    @Column(name = "PUSER")
    private String pUser;
    @Column(name = "MAC")
    private String mac;
    @Column(name = "LOG_DATE")
    private LocalDateTime logDate;
    @Column(name = "LOG_TYPE")
    private String logType;
    @Column(name = "IP")
    private String ip;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getpUser() {
        return pUser;
    }

    public void setpUser(String pUser) {
        this.pUser = pUser;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public LocalDateTime getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDateTime logDate) {
        this.logDate = logDate;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
