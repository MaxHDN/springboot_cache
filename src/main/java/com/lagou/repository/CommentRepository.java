package com.lagou.repository;

import com.lagou.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    @Transactional
    @Modifying
    @Query("update t_comment c set c.author = ?1 where c.id=?2")
    public int updateComment(String author,Integer id);
}
