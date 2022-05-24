/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.products.physics.engine.impl;

import com.blazartech.products.physics.engine.Body;
import com.blazartech.products.physics.engine.Force;
import com.blazartech.products.physics.engine.Vector2D;

/**
 *
 * @author aar1069
 */
public class SimpleForce2 implements Force {

    public static double ACCELERATION_X = -100;
    public static double ACCELERATION_Y = 0;
    
    @Override
    public Vector2D calculateAcceleration(Body body, long dt) {
        
        return new Vector2D(ACCELERATION_X, ACCELERATION_Y);
    }
    
}
