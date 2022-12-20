package com.groupProject.threadservice.controller;

import com.groupProject.threadservice.entity.Organization;
import com.groupProject.threadservice.entity.Thread;
import com.groupProject.threadservice.repository.OrganizationRepository;
import com.groupProject.threadservice.repository.ThreadRepository;
import com.groupProject.threadservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {
    @Autowired
    private  OrganizationService organizationService;

    // get all organizations
    @GetMapping("/")
    public List<Organization> findAllOrganizations() {
        return organizationService.findAllOrganizations();
    }

    // get organization by name
    @GetMapping("/name/{name}")
    public Organization findOrganizationByName(String name) {
        return organizationService.findOrganizationByName(name);
    }

    // post an organization
    @PostMapping("/")
    public Organization saveOrganization(@RequestBody Organization organization){
        return  organizationService.saveOrganization(organization);
    }
     //delete org
    @DeleteMapping("/{id}")
    public String deletetOrgById(@PathVariable("id") UUID id) {
        organizationService.deletetOrgById(id);
        return "org deleted Successfully!!";
    }


    // update org
    @PutMapping("/{id}")
    public Organization updateOrg(@PathVariable("id") UUID id, @RequestBody Organization organization) {
        return organizationService.updateOrg(id,organization);
    }
}
