package ru.danileyko.service;

import org.springframework.stereotype.Service;
import ru.danileyko.model.CustumerInfo;

import java.util.List;

/**
 * Created by danil on 02.11.2017.
 */
public interface CustomerService {
    public List<CustumerInfo> getAllCustomerInfo(String vUser);
}
