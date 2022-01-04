package com.javagame;

import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;


public class GameObject {
    
    public Vector3 position;
    public Vector3 velocity;
    public Quaternion orientation;
    public String id; //TODO: set this eventually 

    private GraphicsComponent graphics_;
    private PhysicsComponent physics_;
    private ControllerComponent controller_;

    public GameObject(GraphicsComponent graphics, PhysicsComponent physics, ControllerComponent controller)
    {
        controller_ = controller;
        graphics_ = graphics;
        physics_ = physics;
    }

    public void init(Vector3 position, Quaternion orientation)
    {
        this.position = position;
        this.orientation = orientation;
        this.velocity = new Vector3(0,0,0);
        graphics_.init(this);
    }

    public void update(float deltaTime, float fixedTime, boolean updatePhysics, ModelBatch modelBatch)
    {
        controller_.update(this, deltaTime);
        graphics_.update(this, modelBatch);
        if(updatePhysics)
            physics_.update(this, fixedTime);
    }
}
