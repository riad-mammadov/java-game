package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

// Coin picture and shape
public class Coin extends DynamicBody {
    private static final Shape coinShape = new CircleShape(1);
    private static final BodyImage image = new BodyImage("data/coin.png",3f);





    public Coin(World world) {
        super(world,coinShape);
        addImage(image);
    }

}