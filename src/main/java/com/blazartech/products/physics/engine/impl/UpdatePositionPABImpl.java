/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.products.physics.engine.impl;

import com.blazartech.products.physics.engine.Body;
import com.blazartech.products.physics.engine.Force;
import com.blazartech.products.physics.engine.Vector2D;
import java.util.Collection;
import java.util.concurrent.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

/**
 *
 * @author AAR1069
 */
@Service
public class UpdatePositionPABImpl implements UpdatePositionPAB {

    private static final Logger logger = LoggerFactory.getLogger(UpdatePositionPABImpl.class);
    
    @Override
    public Future<Void> updatePosition(Body body, Collection<Force> forces, long dt) {
        Vector2D accumulatedAcceleration = new Vector2D(0, 0);

        logger.info("applying forces to body " + body);
        for (Force force : forces) {
            Vector2D acceleration = force.calculateAcceleration(body, dt);
            accumulatedAcceleration = accumulatedAcceleration.add(acceleration);
        }

        // update the velocity based on the acceleration.
        logger.info("updating velocity");
        Vector2D velocity = body.getState().getVelocity();
        velocity = velocity.add(accumulatedAcceleration.multiply(dt / 1000.f));
        body.getState().setVelocity(velocity);

        // update the position based on the velocity.
        logger.info("updating position");
        Vector2D position = body.getState().getPosition();
        position = position.add(velocity.multiply(dt / 1000.f));
        body.getState().setPosition(position);
        
        // done
        return new AsyncResult<>(null);
    }

}
