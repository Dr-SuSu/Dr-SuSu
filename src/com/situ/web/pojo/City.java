package com.situ.web.pojo;

public class City {
    private int id;
    private String city;
    private int provinceId;

    public City() {
    }

    public City(int id, String city, int provinceId) {
        this.id = id;
        this.city = city;
        this.provinceId = provinceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", provinceId='" + provinceId + '\'' +
                '}';
    }
}
