import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameCanvas extends JPanel {

    public GameCanvas(Image img) {
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouse was hit");
                // create rocket
                Rocket rocket = new Rocket(e.getX(), e.getY(), img.getGraphics());
                repaint();
            }
        });
    }
}
