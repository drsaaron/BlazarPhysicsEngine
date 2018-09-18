/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blazartech.products.physics.engine.event;

import com.blazartech.products.physics.engine.Force;
import com.blazartech.products.physics.engine.PhysicsEngine;

/**
 *
 * @author AAR1069
 * @version $Id$
 */

/*
$Log$
********************************************************************************/

public class PhysicsEngineForceEvent extends PhysicsEngineEvent {

    private final Force force;

    /**
     * Get the value of force
     *
     * @return the value of force
     */
    public Force getForce() {
        return force;
    }

    public PhysicsEngineForceEvent(PhysicsEngine engine, Force force) {
        super(engine);
        this.force = force;
    }
}
