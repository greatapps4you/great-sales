package us.greatapps4you.greatsales.desktop.common.wait;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MailBoard extends JPanel implements Runnable {
    private final int B_WIDTH = 250;
    private final int B_HEIGHT = 80;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = 15;
    private final int DELAY = 10;
    private Image star;
    private Thread animator;
    private int x;
    private int y;

    public MailBoard() {
        this.loadImage();
        this.initBoard();
    }

    private void loadImage() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/us/greatapps4you/greatsales/desktop/resource/image/mail-white.png"));
        this.star = ii.getImage();
    }

    private void initBoard() {
        this.setBackground(new Color(51, 51, 51));
        this.setPreferredSize(new Dimension(250, 80));
        this.setDoubleBuffered(true);
        this.x = -40;
        this.y = 15;
    }

    public void addNotify() {
        super.addNotify();
        this.animator = new Thread(this);
        this.animator.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.drawStar(g);
    }

    private void drawStar(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(this.star, this.x, this.y, 50, 50, this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    private void cycle() {
        ++this.x;
        if (this.x > 250) {
            this.y = 15;
            this.x = -40;
        }

    }

    public void run() {
        long beforeTime = System.currentTimeMillis();

        while(true) {
            this.cycle();
            this.repaint();
            long timeDiff = System.currentTimeMillis() - beforeTime;
            long sleep = 10L - timeDiff;
            if (sleep < 0L) {
                sleep = 2L;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException var8) {
                System.out.println("Interrupted: " + var8.getMessage());
            }

            beforeTime = System.currentTimeMillis();
        }
    }
}
