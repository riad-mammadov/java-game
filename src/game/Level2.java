package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Level2 extends GameLevel {
    public Level2(Game g) {
        super(g);
        Shape platformShape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(1, -3f));
        platform1.setAngleDegrees(0);
        platform1.setFillColor(Color.RED);


        Shape platformShape2 = new BoxShape(3, 0.5f);
        StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(12, -3f));
        platform2.setAngleDegrees(0);
        platform2.setFillColor(Color.PINK);



        for (int i = 0; i < 4; i++) {
            Coin coin = new Coin(this);
            coin.setPosition(new Vec2(i + -2f, 4));
        }

    }

    @Override
    public boolean isComplete() {
        return spiderman.getScore() >= 12;
    }
}