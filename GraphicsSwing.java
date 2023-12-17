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

        g2.setColor(new Color(44, 53, 123));
        g2.fillRect(0, 0, 600, 600);

        // background
        g2.setColor(Color.WHITE);
        for (int i = 0; i < 600; i += 5) {
            for (int j = 0; j < 600; j += 5) {
                plotdot(g2, i, j, 2);
            }
        }

        Color areaBunny = new Color(255, 255, 255);
        Color frameBunny = new Color(31, 41, 111);
        g2.setColor(areaBunny);
        drawBunny(g2, 63, 0, 1);
        buffer = FloodFill2(buffer, 64, 1, areaBunny, areaBunny); // body
        buffer = FloodFill2(buffer, 87, 371, areaBunny, areaBunny); // left arm
        buffer = FloodFill2(buffer, 199, 561, areaBunny, areaBunny); // left leg
        buffer = FloodFill2(buffer, 592, 453, areaBunny, areaBunny); // tail
        g2.setColor(frameBunny);
        drawBunny(g2, 63, 0, 4);

        Color frameText = new Color(43, 53, 134);
        Color areaText = new Color(255, 255, 254);
        g2.setColor(areaText);
        H(g2, 0, 0, 1);
        P(g2, 0, 0, 1);
        P(g2, 0, 0, 1);
        Y(g2, 0, 0, 1);
        N(g2, 122, 400, 1);
        // buffer = FloodFill2(buffer, 124, 402, areaText, areaText);
        buffer = FloodFillGradient(buffer, 123, 401, 124 + 67, 401 + 158, areaText, frameBunny, areaText);
        W(g2, 193, 400, 1);
        buffer = FloodFillGradient(buffer, 194, 401, 194 + 106, 401 + 158, areaText, frameBunny, areaText);
        // buffer = FloodFill2(buffer, 195, 402, areaText, areaText);
        J(g2, 294, 471, 1);
        // buffer = FloodFill2(buffer, 296, 473, areaText, areaText);
        buffer = FloodFillGradient(buffer, 294 + 23, 471 - 70, 294 + 52, 471 + 87, areaText, frameBunny, areaText);
        N(g2, 352, 400, 1);
        // buffer = FloodFill2(buffer, 354, 402, areaText, areaText);
        buffer = FloodFillGradient(buffer, 353, 401, 353 + 67, 401 + 158, areaText, frameBunny, areaText);
        S(g2, 422, 400, 1);
        // buffer = FloodFill2(buffer, 443, 420, areaText, areaText);
        buffer = FloodFillGradient(buffer, 423 + 30, 401, 423 + 69, 401 + 158, areaText, frameBunny, areaText);

        g2.setColor(frameText);
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

    private void drawBunny(Graphics g, int x, int y, int size) {
        curve(g, new int[] { x, x - 30, x - 30, x }, new int[] { y, y + 30, y + 129, y + 159 }, size);
        curve(g, new int[] { x, x - 33, x - 33, x }, new int[] { y + 159, y + 159, y + 224, y + 234 }, size);
        curve(g, new int[] { x, x + 16, x + 87, x + 122 }, new int[] { y + 234, y + 262, y + 264, y + 295 }, size);

        // left arm
        curve(g, new int[] { x + 121, x + 45, x + 45, x - 31 }, new int[] { y + 296, y + 344, y + 344, y + 305 },
                size);
        curve(g, new int[] { x - 31, x - 45, x - 45, x - 63 }, new int[] { y + 305, y + 303, y + 303, y + 306 },
                size);
        curve(g, new int[] { x + 93, x + 21, x - 47, x - 63 }, new int[] { y + 434, y + 443, y + 421, y + 387 },
                size);

        curve(g, new int[] { x + 123, x + 82, x + 82, x + 91 }, new int[] { y + 294, y + 344, y + 408, y + 408 }, size);
        curve(g, new int[] { x + 91, x + 91, x + 202, x + 257 }, new int[] { y + 390, y + 563, y + 563, y + 563 },
                size);
        curve(g, new int[] { x + 280, x + 252, x + 252, x + 256 }, new int[] { y + 537, y + 547, y + 600, y + 600 },
                size);

        curve(g, new int[] { x + 471, x + 508, x + 508, x + 471 }, new int[] { y + 600, y + 550, y + 437, y + 419 },
                size);
        curve(g, new int[] { x + 471, x + 447, x + 372, x + 366 }, new int[] { y + 419, y + 397, y + 383, y + 344 },
                size);
        curve(g, new int[] { x + 347, x + 387, x + 447, x + 487 }, new int[] { y + 350, y + 336, y + 336, y + 354 },
                size);
        curve(g, new int[] { x + 487, x + 511, x + 537, x + 511 }, new int[] { y + 354, y + 373, y + 338, y + 323 },
                size);
        curve(g, new int[] { x + 517, x + 524, x + 531, x + 516 }, new int[] { y + 329, y + 337, y + 317, y + 305 },
                size);
        curve(g, new int[] { x + 524, x + 532, x + 537, x + 524 }, new int[] { y + 314, y + 322, y + 303, y + 287 },
                size);
        curve(g, new int[] { x + 524, x + 489, x + 341, x + 273 }, new int[] { y + 287, y + 238, y + 240, y + 259 },
                size);
        curve(g, new int[] { x + 273, x + 300, x + 427, x + 427 }, new int[] { y + 259, y + 250, y + 237, y + 109 },
                size);
        curve(g, new int[] { x + 427, x + 437, x + 440, x + 416 }, new int[] { y + 109, y + 117, y + 90, y + 63 },
                size);
        line(g, x + 416, y + 63, x + 423, y + 63, size);
        curve(g, new int[] { x + 423, x + 403, x + 395, x + 392 }, new int[] { y + 63, y + 47, y + 32, y },
                size);

        // left leg
        curve(g, new int[] { x + 134, x + 109, x + 109, x + 115 }, new int[] { y + 526, y + 536, y + 600, y + 600 },
                size);
        curve(g, new int[] { x + 257, x + 245, x + 239, x + 228 }, new int[] { y + 563, y + 592, y + 597, y + 600 },
                size);
        // left boot
        curve(g, new int[] { x + 110, x + 56, x + 38, x + 35 }, new int[] { y + 569, y + 575, y + 586, y + 600 },
                size);

        // tail
        curve(g, new int[] { x + 496, x + 517, x + 529, x + 537 }, new int[] { y + 529, y + 536, y + 536, y + 530 },
                size);
        curve(g, new int[] { x + 482, x + 497, x + 521, x + 537 }, new int[] { y + 429, y + 404, y + 392, y + 413 },
                size);

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

    private BufferedImage FloodFillGradient(BufferedImage m, int xStart, int yStart, int xEnd, int yEnd,
            Color startColor, Color endColor, Color target) {
        Graphics2D g2 = m.createGraphics();
        Queue<Point> q = new LinkedList<>();

        float ratio = (float) (yStart - yStart) / (yEnd - yStart - 1);

        Color lineColor = interpolateColor(startColor, endColor, ratio);
        Color lineColor1 = interpolateColor(startColor, endColor, ratio);
        Color lineColor2 = interpolateColor(startColor, endColor, ratio);

        if (m.getRGB(xStart, yStart) != target.getRGB()) {
            g2.setColor(lineColor);
            plotdot(g2, xStart, yStart, 1);
            q.add(new Point(xStart, yStart));
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            ratio = (float) (p.y - yStart) / (yEnd - yStart - 1);
            lineColor = interpolateColor(startColor, endColor, ratio);

            ratio = (float) (p.y - yStart - 1) / (yEnd - yStart - 1);
            lineColor1 = interpolateColor(startColor, endColor, ratio);

            ratio = (float) (p.y - yStart + 1) / (yEnd - yStart - 1);
            lineColor2 = interpolateColor(startColor, endColor, ratio);

            // s
            if (p.y + 1 < 600 && (m.getRGB(p.x, p.y + 1) != target.getRGB())) {
                if (m.getRGB(p.x, p.y + 1) != lineColor2.getRGB()) {
                    g2.setColor(lineColor2);
                    plotdot(g2, p.x, p.y + 1, 1);
                    q.add(new Point(p.x, p.y + 1));
                }
            }
            // n
            if (p.y - 1 > 0 && (m.getRGB(p.x, p.y - 1) != target.getRGB())) {
                if (m.getRGB(p.x, p.y - 1) != lineColor1.getRGB()) {
                    g2.setColor(lineColor1);
                    plotdot(g2, p.x, p.y - 1, 1);
                    q.add(new Point(p.x, p.y - 1));
                }
            }
            // e
            if (p.x + 1 < 600 && (m.getRGB(p.x + 1, p.y) != target.getRGB())) {
                if (m.getRGB(p.x + 1, p.y) != lineColor.getRGB()) {
                    g2.setColor(lineColor);
                    plotdot(g2, p.x + 1, p.y, 1);
                    q.add(new Point(p.x + 1, p.y));
                }
            }
            // w
            if (p.x - 1 > 0 && (m.getRGB(p.x - 1, p.y) != target.getRGB())) {
                if (m.getRGB(p.x - 1, p.y) != lineColor.getRGB()) {
                    g2.setColor(lineColor);
                    plotdot(g2, p.x - 1, p.y, 1);
                    q.add(new Point(p.x - 1, p.y));
                }
            }

        }
        return m;
    }

    private Color interpolateColor(Color startColor, Color endColor, float ratio) {
        int red = Math.max(0, Math.min(255, (int) (startColor.getRed() * (1 - ratio) + endColor.getRed() * ratio)));
        int green = Math.max(0,
                Math.min(255, (int) (startColor.getGreen() * (1 - ratio) + endColor.getGreen() * ratio)));
        int blue = Math.max(0, Math.min(255, (int) (startColor.getBlue() * (1 - ratio) + endColor.getBlue() * ratio)));

        return new Color(red, green, blue);
    }

}