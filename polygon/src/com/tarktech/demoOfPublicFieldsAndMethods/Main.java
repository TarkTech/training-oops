package com.tarktech.demoOfPublicFieldsAndMethods;

import com.tarktech.demoOfPublicFieldsAndMethods.domain.Rectangle;
import com.tarktech.demoOfPublicFieldsAndMethods.domain.Square;
import com.tarktech.demoOfPublicFieldsAndMethods.domain.Triangle;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.length = 10;
        rectangle.breath = 20;
        rectangle.area();

        Triangle triangle = new Triangle();
        triangle.base = 10;
        triangle.height = 20;
        triangle.area();

        Square square = new Square();
        square.side = 10;
        square.area();
    }
}
