package ru.danileyko.controller;

import org.springframework.context.annotation.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by danil on 24.10.2017.
 */
@Controller
@RequestMapping(value = "/",method = {RequestMethod.GET,RequestMethod.POST})
public class SecureController {
    List<String> list = new ArrayList<>();
    List<GrantedAuthority> listAuthorities = new ArrayList<GrantedAuthority>();

    @RequestMapping(value = "/test")
    public @ResponseBody
    List<String> list(){
        list.add("Test.");
        String loggedUser = getPrincipal();
        System.out.println("loggedUser is: "+loggedUser);
        return list;
    }
    @RequestMapping(value = "/roles")
    public @ResponseBody List<GrantedAuthority> authority(){
        listAuthorities = getRoles();
        return listAuthorities;
    }

    @RequestMapping(value = {"/admin","/logout"})
    public String redirectToIndex(){
        return "forward:/index.html";
    }

    private String getPrincipal(){
        String userName = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object prncipal = authentication.getPrincipal();

        if(prncipal instanceof UserDetails){
            userName = ((UserDetails)prncipal).getUsername();
        } else {
            userName = prncipal.toString();
        }
        return userName;
    }

    private List<GrantedAuthority> getRoles(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<GrantedAuthority> listAuthorities = new ArrayList<GrantedAuthority>();
        listAuthorities.addAll(authorities);
        return listAuthorities;
    }
}
