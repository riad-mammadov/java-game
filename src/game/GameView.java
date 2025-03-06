package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

public class GameView extends UserView {

    private final Image background;
    private Spiderman spiderman;
    private Coin coin;
    protected CoinCollect coinCollect;
    //Background image
    public GameView(World w, int width, int height,Spiderman h) {
        super(w, width, height);
        background = new ImageIcon("data/fightbackground.gif").getImage();
        this.spiderman = h;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }
// Coin scoreboard (top left)
    @Override
    protected void paintForeground(Graphics2D g){
        g.setColor(Color.getColor("Coins", Color.PINK));
        Font font = new Font("Calibri", Font.BOLD,20);
        g.setFont(font);
        g.setColor(Color.BLUE);
        String score = "Coins :" + spiderman.getScore();
        g.drawString(score,getWidth()/8,getHeight()/8);
    }

    public void UpdateSpiderman(Spiderman h){
        this.spiderman = h;
    }
}