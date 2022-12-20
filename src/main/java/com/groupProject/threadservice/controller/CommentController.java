package com.groupProject.threadservice.controller;

import com.groupProject.threadservice.entity.Comment;
import com.groupProject.threadservice.entity.Thread;
import com.groupProject.threadservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    public CommentService commentService;

    //get all comments
    @GetMapping("/")
    public List<Comment> findAllComments() {
        return commentService.findAllComments();
    }

    // get comments of a thread
    @GetMapping("/thread/{thread_id}")
    public List<Comment> findCommentsByThreadId(@PathVariable("thread_id") UUID id) {
        return commentService.findCommentsByThreadId(id);
    }

    // post a comment
    @PostMapping("/")
    public String saveComment(@RequestBody Comment comment){

        return  commentService.saveComment(comment);
    }

    // UPDATE A COMMENT
    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable("id") UUID id, @RequestBody Comment comment) {
        return commentService.updateComment(id,comment);
    }

    //delete a comment
    @DeleteMapping("/{id}")
    public String deleteCommentById(@PathVariable("id") UUID id) {
        commentService.deleteCommentById(id);
        return "Comment deleted Successfully!!";
    }



}
