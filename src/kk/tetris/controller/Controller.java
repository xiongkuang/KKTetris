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

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public ShapeFactory getShapeFactory() {
        return shapeFactory;
    }

    public void setShapeFactory(ShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
    }

    public Ground getGround() {
        return ground;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

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
                if (isShapeCanMoveDown(shape)) {
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
    public synchronized boolean  isShapeCanMoveDown(Shape shape){
        if (this.shape != shape){
            return false;
        }
        if (ground.isMovable(shape, Shape.DOWN)){
            return true;
        }else {
            ground.accept(this.shape);
            if (!ground.isFull()){
                this.shape = shapeFactory.getShape(this);
            }
            System.out.println("Game Over");

            return false;
        }
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
