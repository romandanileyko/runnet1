package ru.danileyko.service;

import ru.danileyko.model.Device;

import java.util.List;

/**
 * Created by danil on 14.09.2017.
 */
public interface DeviceService {
    List<Device> getAllDevices();
    public List<Object[]> getPortStatus1();
}
