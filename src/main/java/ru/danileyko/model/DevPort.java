package ru.danileyko.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danil on 15.09.2017.
 */
@Entity
@Table(name = "HDEVPORT")
public class DevPort implements Serializable {
    @Id
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "DEVID")
    private Device device;
    @Column(name = "IFNAME")
    private String ifName;

    @OneToMany(mappedBy = "port")
    private List<ClientStatus> clientStatus = new ArrayList<>();

    @OneToMany(mappedBy = "devPort")
    private List<PortStatus> portStatusList = new ArrayList<>();

    public List<ClientStatus> getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(List<ClientStatus> clientStatus) {
        this.clientStatus = clientStatus;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIfName() {
        return ifName;
    }

    public void setIfName(String ifName) {
        this.ifName = ifName;
    }

    @Override
    public String toString() {
        return "Id"+id+" Device "+device+" ifName "+ifName;
    }
}
