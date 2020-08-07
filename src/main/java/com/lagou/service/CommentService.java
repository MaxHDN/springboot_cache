package com.lagou.service;

import com.lagou.pojo.Comment;
import com.lagou.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Cacheable(cacheNames = "comment",unless = "#result==null")
    public Comment findCommentById(Integer id){
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if(optionalComment.isPresent()){
            return optionalComment.get();
        }
        return null;
    }


    @CachePut(cacheNames = "comment" ,key = "#result.id")
    public Comment updateComment(Comment comment){
        commentRepository.updateComment(comment.getAuthor(),comment.getId());
        return comment;
    }


    @CacheEvict(cacheNames = "comment")
    public void deleteComment(Integer id){
        commentRepository.deleteById(id);
    }

}
