package com.javagame;

public class PhysicsComponent{
    
    public void update(GameObject gameObject, float fixedDelta)
    {
        gameObject.position.add(gameObject.velocity.scl(fixedDelta));
    }
}
