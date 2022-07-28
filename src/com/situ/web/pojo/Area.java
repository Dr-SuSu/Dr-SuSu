package com.situ.web.pojo;

public class Area {
    private int id;
    private String area;
    private int cityId;

    public Area(int id, String area, int cityId) {
        this.id = id;
        this.area = area;
        this.cityId = cityId;
    }

    public Area() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
