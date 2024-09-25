/* 
Triangle.java
Author: Anika Krieger
Project Name: Particle Engine 3
Date: September 24
Description: Triangle - sets up triangular particle and movement
*/

package com.PEIII;

import processing.core.PApplet;

public class Triangle extends Shape {
    float size; // size of the triangle

    Triangle(float x_, float y_, float size_, PApplet main_, int c, float xVel_, float yVel_) {
        super(x_, y_, main_, c, xVel_, yVel_);
        this.size = size_;
    }

    void draw() {
        main.fill(color);
        main.pushMatrix();
        main.translate(x, y);
        main.triangle(-size / 2, size / 2, size / 2, size / 2, 0, -size / 2);
        main.popMatrix();
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
        float dx = x - clickX;
        float dy = y - clickY;
        float distance = PApplet.dist(x, y, clickX, clickY);
        if (distance > 0) {
            xVel = dx / distance * 5;
            yVel = dy / distance * 5;
        }
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
        setSize(getSize() + 5); // Increase size on mouse click
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
