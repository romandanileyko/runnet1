package ru.danileyko.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.danileyko.model.Device;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by danil on 14.09.2017.
 */
@Transactional
@Repository
public class DeviceDaoImpl implements DeviceDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<Device> getAllDevices() {
        return entityManager.createQuery("SELECT dev from Device dev",Device.class).getResultList();
    }

    @Override
    public List<String> getPortsBySwitch(String ip) {
        return entityManager.createQuery("select dp.ifName from DevPort dp where dp.device.ip = :ip",String.class)
                .setParameter("ip",ip)
                .getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Object[]> getPortStatus1(){
        return (List<Object[]>) entityManager.createQuery("SELECT dev,ps " +
                "FROM Device dev,DevPort dp,PortStatus ps " +
                "WHERE dev.ip = dp.device.ip " +
                "AND dp.device.ip = ps.ip " +
                "AND dp.ifName = ps.ifName "+
                "AND ps.ip not like '109.123.128.%'"+
                "AND ps.adminStatus <> 'Up'").setMaxResults(70).getResultList();
    }
}
