package com.example.foodreceipt.model;

public class HomeEntity {
    private int image;
    private String name;
    private int navigation;
    private Class fragment;

    public HomeEntity() {
    }

    public HomeEntity(int image, String name, int navigation, Class fragment) {
        this.image = image;
        this.name = name;
        this.navigation = navigation;
        this.fragment = fragment;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNavigation() {
        return navigation;
    }

    public void setNavigation(int navigation) {
        this.navigation = navigation;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }
}
