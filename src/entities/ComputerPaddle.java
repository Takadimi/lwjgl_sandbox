package entities;

public class ComputerPaddle extends Paddle {

    private int width;
    private int height;
    private int x;
    private int y;

    public ComputerPaddle(int x, int y) {
        this.width = super.WIDTH;
        this.height = super.HEIGHT;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {

    }
}
