/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blazartech.products.physics.engine;

import com.blazartech.products.physics.engine.impl.PhysicsEngineImpl;

/**
 *
 * @author AAR1069
 * @version $Id$
 */

/*
$Log$
********************************************************************************/

public class PhysicsEngineHelper {

    private static PhysicsEngineHelper _instance = new PhysicsEngineHelper();
    public static PhysicsEngineHelper instance() { return _instance; }

    private static PhysicsEngine _engine = new PhysicsEngineImpl();
    public PhysicsEngine getEngine() { return _engine; }

    public PhysicsTimer getTimer() {
        return PhysicsTimer.instance();
    }
}
