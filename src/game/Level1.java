package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Level1 extends GameLevel {
    public Level1(Game g){
    //Platform details
        super(g);
        Shape platformShape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(1, -3f));
        platform1.setAngleDegrees(0);
        platform1.setFillColor(Color.BLUE);


// Amount of coins for the level
        for (int i=0; i<2; i++) {
            Coin coin = new Coin(this);
            coin.setPosition(new Vec2(i+-1f,0));
        }

        spiderman.setPosition(new Vec2(-4,7));

    }
// Return score of >=6 and level is complete
    @Override
    public boolean isComplete() {
        return spiderman.getScore() >= 6;
    }
}