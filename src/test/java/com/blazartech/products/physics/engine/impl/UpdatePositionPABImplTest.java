/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.products.physics.engine.impl;

import com.blazartech.products.physics.engine.Body;
import com.blazartech.products.physics.engine.Force;
import com.blazartech.products.physics.engine.Vector2D;
import java.util.ArrayList;
import java.util.List;
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
    UpdatePositionPABImplTest.UpdatePositionPABImplTestConfiguration.class
})
public class UpdatePositionPABImplTest {
    
    private static Logger logger = LoggerFactory.getLogger(UpdatePositionPABImplTest.class);
    
    @Configuration
    public static class UpdatePositionPABImplTestConfiguration {
        
        @Bean
        public UpdatePositionPABImpl getUpdatePositionPABImpl() {
            return new UpdatePositionPABImpl();
        }
    }
    
    @Autowired
    private UpdatePositionPABImpl impl;
    
    public UpdatePositionPABImplTest() {
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
    
    @Test
    public void testAccumulateAcceleration() {
        logger.info("testAccumulateAcceleration");
        
        long dt = 1L;
        
        Body body = new SimpleBody();
        Force force = new SimpleForce();
        Force force2 = new SimpleForce2();
        
        List<Force> forces = new ArrayList<>();
        forces.add(force);
        forces.add(force2); 
        
        Vector2D acceleration = impl.accumulateAcceleration(body, forces, dt);
        
        assertEquals(SimpleForce.ACCELERATION_X + SimpleForce2.ACCELERATION_X, acceleration.getX(), 0.1);
        assertEquals(SimpleForce.ACCELERATION_Y + SimpleForce2.ACCELERATION_Y, acceleration.getY(), 0.1);
    }

    /**
     * Test of updatePosition method, of class UpdatePositionPABImpl.
     */
    @Test
    public void testUpdatePosition() {
        logger.info("updatePosition");
        
        long dt = 1L;
        
        Body body = new SimpleBody();
        Force force = new SimpleForce();
        
        List<Force> forces = new ArrayList<>();
        forces.add(force);
        
        impl.updatePosition(body, forces, dt);

        Vector2D velocity = body.getState().getVelocity();
        assertEquals(SimpleBody.INITIAL_VX + SimpleForce.ACCELERATION_X * dt / 1000, velocity.getX(), 0.1);
        assertEquals(SimpleBody.INITIAL_VY + SimpleForce.ACCELERATION_Y * dt / 1000, velocity.getY(), 0.1);
        
        Vector2D position = body.getState().getPosition();
        assertEquals(SimpleBody.INITIAL_X + (SimpleBody.INITIAL_VX + SimpleForce.ACCELERATION_X * dt / 1000) * dt, position.getX(), 0.1);
        assertEquals(SimpleBody.INITIAL_Y + (SimpleBody.INITIAL_VY + SimpleForce.ACCELERATION_Y * dt / 1000) * dt, position.getY(), 0.1);

    }
    
}
