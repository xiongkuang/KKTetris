package kk.tetris.view;

import kk.tetris.entities.Ground;
import kk.tetris.entities.Shape;
import kk.tetris.util.Global;

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
        g.setColor(new Color(0xcfcfcf));
        g.fillRect(0, 0, Global.WIDTH * Global.CELL_SIZE, Global.HEIGHT * Global.CELL_SIZE);
        if (shape != null && ground != null){
            shape.drawMe(g);
            ground.drawMe(g);
        }
    }

    public GamePanel(){
        this.setSize(Global.WIDTH * Global.CELL_SIZE, Global.HEIGHT * Global.CELL_SIZE);
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Ground getGround() {
        return ground;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }
}
