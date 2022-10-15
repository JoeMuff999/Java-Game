package com.javagame;

import com.badlogic.gdx.math.Vector3;

/**
 * I dont want to use this class. There should not be a controller class, but rather just an input class. The physics should handle the movement of an AI agent.
 */

public class AgentControllerComponent extends ControllerComponent{
    
    public float Acceleration = 1;

    @Override
    public void update(GameObject gameObject, float deltaTime)
    {
        // System.out.println(Acceleration * deltaTime);
        // gameObject.velocity.add(-1 * Acceleration * deltaTime, 0, 0);
    }
}
