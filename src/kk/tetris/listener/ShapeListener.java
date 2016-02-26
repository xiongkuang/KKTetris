package kk.tetris.listener;

import kk.tetris.entities.Shape;

/**
 * Created by xiongkuang on 2/25/16.
 */
public interface ShapeListener {
    void shapeMoveDown(Shape shape);

    boolean isShapeCanMoveDown(Shape shape);
}
