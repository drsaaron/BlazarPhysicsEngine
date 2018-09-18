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

public interface PhysicsEngineForceListener extends EventListener {

    public void forceAdded(PhysicsEngineForceEvent event);

    public void forceRemoved(PhysicsEngineForceEvent event);
}
