package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Level3 extends GameLevel {
    public Level3(Game g){
        super(g);
       // Placement/colour/size of the platforms
        Shape platformShape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);



        Shape platformShape2 = new BoxShape(3, 0.5f);
        StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(15, -3f));
        platform2.setAngleDegrees(0);
        platform2.setFillColor(Color.RED);

        Shape platformShape3 = new BoxShape(3, 0.5f);
        StaticBody platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(-5, -1f));
        platform3.setAngleDegrees(0);
        platform3.setFillColor(Color.RED);

        // How many coins will be in the level
            for (int i=0; i<6; i++) {
            Coin coin = new Coin(this);
            coin.setPosition(new Vec2(i+2f,0));
        }

        // Position of the game character
        spiderman.setPosition(new Vec2(-4,7));

    }

    @Override
    // Once spiderman gets the score of 18 or more, the level is complete
    public boolean isComplete() {
        return spiderman.getScore() >= 18;
    }
}