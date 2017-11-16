package ru.danileyko.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by danil on 16.11.2017.
 */
@Entity
@Table(name = "CUSTOMER_BALANS_V")
public class CustomerBalans {
    @Id
    @Column(name = "PUSER")
    private String pUser;
    @Column(name = "CUR_STATUS")
    private String currentStatus;
    @Column(name = "OSTATOK")
    private float ostatok;

    public String getpUser() {
        return pUser;
    }

    public void setpUser(String pUser) {
        this.pUser = pUser;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public float getOstatok() {
        return ostatok;
    }

    public void setOstatok(float ostatok) {
        this.ostatok = ostatok;
    }
}
