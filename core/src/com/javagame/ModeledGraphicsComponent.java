package com.javagame;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g3d.*;

public class ModeledGraphicsComponent extends GraphicsComponent{
    
    private ModelInstance instance;
    private Model model_;

    public ModeledGraphicsComponent(Model model)
    {
        model_ = model;
    }   

    @Override
    public void init(GameObject gameObject)
    {
		instance = new ModelInstance(model_, gameObject.position);
    }

    @Override
    public void update(GameObject gameObject, ModelBatch modelBatch)
    {
        instance.transform.set(gameObject.position, gameObject.orientation);
        modelBatch.render(instance);
    }
}
