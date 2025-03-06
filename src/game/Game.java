package game;

import city.cs.engine.*;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Your main game entry point
 */


public class Game {
    private SoundClip gameMusic;
    protected GameLevel world;
    protected GameView view;
    protected SpidermanController controller;


    /**
     * Initialise a new Game.
     */
    public Game() {
// Background Music
        try {
            gameMusic = new SoundClip("data/music.mp3");
            gameMusic.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);

        }


        world = new Level1(this);


        view = new GameView(world, 640, 384, world.getSpiderman());
        controller = new SpidermanController(world.spiderman);
        view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));


        final JFrame frame = new JFrame("City Game");
        frame.add(view);
        ControlPanel controlPanel = new ControlPanel(this);
        frame.add(controlPanel.getMainPanel(), BorderLayout.NORTH);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.setResizable(false);

        frame.pack();

        frame.setVisible(true);


        //JFrame debugView = new DebugViewer(world, 640, 384);


        world.start();
    }

    public void StopGame() {
        world.stop();
    }

    public void StartGame() {
        world.start();
    }

    public void Replay() {
        if (world instanceof Level1) {
            world.stop();
            world = new Level1(this);
            view.setWorld(world);
            controller.UpdateSpiderman(world.getSpiderman());
            world.start();
        } else if (world instanceof Level2) {
            world.stop();
            world = new Level2(this);
            view.setWorld(world);
            controller.UpdateSpiderman(world.getSpiderman());
            world.start();
        } else if (world instanceof Level3) {
            world.stop();
            world = new Level3(this);
            view.setWorld(world);
            controller.UpdateSpiderman(world.getSpiderman());
            world.start();
        }
    }

// Allows you to progress through each level
    public void goToNextLevel() {
        if (world instanceof Level1) {
            //stop the current level
            world.stop();
            //create the new (appropriate) level
            //level now refers to new level
            world = new Level2(this);
            //change the view to look into new level
            view.setWorld(world);
            //change the controller to control the
            //student in the new world
            controller.UpdateSpiderman(world.spiderman);
            //start the simulation in the new level
            view.UpdateSpiderman(world.getSpiderman());
            world.start();
        } else if (world instanceof Level2) {
            //stop the current level
            world.stop();
            //create the new (appropriate) level
            //level now refers to new level
            world = new Level3(this);
            //change the view to look into new level
            view.setWorld(world);
            //change the controller to control the
            //student in the new world
            controller.UpdateSpiderman(world.spiderman);
            //start the simulation in the new level
            view.UpdateSpiderman(world.getSpiderman());
            world.start();

        } else if (world instanceof Level3) {
            System.out.println("Game Done");
            System.exit(0);
        }


    }


    /**
     * Run the game.
     */
    public static void main(String[] args) {

        new Game();
    }
}