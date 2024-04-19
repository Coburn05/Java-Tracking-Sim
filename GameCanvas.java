import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameCanvas extends JPanel {

    private boolean isMousePressed = false;
    private Timer rocketAddTimer;

    public GameCanvas(Image img) {
        setFocusable(true);

        // Add mouse listener for mouse clicks and movement
        // Set up a timer to add rockets periodically while the mouse is held down
        rocketAddTimer = new Timer(100, e -> {
            if (isMousePressed) {
                System.out.println("Adding rocket...");
                // Perform any action needed on mouse press
                Main.getMainUI().addRocket(getMousePosition().x, getMousePosition().y);
            }
        });

        // Add mouse listener for mouse clicks and movement
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                isMousePressed = true;
                rocketAddTimer.start(); // Start the timer when the mouse is pressed
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isMousePressed = false;
                rocketAddTimer.stop(); // Stop the timer when the mouse is released
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isMousePressed) {
                    System.out.println("Mouse dragged while pressed");
                    // Perform any action needed while mouse is pressed and moving
                }
            }
        });

        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                char keyPressed = (char) Character.toLowerCase((e.getKeyChar()));
                keyAction(keyPressed);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                char keyReleased = (char) Character.toLowerCase(e.getKeyChar());
            }
        });
    }

    private void keyAction(char keyPressed) {
        switch(keyPressed) {
            case 'w':
                System.out.println("W");
                break;
            case 'a':
                System.out.println("A");
                break;
            case 's':
                System.out.println("S");
                break;
            case 'd':
                System.out.println("D");
                break;
            default:
                break;
        }
    }
}
