package ru.danileyko.sshclient;

import com.jcabi.ssh.Shell;
import com.jcabi.ssh.Ssh;
import com.jcabi.ssh.SshByPassword;
import com.jcraft.jsch.*;
import net.sf.expectit.Expect;
import net.sf.expectit.ExpectBuilder;
import net.sf.expectit.ExpectIOException;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;

import static net.sf.expectit.filter.Filters.removeColors;
import static net.sf.expectit.filter.Filters.removeNonPrintable;
import static net.sf.expectit.matcher.Matchers.contains;

/**
 * Created by danil on 03.10.2017.
 */
public class SshClient {
    public String portStatus(String ip,String ifName){
        String status="";
        String[] parts = null;
        try{
             status = new Shell.Plain(
                    new SshByPassword(ip,22,
                            "drv","ZalupaJan112358")
            ).exec("sh interfaces " + ifName +" status");
            System.out.println("STATUS: " + status);
            parts = status.split("\n");
            status = parts[3].substring(28,40).trim();
        }catch (Exception ex){ex.printStackTrace();}
        return status;
    }

    public void portStatusChange(String ip, String ifName, boolean flag){
        ip = ip.trim();
        ifName = ifName.trim();

        String command = null;
        String username = null;
        String password = null;

        if(flag){command = "shutdown";}
        else{command = "no shutdown";}


        Properties properties = new Properties();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("ssh.properties").getFile());
        String path = file.getPath();

        try(InputStream inputStream = new FileInputStream(path)){
            properties.load(inputStream);
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException ex){
            System.out.println("File Error " + ex.getMessage());
        }

        try{
            JSch jSch = new JSch();
            Session session = jSch.getSession(username,ip,22);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setPassword(password);
            session.connect();

            ChannelShell channel = (ChannelShell) session.openChannel("shell");
            channel.connect();

            StringBuilder wholeBuffer = new StringBuilder();

            Expect expect = new ExpectBuilder()
                    .withOutput(channel.getOutputStream())
                    .withInputs(channel.getInputStream(),channel.getExtInputStream())
                    .withEchoInput(wholeBuffer)
                    .withEchoOutput(wholeBuffer)
                    .withInputFilters(removeColors(), removeNonPrintable())
                    .withExceptionOnFailure()
                    .build();

            try {
                expect.sendLine("conf t");
                expect.expect(contains("config"));
                expect.sendLine("interface " + ifName);
                expect.expect(contains("config-if"));
                expect.sendLine(command);
            } catch (ExpectIOException ex){
                System.out.println("Expect Error: "+ex.getMessage());
            }
            String response = wholeBuffer.toString();
            System.out.println(response);
        expect.close();
        channel.disconnect();
        session.disconnect();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
