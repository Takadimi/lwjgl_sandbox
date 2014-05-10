package entities;

import org.lwjgl.input.Keyboard;

import static org.lwjgl.opengl.GL11.*;

public class ComputerPaddle extends Paddle {

    private float width;
    private float height;
    private float x;
    private float y;
    private float computerSpeed = 0.25f;

    public ComputerPaddle(int x, int y) {
        this.width = super.WIDTH;
        this.height = super.HEIGHT;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        glBegin(GL_QUADS);
            glVertex2f(x, y);
            glVertex2f(x + width, y);
            glVertex2f(x + width, y + height);
            glVertex2f(x, y + height);
        glEnd();
    }

    @Override
    public void update(int delta) {

        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            y += (delta * computerSpeed);
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            y -= (delta * computerSpeed);
        }

        if (y > (600 - height)) y = (600 - height);
        if (y < 0) y = 0;

    }

    public boolean contains(Ball ball) {

        if (ball.getX() >= this.x - width && (ball.getY() >= this.y - ball.getHeight() && ball.getY() <= this.y + height)) {
            return true;
        } else {
            return false;
        }

    }

}
