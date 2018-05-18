package soldater.johannas.model.level.blocks;

import soldater.johannas.model.Drawable;

public abstract class Block implements Drawable {
    public static final int WIDTH = 54;
    public static final int HEIGHT = 51;

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    @Override
    public int getDirection() {
        return 0;
    }

    @Override
    public int getState() {
        return 0;
    }

    @Override
    public abstract String getName();
}
