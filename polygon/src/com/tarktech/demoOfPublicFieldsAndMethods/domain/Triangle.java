package com.tarktech.demoOfPublicFieldsAndMethods.domain;

public class Triangle {
    public int height;
    public int base;

    public void area(){
        System.out.println("Area of the triangle is " + height * base * 0.5);
    }
}
