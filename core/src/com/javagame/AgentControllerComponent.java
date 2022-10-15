package com.javagame;

import com.badlogic.gdx.math.Vector3;

/**
 * Demonstration of using transform translations (similar to Unity Transform.Translate) as opposed to adding forces to the rigidbody
 */

public class AgentControllerComponent extends ControllerComponent{
    
    // public float Acceleration = 1;
    Vector3 startPosition = new Vector3(-3,0,0);
    Vector3 endPosition = new Vector3(3,0,0);
    Vector3 target = startPosition;
    float speed = 1.0f;

    @Override
    public void update(GameObject gameObject, float deltaTime)
    {
        if(gameObject.position.dst(target) < 0.001f){
            if(target == startPosition)
                target = endPosition;
            else
                target = startPosition;
        }
        Vector3 toTarget = target.sub(gameObject.position).nor();
        gameObject.position.mulAdd(toTarget, deltaTime);
        // System.out.println(gameObject.position);
    }
}
