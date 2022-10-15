package com.javagame;

import java.util.LinkedList;
import java.util.Queue;

import com.badlogic.gdx.math.Vector3;

public class PhysicsComponent{

    public Vector3 velocity = new Vector3();
    public float mass = 1.0f;
    protected Queue<Vector3> forceQueue = new LinkedList<Vector3>();

    public void addForce(Vector3 force) {

    }
    
    public void update(GameObject gameObject, float fixedDelta)
    {
       
    }
}
