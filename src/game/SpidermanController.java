package game;

import city.cs.engine.BodyImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SpidermanController implements KeyListener {
    private Spiderman spiderman;
    public static final float WALKING_SPEED = 5;
    public SpidermanController(Spiderman spiderman) {this.spiderman = spiderman;}

// Control for Character movement and animations
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code==KeyEvent.VK_A)
        {
            spiderman.startWalking(-WALKING_SPEED);
            spiderman.removeAllImages();
            spiderman.addImage(new BodyImage("data/sman.walk.reversed.gif",3f));
        }

        else if (code==KeyEvent.VK_Q) {
            spiderman.removeAllImages();
            spiderman.addImage(new BodyImage("data/sman.kick.gif", 5f));
        }

        else if (code==KeyEvent.VK_D){
            spiderman.startWalking(WALKING_SPEED);
            spiderman.removeAllImages();
            spiderman.addImage(new BodyImage("data/sman.walk.gif",3f));
        }

        else if (code==KeyEvent.VK_F) {
            spiderman.startWalking(WALKING_SPEED);
            spiderman.removeAllImages();
            spiderman.addImage(new BodyImage("data/sman.flypunch.gif", 7f));

        }
        else if (code==KeyEvent.VK_G) {
            spiderman.startWalking(WALKING_SPEED);
            spiderman.removeAllImages();
            spiderman.addImage(new BodyImage("data/sman.lowkick.gif", 3f));

        }

        else if (code==KeyEvent.VK_W){
            spiderman.jump(10);
        }




    }
// When the key to move the character is released then the character stops
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code== KeyEvent.VK_A){
            spiderman.stopWalking();
            spiderman.removeAllImages();
            spiderman.addImage
                    (new BodyImage("data/sman.still.reversed.gif",3f));

        }
        else if (code == KeyEvent.VK_D) {
            spiderman.stopWalking();
            spiderman.removeAllImages();
            spiderman.addImage
                    (new BodyImage("data/sman.still.gif",3f));
        }


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    public void UpdateSpiderman(Spiderman h){
        this.spiderman = h;
    }
}