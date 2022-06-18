package com.classproject.classprojectbackend.entity;

import javax.persistence.*;

@Entity
@Table(name="askquestion")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="questionid")
    private int questionId;
    @Column(name="email")
    private String email;
    @Column(name="subject")
    private String subject;
    @Column(name="description")
    private String description;

    @OneToOne
    @JoinColumn(name="inqueringaboutid", nullable=false)
    private InqueringAbout inqueringAbout;

    @Column(name="attachments")
    private String attachments;

    @OneToOne
    @JoinColumn(name="serviceconsumerid", nullable=false)
    private ServiceConsumer serviceConsumer;

    public Question() {
    }

    public Question(int questionId, String email, String subject, String description, InqueringAbout inqueringAbout, String attachments, ServiceConsumer serviceConsumer) {
        this.questionId = questionId;
        this.email = email;
        this.subject = subject;
        this.description = description;
        this.inqueringAbout = inqueringAbout;
        this.attachments = attachments;
        this.serviceConsumer = serviceConsumer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InqueringAbout getInqueringAbout() {
        return inqueringAbout;
    }

    public void setInqueringAbout(InqueringAbout inqueringAbout) {
        this.inqueringAbout = inqueringAbout;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public ServiceConsumer getServiceConsumer() {
        return serviceConsumer;
    }

    public void setServiceConsumer(ServiceConsumer serviceConsumer) {
        this.serviceConsumer = serviceConsumer;
    }
}
