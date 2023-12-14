import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.*;

class GraphicsSwing_0816 extends JPanel {
    int WIDTH = 600;
    int HEIGHT = 600;

    public static void main(String[] args) {
        GraphicsSwing_0816 m = new GraphicsSwing_0816();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Happy New Jeans - 0816");
        f.setSize(m.WIDTH, m.HEIGHT);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        BufferedImage buffer = new BufferedImage(601, 601,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();
        // System.out.println(g2);
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 600, 600);

        drawBackground(g2);
        // drawBunny(g2);
        // drawText(g2);
        Color frame = new Color(43, 53, 134);
        // Color area = new Color(255, 255, 255);
        Color area = new Color(255, 255, 255);
        g2.setColor(area);
        H(g2, 0, 0, 1);
        P(g2, 0, 0, 1);
        P(g2, 0, 0, 1);
        Y(g2, 0, 0, 1);
        N(g2, 122, 400, 1);
        buffer = FloodFill2(buffer, 124, 402, area, area);
        W(g2, 193, 400, 1);
        buffer = FloodFill2(buffer, 195, 402, area, area);
        J(g2, 294, 471, 1);
        buffer = FloodFill2(buffer, 296, 473, area, area);
        N(g2, 352, 400, 1);
        buffer = FloodFill2(buffer, 354, 402, area, area);
        S(g2, 422, 400, 1);
        buffer = FloodFill2(buffer, 443, 420, area, area);

        g2.setColor(frame);
        drawText(g2, 3);

        g.drawImage(buffer, 0, 0, null);
    }

    private void drawText(Graphics g, int size) {
        H(g, 0, 0, size);
        P(g, 0, 0, size);
        P(g, 0, 0, size);
        Y(g, 0, 0, size);
        N(g, 122, 400, size);
        W(g, 193, 400, size);
        J(g, 294, 471, size);
        N(g, 352, 400, size);
        S(g, 422, 400, size);
    }

    private void Y(Graphics g, int i, int j, int size) {
    }

    private void P(Graphics g, int i, int j, int size) {
    }

    private void H(Graphics g, int i, int j, int size) {
    }

    private void S(Graphics g, int x, int y, int size) {
        // g.setColor(Color.WHITE);
        line(g, x + 60, y + 48, x + 60, y + 33, size); // |
        curve(g, new int[] { x + 60, x + 60, x, x }, new int[] { y + 33, y - 10, y - 10, y + 33 }, size);
        curve(g, new int[] { x, x, x + 20, x + 20 }, new int[] { y + 32, y + 45, y + 63, y + 63 }, size);
        curve(g, new int[] { x + 20, x + 20, x + 23, x + 20 }, new int[] { y + 63, y + 63, y + 69, y + 69 }, size);
        line(g, x + 20, y + 69, x, y + 69, size); // _
        line(g, x, y + 69, x, y + 158, size); // |
        line(g, x, y + 158, x + 34, y + 158, size); // _
        curve(g, new int[] { x + 34, x + 79, x + 79, x + 50 }, new int[] { y + 158, y + 158, y + 79, y + 59 }, size);
        curve(g, new int[] { x + 28, x + 28, x + 50, x + 50 }, new int[] { y + 28, y + 41, y + 59, y + 59 }, size);
        curve(g, new int[] { x + 28, x + 28, x + 41, x + 41 }, new int[] { y + 28, y + 18, y + 18, y + 28 }, size);
        line(g, x + 40, y + 28, x + 40, y + 48, size); // |
        line(g, x + 40, y + 48, x + 60, y + 48, size); // _

        // line(g, x, y, x + 69, y); // top 491 - 422
        // line(g, x, y, x, y + 158); // left
        // line(g, x, y + 158, x + 69, y + 158); // bottom
        // line(g, x + 69, y, x + 69, y + 158); // right
    }

    private void J(Graphics g, int x, int y, int size) {
        // g.setColor(Color.WHITE);
        line(g, x + 22, y - 71, x + 22, y - 11, size);// |
        curve(g, new int[] { x + 22, x + 22, x + 12, x }, new int[] { y - 11, y, y, y }, size);
        line(g, x, y, x, y + 63, size);// |
        curve(g, new int[] { x, x, x + 52, x + 52 }, new int[] { y + 63, y + 97, y + 97, y + 63 }, size);
        line(g, x + 52, y + 63, x + 52, y - 71, size);// |
        line(g, x + 52, y - 71, x + 22, y - 71, size);// _
        // curve(g, new int[] { 100, 200, 300 }, new int[] { 100, 300, 100 }, 3);
        // line(g, x, y - 71, x + 52, y - 71);// top y = 501-430 (71) x = 346-294 (52)
        // line(g, x, y - 71, x, y + 87); // left 588 - 501 = 87
        // line(g, x, y + 87, x + 52, y + 87); // bottom
        // line(g, x + 52, y - 71, x + 52, y + 87); // right
    }

    private void W(Graphics g, int x, int y, int size) {
        // g.setColor(Color.WHITE);
        line(g, x, y, x + 14, y + 158, size);// \
        line(g, x + 14, y + 158, x + 47, y + 158, size);// _
        line(g, x + 47, y + 158, x + 53, y + 118, size);// /
        line(g, x + 53, y + 118, x + 59, y + 158, size);// \
        line(g, x + 59, y + 158, x + 92, y + 158, size);// _
        line(g, x + 92, y + 158, x + 106, y, size);// /
        line(g, x + 106, y, x + 76, y, size);// _
        line(g, x + 76, y, x + 70, y + 40, size);// /
        line(g, x + 70, y + 40, x + 63, y, size);// \
        line(g, x + 63, y, x + 43, y, size);// _
        line(g, x + 43, y, x + 36, y + 40, size);// /
        line(g, x + 36, y + 40, x + 30, y, size);// \ 236 - 223= 13
        line(g, x + 30, y, x, y, size);// _
        // line(g, x, y, x + 106, y);// top 299
        // line(g, x, y, x, y + 158); // left
        // line(g, x, y + 158, x + 106, y + 158); // bottom
        // line(g, x + 106, y, x + 106, y + 158); // right
    }

    private void N(Graphics g, int x, int y, int size) {
        // g.setColor(Color.WHITE);
        line(g, x, y, x, y + 158, size); // | 122 430 , 122 588
        line(g, x, y + 158, x + 25, y + 158, size); // _ 122 588 , 122 + 25 588
        line(g, x + 25, y + 158, x + 25, y + 118, size); // | 147 588 , 147 588 -40
        line(g, x + 25, y + 118, x + 37, y + 158, size); // \ 147 118 , 147 + 12 588
        line(g, x + 37, y + 158, x + 67, y + 158, size); // _ 159 588 , 189 588
        line(g, x + 67, y + 158, x + 67, y, size); // | 189 430
        line(g, x + 67, y, x + 42, y, size); // _
        line(g, x + 42, y, x + 42, y + 40, size); // |
        line(g, x + 42, y + 40, x + 30, y, size); // \
        line(g, x + 30, y, x, y, size); // _
        // line(g, x, y, x + 67, y); // top 189 67
        // line(g, x, y, x, y + 158); // left 158
        // line(g, x, y + 158, x + 67, y + 158); // bottom
        // line(g, x + 67, y, x + 67, y + 158); // right
    }

    private void drawBunny(Graphics g) {

    }

    private void drawBackground(Graphics g) {
        // vertical-line
        for (int i = 0; i < WIDTH; i += 11) {
            g.setColor(Color.decode("#262e6c"));
            line(g, i, 0, i, 600, 1);

        }
        // horizental-line
        for (int i = 0; i < HEIGHT; i += 11) {
            g.setColor(Color.decode("#262e6c"));
            line(g, 0, i, 600, i, 1);
        }
        // inside-squre
        String codeOutside = "#3c4581";
        String codeInside = "#7a83bd";
        for (int i = 0; i < WIDTH; i += 11) {
            for (int j = 0; j < HEIGHT; j += 11) {
                // left-top
                g.setColor(Color.decode(codeOutside));
                line(g, i + 1, j + 1, i + 5, j + 1, 1);
                line(g, i + 1, j + 1, i + 1, j + 5, 1);
                line(g, i + 5, j + 1, i + 5, j + 5, 1);
                line(g, i + 1, j + 5, i + 5, j + 5, 1);

                g.setColor(Color.decode(codeInside));
                line(g, i + 2, j + 2, i + 4, j + 2, 1);
                line(g, i + 2, j + 2, i + 2, j + 4, 1);
                line(g, i + 4, j + 2, i + 4, j + 4, 1);
                line(g, i + 2, j + 4, i + 4, j + 4, 1);

                // right-top
                g.setColor(Color.decode(codeOutside));
                line(g, i + 6, j + 1, i + 10, j + 1, 1);
                line(g, i + 6, j + 1, i + 6, j + 5, 1);
                line(g, i + 10, j + 1, i + 10, j + 5, 1);
                line(g, i + 6, j + 5, i + 10, j + 5, 1);

                g.setColor(Color.decode(codeInside));
                line(g, i + 7, j + 2, i + 9, j + 2, 1);
                line(g, i + 7, j + 2, i + 7, j + 4, 1);
                line(g, i + 9, j + 2, i + 9, j + 4, 1);
                line(g, i + 7, j + 4, i + 9, j + 4, 1);

                // left-bottom
                g.setColor(Color.decode(codeOutside));
                line(g, i + 1, j + 6, i + 5, j + 6, 1);
                line(g, i + 1, j + 6, i + 1, j + 10, 1);
                line(g, i + 5, j + 6, i + 5, j + 10, 1);
                line(g, i + 1, j + 10, i + 5, j + 10, 1);

                g.setColor(Color.decode(codeInside));
                line(g, i + 2, j + 7, i + 4, j + 7, 1);
                line(g, i + 2, j + 7, i + 2, j + 9, 1);
                line(g, i + 4, j + 7, i + 4, j + 9, 1);
                line(g, i + 2, j + 9, i + 4, j + 9, 1);

                // right-bottom
                g.setColor(Color.decode(codeOutside));
                line(g, i + 6, j + 6, i + 10, j + 6, 1);
                line(g, i + 6, j + 6, i + 6, j + 10, 1);
                line(g, i + 10, j + 6, i + 10, j + 10, 1);
                line(g, i + 6, j + 10, i + 10, j + 10, 1);

                g.setColor(Color.decode(codeInside));
                line(g, i + 7, j + 7, i + 9, j + 7, 1);
                line(g, i + 7, j + 7, i + 7, j + 9, 1);
                line(g, i + 9, j + 7, i + 9, j + 9, 1);
                line(g, i + 7, j + 9, i + 9, j + 9, 1);
            }
        }

    }

    private void line(Graphics g, int x1, int y1, int x2, int y2, int size) {
        // bresenham
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        boolean isSwap = false;

        if (dy > dx) {
            int tmp = dx;
            dx = dy;
            dy = tmp;
            isSwap = true;
        }

        int D = 2 * dy - dx;

        int x = x1;
        int y = y1;

        for (int i = 1; i <= dx; i++) {
            plotdot(g, x, y, size);

            if (D >= 0) {
                if (isSwap)
                    x += sx;
                else
                    y += sy;

                D -= 2 * dx;
            }

            if (isSwap)
                y += sy;
            else
                x += sx;

            D += 2 * dy;
        }
    }

    private void polygon(Graphics g, int[] x, int[] y, int n) {
        g.fillPolygon(x, y, n);
    }

    private void curve(Graphics g, int[] xPoints, int[] yPoints, int size) {
        for (int i = 0; i <= 1000; i++) {
            double t = i / 1000.0;
            int x = (int) (Math.pow((1 - t), 3) * xPoints[0] + 3 * t * Math.pow((1 - t), 2) * xPoints[1]
                    + 3 * Math.pow((t), 2) * (1 - t) * xPoints[2] + Math.pow(t, 3) * xPoints[3]);
            int y = (int) (Math.pow((1 - t), 3) * yPoints[0] + 3 * t * Math.pow((1 - t), 2) * yPoints[1]
                    + 3 * Math.pow((t), 2) * (1 - t) * yPoints[2] + Math.pow(t, 3) * yPoints[3]);
            plotdot(g, x, y, size);
        }

    }

    private void plotdot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }

    public BufferedImage FloodFill(BufferedImage m, int x, int y, Color targetColour,
            Color replacementColor) {
        Graphics2D g2 = m.createGraphics();
        Queue<Point> q = new LinkedList<>();
        if (m.getRGB(x, y) == targetColour.getRGB()) {
            g2.setColor(replacementColor);
            plotdot(g2, x, y, 1);
            q.add(new Point(x, y));
        }
        while (!q.isEmpty()) {
            Point p = q.poll();
            // s
            if (p.y < 600 && m.getRGB(p.x, p.y + 1) == targetColour.getRGB()) {
                g2.setColor(replacementColor);
                plotdot(g2, p.x, p.y + 1, 1);
                q.add(new Point(p.x, p.y + 1));
            }
            // n
            if (p.y > 0 && m.getRGB(p.x, p.y - 1) == targetColour.getRGB()) {
                g2.setColor(replacementColor);
                plotdot(g2, p.x, p.y - 1, 1);
                q.add(new Point(p.x, p.y - 1));
            }
            // e
            if (p.x < 600 && m.getRGB(p.x + 1, p.y) == targetColour.getRGB()) {
                g2.setColor(replacementColor);
                plotdot(g2, p.x + 1, p.y, 1);
                q.add(new Point(p.x + 1, p.y));
            }
            // w
            if (p.x > 0 && m.getRGB(p.x - 1, p.y) == targetColour.getRGB()) {
                g2.setColor(replacementColor);
                plotdot(g2, p.x - 1, p.y, 1);
                q.add(new Point(p.x - 1, p.y));
            }
        }
        return m;
    }

    public BufferedImage FloodFill2(BufferedImage m, int x, int y, Color targetColour,
            Color replacementColor) {
        Graphics2D g2 = m.createGraphics();
        Queue<Point> q = new LinkedList<>();

        if (m.getRGB(x, y) != targetColour.getRGB()) {
            g2.setColor(replacementColor);
            plotdot(g2, x, y, 1);
            q.add(new Point(x, y));
        }
        while (!q.isEmpty()) {
            Point p = q.poll();
            // s
            if (p.y < 600 && m.getRGB(p.x, p.y + 1) != targetColour.getRGB()) {
                // System.out
                // .println(p.x + " " + (p.y + 1) + " " + m.getRGB(p.x, p.y) + " " +
                // targetColour.getRGB() + " "
                // + q.size());
                g2.setColor(replacementColor);
                plotdot(g2, p.x, p.y + 1, 1);
                q.add(new Point(p.x, p.y + 1));
            }
            // n
            if (p.y > 0 && m.getRGB(p.x, p.y - 1) != targetColour.getRGB()) {
                g2.setColor(replacementColor);
                plotdot(g2, p.x, p.y - 1, 1);
                q.add(new Point(p.x, p.y - 1));
            }
            // e
            if (p.x < 600 && m.getRGB(p.x + 1, p.y) != targetColour.getRGB()) {
                g2.setColor(replacementColor);
                plotdot(g2, p.x + 1, p.y, 1);
                q.add(new Point(p.x + 1, p.y));
            }
            // w
            if (p.x > 0 && m.getRGB(p.x - 1, p.y) != targetColour.getRGB()) {
                g2.setColor(replacementColor);
                plotdot(g2, p.x - 1, p.y, 1);
                q.add(new Point(p.x - 1, p.y));
            }
        }
        return m;
    }
}