package com.classproject.classprojectbackend.entity;

import javax.persistence.*;

@Entity
@Table(name="usertype")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="usertypeid")
    private int userTypeId;

    @Column(name="usertypename")
    private String userTypeName;

    public UserType(int userTypeId, String userTypeName) {
        this.userTypeId = userTypeId;
        this.userTypeName = userTypeName;
    }

    public UserType() {
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "userTypeId=" + userTypeId +
                ", userTypeName='" + userTypeName + '\'' +
                '}';
    }
}
