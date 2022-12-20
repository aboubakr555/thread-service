package com.groupProject.threadservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String orgName;

 //   private String profilePicture;
    private String email, address, description;
//    @OneToMany(fetch = FetchType.EAGER, mappedBy="organization", cascade = CascadeType.ALL)
//    private List<Thread> threads;


}
