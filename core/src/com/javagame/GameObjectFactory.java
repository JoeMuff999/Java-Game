package com.javagame;

import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.utils.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.math.*;




public class GameObjectFactory {
	private ModelBuilder modelBuilder;
    
    public GameObjectFactory()
    {
        modelBuilder = new ModelBuilder();
    }

    public GameObject CreateAgent(Vector3 position, Quaternion orientation)
    {
		Model agentModel = modelBuilder.createBox(2f, 2f, 2f,
									new Material(ColorAttribute.createDiffuse(Color.BLUE)), 
									VertexAttributes.Usage.Position|VertexAttributes.Usage.Normal
					); //TODO: eventually make this so its only created once
                    //could also move this to its own agent graphics object? we'll see

        GameObject agent = new GameObject(new ModeledGraphicsComponent(agentModel), new AgentPhysicsComponent(), new AgentControllerComponent());

        agent.init(position, orientation);//initialize agent gameobject
        return agent;
    }
}
