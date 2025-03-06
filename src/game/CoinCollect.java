package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class CoinCollect implements CollisionListener {

    private final Spiderman spiderman;
    protected GameLevel level;
    protected Game game;


    public CoinCollect(Spiderman h,GameLevel l,Game g){
        this.spiderman = h;
        this.level = l;
        this.game = g;
    }

// When the coin is picked up, the score increases by 1 and the coin is destroyed
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody()instanceof Coin) {
            System.out.println("Spiderman picked up the coin");
            spiderman.setCoin(spiderman.getCoin() + 1);
            collisionEvent.getOtherBody().destroy();
            spiderman.setScore(spiderman.getScore() + 1);
            if(level.isComplete()){
                game.goToNextLevel();
            }
        }



    }

}