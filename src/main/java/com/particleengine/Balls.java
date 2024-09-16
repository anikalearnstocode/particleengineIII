/* 
Main.java
Author: Anika Krieger
Project Name: Particle Engine
Date: September 10
Description: Balls class - contains commands for all balls
*/

package com.particleengine;

import java.util.ArrayList;
import processing.core.*;

public class Balls 
{
    PApplet main;
    ArrayList<Ball> balls;

    int ballCount = 600; // total number of balls
    float ballRadius = 15; // uniform size for all balls
    int backgroundColor = 255; // set background color to white

    Balls(PApplet main_) 
    {
        main = main_; // initialize Balls object
        balls = new ArrayList<Ball>(); // initialize ArrayList to store balls
        setup(); // ensure setup is called to initialize the balls
    }

    void setup() 
    {
        main.background(backgroundColor); // set background to default established above
        create(); // call create to create and set up balls
    }

    void create() 
    {
        balls.clear(); // clear balls list before initializing

        // create 700 balls
        for (int i = 0; i < ballCount; i++) 
        {
            float x = main.random(main.width); // assign initial position inside windown boundaries
            float y = main.random(main.height);

            int color = main.color(0, 0, 0); // give all balls color black 

            float xVel = main.random(-2, 2); // randomize velocity for each ball
            float yVel = main.random(-2, 2);

            balls.add(new Ball(x, y, ballRadius, main, color, xVel, yVel)); // create new Ball object and add to list
        }
    }

    void draw() 
    {
        main.background(backgroundColor); // set background color before drawing each frame
        main.noStroke(); // no outline for balls

        for (Ball ball : balls) // draw the balls!
        {
            ball.draw();
        }

        
    }

    void mousePressed() 
    {
        
        for (Ball ball : balls) // check if a ball is clicked when mouse is pressed
        {
            if (ball.isClicked(main.mouseX, main.mouseY)) 
            {
                backgroundColor = ball.ballColor; // if ball is clicked, update background color
                break; // exit the loop once ball is found
            }
        }
    }

    void keyPressed() 
    {
        // check if the "B" / "b" key is pressed
        if (main.key == 'b' || main.key == 'B') 
        {
            blueGradient(); // if so, apply blue gradient to all balls
        }

        // check if the "P" / "p" key is pressed
        if (main.key == 'p' || main.key == 'P') 
        {
            pinkGradient(); // if so, apply pink gradient to all balls
        }
    }

    void blueGradient() 
    {
        // if b/B is pressed, make all balls fall within the following color range
        for (Ball ball : balls) 
        {
            int r = (int)main.random(0, 205); // red value range
            int g = (int)main.random(136, 236); // green value range
            int b = (int)main.random(255); // blue value

            int color = main.color(r, g, b); // create color using RGB values
            ball.setColor(color); // set new ball color
        }
    }

    void pinkGradient() 
    {
        // if p/P is pressed, make all balls fall within the following color range
        for (Ball ball : balls) 
        {
            int r = (int)main.random(255); // red val range
            int g = (int)main.random(60, 225); // green val range
            int b = (int)main.random(250, 255); // blue val range

            int color = main.color(r, g, b); // create color from RGB
            ball.setColor(color); // set new ball color
        }
    }
}
