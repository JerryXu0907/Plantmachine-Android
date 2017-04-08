package com.example.jerry.application11;

/**
 * Created by jerry on 16/4/7.
 */
public class Plant {
    private String name;
    private String city;
    private String category;
    private int time;

    public Plant(String name,String city,String category, int time){
        this.name = name;
        this.category = category;
        this.city = city;
        this.time = time;
    }

    public String getName(){
        return name;
    }

    public String getCity(){
        return city;
    }

    public String getCategory(){
        return category;
    }

    public int getTime(){
        return time;
    }
}
