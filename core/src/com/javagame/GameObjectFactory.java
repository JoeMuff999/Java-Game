package com.javagame;

public class GameObjectFactory {
    

    public GameObject CreateAgent()
    {
        return new GameObject(new GraphicsComponent(), new AgentPhysicsComponent(), new AgentControllerComponent());
    }
}
