/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blazartech.products.physics.engine.event;

import com.blazartech.products.physics.engine.*;

/**
 *
 * @author AAR1069
 * @version $Id$
 */

/*
$Log$
********************************************************************************/

public class PhysicsEngineBodyEvent extends PhysicsEngineEvent {

    private Body body;

    /**
     * Get the value of body
     *
     * @return the value of body
     */
    public Body getBody() {
        return body;
    }

    public PhysicsEngineBodyEvent(PhysicsEngine engine, Body body) {
        super(engine);
        this.body = body;
    }
}
