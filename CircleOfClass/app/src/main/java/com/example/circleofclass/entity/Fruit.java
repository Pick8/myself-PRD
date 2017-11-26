package com.example.circleofclass.entity;

import java.io.Serializable;

/**
 * Created by 佩强 on 2017/11/13.
 */

public class Fruit implements Serializable {
    private String name;
    private int fruitId;
    private int imageId;
    private int imageId1;
    private int imageId2;
    private int imageId3;
    private int imageId4;
    private String text;
//    private int

    public Fruit(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }

}
