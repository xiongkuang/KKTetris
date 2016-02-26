package kk.tetris.view;

import kk.tetris.entities.Ground;
import kk.tetris.entities.Shape;

import javax.swing.*;
import java.awt.*;

/**
 * Created by xiongkuang on 2/25/16.
 */
public class GamePanel extends JPanel {

    private Shape shape;
    private Ground ground;

    public void display(Ground ground, Shape shape){
        System.out.println("game panel's display");
        this.shape = shape;
        this.ground = ground;
        this.repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (shape != null && ground != null){
            shape.drawMe();
            ground.drawMe();
        }
    }
}
