import java.awt.*;
import java.awt.*;
import java.util.*;
/**
 * Program that generates an animated scene.
 * Partial code provided by CSC 116 project 2 PDF
 * https://pages.github.ncsu.edu/engr-csc116-staff/2018-fall/projects/project2/part2
 *
 * @author Sarah Worley
 */

public class Animation {
    /**
     * Declares the variables, computes the position, and prints the results.
     *
     * @param args command line argument. */

    /** Panel width Constant. */
    public static final int WIDTH = 500;
    /** Panel Height Constant. */
    public static final int HEIGHT = 400;
    /** Sleep time Constant. */
    public static final int SLEEP_TIME = 200;
    /** Animation X axis Constant. */
    public static final int INITIAL_X = 190;
    /** Animation y axis Constant. */
    public static final int INITIAL_Y = 330;
    /** Update Constant. */
    public static final int NUMBER_OF_UPDATES = 70;
    /** X axis incrementor. */
    public static final int DX = 5;

    /** The main method creates the animation by repeatedly drawing the background
    * and figure, then "sleeping" (pausing) for a short time.
    */

    public static void main (String[] args) {
        //Draws panel.
        DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
        Graphics g = panel.getGraphics();

        int x = INITIAL_X;
        int y = INITIAL_Y;
        // Creates animation for car and updats background. 
        for (int i = 0; i < NUMBER_OF_UPDATES; i++) {
            drawBackground(g);
            drawFigure(g, x + DX * i, y);
            panel.sleep(SLEEP_TIME);
        }

        System.out.println("\n*CLOSE the Drawing Panel to exit the program*");
    }

    /** Draws a plain blue (sky) background, house with features, sun and grass.
    * @param g Imports graphics to the drawBackground method.
    */
    public static void drawBackground(Graphics g) {
        //Sky.
        Color sky = new Color(135, 206, 250);
        g.setColor(sky);
        g.fillRect(0,0,WIDTH,HEIGHT);
        // Draws Ground.
        g.setColor(Color.GREEN);
        g.fillRect(0, 370, 500, 30);
        //Brick house.
        Color house = new Color(121, 27, 25);
        g.setColor(house);
        g.fillRect(20, 250, 150, 140);
        //Door.
        g.setColor(Color.DARK_GRAY);
        g.fillRect(80, 340, 30, 50);
        //Windows.
        Color window = new Color(240, 230, 140);
        g.setColor(window);
        g.fillRect(35, 290, 30, 40);
        g.fillRect(120, 290, 30, 40);
        //Window panes.
        g.setColor(Color.BLACK);
        g.drawLine(50, 290, 50, 330);
        g.drawLine(135, 290, 135, 330);
        g.drawLine(35, 310, 65, 310);
        g.drawLine(120, 310, 150, 310);
        //Roof top.
        g.setColor(Color.DARK_GRAY);
        Polygon poly = new Polygon();
        poly.addPoint(95 , 180 );
        poly.addPoint(10, 260);
        poly.addPoint(180, 260);
        g.fillPolygon(poly);
        //Sun.
        g.setColor(Color.YELLOW);
        g.fillOval(390, 30, 100, 100);
    }

    /** draws car that will be animated
    * @param g imports graphics into drawFigure method.
    * @param x Gives us initial x axis point for car to start at.
    * @param y Gives us initial y axis point for car to start at.
    */
    public static void drawFigure(Graphics g, int x, int y) {
        //Car windows/ top.
        g.setColor(Color.BLACK);
        g.drawOval(x + 20, y - 20 , 60, 50);
        // Stick figure head.
        g.fillOval(x + 60, y - 10, 12, 12);
        // Stick figure body.
        g.drawLine(x + 65, y + 10, x + 65, y);
        //Car body.
        g.setColor(Color.RED);
        g.fillOval(x, y + 10, 100, 40);
        // Tires.
        g.setColor(Color.WHITE);
        g.fillOval(x + 10, y + 40, 20, 20);
        g.fillOval(x + 70, y + 40, 20, 20);
        // Head lights.
        g.fillOval(x + 90, y + 25 , 10, 10);
    }
}
