package kk.tetris.test;

import kk.tetris.controller.Controller;
import kk.tetris.entities.Ground;
import kk.tetris.entities.Shape;
import kk.tetris.entities.ShapeFactory;
import kk.tetris.view.GamePanel;

import javax.swing.*;

/**
 * Created by xiongkuang on 2/26/16.
 */
public class Game {
    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();
        Ground ground = new Ground();
        GamePanel gamePanel = new GamePanel();
        Controller controller = new Controller(shapeFactory, ground, gamePanel);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(gamePanel.getWidth() + 10, gamePanel.getHeight() + 35);
        frame.add(gamePanel);
        gamePanel.addKeyListener(controller);
        frame.setVisible(true);
        frame.addKeyListener(controller);
        controller.newGame();
    }

}
