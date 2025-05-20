/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blazartech.products.physics.engine;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 *
 * @author AAR1069
 * @version $Id$
 */

/*
$Log$
********************************************************************************/

public class State implements Serializable {

    private double mass;
    public static final String PROP_MASS = "mass";

    /**
     * Get the value of mass
     *
     * @return the value of mass
     */
    public double getMass() {
        return mass;
    }

    /**
     * Set the value of mass
     *
     * @param mass new value of mass
     */
    public void setMass(double mass) {
        double oldMass = this.mass;
        this.mass = mass;
        propertyChangeSupport.firePropertyChange(PROP_MASS, oldMass, mass);
    }

    private Vector2D position;
    public static final String PROP_POSITION = "position";

    /**
     * Get the value of position
     *
     * @return the value of position
     */
    public Vector2D getPosition() {
        return position;
    }

    /**
     * Set the value of position
     *
     * @param position new value of position
     */
    public void setPosition(Vector2D position) {
        Vector2D oldPosition = this.position;
        this.position = position;
        propertyChangeSupport.firePropertyChange(PROP_POSITION, oldPosition, position);
    }
    
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

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

    private Vector2D velocity;
    public static final String PROP_VELOCITY = "velocity";

    /**
     * Get the value of velocity
     *
     * @return the value of velocity
     */
    public Vector2D getVelocity() {
        return velocity;
    }

    /**
     * Set the value of velocity
     *
     * @param velocity new value of velocity
     */
    public void setVelocity(Vector2D velocity) {
        Vector2D oldVelocity = this.velocity;
        this.velocity = velocity;
        propertyChangeSupport.firePropertyChange(PROP_VELOCITY, oldVelocity, velocity);
    }

}
