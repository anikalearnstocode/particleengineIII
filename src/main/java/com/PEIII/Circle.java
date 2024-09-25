/* 
Circle.java
Author: Anika Krieger
Project Name: Particle Engine 3
Date: September 24
Description: Circle - sets up circular particle and movement
*/

package com.PEIII;

import processing.core.PApplet;

public class Circle extends Shape {
    float radius; // radius of the circle

    Circle(float x_, float y_, float radius_, PApplet main_, int c, float xVel_, float yVel_) {
        super(x_, y_, main_, c, xVel_, yVel_);
        this.radius = radius_;
    }

    void draw() {
        main.fill(color);
        main.ellipse(x, y, radius * 2, radius * 2);
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
    boolean isClicked(float mouseX, float mouseY) {
        return PApplet.dist(mouseX, mouseY, x, y) < radius;
    }

    @Override
    float getSize() {
        return radius * 2; // return diameter
    }

    @Override
    void setSize(float newSize) {
        this.radius = newSize / 2; // update radius based on new size
    }

    @Override
    public void mouseClickedBehavior() {
        setSize(getSize() - 5); // Decrease radius on mouse click
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
