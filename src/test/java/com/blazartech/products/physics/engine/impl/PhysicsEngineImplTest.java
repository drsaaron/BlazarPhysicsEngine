/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.products.physics.engine.impl;

import com.blazartech.products.physics.engine.Body;
import com.blazartech.products.physics.engine.Force;
import com.blazartech.products.physics.engine.Vector2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author AAR1069
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
    PhysicsEngineImplTest.PhysicsEngineImplTestConfiguration.class
})
public class PhysicsEngineImplTest {
    
    private static final Logger logger = LoggerFactory.getLogger(PhysicsEngineImplTest.class);
    
    @Configuration
    public static class PhysicsEngineImplTestConfiguration {
        
        @Bean
        public PhysicsEngineImpl getPhysicsEngineImpl() {
            return new PhysicsEngineImpl();
        }
        
        @Bean
        public UpdatePositionPAB getUpdatePositionPAB() {
            return new UpdatePositionPABImpl();
        }
    }
    
    @Autowired
    private PhysicsEngineImpl impl;
    
    public PhysicsEngineImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of stepEngine method, of class PhysicsEngineImpl.
     */
    @Test
    public void testStepEngine() {
        logger.info("stepEngine");
        
        long dt = 1L;
        
        Body body = new SimpleBody();
        Force force = new SimpleForce();
        
        impl.removeAllBodies();
        impl.addBody(body);
        impl.removeAllForces();
        impl.addForce(force);
        
        impl.stepEngine(dt);

        Vector2D velocity = body.getState().getVelocity();
        assertEquals(SimpleBody.INITIAL_VX + SimpleForce.ACCELERATION_X * dt / 1000, velocity.getX(), 0.1);
        assertEquals(SimpleBody.INITIAL_VY + SimpleForce.ACCELERATION_Y * dt / 1000, velocity.getY(), 0.1);
        
        Vector2D position = body.getState().getPosition();
        assertEquals(SimpleBody.INITIAL_X + (SimpleBody.INITIAL_VX + SimpleForce.ACCELERATION_X * dt / 1000) * dt, position.getX(), 0.1);
        assertEquals(SimpleBody.INITIAL_Y + (SimpleBody.INITIAL_VY + SimpleForce.ACCELERATION_Y * dt / 1000) * dt, position.getY(), 0.1);
    }

    /**
     * Test of addBody method, of class PhysicsEngineImpl.
     */
    @Test
    public void testAddBody() {
        logger.info("addBody");
        Body body = new SimpleBody();
        
        impl.removeAllBodies();
        impl.addBody(body);
        
        assertEquals(1, impl.getBodies().size());
    }

    /**
     * Test of removeBody method, of class PhysicsEngineImpl.
     */
    @Test
    public void testRemoveBody() {
        logger.info("removeBody");
        
        Body body1 = new SimpleBody();
        Body body2 = new SimpleBody();
        
        impl.removeAllBodies();
        impl.addBody(body1);
        impl.addBody(body2);
        
        assertEquals(2, impl.getBodies().size());
        
        impl.removeBody(body1);
        assertEquals(1, impl.getBodies().size());

        Body b = impl.getBodies().iterator().next();
        assertEquals(body2, b);
    }

    @Test
    public void testAddForce() {
        logger.info("testAddForce");
        
        Force force = new SimpleForce();
        
        impl.removeAllForces();
        impl.addForce(force);
        
        assertEquals(1, impl.getForces().size());
    }
    
    /**
     * Test of removeForce method, of class PhysicsEngineImpl.
     */
    @Test
    public void testRemoveForce() {
        logger.info("removeForce");
        
        Force force1 = new SimpleForce();
        Force force2 = new SimpleForce();
        
        impl.removeAllForces();
        impl.addForce(force1);
        impl.addForce(force2);
        
        assertEquals(2, impl.getForces().size());

        impl.removeForce(force1);
        
        assertEquals(1, impl.getForces().size());
        
        Force f = impl.getForces().iterator().next();
        assertEquals(force2, f);
    }

    
    
}
