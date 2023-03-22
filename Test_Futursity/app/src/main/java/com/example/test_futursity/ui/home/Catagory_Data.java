package com.example.test_futursity.ui.home;

import android.content.Context;

public class Catagory_Data {

    private String title;
    private String no_of_cources;
    private String image;

    private String code;
    private Context context;

    public Catagory_Data() {
    }

    public Catagory_Data(String title, String no_of_cources, String image, String code, Context context) {
        this.title = title;
        this.no_of_cources = no_of_cources;
        this.image = image;
        this.code = code;
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNo_of_cources() {
        return no_of_cources;
    }

    public void setNo_of_cources(String no_of_cources) {
        this.no_of_cources = no_of_cources;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
