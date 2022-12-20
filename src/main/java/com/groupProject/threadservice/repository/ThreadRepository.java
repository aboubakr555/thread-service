package com.groupProject.threadservice.repository;

import com.groupProject.threadservice.entity.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
 @Repository
public interface ThreadRepository extends JpaRepository<Thread,UUID> {

     Optional<Thread>  findByThreadId(UUID id);


     List<Thread> findByTitle(String title);

     List<Thread> findByUsername(String username);
 }
