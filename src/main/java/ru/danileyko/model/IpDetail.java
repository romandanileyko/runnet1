package ru.danileyko.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by danil on 07.11.2017.
 */
@Entity
@Table(name = "IPDETAIL_V")
public class IpDetail implements Serializable {
    static final long serialVersionUID = 1L;
    @Id
    private long id;
    @Column(name = "IP")
    private String ip;
    @Column(name = "MASK")
    private String mask;
    @Column(name = "IPRANGEID")
    private String iprangeId;
    @Column(name = "STATUS")
    private boolean status;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "DATE_MODIFIED")
    private Date dateModified;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getIprangeId() {
        return iprangeId;
    }

    public void setIprangeId(String iprangeId) {
        this.iprangeId = iprangeId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }
}
