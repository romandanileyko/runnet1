package ru.danileyko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.danileyko.dao.MacCustomerDao;
import ru.danileyko.model.MacCustomer;

import java.util.List;

/**
 * Created by danil on 05.10.2017.
 */
@Service
public class MacCustomerServiceImpl implements MacCustomerService {
    @Autowired
    private MacCustomerDao macCustomerDao;

    @Override
    public void save(MacCustomer macCustomer) {
        macCustomerDao.save(macCustomer);
    }

    @Override
    public List<Object[]> userPort(String user) {
        return macCustomerDao.userPort(user);
    }
}
