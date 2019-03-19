package br.com.unitins.agr.agenda.models;

import java.io.Serializable;

public class Contact implements Serializable {

    private static final long serialVerionID = 1L;

    private Long id = null;
    private String name = null;
    private String phone = null;
    private String company = null;

    public Contact() {
    }

    public Contact(Long id, String name, String phone, String company) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
