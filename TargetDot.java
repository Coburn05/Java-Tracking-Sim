import java.awt.Color;
import java.awt.Graphics;

public class TargetDot {
    private int xLoc = 200;
    private int yLoc = 200;
    private int dx = 0;
    private int dy = 0;
    private int curveStepsCount = 0;
    private double angle = 0;

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

    public void moveUp() {
        // W
        if(dy > -8) {
            dy -= 1;
        }
    }

    public void moveLeft() {
        // A
        if(dx > -8) {
            dx -= 1;
        }
    }

    public void moveDown() {
        // S
        if(dy < 8) {
            dy += 1;
        }
    }

    public void moveRight() {
        // D
        if(dx < 8) {
            dx += 1;
        }
    }

    public void move(int screenWidth, int screenHeight) {
        // Move according to current direction

        this.xLoc += this.dx;
        this.yLoc += this.dy;

        // Check for collision with walls and change direction
        if (this.xLoc <= 15 || this.xLoc >= screenWidth - 15) {
            this.dx *= -1;
        }

        if (this.yLoc <= 15 || this.yLoc >= screenHeight - 15) {
            this.dy *= -1;
        }
    }
}
