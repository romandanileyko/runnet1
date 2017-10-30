package ru.danileyko.service;

import ru.danileyko.model.DhcpLogView;

import java.util.List;

/**
 * Created by danil on 30.10.2017.
 */
public interface DhcpLogService {
    public List<DhcpLogView>  getDhcpLogUserByUserName(String vUser);
}
