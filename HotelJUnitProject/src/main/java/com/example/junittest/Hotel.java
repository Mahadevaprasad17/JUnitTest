package com.example.junittest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hid;

    private String hname;
    private String haddress;
    private String fitem;

    public Hotel(String hname, String haddress, String fitem) {
        this.hname = hname;
        this.haddress = haddress;
        this.fitem = fitem;
    }

    public Hotel() {
        // Default constructor
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress;
    }

    public String getFitem() {
        return fitem;
    }

    public void setFitem(String fitem) {
        this.fitem = fitem;
    }
}
