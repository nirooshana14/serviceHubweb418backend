package com.classproject.classprojectbackend.entity;

import javax.persistence.*;

@Entity
@Table(name="replies")
public class Replies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="replyid")
    private int replyId;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="reply")
    private String reply;

    @Column(name="commentsid")
    private int commentId;

    public Replies() {
    }

    public Replies(int replyId, String name, String email, String reply, int commentId) {
        this.replyId = replyId;
        this.name = name;
        this.email = email;
        this.reply = reply;
        this.commentId = commentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }
}
