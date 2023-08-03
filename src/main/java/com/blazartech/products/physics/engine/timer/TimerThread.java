/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.products.physics.engine.timer;

import com.blazartech.products.physics.engine.PhysicsEngine;

/**
 * a thread that will periodically trigger the engine to update itself.
 * Surely this can be done better, with Timer or something?
 */
class TimerThread extends Thread {

    private final PhysicsEngine engine;
    private final long timeInterval;
    private final int maxIterations;
    private final PhysicsTimer timer;

    public TimerThread(PhysicsEngine e, long i, int maxIterations, final PhysicsTimer outer) {
        this.timer = outer;
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
            if (timer.isRunning()) {
                long now = System.currentTimeMillis();
                long dt = now - lastRun;
                long currentDt = extraDt + dt;
                if (currentDt < timeInterval) {
                    timer.setState(TimerState.Fast);
                    long sleepTime = timeInterval - currentDt;
                    try {
                        sleep(sleepTime);
                    } catch (InterruptedException ex) {
                    }
                } else {
                    extraDt = currentDt - timeInterval;
                    if (extraDt > timeInterval) {
                        extraDt = timeInterval;
                        timer.setState(TimerState.Slow);
                    } else {
                        timer.setState(TimerState.Normal);
                    }
                    lastRun = now;
                    engine.stepEngine(dt);
                    iterationCount++;
                }
            } else {
                try {
                    sleep(timeInterval);
                } catch (InterruptedException ex) {
                }
                lastRun = System.currentTimeMillis();
                extraDt = 0;
            }
        }
        
        // done
        timer.setState(TimerState.Disposed);
    }
    
}
