package ru.danileyko.dao;

import ru.danileyko.model.DhcpLogView;

import java.util.List;

/**
 * Created by danil on 30.10.2017.
 */
public interface DhcpLogViewDao {
    public List<DhcpLogView> getLogForUserByUserName(String vUser);
}
