import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class MainUI extends JPanel {
    private BufferedImage image = new BufferedImage(1280, 768, 1);

    private GameCanvas canvas = new GameCanvas(image) {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(MainUI.this.image, 0, 0, this);
        }
    };

    public BufferedImage getImage() {
        return this.image;
    }

    public void draw(int width, int height) {
        TargetDot targetDot = new TargetDot();
        Rocket rocket = new Rocket();
        JFrame mainUIFrame = new JFrame("Tracking sim");
        mainUIFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainUIFrame.add(this.canvas, "Center");
        mainUIFrame.setSize(width, height);
        mainUIFrame.setVisible(true);
        targetDot.drawDot(this.image.getGraphics());
        rocket.drawRocket(this.image.getGraphics());
        this.canvas.repaint();
        Graphics g = this.image.getGraphics();

        do {
            g.clearRect(0, 0, width, height);
            g.setColor(Color.black);
            rocket.move(width, height, targetDot.getXLoc(), targetDot.getYLoc());
            targetDot.move(width, height);
            targetDot.drawDot(g);
            rocket.drawRocket(g);
            this.canvas.repaint();

            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (true);
    }
}
