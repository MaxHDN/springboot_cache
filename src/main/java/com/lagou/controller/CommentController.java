package com.lagou.controller;

import com.lagou.pojo.Comment;
import com.lagou.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping("/findById")
    public Comment findById(Integer id){
        return commentService.findCommentById(id);
    }

    @RequestMapping("/updateComment")
    public Comment updateComment(String author, Integer id){
        Comment comment = commentService.findCommentById(id);
        if(comment != null){
            comment.setAuthor(author);
            commentService.updateComment(comment);
        }
        return null;
    }

    @RequestMapping("/deleteComment")
    public Comment deleteComment(Integer id){
        Comment comment = commentService.findCommentById(id);
        if(comment != null){
            commentService.deleteComment(id);
            return comment;
        }
        return null;
    }


}
