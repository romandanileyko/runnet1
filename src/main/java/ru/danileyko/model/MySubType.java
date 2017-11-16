package ru.danileyko.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by danil on 07.11.2017.
 */
@Entity
@Table(name = "MY_SUB_TYPE_V")
public class MySubType implements Serializable {
    static final long serialVersionUID = 1L;
    @Id
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ORDER_ID")
    private int orderId;
    @Column(name = "NUM_HOSTEL")
    private int hostelNum;
    @Column(name = "K_HOSTEL_ID")
    private int kHostelId;
    @Column(name = "ADDRESS")
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getHostelNum() {
        return hostelNum;
    }

    public void setHostelNum(int hostelNum) {
        this.hostelNum = hostelNum;
    }

    public int getkHostelId() {
        return kHostelId;
    }

    public void setkHostelId(int kHostelId) {
        this.kHostelId = kHostelId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
