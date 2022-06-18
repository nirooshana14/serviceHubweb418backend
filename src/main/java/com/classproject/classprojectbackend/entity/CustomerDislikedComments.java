package com.classproject.classprojectbackend.entity;


import javax.persistence.*;

@Entity
@Table(name="customerdislikedcomments")
public class CustomerDislikedComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dislikedid")
    private int dislikedId;

    @Column(name="customerid")
    private int customerId;

    @Column(name="commentid")
    private int commentId;

    public CustomerDislikedComments() {
    }

    public CustomerDislikedComments(int dislikedId, int customerId, int commentId) {
        this.dislikedId = dislikedId;
        this.customerId = customerId;
        this.commentId = commentId;
    }

    public int getDislikedId() {
        return dislikedId;
    }

    public void setDislikedId(int dislikedId) {
        this.dislikedId = dislikedId;
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
