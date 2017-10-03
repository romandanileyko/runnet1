package ru.danileyko.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by danil on 14.09.2017.
 */
@Entity
@Table(name = "HDEVICES")
public class Device implements Serializable {
    @Id
    @Column(name = "IP")
    private String ip;
    @Column(name = "NAME")
    private String name;
    @Column(name = "MY_SUB_TYPE_ID")
    private String my_sub_type_id;
    @Column(name = "VENDOR")
    private String vendor;
    @Column(name = "MODEL")
    private String model;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "device",fetch = FetchType.LAZY)
    List<DevPort> ports = new ArrayList<>();

    public List<DevPort> getPorts() {
        return ports;
    }

    public void setPorts(List<DevPort> ports) {
        this.ports = ports;
    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMy_sub_type_id() {
        return my_sub_type_id;
    }

    public void setMy_sub_type_id(String my_sub_type_id) {
        this.my_sub_type_id = my_sub_type_id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(!(obj instanceof Device))
            return false;

        Device device = (Device)obj;

        return (device.ip.equals(ip) &&
                device.name.equals(name) &&
                device.my_sub_type_id.equals(my_sub_type_id) &&
                device.vendor.equals(vendor) &&
                device.model.equals(model));
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip,name,my_sub_type_id,vendor,model);
    }
}