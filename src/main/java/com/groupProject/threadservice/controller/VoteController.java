package com.groupProject.threadservice.controller;

import com.groupProject.threadservice.entity.Thread;
import com.groupProject.threadservice.entity.Vote;
import com.groupProject.threadservice.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votes")
public class VoteController {
    @Autowired
    public VoteService voteService;

    // get votes
    @GetMapping("/")
    public List<Vote> findAllVotes() {
        return voteService.findAllVotes();
    }

    // post a vote
    @PostMapping("/")
    public Vote saveVote(@RequestBody Vote vote){
        return  voteService.saveVote(vote);
    }

}
