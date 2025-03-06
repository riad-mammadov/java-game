package game;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel {
    public JPanel MainPanel;
    private JButton pauseButton;
    private JButton quitButton;
    private JButton playButton;
    private JButton restartButton;

    Game game;

    public ControlPanel(Game game) {
        this.game = game;

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.StartGame();
            }
        });
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.StopGame();
            }
        });

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.Replay();
            }
        });


    }

    public JPanel getMainPanel() {
        return MainPanel;
    }


}