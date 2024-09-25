/* 
Main.java
Author: Anika Krieger
Project Name: Particle Engine 3
Date: September 24
Description: Main program for the Particle Engine III
*/

package com.PEIII;

import processing.core.PApplet;
import java.util.ArrayList;

public class Main extends PApplet {
    ArrayList<Shape> shapes = new ArrayList<Shape>();

    public static void main(String[] args) {
        PApplet.main("com.particleengineREAL2.Main");
    }

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        shapes.add(new Circle(100, 100, 30, this, color(255, 0, 0), 2, 2));
        shapes.add(new Square(200, 200, 50, this, color(0, 255, 0), -2, 2));
        shapes.add(new Triangle(300, 300, 40, this, color(0, 0, 255), 2, -2));
    }

    public void draw() {
        background(255);
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public void mousePressed() {
        for (Shape shape : shapes) {
            if (shape.isClicked(mouseX, mouseY)) {
                shape.scatter(mouseX, mouseY); // Scatter on mouse press
            }
        }
    }

    public void mouseClicked() {
        for (Shape shape : shapes) {
            if (shape.isClicked(mouseX, mouseY)) {
                shape.mouseClickedBehavior(); // Resize on mouse click
            }
        }
    }

    public void keyPressed() {
        for (Shape shape : shapes) {
            shape.keyPressedBehavior(); // Call key press behavior for all shapes
        }
    }

    public void changeCircleColors(int newColor) {
        for (Shape shape : shapes) {
            shape.changeCircleColors(newColor);
        }
    }

    public void changeTriangleColors(int newColor) {
        for (Shape shape : shapes) {
            shape.changeTriangleColors(newColor);
        }
    }

    public void changeSquareColors(int newColor) {
        for (Shape shape : shapes) {
            shape.changeSquareColors(newColor);
        }
    }
}
