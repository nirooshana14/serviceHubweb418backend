package com.classproject.classprojectbackend.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="subscribe")
public class Subscribe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="subscribeid")
    private int subscribeId;

    @Column(name="cardno")
    private String cardNo;

    @OneToOne
    @JoinColumn(name="packageid", nullable=false)
    private Packages packages;

    @OneToOne
    @JoinColumn(name="serviceproviderid", nullable=false)
    private ServiceProvider serviceProvider;

    @Column(name="startdate")
    private Date startDate;

    @Column(name="enddate")
    private Date endDate;

    @Column(name="quotationcount")
    private int quotationcount;

    @Column(name="status")
    private String status;

    public Subscribe(int subscribeId, String cardNo, Packages packages, ServiceProvider serviceProvider, Date startDate, Date endDate, int quotationcount, String status) {
        this.subscribeId = subscribeId;
        this.cardNo = cardNo;
        this.packages = packages;
        this.serviceProvider = serviceProvider;
        this.startDate = startDate;
        this.endDate = endDate;
        this.quotationcount = quotationcount;
        this.status = status;
    }

    public Subscribe() {
    }

    public int getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(int subscribeId) {
        this.subscribeId = subscribeId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Packages getPackages() {
        return packages;
    }

    public void setPackages(Packages packages) {
        this.packages = packages;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getQuotationcount() {
        return quotationcount;
    }

    public void setQuotationcount(int quotationcount) {
        this.quotationcount = quotationcount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
