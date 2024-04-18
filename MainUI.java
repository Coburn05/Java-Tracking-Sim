import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.*;
import java.util.random.RandomGenerator;

public class MainUI extends JPanel {
    private TargetDot targetDot = new TargetDot();
    Rocket rocket = new Rocket();
    private ArrayList<Rocket> listOfRockets = new ArrayList<>();
    private ArrayList<Rocket> listOfRocketsToAdd = new ArrayList<>();
    private BufferedImage image = new BufferedImage(1280, 768, 1);
    private GameCanvas canvas = new GameCanvas(image) {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(MainUI.this.image, 0, 0, this);
        }
    };

    public MainUI() {
        init();
    }

    private void init() {
        JFrame mainUIFrame = new JFrame("Tracking Sim");
        mainUIFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainUIFrame.add(this.canvas, "Center");
        mainUIFrame.setSize(1280, 768);
        mainUIFrame.setVisible(true);
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public void addRocket(int x, int y) {
        listOfRocketsToAdd.add(new Rocket(x, y));
    }

    public void draw(int width, int height) {
        while(true) {
            updateGraphics(width, height, image.getGraphics());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateGraphics(int width, int height, Graphics graphics) {
        listOfRockets.addAll(listOfRocketsToAdd);
        listOfRocketsToAdd.clear();

        graphics.clearRect(0, 0, width, height);
        graphics.setColor(Color.black);

        targetDot.move(width, height);
        targetDot.drawDot(graphics);

        List<Rocket> rocketsToRemove = new ArrayList<>();

        for(Rocket rocket: listOfRockets) {
            if(rocket.shouldRemove()) {
                rocketsToRemove.add(rocket);
            } else {
                rocket.move(width, height, targetDot.getXLoc(), targetDot.getYLoc(), targetDot.getDx(), targetDot.getDy());
                rocket.drawRocket(graphics);
            }
        }

        listOfRockets.removeAll(rocketsToRemove);
        canvas.repaint();
    }
}
