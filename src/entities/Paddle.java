package entities;

public abstract class Paddle extends Entity {

    protected static final int WIDTH = 20;
    protected static final int HEIGHT = 100;

    public Paddle() {}

    public abstract void draw();

}