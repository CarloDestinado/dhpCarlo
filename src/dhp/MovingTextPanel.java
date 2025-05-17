package dhp;

import javax.swing.*;
import java.awt.*;

public class MovingTextPanel extends JPanel {
    private String text;
    private int x = 0;
    private int y = 40;
    private int speed = 2; // Pixels per tick
    private Timer timer;
    private boolean movingRight = true; // 🧭 Controls direction

    public MovingTextPanel(String text) {
        this.text = text;
        setBackground(Color.WHITE);
    }

    public void startMoving() {
        timer = new Timer(20, e -> {
            if (movingRight) {
                x += speed;
                if (x + getFontMetrics(getFont()).stringWidth(text) >= getWidth()) {
                    movingRight = false; // Hit right edge → switch direction
                }
            } else {
                x -= speed;
                if (x <= 0) {
                    movingRight = true; // Hit left edge → switch direction
                }
            }
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.setFont(new Font("Times New Roman", Font.BOLD, 24));
        g.drawString(text, x, y);
    }
}
