/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blazartech.products.physics.engine.impl;

import com.blazartech.products.physics.engine.Body;
import com.blazartech.products.physics.engine.Force;
import com.blazartech.products.physics.engine.PhysicsEngine;
import com.blazartech.products.physics.engine.event.PhysicsEngineBodyEvent;
import com.blazartech.products.physics.engine.event.PhysicsEngineBodyListener;
import com.blazartech.products.physics.engine.event.PhysicsEngineForceEvent;
import com.blazartech.products.physics.engine.event.PhysicsEngineForceListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AAR1069
 * @version $Id$
 */

/*
$Log$
********************************************************************************/

@Service
public class PhysicsEngineImpl implements PhysicsEngine {

    private static final Logger logger = LoggerFactory.getLogger(PhysicsEngineImpl.class);
    
    @Autowired
    private UpdatePositionPAB updatePositionPAB;
    
    @Override
    public void stepEngine(long dt) {
        // iterate over each body and accumulate the forces on that body.
        List<Future<Void>> futures = bodyList.stream()
                .map(b -> updatePositionPAB.updatePosition(b, forceList, dt))
                .collect(Collectors.toList());
        
        futures.forEach((future) -> {
            try {
                future.get();
            } catch (ExecutionException | InterruptedException e) {
                logger.error("error stepping engine: " + e.getMessage());
            }
        });
    }

    private final List<Body> bodyList = new ArrayList<>();

    private void fireBodyAddedEvent(Body body) {
        bodyListeners.forEach((l) -> {
            PhysicsEngineBodyEvent event = new PhysicsEngineBodyEvent(this, body);
            l.bodyAdded(event);
        });
    }

    private void fireBodyRemovedEvent(Body body) {
        bodyListeners.forEach((l) -> {
            PhysicsEngineBodyEvent event = new PhysicsEngineBodyEvent(this, body);
            l.bodyDeleted(event);
        });
    }

    @Override
    public void addBody(Body body) {
        bodyList.add(body);
        fireBodyAddedEvent(body);
    }

    @Override
    public void removeBody(Body body) {
        bodyList.remove(body);
        fireBodyRemovedEvent(body);
    }

    private final List<PhysicsEngineBodyListener> bodyListeners = new ArrayList<>();

    @Override
    public void addBodyListener(PhysicsEngineBodyListener listener) {
        bodyListeners.add(listener);
    }

    @Override
    public void removeBodyListener(PhysicsEngineBodyListener listener) {
        bodyListeners.remove(listener);
    }

    private final List<Force> forceList = new ArrayList<>();

    private void fireForceAddedEvent(Force f) {
        forceListeners.forEach((l) -> {
            PhysicsEngineForceEvent event = new PhysicsEngineForceEvent(this, f);
            l.forceAdded(event);
        });
    }

    private void fireForceDeletedEvent(Force f) {
        forceListeners.forEach((l) -> {
            PhysicsEngineForceEvent event = new PhysicsEngineForceEvent(this, f);
            l.forceRemoved(event);
        });
    }

    @Override
    public void addForce(Force force) {
        forceList.add(force);
        fireForceAddedEvent(force);
    }

    @Override
    public void removeForce(Force force) {
        forceList.remove(force);
        fireForceDeletedEvent(force);
    }

    private final List<PhysicsEngineForceListener> forceListeners = new ArrayList<>();

    @Override
    public void addForceListener(PhysicsEngineForceListener listener) {
        forceListeners.add(listener);
    }

    @Override
    public void removeForceListener(PhysicsEngineForceListener listener) {
        forceListeners.remove(listener);
    }

    @Override
    public void removeAllBodies() {
        bodyList.clear();
        fireBodyRemovedEvent(null);
    }

    @Override
    public void removeAllForces() {
        forceList.clear();
        fireForceDeletedEvent(null);
    }

    @Override
    public Collection<Body> getBodies() {
        return bodyList;
    }

    @Override
    public Collection<Force> getForces() {
        return forceList;
    }


}
