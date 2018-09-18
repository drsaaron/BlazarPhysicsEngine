/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blazartech.products.physics.engine;

/**
 * An interface that represents a force rule.  This force will be represented
 * as a vector.
 *
 * @author AAR1069
 * @version $Id$
 */

/*
$Log$
********************************************************************************/

public interface Force {

    /**
     * calculate a body's acceleration due to this force.
     * @param body
     * @param dt
     * @return
     */
    public Vector2D calculateAcceleration(Body body, long dt);
}
