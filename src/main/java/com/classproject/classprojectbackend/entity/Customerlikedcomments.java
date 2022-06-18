package com.classproject.classprojectbackend.entity;

import javax.persistence.*;

@Entity
@Table(name="customerlikedcomments")
public class Customerlikedcomments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="likedid")
    private int likedId;

    @Column(name="customerid")
    private int customerId;

    @Column(name="commentid")
    private int commentId;

    public Customerlikedcomments() {
    }

    public Customerlikedcomments(int likedId, int customerId, int commentId) {
        this.likedId = likedId;
        this.customerId = customerId;
        this.commentId = commentId;
    }

    public int getLikedId() {
        return likedId;
    }

    public void setLikedId(int likedId) {
        this.likedId = likedId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }
}
