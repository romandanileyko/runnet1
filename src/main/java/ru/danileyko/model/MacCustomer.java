package ru.danileyko.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by danil on 28.09.2017.
 */
@Entity
@Table(name = "MAC_CUSTOMER_V")
public class MacCustomer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "MAC_CUSTOMER_SEQ")
    @SequenceGenerator(name = "MAC_CUSTOMER_SEQ",sequenceName = "MAC_CUSTOMER_SEQ",allocationSize = 1)
    private Long id;
    @Column(name = "PUSER")
    private String puser;
    @Column(name = "MAC")
    private String mac;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "TYPE_DEVICE_ID")
    private Long typeDeviceId;
    @Column(name = "IP_DETAIL_ID")
    private Long ipDetailId;
    @Column(name = "CHANGE_STATUS_DATE")
    private Timestamp changeStatusDate;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "DATE_MODIFIED")
    private Timestamp dateModified;
    @Column(name = "DATE_CREATED")
    private Timestamp dateCreated;

    @OneToMany(mappedBy = "macCustomer")
    private List<ClientStatus> statusList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPuser() {
        return puser;
    }

    public void setPuser(String puser) {
        this.puser = puser;
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

    public Long getTypeDeviceId() {
        return typeDeviceId;
    }

    public void setTypeDeviceId(Long typeDeviceId) {
        this.typeDeviceId = typeDeviceId;
    }

    public Long getIpDetailId() {
        return ipDetailId;
    }

    public void setIpDetailId(Long ipDetailId) {
        this.ipDetailId = ipDetailId;
    }

    public Timestamp getChangeStatusDate() {
        return changeStatusDate;
    }

    public void setChangeStatusDate(Timestamp changeStatusDate) {
        this.changeStatusDate = changeStatusDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getDateModified() {
        return dateModified;
    }

    public void setDateModified(Timestamp dateModified) {
        this.dateModified = dateModified;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<ClientStatus> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<ClientStatus> statusList) {
        this.statusList = statusList;
    }
}
