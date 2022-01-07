package com.javagame;

import com.badlogic.gdx.math.Vector3;

public class AgentControllerComponent extends ControllerComponent{
    
    public float Acceleration = 1;

    @Override
    public void update(GameObject gameObject, float deltaTime)
    {
        // System.out.println(Acceleration * deltaTime);
        gameObject.velocity.add(-1 * Acceleration * deltaTime, 0, 0);
    }
}
