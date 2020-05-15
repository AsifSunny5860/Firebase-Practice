package com.example.myproject;

public class House {
    private String name;
    private String mobilenumber,id,address,branches,capacity;
    int logo;



    public House(String name, String mobilenumber, int logo,String id,String address,String branches,String capacity) {
        this.name = name;
        this.mobilenumber = mobilenumber;
        this.logo = logo;
        this.address=address;
        this.branches=branches;
        this.capacity=capacity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBranches() {
        return branches;
    }

    public void setBranches(String branches) {
        this.branches = branches;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public int getLogo() {
        return logo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
