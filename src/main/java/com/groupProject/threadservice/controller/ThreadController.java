package com.groupProject.threadservice.controller;



import com.groupProject.threadservice.entity.Comment;
import com.groupProject.threadservice.entity.Thread;
import com.groupProject.threadservice.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/threads")
public class ThreadController {
    @Autowired
    private ThreadService threadService;

    //save a thread
    @PostMapping
    public Thread saveThread(@RequestBody Thread thread){


        return  threadService.saveThread(thread);
    }

    // fetch all threads
    @GetMapping
    public List<Thread> findAllThreads() {
        return threadService.findAllThreads();

    }

    //fetch thread by id
    @GetMapping("/{id}")
    public Thread findThreadById(@PathVariable("id") UUID id) {
        return threadService.findThreadById(id);

    }

    //fetch thread by title
    @GetMapping("/title/{title}")
    public List<Thread> findThreadByTitle(@PathVariable("title") String title) {
        return threadService.findThreadByTitle(title);

    }


    //fetch thread by username
   @GetMapping("/user/{user}")
    public List<Thread> findThreadsByUser(String username) {
       return threadService.findThreadByUsername(username);
    }


    // delete thread by id
    @DeleteMapping("/{id}")
    public String deleteThreadById(@PathVariable("id") UUID threadId) {
       threadService.deleteThreadById(threadId);
        return "Thread deleted Successfully!!";
    }


    // update thread
    @PutMapping("/{id}")
    public Thread updateThread(@PathVariable("id") UUID id, @RequestBody Thread thread) {
        return threadService.updateThread(id,thread);
    }

//    // add a comment to a thread
//    @PostMapping("/comment/{id}")
//    public String addCommentToThread(@PathVariable("id") UUID id,@RequestBody Comment comment) {
//        return threadService.addCommentToThread(id,comment);
//
//    }
//
//    // delete comment from thread
//    @DeleteMapping("/comment/{id}")
//    public String deleteCommentFromThread(@PathVariable("id") UUID threadId,@RequestBody Comment comment) {
//        threadService.deleteCommentFromThread(threadId,comment);
//        return "Thread Comment deleted Successfully!!";
//    }




}
