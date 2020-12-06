package com.electronicbill.models;

import java.io.Serializable;

public class CategoryDataModel implements Serializable {
    private int image_resource;
    private String name;
    private String date;

    public CategoryDataModel(int image_resource, String name, String date) {
        this.image_resource = image_resource;
        this.name = name;
        this.date = date;
    }

    public int getImage_resource() {
        return image_resource;
    }

    public void setImage_resource(int image_resource) {
        this.image_resource = image_resource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
