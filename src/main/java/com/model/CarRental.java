package com.model;

import java.util.Date;

public class CarRental {
    private int id;
    private String carPhoto;
    private String contactWay;
    private String brand;
    private float mileage;
    private int age;
    private float price;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarPhoto() {
        return carPhoto;
    }

    public void setCarPhoto(String carPhoto) {
        this.carPhoto = carPhoto;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public CarRental(int id, String carPhoto, String contactWay, String brand, float mileage, int age, float price) {
        this.id = id;
        this.carPhoto = carPhoto;
        this.contactWay = contactWay;
        this.brand = brand;
        this.mileage = mileage;
        this.age = age;
        this.price = price;
    }
}
