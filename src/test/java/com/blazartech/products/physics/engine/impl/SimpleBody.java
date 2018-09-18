/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blazartech.products.physics.engine.impl;

import com.blazartech.products.physics.engine.Body;
import com.blazartech.products.physics.engine.State;

/**
 *
 * @author AAR1069
 * @version $Id$
 */

/*
$Log$
********************************************************************************/

public class SimpleBody implements Body {

    private State state = new State();

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
