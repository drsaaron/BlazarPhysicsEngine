/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blazartech.products.physics.engine;

import com.blazartech.products.physics.engine.event.PhysicsEngineBodyListener;
import com.blazartech.products.physics.engine.event.PhysicsEngineForceListener;
import java.util.Collection;

/**
 *
 * @author AAR1069
 * @version $Id$
 */

/*
$Log$
********************************************************************************/

public interface PhysicsEngine {

    /**
     * apply a single step in the engine.
     * @param dt delta time in milliseconds
     */
    public void stepEngine(long dt);

    /**
     * add a body to the engine
     * @param body the body to add
     */
    public void addBody(Body body);

    public void removeBody(Body body);

    public void removeAllBodies();

    public Collection<Body> getBodies();

    /**
     * add a listener for body-related events.
     * @param listener
     */
    public void addBodyListener(PhysicsEngineBodyListener listener);

    /**
     * remove a listener for body-related events.
     * @param listener
     */
    public void removeBodyListener(PhysicsEngineBodyListener listener);

    public void addForce(Force force);

    public void removeForce(Force force);

    public void removeAllForces();

    public Collection<Force> getForces();

    public void addForceListener(PhysicsEngineForceListener listener);

    public void removeForceListener(PhysicsEngineForceListener listener);
}
