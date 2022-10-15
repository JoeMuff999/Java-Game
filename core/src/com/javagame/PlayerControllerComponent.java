package com.javagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;

public class PlayerControllerComponent extends ControllerComponent {

    @Override
    public void update(GameObject gameObject, float deltaTime)
    {
        Vector3 delta = new Vector3();
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            delta.add(Utils.LEFT);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            delta.add(Utils.RIGHT);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            delta.add(Utils.FORWARD);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            delta.add(Utils.BACKWARD);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
        {
            delta.add(Utils.UP);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
        {
            delta.add(Utils.DOWN);
        }
        gameObject.getPhysics_().addForce(delta.scl(deltaTime));
    }
    
}
