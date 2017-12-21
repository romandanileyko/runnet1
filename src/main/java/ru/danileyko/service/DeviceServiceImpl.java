package ru.danileyko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.danileyko.dao.DeviceDao;
import ru.danileyko.model.Device;

import java.util.List;

/**
 * Created by danil on 14.09.2017.
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceDao tDevicesDao;

    @Override
    public List<Device> getAllDevices() {
        return tDevicesDao.getAllDevices();
    }

    @Override
    public List<String> getPortsBySwitch(String ip) {
        return tDevicesDao.getPortsBySwitch(ip);
    }

    @Override
    public List<Object[]> getPortStatus1() {
        return tDevicesDao.getPortStatus1();
    }

}
