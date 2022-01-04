package com.javagame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Iterator;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.*;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.graphics.g3d.environment.*;

import com.badlogic.gdx.utils.TimeUtils;

import com.javagame.*;

public class Main extends ApplicationAdapter {
	private PerspectiveCamera mainCamera;
	private ModelBatch modelBatch;
	private Model cubeModel;
	private ModelInstance cubeInstance;
	private Environment environment;

	private ArrayList<GameObject> gameObjects;

	public static final int ScreenWidth = 800;
	public static final int ScreenHeight = 600;
	public GameObjectFactory factory;

	public double total_angle = 0;
	public float fixedDeltaTime; // figure out how to do this properly :)

	@Override
	public void create(){
		factory = new GameObjectFactory();
		gameObjects = new ArrayList<GameObject>();
		mainCamera = new PerspectiveCamera(90, ScreenWidth, ScreenHeight);
		mainCamera.position.set(0f, 0f, 3f);
		mainCamera.lookAt(0f,0f,0f);
		mainCamera.near = 0.1f;
		mainCamera.far = 300f;

		modelBatch = new ModelBatch();

		// cubeInstance = new ModelInstance(cubeModel, 0, 0, 0);
		GameObject agent = factory.CreateAgent(new Vector3(0,0,0), new Quaternion());
		gameObjects.add(agent);
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.8f, 0.8f, 0.8f, 1f));
	}
	@Override
	public void render()
	{
		Gdx.gl.glClearColor(0.68f, 0.85f, 0.90f, 0.2f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT| GL20.GL_DEPTH_BUFFER_BIT);
		// cameraOrbit();
		mainCamera.update();
		//physics update should be on a separate timer. when you go to update the gameobjects, basically just pass a bool that says if you should update the physics or not
		modelBatch.begin(mainCamera);
		for (GameObject go : gameObjects) {
			go.update(Gdx.graphics.getDeltaTime(), Gdx.graphics.getDeltaTime(), true, modelBatch);
		}
		modelBatch.end();
	}

	public void cameraOrbit(){
		double dt = Gdx.graphics.getDeltaTime();
		double ms = Math.toRadians(60.0f)*dt;
		total_angle+= ms;
		double total_dist = 3 * 2 * Math.sin(ms/2.0f);
		double new_x = mainCamera.position.x + Math.cos(total_angle) * total_dist;
		double new_z = mainCamera.position.z - Math.sin(total_angle) * total_dist; 
		mainCamera.position.set((float) new_x, 0, (float) new_z);
		mainCamera.lookAt(0f,0f,0f);
	}

	@Override
	public void dispose () {
		modelBatch.dispose();
		// cubeModel.dispose();
	}
}