package com.classproject.classprojectbackend.entity;

import javax.persistence.*;

@Entity
@Table(name="branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="branchid")
    private int branchId;

    @Column(name="branchname")
    private String branchName;


    public Branch(int branchId, String branchName) {
        this.branchId = branchId;
        this.branchName = branchName;
    }

    public Branch() {
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
