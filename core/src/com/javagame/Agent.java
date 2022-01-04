package com.javagame;

/*

    Design choice to make agent its own class (and not just using game object factory)

    Agent will have logic specific to their function (e.g. health)
    since these fields don't really have a component (theres really no need to isolate this logic), we can just put the logic in the overriden gameobject update method
    We could put this logic into its own component, and then have a "game logic" component that we load into the Gameobject, but that doesn't really make sense. This logic could be to stop updating once health < 0. I would have no idea how to put this logic into a GameObject through components...

    I chose to comment out this class to see if I can abide by the component system fully
    

public class Agent extends GameObject{

    public float health = 100.0f;
    
    public Agent(GraphicsComponent graphics, AgentPhysicsComponent physics, AgentControllerComponent controller)
    {
        super(graphics, physics, controller);
    }

    @Override
    public void update(float deltaTime, float fixedTime, boolean updatePhysics)
    {
        controller_.update(this, deltaTime);
        graphics_.update();
        if(updatePhysics)
            physics_.update(this, fixedTime);
    }


    public void SetMaxSpeed(float speed)
    {
        // super.physics_.MaxSpeed = speed;
    }

}
*/