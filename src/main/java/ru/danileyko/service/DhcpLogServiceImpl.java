package ru.danileyko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.danileyko.dao.DhcpLogViewDao;
import ru.danileyko.model.DhcpLogView;

import java.util.List;

/**
 * Created by danil on 30.10.2017.
 */
@Service
public class DhcpLogServiceImpl implements DhcpLogService {
    @Autowired
    DhcpLogViewDao dhcpLogViewDao;
    @Override
    public List<DhcpLogView> getDhcpLogUserByUserName(String vUser) {
        return dhcpLogViewDao.getLogForUserByUserName(vUser);
    }
}
