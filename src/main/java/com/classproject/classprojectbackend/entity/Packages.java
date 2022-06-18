package com.classproject.classprojectbackend.entity;

import javax.persistence.*;

@Entity
@Table(name="packages")
public class Packages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="packageid")
    private int packageId;

    @Column(name="packagename")
    private String packageName;

    @Column(name="templates")
    private int templates;

    @Column(name="accountscountpermonth")
    private int accountsCountPerMonth;

    @Column(name="calender")
    private String calender;

    @Column(name="googlemap")
    private String googleMap;

    @Column(name="price")
    private String price;

    @Column(name="description")
    private String description;

    public Packages() {
    }

    public Packages(int packageId, String packageName, int templates, int accountsCountPerMonth, String calender, String googleMap, String price, String description) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.templates = templates;
        this.accountsCountPerMonth = accountsCountPerMonth;
        this.calender = calender;
        this.googleMap = googleMap;
        this.price = price;
        this.description = description;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getTemplates() {
        return templates;
    }

    public void setTemplates(int templates) {
        this.templates = templates;
    }

    public int getAccountsCountPerMonth() {
        return accountsCountPerMonth;
    }

    public void setAccountsCountPerMonth(int accountsCountPerMonth) {
        this.accountsCountPerMonth = accountsCountPerMonth;
    }

    public String getCalender() {
        return calender;
    }

    public void setCalender(String calender) {
        this.calender = calender;
    }

    public String getGoogleMap() {
        return googleMap;
    }

    public void setGoogleMap(String googleMap) {
        this.googleMap = googleMap;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
