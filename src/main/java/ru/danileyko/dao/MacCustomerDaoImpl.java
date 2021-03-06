package ru.danileyko.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.danileyko.model.MacCustomer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danil on 05.10.2017.
 */
@Transactional
@Repository
public class MacCustomerDaoImpl implements MacCustomerDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(MacCustomer mac) {
        entityManager.persist(mac);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Object[]> userPort(String user) {
        List<Object[]> result = new ArrayList<>();
        String sql = "SELECT DISTINCT mcv.PUSER,mcv.MAC,hcl.DEVICE_IP,hcl.IFNAME,hcl.CLIENTIP,hcl.STATUS,hps.ADMINSTATUS,msv.NAME,\n" +
                "  first_value(hcl.UPDATETIME) OVER (PARTITION BY mcv.PUSER,mcv.MAC,hcl.DEVICE_IP,hcl.IFNAME,hcl.CLIENTIP,hcl.STATUS,hps.ADMINSTATUS,msv.NAME ORDER BY UPDATETIME DESC ) AS LAST_UPDATE_TIME\n" +
                "  FROM RUNNET.MAC_CUSTOMER_V mcv,RUNNET.HCLIENTSTATUS hcl,RUNNET.HPORTSTATUS hps,RUNNET.CUSTOMER cust,RUNNET.MY_SUB_TYPE_V msv\n" +
                "WHERE mcv.MAC = hcl.MAC\n" +
                "AND hcl.DEVICE_IP = hps.IP\n" +
                "AND hcl.IFNAME = hps.IFNAME\n" +
                "AND cust.PUSER = mcv.PUSER\n" +
                "AND msv.ID = cust.SUBTYPE\n" +
                "AND mcv.PUSER LIKE ?";

        Query query = entityManager.createNativeQuery(sql).setParameter(1,user+"%");
        return result = query.getResultList();
    }
}
