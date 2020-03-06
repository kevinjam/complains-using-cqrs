package com.kevinjanvier.democomplaints.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ComplaintQueryObject {

    @Id
    private String complainId;
    private String company;
    private String description;

    public ComplaintQueryObject() {
    }

    public ComplaintQueryObject(String complainId, String company, String description){
        this.complainId = complainId;
        this.company = company;
        this.description = description;
    }



    public String getComplainId() {
        return complainId;
    }

    public String getCompany() {
        return company;
    }

    public String getDescription() {
        return description;
    }
}
