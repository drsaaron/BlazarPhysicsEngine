/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.products.physics.engine.timer;

import com.blazartech.products.physics.engine.PhysicsEngine;
import java.beans.PropertyChangeListener;

/**
 *
 * @author AAR1069
 */
public interface PhysicsTimer {

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    void addPropertyChangeListener(PropertyChangeListener listener);

    /**
     * Get the value of state
     *
     * @return the value of state
     */
    TimerState getState();

    void pauseEngine();

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    void removePropertyChangeListener(PropertyChangeListener listener);

    /**
     * Set the value of state
     *
     * @param state new value of state
     */
    void setState(TimerState state);

    /**
     *
     * @param engine
     * @param timeInterval how often to run the engine in milliseconds
     * @param maxIterations
     */
    void startEngine(PhysicsEngine engine, long timeInterval, int maxIterations);

    void stopEngine();
    
}
