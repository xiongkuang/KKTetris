package kk.tetris.entities;

/**
 * Created by xiongkuang on 2/25/16.
 */
public class ShapeFactory {

    public Shape getShape(){
        System.out.println("get shape");
        return new Shape();
    }


}
