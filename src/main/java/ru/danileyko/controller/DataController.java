package ru.danileyko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.danileyko.model.*;
import ru.danileyko.reports.ReportStatusOfPort;
import ru.danileyko.reports.UserPorts;
import ru.danileyko.service.DeviceService;
import ru.danileyko.service.DhcpLogService;
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

    @Autowired
    private DhcpLogService dhcpLogService;

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
    public @ResponseBody String getStatus(@RequestParam("devIp") String devIp,@RequestParam("ifName") String ifName){
        SshClient sshClient = new SshClient();
        return sshClient.portStatus(devIp,ifName);
    }

    @RequestMapping(value = "/shut",method = RequestMethod.POST)
    public @ResponseBody String setShutdown(@RequestParam("devIp") String devIp,@RequestParam("ifName") String ifName){
        SshClient sshClient = new SshClient();
        sshClient.portStatusChange(devIp.trim(),ifName.trim(),false);
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

    @RequestMapping(value = "/userport",method = RequestMethod.POST)
    public @ResponseBody List<UserPorts> getUserPort(@RequestParam("puser") String puser){
        List<Object[]> listObj = macCustomerService.userPort(puser);

        List<UserPorts> userPortsList = new ArrayList<>();

        listObj.forEach((record)->{
            UserPorts userPorts = new UserPorts();
            System.out.println ((String) record[0]);
            System.out.println ((String) record[1]);
            System.out.println ((String) record[5]);
            userPorts.setPuser((String) record[0]);
            userPorts.setMac((String) record[1]);
            userPorts.setDeviceIp((String) record[2]);
            userPorts.setIfName((String) record[3]);
            userPorts.setClientIp((String) record[4]);
            userPorts.setStatus((String) record[5]);
            userPorts.setLastDateUpdate((Timestamp) record[8]);
            userPorts.setAdminStatus((String) record[6]);
            userPorts.setHostel((String) record[7]);
            userPortsList.add(userPorts);
        });
        return userPortsList;
    }

    @RequestMapping(value = "/dhcplog")
    public @ResponseBody List<DhcpLogView> getDhcpLogByUserName(@RequestParam("vUser") String vUser){
        return dhcpLogService.getDhcpLogUserByUserName(vUser);
    }
}
