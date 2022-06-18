package com.classproject.classprojectbackend.controler;

import com.classproject.classprojectbackend.entity.Comments;
import com.classproject.classprojectbackend.entity.CustomerDislikedComments;
import com.classproject.classprojectbackend.entity.Customerlikedcomments;
import com.classproject.classprojectbackend.entity.Replies;
import com.classproject.classprojectbackend.service.CommentsService;
import com.classproject.classprojectbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/comments")
@CrossOrigin(origins = "http://localhost:3000")
public class CommentsControler {

    @Autowired(required=true)
    private CommentsService commentsService;

    @PostMapping("/postComment")
    public ResponseEntity<Comments> postComments(@RequestBody Comments comments) {
        Comments comments1 = null;
        try {
            comments = commentsService.saveComments(comments);
        } catch (Exception ex) {

        }

        return new ResponseEntity<Comments>(comments1, HttpStatus.OK);

    }

    @GetMapping("/allComments")
    public ResponseEntity<ArrayList<Comments>> getAllComments() {

        ArrayList<Comments> comments = null;
        try {
            comments = commentsService.getComments();
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<ArrayList<Comments>>(comments, HttpStatus.OK);
    }

    @GetMapping("/getLikedComments/{id}")
    public ResponseEntity<ArrayList<Customerlikedcomments>> getLikedComments(@PathVariable("id") int id) {

        ArrayList<Customerlikedcomments> comments = null;
        try {
            comments = commentsService.getLikedComments(id);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<ArrayList<Customerlikedcomments>>(comments, HttpStatus.OK);
    }


    @GetMapping("/updateLikedComment/{likes},{commentId},{customerId},{reason},{likeId}")
    public ResponseEntity<String> updateLikedComment(@PathVariable("likes") int likes,
                                                     @PathVariable("commentId") int commentId,
                                                     @PathVariable("customerId") int customerId,
                                                     @PathVariable("reason") String reason,
                                                     @PathVariable("likeId") int likeId) {


        try {
            commentsService.updateLikedComment(likes,commentId,customerId,reason,likeId);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<String>("Comments Liked Updated Successfully", HttpStatus.OK);
    }
    @GetMapping("/getDisLikedComments/{id}")
    public ResponseEntity<ArrayList<CustomerDislikedComments>> getDisLikedComments(@PathVariable("id") int id) {

        ArrayList<CustomerDislikedComments> comments = null;
        try {
            comments = commentsService.getDisLikedComments(id);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<ArrayList<CustomerDislikedComments>>(comments, HttpStatus.OK);
    }

    @GetMapping("/updateDisLikedComment/{dislikes},{commentId},{customerId},{reason},{dislikeid}")
    public ResponseEntity<String> updateDisLikedComment(@PathVariable("dislikes") int dislikes,
                                                        @PathVariable("commentId") int commentId,
                                                        @PathVariable("customerId") int customerId,
                                                        @PathVariable("reason") String reason,
                                                        @PathVariable("dislikeid") int dislikeid) {


        try {
            commentsService.updateDisLikedComment(dislikes,commentId,customerId,reason,dislikeid);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<String>("Comments Liked Updated Successfully", HttpStatus.OK);
    }


    @GetMapping("/getReplies/{commentId}")
    public ResponseEntity<ArrayList<Replies>> getReplies(@PathVariable("commentId") int commentId) {

        ArrayList<Replies> replies = null;
        try {
            replies = commentsService.getReplies(commentId);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<ArrayList<Replies>>(replies, HttpStatus.OK);
    }

    @PostMapping("/postReplies/{repliesCount}")
    public ResponseEntity<String> postReplies(@RequestBody Replies replies,@PathVariable("repliesCount") int repliesCount) {

        try {
            commentsService.addReplies(replies,repliesCount);
        } catch (Exception ex) {

        }

        return new ResponseEntity<String>("Replies added successfully", HttpStatus.OK);

    }




}
