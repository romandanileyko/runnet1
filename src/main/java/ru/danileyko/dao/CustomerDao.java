package ru.danileyko.dao;

import ru.danileyko.model.CustumerInfo;

import java.util.List;

/**
 * Created by danil on 02.11.2017.
 */
public interface CustomerDao {
    public List<CustumerInfo> getAllCustomerInfo(String vUser);
}
