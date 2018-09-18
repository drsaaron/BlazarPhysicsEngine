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

public class Vector2D implements Serializable  {

    public Vector2D() { this(0, 0); }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }

    private double x;

    /**
     * Get the value of x
     *
     * @return the value of x
     */
    public double getX() {
        return x;
    }

    /**
     * Set the value of x
     *
     * @param x new value of x
     */
    public void setX(double x) {
        double oldX = this.x;
        this.x = x;
        propertyChangeSupport.firePropertyChange("x", oldX, x);
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

    private double y;

    /**
     * Get the value of y
     *
     * @return the value of y
     */
    public double getY() {
        return y;
    }

    /**
     * Set the value of y
     *
     * @param y new value of y
     */
    public void setY(double y) {
        double oldY = this.y;
        this.y = y;
        propertyChangeSupport.firePropertyChange("y", oldY, y);
    }

    /**
     * add 2 vectors
     * @param v
     * @return vector sum
     */
    public Vector2D add(Vector2D v) {
        Vector2D sum = new Vector2D();
        sum.setX(getX() + v.getX());
        sum.setY(getY() + v.getY());
        return sum;
    }

    /**
     * subtract two vectors
     * @param v
     * @return vector difference
     */
    public Vector2D subtract(Vector2D v) {
        Vector2D sum = new Vector2D();
        sum.setX(getX() - v.getX());
        sum.setY(getY() - v.getY());
        return sum;
    }

    /**
     * scale a vector
     * @param f
     * @return scaled vector
     */
    public Vector2D multiply(double f) {
        Vector2D sum = new Vector2D();
        sum.setX(getX() * f);
        sum.setY(getY() * f);
        return sum;
    }

    private static double sqr(double x) {
        return x * x;
    }

    /**
     * get the "size" of the vector
     * @return
     */
    public double size() {
        return Math.sqrt(sqr(getX()) + sqr(getY()));
    }

    /**
     * dot product.
     * @param v
     * @return
     */
    public double dot(Vector2D v) {
        return getX() * v.getX() + getY() * v.getY();
    }


}
