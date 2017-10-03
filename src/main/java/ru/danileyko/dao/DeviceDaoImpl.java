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
        return (List<Device>)entityManager.createQuery("SELECT dev.ip,dev.name,dev.vendor,dev.model from Device dev").getResultList();
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
                "AND ps.adminStatus <> 'Up'").setMaxResults(10).getResultList();
    }
}
