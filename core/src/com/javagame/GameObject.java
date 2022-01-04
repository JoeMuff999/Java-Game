package com.javagame;

import com.badlogic.gdx.math.Vector3;

public class GameObject {
    
    public Vector3 position;
    public Vector3 velocity;

    private GraphicsComponent graphics_;
    private PhysicsComponent physics_;
    private ControllerComponent controller_;

    public GameObject(GraphicsComponent graphics, PhysicsComponent physics, ControllerComponent controller)
    {
        controller_ = controller;
        graphics_ = graphics;
        physics_ = physics;
    }

    public void update(float deltaTime, float fixedTime, boolean updatePhysics)
    {
        controller_.update();
        graphics_.update();
        if(updatePhysics)
            physics_.update(this, fixedTime);
    }
}
