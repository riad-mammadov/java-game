package game;

import city.cs.engine.*;

public class Spiderman extends Walker{
    private static final Shape spidermanShape = new PolygonShape(0.26f,1.95f,
            2.02f,1.69f,
            1.89f,-1.53f,
            0.62f,-2.03f,
            -1.79f,-2.08f,
            -1.79f,1.68f,
            0.2f,1.95f);

    private static final BodyImage image = new BodyImage("data/sman.still.gif",3f);
    private int coin;
    private int score;

    public Spiderman(World world){
        super(world,spidermanShape);
        addImage(image);
        coin = 0;
    }

    public void setCoin(int coin) {
        this.coin = coin;
        System.out.println(coin);
    }

    public int getCoin() {
        return coin;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}






