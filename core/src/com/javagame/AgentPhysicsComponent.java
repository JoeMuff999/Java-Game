package com.javagame;

import com.badlogic.gdx.math.*;

public class AgentPhysicsComponent extends PhysicsComponent{
    public float MaxSpeed = 4; 

    @Override
    public void addForce(Vector3 force) {
        forceQueue.add(force);
    }
    
    @Override
    public void update(GameObject gameObject, float fixedDelta)
    {
        // System.out.println(gameObject.toString() + " " + forceQueue.size());
        //for concurrency, we would need to copy the forceQueue before emptying it. This is only if physics is running on a separate thread 
        Vector3 forceDelta = new Vector3();
        while(forceQueue.peek() != null) {
            forceDelta.add(forceQueue.poll());
            assert false;
        }
        velocity.mulAdd(forceDelta, 1.0f/mass); // velocity += force/mass
        velocity.clamp(0, MaxSpeed);
        gameObject.position.mulAdd(velocity, fixedDelta);
    }
}
