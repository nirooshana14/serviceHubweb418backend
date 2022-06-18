package com.classproject.classprojectbackend.entity;

import javax.persistence.*;

@Entity
@Table(name="quotation")
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="quotationid")
    private  int quotationId;

    @Column(name="message")
    private  String message;

    @OneToOne
    @JoinColumn(name="requirementid", nullable=false)
    private PostRequirement postRequirement;

    @OneToOne
    @JoinColumn(name="serviceconsumerid", nullable=false)
    private ServiceConsumer serviceConsumer;

    @OneToOne
    @JoinColumn(name="serviceproviderid", nullable=false)
    private ServiceProvider serviceProvider;

    public Quotation(int quotationId, String message, PostRequirement postRequirement, ServiceConsumer serviceConsumer, ServiceProvider serviceProvider) {
        this.quotationId = quotationId;
        this.message = message;
        this.postRequirement = postRequirement;
        this.serviceConsumer = serviceConsumer;
        this.serviceProvider = serviceProvider;
    }

    public Quotation() {
    }

    public int getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(int quotationId) {
        this.quotationId = quotationId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PostRequirement getPostRequirement() {
        return postRequirement;
    }

    public void setPostRequirement(PostRequirement postRequirement) {
        this.postRequirement = postRequirement;
    }

    public ServiceConsumer getServiceConsumer() {
        return serviceConsumer;
    }

    public void setServiceConsumer(ServiceConsumer serviceConsumer) {
        this.serviceConsumer = serviceConsumer;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
}
