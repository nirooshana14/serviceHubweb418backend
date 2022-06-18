package com.classproject.classprojectbackend.entity;


import javax.persistence.*;

@Entity
@Table(name="serviceproviderwithpromo")
public class ServiceProviderWithPromo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="serviceproviderwithpromoid")
    private int serviceproviderWithPromoId;
    @Column(name="serviceproviderid")
    private  int serviceproviderId;
    @Column(name="agentid")
    private  int agentId;

    public ServiceProviderWithPromo(int serviceproviderWithPromoId, int serviceproviderId, int agentId) {
        this.serviceproviderWithPromoId = serviceproviderWithPromoId;
        this.serviceproviderId = serviceproviderId;
        this.agentId = agentId;
    }

    public ServiceProviderWithPromo() {
    }

    public int getServiceproviderWithPromoId() {
        return serviceproviderWithPromoId;
    }

    public void setServiceproviderWithPromoId(int serviceproviderWithPromoId) {
        this.serviceproviderWithPromoId = serviceproviderWithPromoId;
    }

    public int getServiceproviderId() {
        return serviceproviderId;
    }

    public void setServiceproviderId(int serviceproviderId) {
        this.serviceproviderId = serviceproviderId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    @Override
    public String toString() {
        return "ServiceProviderWithPromo{" +
                "serviceproviderWithPromoId=" + serviceproviderWithPromoId +
                ", serviceproviderId=" + serviceproviderId +
                ", agentId=" + agentId +
                '}';
    }
}
