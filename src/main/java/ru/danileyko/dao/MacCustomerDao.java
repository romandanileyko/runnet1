package ru.danileyko.dao;

import ru.danileyko.model.MacCustomer;

import java.util.List;

/**
 * Created by danil on 05.10.2017.
 */
public interface MacCustomerDao {
    public void save(MacCustomer mac);
    public List<Object[]> userPort(String user);
}
