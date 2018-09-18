/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.products.physics.engine.impl;

import com.blazartech.products.physics.engine.Body;
import com.blazartech.products.physics.engine.Force;
import com.blazartech.products.physics.engine.Vector2D;

/**
 *
 * @author AAR1069
 */
public class SimpleForce implements Force {

    public static double ACCELERATION_X = 0;
    public static double ACCELERATION_Y = 10;
    
    @Override
    public Vector2D calculateAcceleration(Body body, long dt) {
        
        return new Vector2D(ACCELERATION_X, ACCELERATION_Y);
    }
    
}
