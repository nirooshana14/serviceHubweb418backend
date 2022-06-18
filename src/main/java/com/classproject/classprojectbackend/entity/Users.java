package com.classproject.classprojectbackend.entity;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    private int userId;

    public Users() {
    }

    @Column(name="email")
    private String email;

    @Column(name="username")
    private String userName;

    @Column(name="address")
    private String address;

    @Column(name="postcode")
    private String postcode;

    @Column(name="contactnumber")
    private String contactNumber;

    @Column(name="password")
    private String password;

    @Column(name="usertypeid")
    private int userTypeId;

    @Column(name="image")
    private String image;

    public Users(int userId, String email, String userName, String address, String postcode, String contactNumber, String password, int userTypeId, String image) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.address = address;
        this.postcode = postcode;
        this.contactNumber = contactNumber;
        this.password = password;
        this.userTypeId = userTypeId;
        this.image = image;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
