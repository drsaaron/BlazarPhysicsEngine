/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blazartech.products.physics.engine.impl;

import com.blazartech.products.physics.engine.Body;
import com.blazartech.products.physics.engine.State;
import com.blazartech.products.physics.engine.Vector2D;

/**
 *
 * @author AAR1069
 * @version $Id$
 */

/*
$Log$
********************************************************************************/

public class SimpleBody implements Body {

    public static final double MASS = 1000;
    public static final double INITIAL_X = 100;
    public static final double INITIAL_Y = 100;
    public static final double INITIAL_VX = 0;
    public static final double INITIAL_VY = 0;
    
    private State state;

    SimpleBody() {
        state = new State();
        
        state.setMass(MASS);
        state.setPosition(new Vector2D(INITIAL_X, INITIAL_Y));
        state.setVelocity(new Vector2D(INITIAL_VX, INITIAL_VY));
    }
    
    /**
     * Get the value of state
     *
     * @return the value of state
     */
    public State getState() {
        return state;
    }

    /**
     * Set the value of state
     *
     * @param state new value of state
     */
    public void setState(State state) {
        this.state = state;
    }

}
