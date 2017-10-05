package ru.danileyko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.danileyko.model.Device;
import ru.danileyko.model.PortStatus;
import ru.danileyko.reports.ReportStatusOfPort;
import ru.danileyko.service.DeviceService;
import ru.danileyko.sshclient.SshClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danil on 13.09.2017.
 */
@RestController
public class DataController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping("/user")
    public @ResponseBody String getUser(){
        return "{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"}," +
                "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}";
    }

    @RequestMapping("/alldev")
    public @ResponseBody List<Device> getDevices(){
        return deviceService.getAllDevices();
    }

    @RequestMapping("/portstatus")
    public @ResponseBody List<ReportStatusOfPort> getPortStatus(){
        List<Object[]> listObj = deviceService.getPortStatus1();
        List<ReportStatusOfPort> list = new ArrayList<>();

        for(Object o[]:listObj) {
            Device device = (Device) o[0];
            PortStatus portStatus = (PortStatus) o[1];

            ReportStatusOfPort report = new ReportStatusOfPort(
                    device.getName(),
                    device.getIp(),
                    portStatus.getIfName(),
                    portStatus.getAdminStatus(),
                    portStatus.getOperationalStatus(),
                    portStatus.getLastInDate());
            list.add(report);
        }
        return list;
    }

    @RequestMapping("/sshtest")
    public @ResponseBody String getStatus(){
        SshClient sshClient = new SshClient();
        return sshClient.portStatus("10.2.57.7","FastEthernet0/44");
    }

    @RequestMapping("/shut")
    public @ResponseBody String setShutdown(){
        SshClient sshClient = new SshClient();
        sshClient.portStatusChange("10.2.57.7","FastEthernet0/44",false);
        return "shutdown";
    }
}
