package com.dh.mediaplayer.bean;

import java.util.Date;

/**
 * Created by DH on 5/13/2015.
 */
public class CategoryBean {
    private int categoriesId;
    private String categoriesName;
    private String description;


    public CategoryBean() {
    }

    public CategoryBean(int categoriesId, String categoriesName, String description) {
        this.categoriesId = categoriesId;
        this.categoriesName = categoriesName;
        this.description = description;
    }

    public int getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(int categoriesId) {
        this.categoriesId = categoriesId;
    }

    public String getCategoriesName() {
        return categoriesName;
    }

    public void setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
