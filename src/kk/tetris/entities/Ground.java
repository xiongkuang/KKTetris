package kk.tetris.entities;

import kk.tetris.util.Global;

/**
 * Created by xiongkuang on 2/25/16.
 */
public class Ground {
    public void accept(Shape shape){
        System.out.println("ground's accept shape");
    }

    public void drawMe(){
        System.out.println("ground's draw me");
    }

    public boolean isMovable(Shape shape, int action){
        int left = shape.getLeft();
        int top = shape.getTop();
        switch (action){
            case Shape.LEFT:
                left--;
                break;
            case Shape.RIGHT:
                left++;
                break;
            case Shape.DOWN:
                top++;
                break;
        }
        for (int x = 0; x < 4; x++){
            for (int y = 0; y < 4; y++){
                if (shape.isMember(x, y, action == Shape.ROTATE)){
                    if (top + y >= Global.HEIGHT || left + x < 0 || left + x >= Global.WIDTH)
                        return false;
                }
            }
        }
        return true;
    }
}
