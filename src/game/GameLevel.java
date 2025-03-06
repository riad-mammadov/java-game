package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public abstract class GameLevel extends World {
    protected CoinCollect listener;
    private Coin bag;

    protected Spiderman spiderman;
    public GameLevel(Game game){
        super();




        Shape shape = new BoxShape(30, 1f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -10f));


        Shape wallShape = new BoxShape(0.5f,7);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-15.9f,-4));

        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(15.9f,-4));



        spiderman = new Spiderman(this);




        spiderman.addCollisionListener(new CoinCollect(spiderman,this,game));
        CoinCollect encounter = new CoinCollect(spiderman,this,game);
        spiderman.addCollisionListener(encounter);





        //hulk.setPosition(new Vec2(4,-7));

        listener = new CoinCollect(spiderman,this,game);
        spiderman.addCollisionListener(listener);








    }







    public Spiderman getSpiderman() {
        return spiderman;
    }

    public CoinCollect getListener() {
        return listener;
    }

    public abstract boolean isComplete();



}
