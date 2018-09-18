/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.products.physics.engine;

import java.beans.PropertyChangeListener;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author AAR1069
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
    Vector2DTest.Vector2DTestConfiguration.class
})
public class Vector2DTest {

    private static final Logger logger = LoggerFactory.getLogger(Vector2DTest.class);

    @Configuration
    static class Vector2DTestConfiguration {

    }

    public Vector2DTest() {
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
     * Test of add method, of class Vector2D.
     */
    @Test
    public void testAdd() {
        logger.info("add");

        Vector2D expResult = new Vector2D(25, 160);

        Vector2D result = v1.add(v2);

        assertEquals(expResult.getX(), result.getX(), 0.1);
        assertEquals(expResult.getY(), result.getY(), 0.1);
    }

    /**
     * Test of subtract method, of class Vector2D.
     */
    @Test
    public void testSubtract() {
        logger.info("subtract");

        Vector2D expResult = new Vector2D(-5, -140);

        Vector2D result = v1.subtract(v2);

        assertEquals(expResult.getX(), result.getX(), 0.1);
        assertEquals(expResult.getY(), result.getY(), 0.1);
    }

    /**
     * Test of multiply method, of class Vector2D.
     */
    @Test
    public void testMultiply() {
        logger.info("multiply");

        double factor = 3;

        Vector2D expResult = new Vector2D(45, 450);

        Vector2D result = v2.multiply(factor);

        assertEquals(expResult.getX(), result.getX(), 0.1);
        assertEquals(expResult.getY(), result.getY(), 0.1);
    }

    final Vector2D v1 = new Vector2D(10, 10);
    final Vector2D v2 = new Vector2D(15, 150);

    /**
     * Test of size method, of class Vector2D.
     */
    @Test
    public void testSize() {
        logger.info("size");

        double expResult = Math.sqrt(200);

        double result = v1.size();

        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of dot method, of class Vector2D.
     */
    @Test
    public void testDot() {
        logger.info("dot");

        double expResult = v1.getX() * v2.getX() + v1.getY() * v2.getY();

        double result = v1.dot(v2);
        
        assertEquals(expResult, result, 0.0);
    }

}
