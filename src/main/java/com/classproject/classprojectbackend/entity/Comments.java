package com.classproject.classprojectbackend.entity;

import javax.persistence.*;

@Entity

@Table(name="comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="commentsid ")
    private int commentsId;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="review")
    private String review;
    @Column(name="rating")
    private String rating;
    @Column(name="likes")
    private int  likes;
    @Column(name="dislikes")
    private int  dislikes;

    @Column(name="replies")
    private int  replies;

    public Comments(int commentsId, String name, String email, String review, String rating, int likes, int dislikes, int replies) {
        this.commentsId = commentsId;
        this.name = name;
        this.email = email;
        this.review = review;
        this.rating = rating;
        this.likes = likes;
        this.dislikes = dislikes;
        this.replies = replies;
    }

    public Comments() {
    }

    public int getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(int commentsId) {
        this.commentsId = commentsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }
}
