/* 
Shape.java
Author: Anika Krieger
Project Name: Particle Engine 2
Date: September 24
Description: Parent class
*/

package com.PEIII;

import com.particleengine2.Square;
import com.particleengine2.Triangle;

import processing.core.PApplet;

public abstract class Shape {
    PApplet main;
    float x, y; // location of the shape
    float xVel; // horizontal velocity
    float yVel; // vertical velocity
    int color; // color of the shape

    Shape(float x_, float y_, PApplet main_, int c, float xVel_, float yVel_) {
        this.x = x_;
        this.y = y_;
        this.main = main_;
        this.color = c; // Ensure color is initialized
        this.xVel = xVel_;
        this.yVel = yVel_;
    }

    abstract void draw(); // Abstract method for drawing the shape
    abstract void move(); // Abstract method for moving the shape
    abstract void scatter(float clickX, float clickY); // Abstract method for scattering
    abstract boolean isClicked(float mouseX, float mouseY); // Abstract method for click detection
    abstract void mouseClickedBehavior(); // Abstract method for mouse click behavior
    abstract void keyPressedBehavior(); // Abstract method for key press behavior
    abstract float getSize(); // Abstract method to get size
    abstract void setSize(float newSize); // Abstract method to set size
    abstract void reset(float x_, float y_, float xVel_, float yVel_); // Abstract method to reset

    void checkBounds() {
        if (x < 0 || x > main.width) {
            xVel *= -1;
        }
        if (y < 0 || y > main.height) {
            yVel *= -1;
        }
    }

    void setColor(int newColor) {
        this.color = newColor;
    }

    void changeCircleColors(int newColor) {
        if (this instanceof Circle) {
            setColor(newColor);
        }
    }

    void changeTriangleColors(int newColor) {
        if (this instanceof Triangle) {
            setColor(newColor);
        }
    }

    void changeSquareColors(int newColor) {
        if (this instanceof Square) {
            setColor(newColor);
        }
    }
}
