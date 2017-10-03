package ru.danileyko.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by danil on 15.09.2017.
 */
@Entity
@Table(name = "HCLIENTSTATUS",
        uniqueConstraints = @UniqueConstraint(columnNames = {"DEVICE_IP","IFNAME"}))
public class ClientStatus implements Serializable {
    @Id
    private Long id;
    @Column(name = "DEVICE_IP")
    private String devIp;
    @Column(name = "IFNAME")
    private String ifName;
    @Column(name = "CLIENTIP")
    private String ip;
    @Column(name = "MAC",insertable = false,updatable = false)
    private String mac;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "VENDOR")
    private String vendor;
    @Column(name = "VLAN")
    private String vlan;
    @Column(name = "UPDATETIME")
    private Timestamp updatetime;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "DEVICE_IP",referencedColumnName = "DEVID",insertable = false, updatable = false),
            @JoinColumn(name = "IFNAME",referencedColumnName = "IFNAME",insertable = false, updatable = false)
    })
    private DevPort port;

    @ManyToOne
    @JoinColumn(name = "MAC",referencedColumnName = "MAC")
    private MacCustomer macCustomer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDevIp() {
        return devIp;
    }

    public void setDevIp(String devIp) {
        this.devIp = devIp;
    }

    public String getIfName() {
        return ifName;
    }

    public void setIfName(String ifName) {
        this.ifName = ifName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVlan() {
        return vlan;
    }

    public void setVlan(String vlan) {
        this.vlan = vlan;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    public DevPort getPort() {
        return port;
    }

    public void setPort(DevPort port) {
        this.port = port;
    }

    public MacCustomer getMacCustomer() {
        return macCustomer;
    }

    public void setMacCustomer(MacCustomer macCustomer) {
        this.macCustomer = macCustomer;
    }
}