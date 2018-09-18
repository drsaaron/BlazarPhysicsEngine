/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blazartech.products.physics.engine.event;

import com.blazartech.products.physics.engine.PhysicsEngine;
import java.util.EventObject;

/**
 * base class for all engine-related events.  For all events, it is assumed
 * the "source" is the engine.
 * @author AAR1069
 * @version $Id$
 */

/*
$Log$
********************************************************************************/

public abstract class PhysicsEngineEvent extends EventObject {

    public PhysicsEngineEvent(PhysicsEngine engine) {
        super(engine);
    }
}
