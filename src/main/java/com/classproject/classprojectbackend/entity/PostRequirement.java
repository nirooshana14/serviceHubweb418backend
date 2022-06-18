package com.classproject.classprojectbackend.entity;

import javax.persistence.*;

@Entity
@Table(name="postrequirement")
public class PostRequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="requirementid")
    private  int requirementId;


    @OneToOne
    @JoinColumn(name="branchid", nullable=false)
    private Branch branch;

    @Column(name="requirementdetails")
    private String requirementDetails;

    @Column(name="email")
    private String email;

    @Column(name="phonenumber")
    private String phonenumber;

    @Column(name="category")
    private String category;

    @OneToOne
    @JoinColumn(name="serviceconsumerid", nullable=false)
    private ServiceConsumer serviceConsumer;

    public PostRequirement(int requirementId, Branch branch, String requirementDetails, String email, String phonenumber, String category, ServiceConsumer serviceConsumer) {
        this.requirementId = requirementId;
        this.branch = branch;
        this.requirementDetails = requirementDetails;
        this.email = email;
        this.phonenumber = phonenumber;
        this.category = category;
        this.serviceConsumer = serviceConsumer;
    }

    public PostRequirement() {
    }

    public int getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(int requirementId) {
        this.requirementId = requirementId;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getRequirementDetails() {
        return requirementDetails;
    }

    public void setRequirementDetails(String requirementDetails) {
        this.requirementDetails = requirementDetails;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ServiceConsumer getServiceConsumer() {
        return serviceConsumer;
    }

    public void setServiceConsumer(ServiceConsumer serviceConsumer) {
        this.serviceConsumer = serviceConsumer;
    }
}
