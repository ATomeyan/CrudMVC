package com.bdg.crudmvc.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "first_Name")
    private String f_Name;
    @Column(name = "last_Name")
    private String l_Name;
    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(int id, String f_Name, String l_Name, String email) {
        this.id = id;
        this.f_Name = f_Name;
        this.l_Name = l_Name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getF_Name() {
        return f_Name;
    }

    public void setF_Name(String f_Name) {
        this.f_Name = f_Name;
    }

    public String getL_Name() {
        return l_Name;
    }

    public void setL_Name(String l_Name) {
        this.l_Name = l_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}