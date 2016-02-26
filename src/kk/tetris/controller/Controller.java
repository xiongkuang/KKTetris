package kk.tetris.controller;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import kk.tetris.entities.Ground;
import kk.tetris.entities.Shape;
import kk.tetris.entities.ShapeFactory;
import kk.tetris.view.GamePanel;

/**
 * Created by xiongkuang on 2/25/16.
 */
public class Controller extends KeyAdapter {
    private Shape shape;
    private ShapeFactory shapeFactory;
    private Ground ground;
    private GamePanel gamePanel;

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                shape.rotate();
                break;
            case KeyEvent.VK_DOWN:
                shape.moveDown();
                break;
            case KeyEvent.VK_LEFT:
                shape.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                shape.moveRight();
                break;
        }
        gamePanel.display(ground, shape);
    }
}
