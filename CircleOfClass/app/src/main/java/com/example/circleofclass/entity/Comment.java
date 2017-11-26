package com.example.circleofclass.entity;

import java.io.Serializable;

/**
 * Created by 佩强 on 2017/11/19.
 */

public class Comment implements Serializable{
    private int imageId;
    private String text;
    private int fruitId;
    private String name;

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getText() {
        return text;
    }

    public Comment(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }

}
