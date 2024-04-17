import javax.swing.*;
import java.awt.*;

public class Rocket {
    // Rocket is going to chase the TargetDot

    private int xLoc;
    private int yLoc;
    private int dx = 15;
    private int dy = 15;

    public Rocket(int xLoc, int yLoc, Graphics g) {
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        g.setColor(Color.ORANGE);
        g.fillOval(this.xLoc, this.yLoc, 10, 10);
    }

    public Rocket() {
        xLoc = 20;
        yLoc = 20;
    }

    public void drawRocket(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillOval(this.xLoc, this.yLoc, 10, 10);
    }

    public void move(int screenWidth, int screenHeight, int targetX, int targetY) {
        // calculate direction to target
        dx = targetX - xLoc;
        dy = targetY - yLoc;

        double magnitudeOfVelocity = Math.sqrt(dx * dx + dy * dy);
        double normalizedDx = dx / magnitudeOfVelocity;
        double normalizedDy = dy / magnitudeOfVelocity;

        // Move rocket towards the target
        this.xLoc += normalizedDx * 15; // Adjust the speed as needed
        this.yLoc += normalizedDy * 15; // Adjust the speed as needed

        if (this.xLoc <= 15 || this.xLoc >= screenWidth - 15) {
            this.dx *= -1;
        }

        if(this.xLoc == targetX && this.yLoc == targetY) {
            xLoc = 20;
            yLoc = 20;
        }

        if (this.yLoc <= 15 || this.yLoc >= screenHeight - 15) {
            this.dy *= -1;
        }
    }
}
