package ru.danileyko.service;

import ru.danileyko.model.MacCustomer;

import java.util.List;

/**
 * Created by danil on 05.10.2017.
 */
public interface MacCustomerService {
    public void save(MacCustomer macCustomer);
    public List<Object[]> userPort(String user);
}
