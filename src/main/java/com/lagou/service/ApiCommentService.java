package com.lagou.service;

import com.lagou.pojo.Comment;
import com.lagou.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class ApiCommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    RedisTemplate redisTemplate;

    public Comment findCommentById(Integer id){

        Object o = redisTemplate.opsForValue().get("comment_" + id);
        if(o==null){
            Optional<Comment> optionalComment = commentRepository.findById(id);
            if(optionalComment.isPresent()){
                Comment comment = optionalComment.get();
                // 将查询结果放到缓存中，并设置有效期为1天
                redisTemplate.opsForValue().set("comment_" + id,comment,1, TimeUnit.DAYS);
                return comment;
            }
        }

        return (Comment) o;
    }


    public Comment updateComment(Comment comment){
        commentRepository.updateComment(comment.getAuthor(),comment.getId());
        redisTemplate.opsForValue().set("comment_" + comment.getId(),comment,1, TimeUnit.DAYS);
        return comment;
    }


    public void deleteComment(Integer id){
        commentRepository.deleteById(id);
        redisTemplate.delete("comment_" + id);
    }

}
