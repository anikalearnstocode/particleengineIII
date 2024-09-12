package com.particleengine;
/* 
Main.java
Author: Anika Krieger
Project Name: Particle Engine
Date: September 10
Description: Particle Engine Project CRCPIII - Create particle engine with basic physics and some interactivity
*/

import processing.core.*;

public class Main extends PApplet {

    Ball ball; //a ball that we will draw to the screen
    
    
    public static void main(String[] args) 
    {
        PApplet.main("com.particleengine.Main");
    }

    public void settings()
    {
        // Change screen size from default
        size(500,500);
    }

    

    public void setup()
    {
        ball = new Ball(width/2.0f, height*.10f, 50.f, this, color(173, 241, 255)); //make everything a float by adding an f at the end
        
    }


    public void draw()
    {
        background(255, 176, 239);

        noStroke();
        ball.draw();
    }

    public void mousePressed()
    {
         ball.faster();
    }
}   

