package com.groupProject.threadservice.repository;

import com.groupProject.threadservice.entity.Vote;
import com.groupProject.threadservice.entity.VoteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote,VoteId> {

}
