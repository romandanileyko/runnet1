package ru.danileyko.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * Created by danil on 15.09.2017.
 */
@Entity
@Table(name = "HLASTPORTSTATUS_V")
public class PortStatus {
    @Id
    private Long id;
    @Column(name = "IP")
    private String ip;
    @Column(name = "IFNAME")
    private String ifName;
    @Column(name = "LAST_ADMINSTATUS")
    private String adminStatus;
    @Column(name = "LAST_OPERATIONALSTATUS")
    private String operationalStatus;
    @Column(name = "LAST_INDATE",insertable = false,updatable = false)
  //  @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastInDate;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "IP",referencedColumnName = "DEVID",insertable = false,updatable = false),
            @JoinColumn(name = "IFNAME",referencedColumnName = "IFNAME",insertable = false,updatable = false)
    })
    private DevPort devPort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIfName() {
        return ifName;
    }

    public void setIfName(String ifName) {
        this.ifName = ifName;
    }

    public String getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus;
    }

    public String getOperationalStatus() {
        return operationalStatus;
    }

    public void setOperationalStatus(String operationalStatus) {
        this.operationalStatus = operationalStatus;
    }

    public LocalDateTime getLastInDate() {
        return lastInDate;
    }

    public void setLastInDate(LocalDateTime lastInDate) {
        this.lastInDate = lastInDate;
    }

    public DevPort getDevPort() {
        return devPort;
    }

    public void setDevPort(DevPort devPort) {
        this.devPort = devPort;
    }
}