/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.products.physics.engine.timer;

import com.blazartech.products.physics.engine.PhysicsEngine;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.annotation.PreDestroy;
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
public class PhysicsTimerImpl implements PhysicsTimer {

    private TimerState state = TimerState.NotStarted;

    @Override
    public boolean isRunning() {
        return getState() != TimerState.NotStarted && getState() != TimerState.Disposed;
    }

    /**
     * Get the value of state
     *
     * @return the value of state
     */
    @Override
    public TimerState getState() {
        return state;
    }

    /**
     * Set the value of state
     *
     * @param state new value of state
     */
    @Override
    public void setState(TimerState state) {
        TimerState oldState = this.state;
        this.state = state;
        propertyChangeSupport.firePropertyChange("state", oldState, state);
    }
    
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
    private TimerThread timerThread;

    /**
     * 
     * @param engine
     * @param timeInterval how often to run the engine in milliseconds
     * @param maxIterations
     */
    @Override
    public void startEngine(PhysicsEngine engine, long timeInterval, int maxIterations) {
        timerThread = new TimerThread(engine, timeInterval, maxIterations, this);
        setState(TimerState.Normal);
        timerThread.start();
    }

    @Override
    @PreDestroy
    public void stopEngine() {
        timerThread = null;
        setState(TimerState.Disposed);
    }

    @Override
    public void pauseEngine() {
        setState(TimerState.Paused);
    }

}
