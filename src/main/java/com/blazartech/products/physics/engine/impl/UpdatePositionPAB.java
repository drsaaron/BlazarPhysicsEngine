/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.products.physics.engine.impl;

import com.blazartech.products.physics.engine.Body;
import com.blazartech.products.physics.engine.Force;
import java.util.Collection;

/**
 *
 * @author AAR1069
 */
public interface UpdatePositionPAB {
    
    void updatePosition(Body body, Collection<Force> forces, long dt);
}
