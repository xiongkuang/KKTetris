package kk.tetris.entities;


import kk.tetris.listener.ShapeListener;

import java.awt.*;
import java.lang.Runnable;
import kk.tetris.listener.ShapeListener;
import kk.tetris.util.Global;

import javax.xml.bind.annotation.XmlElementDecl;

import static java.lang.Thread.*;

/**
 * Created by xiongkuang on 2/25/16.
 */
public class Shape {

    public static final int ROTATE = 0;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int DOWN = 3;

    private int[][] body;
    private int status;
    private int left;//x coordinate
    private int top;//y coordinate

    private ShapeListener listener;

    public void moveLeft(){
        System.out.println("shape's move left");
        left--;
    }

    public void moveRight(){
        System.out.println("shape's move right");
        left++;
    }

    public void moveDown(){
        System.out.println("shape's move down");
        top++;
    }

    public void rotate(){
        System.out.println("shape's rotate");
        status = (status + 1) % body.length;
    }

    public void drawMe(Graphics g){
        System.out.println("shape's draw me");
        g.setColor(Color.RED);
        for (int x = 0; x < 4; x++){
            for (int y = 0; y < 4; y++){
                if (getFlagByPoint(x, y)){
                    g.fill3DRect((left + x) * Global.CELL_SIZE, (top + y) * Global.CELL_SIZE,
                            Global.CELL_SIZE, Global.CELL_SIZE, true);
                }
            }
        }
    }

    private boolean getFlagByPoint(int x, int y){
        return body[status][y * 4 + x] == 1;
    }

    public boolean isMember(int x, int y, boolean rotate){
        int tempStatus = status;
        if (rotate){
            tempStatus = (status + 1) % body.length;
        }
        return body[tempStatus][y * 4 + x] == 1;

    }

    private class ShapeDriver implements Runnable{
        @Override
        public void run() {
            while(listener.isShapeCanMoveDown(Shape.this)){
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
        new Thread(new ShapeDriver()).start();
    }

    public void addShapeListener(ShapeListener listener){
        if (listener != null){
            this.listener = listener;
        }

    }

    public void setBody(int body[][]){
        this.body = body;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTop() {
        return top;
    }

    public int getLeft() {
        return left;
    }
}