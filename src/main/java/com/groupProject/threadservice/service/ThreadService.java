package com.groupProject.threadservice.service;


import com.groupProject.threadservice.entity.Comment;
import com.groupProject.threadservice.entity.Thread;

import com.groupProject.threadservice.repository.ThreadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service

public class ThreadService {


    @Autowired
    private  ThreadRepository threadRepository;

    public Thread updateThread(UUID id, Thread thread) {
        Thread ThreadDB = threadRepository.findById(id).get();

        if(Objects.nonNull(thread.getTitle()) && !"".equalsIgnoreCase(thread.getTitle())) {
            ThreadDB.setTitle(thread.getTitle());
        }
        if(Objects.nonNull(thread.getContent()) && !"".equalsIgnoreCase(thread.getContent())) {
            ThreadDB.setContent(thread.getContent());
        }
//        if(Objects.nonNull(thread.getUpVotes()) && thread.getUpVotes()!=0 && thread.getUpVotes()!=ThreadDB.getUpVotes()) {
//            ThreadDB.setUpVotes(thread.getUpVotes());
//        }
//        if(Objects.nonNull(thread.getDownVotes()) && thread.getDownVotes()!=0 && thread.getDownVotes()!=ThreadDB.getDownVotes()) {
//            ThreadDB.setDownVotes(thread.getDownVotes());
//        }

        return threadRepository.save(ThreadDB);


    }

    public Thread saveThread(Thread thread) {
        return threadRepository.save(thread);
    }


    public Thread findThreadById(UUID id) {

        return threadRepository.findByThreadId(id).orElseThrow(
                IllegalStateException::new
        );
    }

    public List<Thread> findAllThreads() {
        return threadRepository.findAll();
    }

    public List<Thread> findThreadByTitle(String title) {
        return threadRepository.findByTitle(title);
    }

    public List<Thread> findThreadByUsername(String username) {
        return threadRepository.findByUsername(username);
    }

    public void deleteThreadById(UUID threadId) {
        threadRepository.deleteById(threadId);
    }
//
//    public String addCommentToThread(UUID id, Comment comment) {
//        Thread ThreadDB = threadRepository.findById(id).get();
//        ThreadDB.getComments().add(comment);
//         threadRepository.save(ThreadDB);
//         return "Comment added";
//    }
//
//    public String deleteCommentFromThread(UUID threadId, Comment comment) {
//        Thread ThreadDB = threadRepository.findById(threadId).get();
//        ThreadDB.getComments().remove(comment);
//        threadRepository.save(ThreadDB);
//        return "Thread Comment Deleted";
//    }
}
