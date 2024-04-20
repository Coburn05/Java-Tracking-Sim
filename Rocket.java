import javax.swing.*;
import java.awt.*;

public class Rocket {
    // Rocket is going to chase the TargetDot

    private int xLoc;
    private int yLoc;
    private int dx = 15;
    private int dy = 15;
    private Graphics graphics;
    private boolean shouldRemove = false;
    private double minTurningRadius = 10;

    public Rocket(int xLoc, int yLoc, Graphics g) {
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        graphics  = g;
        graphics.setColor(Color.ORANGE);
        graphics.fillOval(this.xLoc, this.yLoc, 10, 10);
    }

    public Rocket() {
        xLoc = 20;
        yLoc = 20;
    }

    public Rocket(int xLoc, int yLoc) {
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }

    public boolean shouldRemove() {
        return shouldRemove;
    }

    public void drawRocket(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillOval(this.xLoc, this.yLoc, 10, 10);
    }

    public static Rocket addRocket(int x, int y) {
        return new Rocket(x, y);
    }

    public void move(int screenWidth, int screenHeight, int targetX, int targetY, int targetVelocityX, int targetVelocityY) {
        // Calculate direction to current target position
        int dx = targetX - xLoc;
        int dy = targetY - yLoc;
        int missileSpeed = 15;

        // Calculate distance to target
        double distanceToTarget = Math.sqrt(dx * dx + dy * dy);

        // Calculate time to intercept (assuming constant velocity)
        double timeToIntercept = distanceToTarget / missileSpeed;

        // Predict future position of target
        int futureTargetX = targetX + (int) (targetVelocityX * timeToIntercept);
        int futureTargetY = targetY + (int) (targetVelocityY * timeToIntercept);

        // Calculate direction to intercept point
        int interceptDx = futureTargetX - xLoc;
        int interceptDy = futureTargetY - yLoc;

        // Normalize direction vector
        double magnitudeOfVelocity = Math.sqrt(interceptDx * interceptDx + interceptDy * interceptDy);
        double normalizedDx = interceptDx / magnitudeOfVelocity;
        double normalizedDy = interceptDy / magnitudeOfVelocity;

        // Calculate minimum turning radius
        double minTurningRadiusX = normalizedDx * minTurningRadius;
        double minTurningRadiusY = normalizedDy * minTurningRadius;

        // Move missile towards the intercept point
        this.xLoc += minTurningRadiusX;
        this.yLoc += minTurningRadiusY;

        // Check if missile is close enough to target
        if (Math.abs(xLoc - targetX) <= 10 && Math.abs(yLoc - targetY) <= 10) {
            shouldRemove = true;
            System.out.println("Hit");
        }

        // Bounce off the walls
        if (this.xLoc <= 0 || this.xLoc >= screenWidth - 10) {
            this.dx *= -1;
        }
        if (this.yLoc <= 0 || this.yLoc >= screenHeight - 10) {
            this.dy *= -1;
        }
    }

}
