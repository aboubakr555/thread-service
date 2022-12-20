package com.groupProject.threadservice.service;

import com.groupProject.threadservice.entity.Thread;
import com.groupProject.threadservice.entity.Vote;
import com.groupProject.threadservice.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {
    @Autowired
    public VoteRepository voteRepository;

    public  Vote saveVote(Vote vote) {
        if(vote.getVoteValue()<2 && vote.getVoteValue()>-2){
            return voteRepository.save(vote);
        }
        return null;

    }


    public List<Vote> findAllVotes() {
        return  voteRepository.findAll();
    }
}
