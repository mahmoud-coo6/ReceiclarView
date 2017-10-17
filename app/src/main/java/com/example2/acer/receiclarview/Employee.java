package com.example2.acer.receiclarview;

/**
 * Created by ACER on 13/07/17.
 */

public class Employee {
    private String name;
    private int age;
    private int imageId;

    public Employee(){}

    public Employee(String name,int age,int imageId){
        this.name=name;
        this.age=age;
        this.imageId=imageId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
