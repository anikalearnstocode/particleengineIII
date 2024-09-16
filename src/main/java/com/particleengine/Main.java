/* 
Main.java
Author: Anika Krieger
Project Name: Particle Engine
Date: September 10
Description: Particle Engine Project CRCPIII - Create particle engine with basic physics and some interactivity
*/

package com.particleengine;

import processing.core.PApplet;

public class Main extends PApplet 
{

    Balls balls; // handles balls in simulation

    public static void main(String[] args) 
    {
        PApplet.main("com.particleengine.Main");
    }

    public void settings()
    {
        size(800, 600); // size of window
    }

    public void setup()
    {
        balls = new Balls(this); // create instance of Balls class
        balls.setup(); // call setup to initialize balls
    }

    public void draw()
    {
        background(255); // clear background each frame
        balls.draw(); // draw the balls
    }

    public void keyPressed()
    {
        balls.keyPressed(); // call keyPressed in Balls class when a key is pressed
    }

    public void mousePressed()
    {
        balls.mousePressed(); // call mousePressed in Balls class when mouse is pressed
    }
}
