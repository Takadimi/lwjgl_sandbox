package game;

import entities.ComputerPaddle;
import entities.PlayerPaddle;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

import java.nio.FloatBuffer;

public class Game {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private int playerX = 20;
    private int playerY = 300;
    private int computerX = WIDTH - 20;
    private int computerY = 300;
    private PlayerPaddle playerPaddle = new PlayerPaddle(playerX, playerY);
    private ComputerPaddle computerPaddle = new ComputerPaddle(computerX, computerY);
    private int fps = 0;
    private long lastFPS;
    private long lastFrame;

    public Game() {

        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create();

            initGL();
            lastFrame = getTime();
            lastFPS = getTime();

            gameLoop();

            // After the game loop exits, destroy the display and exit the program cleanly
            Display.destroy();

        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

    public void gameLoop() {

        while (!Display.isCloseRequested()) {

            update(getDelta());
            render();

            Display.update();
            Display.sync(60);

        }

    }

    public void initGL() {

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, WIDTH, 0, HEIGHT, 1, -1);
        glMatrixMode(GL_MODELVIEW);

    }

    public void update(int delta) {

        if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            quit();
        }

        playerPaddle.update(delta);
        updateFPS();

    }

    public void render() {

        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        playerPaddle.draw();

    }

    public long getTime() {

        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

    public int getDelta() {

        long time = getTime();
        int delta = (int) (time - lastFrame);
        lastFrame = time;

        return delta;

    }

    public void updateFPS() {
        if (getTime() - lastFPS > 1000) {
            Display.setTitle("FPS: " + fps);
            fps = 0;
            lastFPS += 1000;
        }
        fps++;
    }

    public void quit() {
        Display.destroy();
        System.exit(0);
    }

    public static void main(String[] args) {

        new Game();

    }
}