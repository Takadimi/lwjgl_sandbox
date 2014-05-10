package entities;

import static org.lwjgl.opengl.GL11.*;

public class Ball extends Entity {

    private int width = 20;
    private int height = 20;
    private int x;
    private int y;
    private float velocity = 0.25f;
    private boolean movingLeft = true;

    public Ball(int x, int y) {

        this.x = x;
        this.y = y;

    }

    @Override
    public void draw() {

        glBegin(GL_QUADS);
            glVertex2i(x, y);
            glVertex2i(x + width, y);
            glVertex2i(x + width, y + height);
            glVertex2i(x, y + height);
        glEnd();

    }

    @Override
    public void update(int delta) {

        if (movingLeft) {
            x -= delta * velocity;
        } else {
            x += delta * velocity;
        }

        if (x < 0 || x > 800) {
            x = 400;
            movingLeft = true;
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMovingLeft(boolean left) {

        this.movingLeft = left;

    }

}
