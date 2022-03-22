package com.tarktech.demoOfPrivateFieldsAndParameterizedConstructor;

import com.tarktech.demoOfPrivateFieldsAndParameterizedConstructor.domain.Rectangle;
import com.tarktech.demoOfPrivateFieldsAndParameterizedConstructor.domain.Square;
import com.tarktech.demoOfPrivateFieldsAndParameterizedConstructor.domain.Triangle;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 20);
        rectangle.area();

        Triangle triangle = new Triangle(10, 20);
        triangle.area();

        Square square = new Square(10);
        square.area();
    }
}
