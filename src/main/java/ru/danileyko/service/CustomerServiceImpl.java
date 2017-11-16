package ru.danileyko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.danileyko.dao.CustomerDao;
import ru.danileyko.model.CustumerInfo;

import java.util.List;

/**
 * Created by danil on 02.11.2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerDao customerDao;
    @Override
    public List<CustumerInfo> getAllCustomerInfo(String vUser) {
        return customerDao.getAllCustomerInfo(vUser);
    }
}
