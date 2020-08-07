package com.lagou.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "t_comment")
public class Comment implements Serializable {

    @Id // 表明表中的主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键的自增策略
    private Integer id;
    private String content;
    private String author;
    @Column(name = "a_id") // 映射表中的字段
    private Integer aId;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", aId=" + aId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }
}
