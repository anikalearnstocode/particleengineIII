/* 
Square.java
Author: Anika Krieger
Project Name: Particle Engine 3
Date: September 24
Description: Square - sets up square particle and movement
*/

package com.PEIII;

import processing.core.PApplet;

public class Square extends Shape {
    float size; // size of the square

    Square(float x_, float y_, float size_, PApplet main_, int c, float xVel_, float yVel_) {
        super(x_, y_, main_, c, xVel_, yVel_);
        this.size = size_;
    }

    void draw() {
        main.fill(color);
        main.rectMode(PApplet.CENTER);
        main.rect(x, y, size, size);
        move();
    }

    @Override
    void move() {
        x += xVel;
        y += yVel;
        checkBounds();
    }

    @Override
    void scatter(float clickX, float clickY) {
        xVel = (x - clickX) * 0.022f; // set horizontal velocity based on click distance
        yVel = (y - clickY) * 0.022f; // set vertical velocity based on click distance
    }

    @Override
    boolean isClicked(float mx, float my) {
        return mx >= x - size / 2 && mx <= x + size / 2 && my >= y - size / 2 && my <= y + size / 2;
    }

    @Override
    float getSize() {
        return size;
    }

    @Override
    void setSize(float newSize) {
        this.size = newSize;
    }

    @Override
    public void mouseClickedBehavior() {
        setSize(getSize() - 5); // Decrease size on mouse click
    }

    @Override
    public void keyPressedBehavior() {
        if (main.key == 'r') { // Change color to red
            setColor(main.color(255, 0, 0));
        } else if (main.key == 'g') { // Change to green
            setColor(main.color(0, 255, 0));
        } else if (main.key == 'b') { // Change to blue
            setColor(main.color(0, 0, 255));
        }
    }

    @Override
    public void reset(float x_, float y_, float xVel_, float yVel_) {
        this.x = x_;
        this.y = y_;
        this.xVel = xVel_;
        this.yVel = yVel_;
    }
}
