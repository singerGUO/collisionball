package zhenghao.guo;

/*name Zhenghao Guo
 * winter quarter2018
 * students id:950671756
 * In this case, I used the code of star professor provides.
 * For making all the shapes collide with each other, we should calculate all the situation of the change of direction(speed).
 * For example: the wall collision(4sides),circle and star, star and star,circle and circle.
 * when we paint the graph, we need to get call a method with all parameters we set before .  
 * 
 */


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.util.*;

public class Assg4 extends JFrame {

    static int width = 800;
    static int height = 600;
    static int R, G, B;
    static int x1, y1, size1, speedX1, speedY1;
    static int x2, y2, size2, speedX2, speedY2;
    static int x3, y3, size3, speedX3, speedY3;
    static int x4, y4, sizeStar1, speedStarX1, speedStarY1;
    static int x5, y5, sizeStar2, speedStarX2, speedStarY2;
    static Color color1, color2, color3, colorStar1, colorStar2;

    public Assg4() {
        super("Your Title");
        setBounds(100, 100, width, height);  // at your monitor
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void createBall() {
        Random rand = new Random();   // for random number generator
        R = rand.nextInt(256);
        G = rand.nextInt(256);
        B = rand.nextInt(256);
        color1 = new Color(R, G, B);

        x1 = rand.nextInt(width);
        y1 = rand.nextInt(height);
        size1 = rand.nextInt(90) + 20;
        speedX1 = rand.nextInt(5) + 1;
        speedY1 = rand.nextInt(5) + 1;
    }

    public static void createBall2() {
        Random rand = new Random();   // for random number generator
        R = rand.nextInt(256);
        G = rand.nextInt(256);
        B = rand.nextInt(256);
        color2 = new Color(R, G, B);

        x2 = rand.nextInt(width);
        y2 = rand.nextInt(height);
        size2 = rand.nextInt(90) + 20;
        speedX2 = rand.nextInt(5) + 1;
        speedX2 = rand.nextInt(5) + 1;
    }

    public static void createBall3() {
        Random rand = new Random();   // for random number generator
        R = rand.nextInt(256);
        G = rand.nextInt(256);
        B = rand.nextInt(256);
        color3 = new Color(R, G, B);

        x3 = rand.nextInt(width);
        y3 = rand.nextInt(height);
        size3 = rand.nextInt(90) + 20;
        speedX3 = rand.nextInt(5) + 1;
        speedY3 = rand.nextInt(5) + 1;
    }

    public static void createStar1() {
        Random rand = new Random();   // for random number generator
        R = rand.nextInt(256);
        G = rand.nextInt(256);
        B = rand.nextInt(256);
        colorStar1 = new Color(R, G, B);

        x4 = rand.nextInt(width);
        y4 = rand.nextInt(height);
        sizeStar1 = rand.nextInt(90) + 20;
        speedStarX1 = rand.nextInt(5) + 1;
        speedStarY1 = rand.nextInt(5) + 1;
    }

    public static void createStar2() {
        Random rand = new Random();   // for random number generator
        R = rand.nextInt(256);
        G = rand.nextInt(256);
        B = rand.nextInt(256);
        colorStar2 = new Color(R, G, B);

        x5 = rand.nextInt(width);
        y5 = rand.nextInt(height);
        sizeStar2=rand.nextInt(90)+20;
        speedStarX2 = rand.nextInt(5) + 1;
        speedStarY2 = rand.nextInt(5) + 1;
    }

    public void createCircle(Graphics g, Color color, int x, int y, int size){
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    public void createStar(Graphics g, Color color, int x, int y,int size){
        int[] xCoords = new int[10];
        int[] yCoords = new int[10];
        int ang = 90 - 36;
        double rad;
        double PI = 3.14159;

        g.setColor(color);
        for(int i = 0; i < 10; i++) {
            if (i % 2 == 0) rad = size * 0.38;
            else rad = size;
            xCoords[i] += (int)(rad * Math.cos(PI * ang / 180.0));
            yCoords[i] -= (int)(rad * Math.sin(PI * ang / 180.0));
            ang += 36;
            xCoords[i] += x;
            yCoords[i] += y;
        }

        g.fillPolygon(xCoords, yCoords, 10);
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        createCircle(g, color1, x1, y1, size1); //Circle1
        createCircle(g, color2, x2, y2, size2); //Circle2
        createCircle(g, color3, x3, y3, size3); //Circle3
        createStar(g, colorStar1, x4, y4,sizeStar1); //Star1
        createStar(g, colorStar2, x5, y5,sizeStar2); //Star2

        //CheckCollision
        x1 += speedX1;
        if ((x1 >= width-size1) || (x1 <= 0)) {
            speedX1 = speedX1 * -1;
        }
        y1 += speedY1;
        if ((y1 >= height-size1) || (y1 <= 0)) {
            speedY1 = speedY1 * -1;
        }

        x2 += speedX2;
        if ((x2 >= width) || (x2 <= 0)) {
            speedX2 = speedX2 * -1;
        }
        y2 += speedY2;
        if ((y2 >= height-size2) || (y2 <= 0)) {
            speedY2 = speedY2 * -1;
        }

        x3 += speedX3;
        if ((x3 >= width-size3) || (x3 <= 0)) {
            speedX3 = speedX3 * -1;
        }
        y3 += speedY3;
        if ((y3 >= height-size3) || (y3 <= 0)) {
            speedY3 = speedY3 * -1;
        }

        x4 += speedStarX1;
        if ((x4 >= width-sizeStar1 ) || (x4 <= sizeStar1)) {
            speedStarX1 = speedStarX1 * -1;
        }
        y4 += speedStarY1;
        if ((y4 >= height-sizeStar1 ) || (y4 <= sizeStar1)) {
            speedStarY1 = speedStarY1 * -1;
        }

        x5 += speedStarX2;
        if ((x5 >= width-sizeStar2 ) || (x5 <= sizeStar2)) {
            speedStarX2 = speedStarX2 * -1;
        }
        y5 += speedStarY2;
        if ((y5 >= height-sizeStar2 ) || (y5 <= sizeStar2)) {
            speedStarY2 = speedStarY2 * -1;
        }

        double distance = Math.hypot(x1 - x2, y1 - y2);
        if(distance <= (size1 / 2 + size2 / 2)) {
        	speedX1 = speedX1 * -1;
        	speedY1 = speedY1 * -1;
        	speedX2 = speedX2 * -1;
        	speedY2 = speedY2 * -1;
        }

        double distance2 = Math.hypot(x1 - x3, y1 - y3);
        if(distance2 <= (size1 / 2 + size3 / 2)) {
            speedX1 = speedX1 * -1;
            speedY1 = speedY1 * -1;
            speedX2 = speedX2 * -1;
            speedY2 = speedY2 * -1;
        }

        double distance3 = Math.hypot((x1 + size1 / 2) - x4, (y1 + size1 / 2) - y4);
        if(distance3 <= (size1 / 2 + sizeStar1 / 2)) {
            speedX1 = speedX1 * -1;
            speedY1 = speedY1 * -1;
            speedStarX1 = speedStarX1 * -1;
            speedStarX2 = speedStarX2 * -1;
        }

        double distance4 = Math.hypot((x1 + size1 / 2) - x5, (y1 + size1 / 2) - y5);
        if(distance4 <=(size1 / 2 + sizeStar2 / 2)) {
            speedX1 = speedX1 * -1;
            speedY1 = speedY1 * -1;
            speedStarX2 = speedStarX2 * -1;
            speedStarY2 = speedStarY2 * -1;
        }

        double distance5 = Math.hypot(x2 - x3, y2 - y3);
        if(distance5 <= (size2 / 2 + size3 / 2)) {
        	speedX2 = speedX2 * -1;
        	speedY2 = speedY2 * -1;
        	speedX3 = speedX3 * -1;
        	speedY3 = speedY3 * -1;
        }

        double distance6 = Math.hypot((x2 + size2 / 2) - x4, (y2 + size2 / 2) - y4);
        if(distance6 <= (size2 / 2 + sizeStar1 / 2)) {
            speedX2 = speedX2 * -1;
            speedY2 = speedY2 * -1;
            speedStarX1 = speedStarX1 * -1;
            speedStarY1 = speedStarY1 * -1;
        }

        double distance7 = Math.hypot((x2 + size2 / 2) - x5, (y2 + size2 / 2) - y5);
        if(distance7 <= (size2 / 2 + sizeStar2 / 2)) {
            speedX2 = speedX2 * -1;
            speedY2 = speedY2 * -1;
            speedStarX2 = speedStarX2 * -1;
            speedStarY2 = speedStarY2 * -1;
        }

        double distance8 = Math.hypot((x3 + size3 / 2) - x4, (y3 + size3 / 2) - y4);
        if(distance8 <= (size3 / 2 + sizeStar1 / 2)) {
            speedX3 = speedX3 * -1;
            speedY3 = speedY3 * -1;
            speedStarX1 = speedStarX1 * -1;
            speedStarY1 = speedStarY1 * -1;
        }

        double distance9 = Math.hypot((x3 + size3 / 2) - x5, (y3 + size3 / 2) - y5);
        if(distance9 <= (size3 / 2 + sizeStar2 / 2)) {
            speedX3 = speedX3 * -1;
            speedY3 = speedY3 * -1;
            speedStarX2 = speedStarX2 * -1;
            speedStarY2 = speedStarY2 * -1;
        }

        double distance10 = Math.hypot(x4 -x5, y4 - y5);
        if(distance10  <= (sizeStar1 / 2 + sizeStar2 / 2)) {
            speedStarX1 = speedStarX1 * -1;
            speedStarY1 = speedStarY1 * -1;
            speedStarX2 = speedStarX2 * -1;
            speedStarY2 = speedStarY2 * -1;
        }

 

        try {
            Thread.sleep(5);
        } catch (Exception exc) {
        }

        repaint();
    }

    public static void main(String[] args) {
        createBall();
        createBall2();
        createBall3();
        createStar1();
        createStar2();
        new Assg4();
    }
}
