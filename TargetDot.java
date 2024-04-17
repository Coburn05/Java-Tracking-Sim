import java.awt.Color;
import java.awt.Graphics;

public class TargetDot {
    private int xLoc = 20;
    private int yLoc = 20;
    private int dx = 10;
    private int dy = -10;

    public int getXLoc() {
        return this.xLoc;
    }

    public int getYLoc() {
        return this.yLoc;
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
