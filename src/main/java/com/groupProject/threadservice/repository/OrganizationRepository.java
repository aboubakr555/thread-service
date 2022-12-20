package com.groupProject.threadservice.repository;

import com.groupProject.threadservice.entity.Organization;
import com.groupProject.threadservice.entity.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, UUID> {
    Organization findByOrgName(String name);
}
