/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blazartech.products.physics.engine.impl;

import com.blazartech.products.physics.engine.Body;
import com.blazartech.products.physics.engine.Force;
import com.blazartech.products.physics.engine.PhysicsEngine;
import com.blazartech.products.physics.engine.Vector2D;
import com.blazartech.products.physics.engine.event.PhysicsEngineBodyEvent;
import com.blazartech.products.physics.engine.event.PhysicsEngineBodyListener;
import com.blazartech.products.physics.engine.event.PhysicsEngineForceEvent;
import com.blazartech.products.physics.engine.event.PhysicsEngineForceListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author AAR1069
 * @version $Id$
 */

/*
$Log$
********************************************************************************/

public class PhysicsEngineImpl implements PhysicsEngine {

    public void stepEngine(long dt) {
        // iterate over each body and accumulate the forces on that body.
        for (Body body : bodyList) {
            Vector2D accumulatedForce = new Vector2D(0, 0);

            for (Force force : forceList) {
                Vector2D appliedForce = force.calculateAcceleration(body, dt);
                accumulatedForce = accumulatedForce.add(appliedForce);
            }

            // update the velocity based on the acceleration.
            Vector2D velocity = body.getState().getVelocity();
            velocity = velocity.add(accumulatedForce.multiply(dt/1000.f));
            body.getState().setVelocity(velocity);

            // update the position based on the velocity.
            Vector2D position = body.getState().getPosition();
            position = position.add(velocity.multiply(dt/1000.f));
            body.getState().setPosition(position);
        }
    }

    private List<Body> bodyList = new ArrayList<Body>();

    private void fireBodyAddedEvent(Body body) {
        for (PhysicsEngineBodyListener l : bodyListeners) {
            PhysicsEngineBodyEvent event = new PhysicsEngineBodyEvent(this, body);
            l.bodyAdded(event);
        }
    }

    private void fireBodyRemovedEvent(Body body) {
        for (PhysicsEngineBodyListener l : bodyListeners) {
            PhysicsEngineBodyEvent event = new PhysicsEngineBodyEvent(this, body);
            l.bodyDeleted(event);
        }
    }

    public void addBody(Body body) {
        bodyList.add(body);
        fireBodyAddedEvent(body);
    }

    public void removeBody(Body body) {
        bodyList.remove(body);
        fireBodyRemovedEvent(body);
    }

    private List<PhysicsEngineBodyListener> bodyListeners = new ArrayList<PhysicsEngineBodyListener>();

    public void addBodyListener(PhysicsEngineBodyListener listener) {
        bodyListeners.add(listener);
    }

    public void removeBodyListener(PhysicsEngineBodyListener listener) {
        bodyListeners.remove(listener);
    }

    private List<Force> forceList = new ArrayList<Force>();

    private void fireForceAddedEvent(Force f) {
        for (PhysicsEngineForceListener l : forceListeners) {
            PhysicsEngineForceEvent event = new PhysicsEngineForceEvent(this, f);
            l.forceAdded(event);
        }
    }

    private void fireForceDeletedEvent(Force f) {
        for (PhysicsEngineForceListener l : forceListeners) {
            PhysicsEngineForceEvent event = new PhysicsEngineForceEvent(this, f);
            l.forceRemoved(event);
        }
    }

    public void addForce(Force force) {
        forceList.add(force);
        fireForceAddedEvent(force);
    }

    public void removeForce(Force force) {
        forceList.remove(force);
        fireForceDeletedEvent(force);
    }

    private List<PhysicsEngineForceListener> forceListeners = new ArrayList<PhysicsEngineForceListener>();

    public void addForceListener(PhysicsEngineForceListener listener) {
        forceListeners.add(listener);
    }

    public void removeForceListener(PhysicsEngineForceListener listener) {
        forceListeners.remove(listener);
    }

    public void removeAllBodies() {
        bodyList.clear();
        fireBodyRemovedEvent(null);
    }

    public void removeAllForces() {
        forceList.clear();
        fireForceDeletedEvent(null);
    }

    public Collection<Body> getBodies() {
        return bodyList;
    }

    public Collection<Force> getForces() {
        return forceList;
    }


}
