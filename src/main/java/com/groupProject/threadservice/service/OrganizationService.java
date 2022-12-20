package com.groupProject.threadservice.service;

import com.groupProject.threadservice.entity.Organization;
import com.groupProject.threadservice.entity.Thread;
import com.groupProject.threadservice.repository.OrganizationRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class OrganizationService {

    @Autowired
    public OrganizationRepository organizationRepository;

    public List<Organization> findAllOrganizations() {
        return organizationRepository.findAll();

    }

    public Organization findOrganizationByName(String name) {
        return organizationRepository.findByOrgName(name);
    }

    public Organization saveOrganization(Organization organization) {
        // not saved if the name already exists
        if(organization==organizationRepository.findByOrgName(organization.getOrgName())){
            return null;
        }
        return organizationRepository.save(organization);

    }

    public void deletetOrgById(UUID id) {
        organizationRepository.deleteById(id);
    }

    public Organization updateOrg(UUID id, Organization organization) {
        Organization orgDB = organizationRepository.findById(id).get();

        if(Objects.nonNull(organization.getOrgName()) && !"".equalsIgnoreCase(organization.getOrgName())) {
            orgDB.setOrgName(organization.getOrgName());
        }
        if(Objects.nonNull(organization.getAddress()) && !"".equalsIgnoreCase(organization.getAddress())) {
            orgDB.setAddress(organization.getAddress());
        }
        if(Objects.nonNull(organization.getDescription()) && !"".equalsIgnoreCase(organization.getDescription())) {
            orgDB.setDescription(organization.getDescription());
        }
        if(Objects.nonNull(organization.getEmail()) && !"".equalsIgnoreCase(organization.getEmail())) {
            orgDB.setEmail(organization.getEmail());
        }




        return organizationRepository.save(orgDB);

    }
}
