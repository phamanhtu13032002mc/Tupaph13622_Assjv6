package com.example.tupaph13622_assjv6.rest.controller;

import com.example.tupaph13622_assjv6.respository.RoleRepository;
import com.example.tupaph13622_assjv6.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
public class RoleRestController {
    @Autowired
    RoleRepository roleRepository;
    @GetMapping()
    public List<Role> getAll(){
        return roleRepository.findAll();
    }
}
