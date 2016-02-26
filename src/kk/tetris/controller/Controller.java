package kk.tetris.controller;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import kk.tetris.entities.Ground;
import kk.tetris.entities.Shape;
import kk.tetris.entities.ShapeFactory;
import kk.tetris.listener.ShapeListener;
import kk.tetris.view.GamePanel;

/**
 * Created by xiongkuang on 2/25/16.
 */
public class Controller extends KeyAdapter implements ShapeListener {
    private Shape shape;
    private ShapeFactory shapeFactory;
    private Ground ground;
    private GamePanel gamePanel;

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                if (ground.isMovable(shape, Shape.ROTATE)) {
                    shape.rotate();
                }
                break;
            case KeyEvent.VK_DOWN:
                if (ground.isMovable(shape, Shape.DOWN)) {
                    shape.moveDown();
                }
                break;
            case KeyEvent.VK_LEFT:
                if (ground.isMovable(shape, Shape.LEFT)){
                    shape.moveLeft();
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (ground.isMovable(shape, Shape.RIGHT)) {
                    shape.moveRight();
                }
                break;
        }
        gamePanel.display(ground, shape);
    }

    @Override
    public void shapeMoveDown(Shape shape){
        gamePanel.display(ground, shape);
    }

    @Override
    public boolean isShapeCanMoveDown(Shape shape){
        return ground.isMovable(shape, Shape.DOWN);
    }
    public void newGame(){
        shape = shapeFactory.getShape(this);
    }

    public Controller(ShapeFactory shapeFactory, Ground ground, GamePanel gamePanel){
        this.shapeFactory = shapeFactory;
        this.ground = ground;
        this.gamePanel = gamePanel;

    }
}
