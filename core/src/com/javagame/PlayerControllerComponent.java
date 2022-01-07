package com.javagame;

import java.nio.file.attribute.AclEntry;

import com.badlogic.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;

public class PlayerControllerComponent extends ControllerComponent {
    
    public float Acceleration = 1;

    @Override
    public void update(GameObject gameObject, float deltaTime)
    {
        Vector3 velocityDelta = Vector3.Zero;
        gameObject.velocity = Vector3.Zero;
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            velocityDelta.add(Utils.LEFT);
            // System.out.println("PRESSED");
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            velocityDelta.add(Utils.RIGHT);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            velocityDelta.add(Utils.FORWARD);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            velocityDelta.add(Utils.BACKWARD);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
        {
            velocityDelta.add(Utils.UP);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
        {
            velocityDelta.add(Utils.DOWN);
        }
        gameObject.velocity.mulAdd(velocityDelta, deltaTime);
        // System.out.println(gameObject.velocity);
    }
    
}
