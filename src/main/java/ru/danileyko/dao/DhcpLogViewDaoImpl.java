package ru.danileyko.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.danileyko.model.DhcpLogView;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danil on 30.10.2017.
 */
@Transactional
@Repository
public class DhcpLogViewDaoImpl implements DhcpLogViewDao {
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<DhcpLogView> getLogForUserByUserName(String vUser) {
        return entityManager.createQuery("SELECT dhcp FROM DhcpLogView dhcp " +
                "where dhcp.pUser like :vUser " +
                "or dhcp.mac like :vUser " +
                "ORDER BY dhcp.logDate DESC")
                .setParameter("vUser","%"+vUser+"%")
                .setMaxResults(10)
                .getResultList();
    }
}
