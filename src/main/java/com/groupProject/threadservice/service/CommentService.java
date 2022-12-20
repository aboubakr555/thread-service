package com.groupProject.threadservice.service;

import com.groupProject.threadservice.entity.Comment;
import com.groupProject.threadservice.entity.Thread;
import com.groupProject.threadservice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class CommentService {

    @Autowired
    public  CommentRepository commentRepository;


    public List<Comment> findAllComments() {
        return  commentRepository.findAll();
    }


    public List<Comment> findCommentsByThreadId(UUID id) {
        return commentRepository.findByThread(id);
    }

    public String saveComment(Comment comment) {
        if(Objects.nonNull(comment.getContent()) && Objects.nonNull(comment.getThread()) && !"".equalsIgnoreCase(comment.getContent())) {
             commentRepository.save(comment);
             return "Comment saved";
        }
        return "Content and thread must be non empty";
    }

    public Comment updateComment(UUID id, Comment comment) {
        Comment commentDB = commentRepository.findById(id).get();

        if(Objects.nonNull(comment.getContent()) && !"".equalsIgnoreCase(comment.getContent())) {
            commentDB.setContent(comment.getContent());
        }

        return commentRepository.save(commentDB);

    }

    public void deleteCommentById(UUID id) {
        commentRepository.deleteById(id);
    }
}
