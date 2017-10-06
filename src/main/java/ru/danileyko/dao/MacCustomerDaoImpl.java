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
    public List<Object[]> userPort(String user) {
        List<Object[]> result = new ArrayList<>();

        Query query = entityManager.createQuery("SELECT DISTINCT mcv, hcl FROM MacCustomer mcv,ClientStatus hcl" +
                " WHERE mcv.mac = hcl.mac" +
                " AND mcv.puser LIKE 'Vdr%'" +
                " ORDER BY hcl.updatetime DESC");
        return result = query.getResultList();
    }
}
