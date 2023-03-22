package com.example.test_futursity.ui.home;

import android.content.Context;

public class Course_Data {

    private String title;
    private String price;

    private String image;

    private Context context;

    public Course_Data() {
    }

    public Course_Data(String title, String price, String image, Context context) {
        this.title = title;
        this.price = price;
        this.image = image;
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
