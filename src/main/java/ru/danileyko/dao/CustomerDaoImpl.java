package ru.danileyko.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.danileyko.model.CustumerInfo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by danil on 02.11.2017.
 */
@Transactional
@Repository
public class CustomerDaoImpl implements CustomerDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CustumerInfo> getAllCustomerInfo(String vUser) {
        return entityManager.createQuery("SELECT cust FROM CustumerInfo cust where cust.pUser=:vUser")
                .setParameter("vUser",vUser)
                .setMaxResults(10)
                .getResultList();
    }
}
