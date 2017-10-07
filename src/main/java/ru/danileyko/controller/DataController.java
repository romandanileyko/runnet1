package ru.danileyko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.danileyko.model.ClientStatus;
import ru.danileyko.model.Device;
import ru.danileyko.model.MacCustomer;
import ru.danileyko.model.PortStatus;
import ru.danileyko.reports.ReportStatusOfPort;
import ru.danileyko.reports.UserPorts;
import ru.danileyko.service.DeviceService;
import ru.danileyko.service.MacCustomerService;
import ru.danileyko.sshclient.SshClient;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danil on 13.09.2017.
 */
@RestController
public class DataController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private MacCustomerService macCustomerService;

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
    @RequestMapping("/savemac")
    public @ResponseBody String saveMac(){
        MacCustomer macCustomer = new MacCustomer();
        macCustomer.setMac("00:50:56:c0:00:19");
        macCustomer.setPuser("Vdrv1");
        macCustomer.setStatus("E");
        macCustomerService.save(macCustomer);
        return "save";
    }

    @RequestMapping("/userport")
    public @ResponseBody List<UserPorts> getUserPort(){
        List<Object[]> listObj = macCustomerService.userPort("Vdr");
        UserPorts userPorts = new UserPorts();
        List<UserPorts> userPortsList = new ArrayList<>();

        listObj.forEach((record)->{
            System.out.println ((String) record[0]);
            System.out.println ((String) record[1]);
            userPorts.setPuser((String) record[0]);
            userPorts.setMac((String) record[1]);
            userPorts.setDeviceIp((String) record[2]);
            userPorts.setIfName((String) record[3]);
            userPorts.setClientIp((String) record[4]);
            userPorts.setStatus((String) record[5]);
            userPorts.setLastDateUpdate((Timestamp) record[6]);
            userPortsList.add(userPorts);
        });
        return userPortsList;
    }
}
