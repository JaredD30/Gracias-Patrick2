package com.adventurehub.api.composite.travelPackage;

import lombok.*;


public class ServiceAddresses {
    private String cmp;
    private String trpa;

    public ServiceAddresses(String cmp, String trpa) {
        this.cmp = cmp;
        this.trpa = trpa;
    }

    public String getCmp() {
        return cmp;
    }

    public String getTrpa() {
        return trpa;
    }
}
