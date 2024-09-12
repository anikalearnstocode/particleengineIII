/* 
Main.java
Author: Anika Krieger
Project Name: Particle Engine
Date: September 10
Description: a bouncing ball, bounces up and down
*/

package com.particleengine;

import processing.core.*;

public class Ball {
    PApplet main;// the main class - provides all functionality of processing

    float x, y; //location of the ball
    float yVel = 1;

    float radius; //size of ball
    int ballColor;
    float y_direction = 1; //which direction the ball goes, 1 is down, adding & -1 is up, you're subtracting!

    Ball(float x_, float y_, float radius_, PApplet main_, int c)
    {
        x = x_;y = y_;
        radius = radius_;

        main = main_;
        ballColor = c;
        
    }

    void draw()
    {
        main.fill(ballColor);
        main.ellipse(x, y, radius, radius);
        move();
        
    }

    void move()
    {
        y += yVel*y_direction;
        if( y > main.height )
            {
                y_direction = -1;
            }
    }

    void faster()
    {
        yVel++;
    }
}
