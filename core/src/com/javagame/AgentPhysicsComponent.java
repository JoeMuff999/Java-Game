package com.javagame;

import com.badlogic.gdx.math.*;

public class AgentPhysicsComponent extends PhysicsComponent{
    public float MaxSpeed = 4; 
    
    @Override
    public void update(GameObject gameObject, float fixedDelta)
    {
        gameObject.velocity.clamp(0, MaxSpeed);
        Vector3 scaledVelocity = new Vector3(gameObject.velocity);
        gameObject.position.mulAdd(scaledVelocity, fixedDelta);

        // System.out.println(gameObject.position);
    }
}
