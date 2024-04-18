import java.awt.Color;
import java.awt.Graphics;

public class TargetDot {
    private int xLoc = 20;
    private int yLoc = 20;
    private int dx = 5;
    private int dy = -5;
    private final int VELOCITY_CONSTANT = 5;
    private double maxAngleChange = 30;
    private int numStepsOnCurve = 0;
    //double angleChange = (Math.random() * maxAngleChange) - (maxAngleChange / 2.0); // Random angle change within a certain range

    public int getXLoc() {
        return this.xLoc;
    }

    public int getYLoc() {
        return this.yLoc;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public void drawDot(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillOval(this.xLoc, this.yLoc, 15, 15);
    }

    public void move(int screenWidth, int screenHeight) {
        this.xLoc += this.dx;
        this.yLoc += this.dy;
        if (this.xLoc <= 15 || this.xLoc >= screenWidth - 15) {
            this.dx *= -1;
        }

        if (this.yLoc <= 15 || this.yLoc >= screenHeight - 15) {
            this.dy *= -1;
        }
    }
}
