/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.products.physics.engine.impl;

import com.blazartech.products.physics.engine.Body;
import com.blazartech.products.physics.engine.Force;
import com.blazartech.products.physics.engine.event.PhysicsEngineBodyListener;
import com.blazartech.products.physics.engine.event.PhysicsEngineForceListener;
import java.util.Collection;
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
        System.out.println("stepEngine");
        long dt = 0L;
        PhysicsEngineImpl instance = new PhysicsEngineImpl();
        instance.stepEngine(dt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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

    /**
     * Test of addBodyListener method, of class PhysicsEngineImpl.
     */
    @Test
    public void testAddBodyListener() {
        System.out.println("addBodyListener");
        PhysicsEngineBodyListener listener = null;
        PhysicsEngineImpl instance = new PhysicsEngineImpl();
        instance.addBodyListener(listener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeBodyListener method, of class PhysicsEngineImpl.
     */
    @Test
    public void testRemoveBodyListener() {
        System.out.println("removeBodyListener");
        PhysicsEngineBodyListener listener = null;
        PhysicsEngineImpl instance = new PhysicsEngineImpl();
        instance.removeBodyListener(listener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addForce method, of class PhysicsEngineImpl.
     */
    @Test
    public void testAddForce() {
        System.out.println("addForce");
        Force force = null;
        PhysicsEngineImpl instance = new PhysicsEngineImpl();
        instance.addForce(force);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeForce method, of class PhysicsEngineImpl.
     */
    @Test
    public void testRemoveForce() {
        System.out.println("removeForce");
        Force force = null;
        PhysicsEngineImpl instance = new PhysicsEngineImpl();
        instance.removeForce(force);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addForceListener method, of class PhysicsEngineImpl.
     */
    @Test
    public void testAddForceListener() {
        System.out.println("addForceListener");
        PhysicsEngineForceListener listener = null;
        PhysicsEngineImpl instance = new PhysicsEngineImpl();
        instance.addForceListener(listener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeForceListener method, of class PhysicsEngineImpl.
     */
    @Test
    public void testRemoveForceListener() {
        System.out.println("removeForceListener");
        PhysicsEngineForceListener listener = null;
        PhysicsEngineImpl instance = new PhysicsEngineImpl();
        instance.removeForceListener(listener);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAllBodies method, of class PhysicsEngineImpl.
     */
    @Test
    public void testRemoveAllBodies() {
        System.out.println("removeAllBodies");
        PhysicsEngineImpl instance = new PhysicsEngineImpl();
        instance.removeAllBodies();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAllForces method, of class PhysicsEngineImpl.
     */
    @Test
    public void testRemoveAllForces() {
        System.out.println("removeAllForces");
        PhysicsEngineImpl instance = new PhysicsEngineImpl();
        instance.removeAllForces();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBodies method, of class PhysicsEngineImpl.
     */
    @Test
    public void testGetBodies() {
        System.out.println("getBodies");
        PhysicsEngineImpl instance = new PhysicsEngineImpl();
        Collection<Body> expResult = null;
        Collection<Body> result = instance.getBodies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getForces method, of class PhysicsEngineImpl.
     */
    @Test
    public void testGetForces() {
        System.out.println("getForces");
        PhysicsEngineImpl instance = new PhysicsEngineImpl();
        Collection<Force> expResult = null;
        Collection<Force> result = instance.getForces();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
