package com.electronicbill.models;

import java.io.Serializable;
import java.util.List;

public class CategoryModel implements Serializable {
    private int image_resource;
    private String title;
    private boolean isSelected = false;
    private  List<CategoryDataModel> categoryDataModelList;

    public CategoryModel(int image_resource, String title, List<CategoryDataModel> categoryDataModelList) {
        this.image_resource = image_resource;
        this.title = title;
        this.categoryDataModelList = categoryDataModelList;
    }

    public int getImage_resource() {
        return image_resource;
    }

    public String getTitle() {
        return title;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setImage_resource(int image_resource) {
        this.image_resource = image_resource;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public List<CategoryDataModel> getCategoryDataModelList() {
        return categoryDataModelList;
    }

    public void setCategoryDataModelList(List<CategoryDataModel> categoryDataModelList) {
        this.categoryDataModelList = categoryDataModelList;
    }
}
