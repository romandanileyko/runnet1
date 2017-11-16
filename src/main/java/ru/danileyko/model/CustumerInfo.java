package ru.danileyko.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Created by danil on 02.11.2017.
 */
@Entity
@Table(name = "CUSTOMER")
public class CustumerInfo {
    @Id
    @Column(name = "PUSER")
    private String pUser;
    @Column(name = "COMPANY")
    private String company;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "BLOCKED")
    private boolean blocked;
    @Column(name = "SUBTYPE")
    private String subtype;
    @OneToMany(fetch = FetchType.EAGER )
    @JoinColumn(name = "PUSER")
    private List<MacCustomer> macCustomers;
    @OneToOne
    @JoinColumn(name = "SUBTYPE",insertable = false,updatable = false)
    private MySubType hostel;
    @OneToOne
    @JoinColumn(name = "PUSER",insertable = false,updatable = false)
    private CustomerBalans balans;

    public String getpUser() {
        return pUser;
    }

    public void setpUser(String pUser) {
        this.pUser = pUser;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<MacCustomer> getMacCustomers() {
        return macCustomers;
    }

    public void setMacCustomers(List<MacCustomer> macCustomers) {
        this.macCustomers = macCustomers;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public MySubType getHostel() {
        return hostel;
    }

    public void setHostel(MySubType hostel) {
        this.hostel = hostel;
    }

    public CustomerBalans getBalans() {
        return balans;
    }

    public void setBalans(CustomerBalans balans) {
        this.balans = balans;
    }
}
