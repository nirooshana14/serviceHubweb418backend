package com.classproject.classprojectbackend.entity;

import javax.persistence.*;
import java.util.Locale;

@Entity
@Table(name="serviceprovider")
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="serviceproviderid")
    private int serviceProviderId;

    @Column(name="companyname")
    private String companyName;

    @Column(name="licencenumber")
    private String licenceNumber;

    @Column(name="description")
    private String description;

    @Column(name="rating")
    private int  rating;

    @Column(name="category")
    private String category;

    @Column(name="location")
    private int location;



    @Column(name="result")
    private String result;

    @OneToOne
    @JoinColumn(name="userid", nullable=false)
    private Users users;


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public ServiceProvider() {
    }

    public ServiceProvider(int serviceProviderId, String companyName, String licenceNumber, String description, int rating, String category, int location, String result, Users users) {
        this.serviceProviderId = serviceProviderId;
        this.companyName = companyName;
        this.licenceNumber = licenceNumber;
        this.description = description;
        this.rating = rating;
        this.category = category;
        this.location = location;
        this.result = result;
        this.users = users;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(int serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }


    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


}
