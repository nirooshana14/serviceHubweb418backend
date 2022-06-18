package com.classproject.classprojectbackend.entity;


import javax.persistence.*;

@Entity

@Table(name="agent")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="agentid ")
    private int agentId;

    @Column(name="nicnumber")
    private String nicNumber;

    @Column(name="dob")
    private String dob;

    @Column(name="type")
    private String type;

    @Column(name="promocode")
    private String promoCode;

    @OneToOne
    @JoinColumn(name="userid", nullable=false)
    private Users users;

    @Column(name="result")
    private String result;

    @Column(name="promocount")
    private int promocount;

    public Agent() {
    }

    public Agent(int agentId, String nicNumber, String dob, String type, String promoCode, Users users, String result, int promocount) {
        this.agentId = agentId;
        this.nicNumber = nicNumber;
        this.dob = dob;
        this.type = type;
        this.promoCode = promoCode;
        this.users = users;
        this.result = result;
        this.promocount = promocount;
    }

    public int getPromocount() {
        return promocount;
    }

    public void setPromocount(int promocount) {
        this.promocount = promocount;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getNicNumber() {
        return nicNumber;
    }

    public void setNicNumber(String nicNumber) {
        this.nicNumber = nicNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
