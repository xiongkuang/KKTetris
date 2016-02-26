package kk.tetris.entities;

import kk.tetris.listener.ShapeListener;

import java.util.Random;

/**
 * Created by xiongkuang on 2/25/16.
 */
public class ShapeFactory {

    private int[][][] shapes = new int[][][]{
            {
                    {1, 0, 0, 0,    1, 1, 1, 0,    0, 0, 0, 0,     0, 0, 0, 0 },//Shape "L"
                    {1, 1, 0, 0,    1, 0, 0, 0,    1, 0, 0, 0,     0, 0, 0, 0 },//Shape "L"
                    {1, 1, 1, 0,    0, 0, 1, 0,    0, 0, 0, 0,     0, 0, 0, 0 },//Shape "L"
                    {0, 1, 0, 0,    0, 1, 0, 0,    1, 1, 0, 0,     0, 0, 0, 0 },//Shape "L"
            }
    };

    public Shape getShape(ShapeListener listener){
        System.out.println("ShapeFactory's get shape");
        Shape shape = new Shape();
        shape.addShapeListener(listener);
        int type = new Random().nextInt(shapes.length);//shapes.length types of shape can be generated
        shape.setBody(shapes[type]);
        shape.setStatus(0);
        return shape;
    }


}
