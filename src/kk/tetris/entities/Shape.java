package kk.tetris.entities;


import kk.tetris.listener.ShapeListener;

import java.lang.Runnable;
import kk.tetris.listener.ShapeListener;

import static java.lang.Thread.*;

/**
 * Created by xiongkuang on 2/25/16.
 */
public class Shape {
    private ShapeListener listener;

    public void moveLeft(){
        System.out.println("move left");
    }

    public void moveRight(){
        System.out.println("move right");
    }

    public void moveDown(){
        System.out.println("move down");
    }

    public void rotate(){
        System.out.println("rotate");
    }

    public void drawMe(){
        System.out.println("draw me");
    }

    private class shapeDriver implements Runnable{
        @Override
        public void run() {
            while(true){
                moveDown();
                listener.shapeMoveDown(Shape.this);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Shape(){
        new Thread(new shapeDriver());
    }

    public void addShapeListener(ShapeListener listener){
        if (listener != null){
            this.listener = listener;
        }

    }

}