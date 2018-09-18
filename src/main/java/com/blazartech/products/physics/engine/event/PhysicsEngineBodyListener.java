/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blazartech.products.physics.engine.event;

import java.util.EventListener;

/**
 *
 * @author AAR1069
 * @version $Id$
 */

/*
$Log$
********************************************************************************/

public interface PhysicsEngineBodyListener extends EventListener {

    /**
     * a body is added to the engine
     * @param event
     */
    public void bodyAdded(PhysicsEngineBodyEvent event);

    /**
     * a body is removed from the engine.
     * @param event
     */
    public void bodyDeleted(PhysicsEngineBodyEvent event);
}
