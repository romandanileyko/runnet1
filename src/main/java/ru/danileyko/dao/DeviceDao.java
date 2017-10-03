package ru.danileyko.dao;

import ru.danileyko.model.Device;

import java.util.List;

/**
 * Created by danil on 14.09.2017.
 */
public interface DeviceDao {
    List<Device> getAllDevices();
    public List<Object[]> getPortStatus1();
}
