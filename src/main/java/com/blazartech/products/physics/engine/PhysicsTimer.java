/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.products.physics.engine;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author AAR1069
 * @version $Id$
 */

/*
$Log$
 ********************************************************************************/

public class PhysicsTimer {

    private static final PhysicsTimer _instance = new PhysicsTimer();

    public static PhysicsTimer instance() {
        return _instance;
    }

    private PhysicsTimer() {
    }

    public enum TimerState {

        NotStarted, Paused, Normal, Slow, Fast, Disposed
    };
    
    private TimerState state = TimerState.NotStarted;

    private boolean isRunning() {
        return getState() != TimerState.NotStarted && getState() != TimerState.Disposed;
    }

    /**
     * Get the value of state
     *
     * @return the value of state
     */
    public TimerState getState() {
        return state;
    }

    /**
     * Set the value of state
     *
     * @param state new value of state
     */
    public void setState(TimerState state) {
        TimerState oldState = this.state;
        this.state = state;
        propertyChangeSupport.firePropertyChange("state", oldState, state);
    }
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
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
    public void startEngine(PhysicsEngine engine, long timeInterval, int maxIterations) {
        timerThread = new TimerThread(engine, timeInterval, maxIterations);
        setState(TimerState.Normal);
        timerThread.start();
    }

    public void stopEngine() {
        timerThread = null;
        setState(TimerState.Disposed);
    }

    public void pauseEngine() {
        setState(TimerState.Paused);
    }

    /**
     * a thread that will periodically trigger the engine to update itself.
     * Surely this can be done better, with Timer or something?
     */
    private class TimerThread extends Thread {

        private final PhysicsEngine engine;
        private final long timeInterval;
        private final int maxIterations;

        public TimerThread(PhysicsEngine e, long i, int maxIterations) {
            engine = e;
            timeInterval = i;
            this.maxIterations = maxIterations;
        }

        @Override
        public void run() {
            long lastRun = System.currentTimeMillis();
            long extraDt = 0;
            int iterationCount = 0;

            while (iterationCount < maxIterations) {
                if (isRunning()) {
                    long now = System.currentTimeMillis();
                    long dt = now - lastRun;
                    long currentDt = extraDt + dt;
                    if (currentDt < timeInterval) {
                        setState(TimerState.Fast);
                        long sleepTime = timeInterval - currentDt;
                        try {
                            Thread.sleep(sleepTime);
                        } catch (InterruptedException ex) {
                        }
                    } else {
                        extraDt = currentDt - timeInterval;
                        if (extraDt > timeInterval) {
                            extraDt = timeInterval;
                            setState(TimerState.Slow);
                        } else {
                            setState(TimerState.Normal);
                        }
                        lastRun = now;
                        engine.stepEngine(dt);
                        iterationCount++;
                    }
                } else {
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException ex) {
                    }
                    lastRun = System.currentTimeMillis();
                    extraDt = 0;
                }
            }

            // done
            setState(TimerState.Disposed);
        }
    }
}
