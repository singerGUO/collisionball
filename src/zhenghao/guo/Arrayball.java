package zhenghao.guo;



	

		import java.awt.Color;
		import java.awt.Graphics;
		import javax.swing.JFrame;
		import java.util.*;

		public class Arrayball extends JFrame {

		    static int width = 800;
		    static int height = 600;
		    static int R, G, B;
		    static Color[] colors = new Color[5];
		    static int[] coordinatesX = new int[5];
		    static int[] coordinatesY = new int[5];
		    static int[] sizes = new int[5];
		    static int[] speedX = new int[5];
		    static int[] speedY = new int[5];

		    public Arrayball() {
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
		        colors[0] = new Color(R, G, B);

		        coordinatesX[0] = rand.nextInt(width);
		        coordinatesY[0] = rand.nextInt(height);
		        sizes[0] = rand.nextInt(90) + 20;
		        speedX[0] = rand.nextInt(5) + 1;
		        speedY[0] = rand.nextInt(5) + 1;
		    }

		    public static void createBall2() {
		        Random rand = new Random();   // for random number generator
		        R = rand.nextInt(256);
		        G = rand.nextInt(256);
		        B = rand.nextInt(256);
		        colors[1] = new Color(R, G, B);

		        coordinatesX[1] = rand.nextInt(width);
		        coordinatesY[1] = rand.nextInt(height);
		        sizes[1] = rand.nextInt(90) + 20;
		        speedX[1] = rand.nextInt(5) + 1;
		        speedX[1] = rand.nextInt(5) + 1;
		    }

		    public static void createBall3() {
		        Random rand = new Random();   // for random number generator
		        R = rand.nextInt(256);
		        G = rand.nextInt(256);
		        B = rand.nextInt(256);
		        colors[2] = new Color(R, G, B);

		        coordinatesX[2] = rand.nextInt(width);
		        coordinatesY[2] = rand.nextInt(height);
		        sizes[2] = rand.nextInt(90) + 20;
		        speedX[2] = rand.nextInt(5) + 1;
		        speedY[2] = rand.nextInt(5) + 1;
		    }

		    public static void createStar1() {
		        Random rand = new Random();   // for random number generator
		        R = rand.nextInt(256);
		        G = rand.nextInt(256);
		        B = rand.nextInt(256);
		        colors[3] = new Color(R, G, B);

		        coordinatesX[3] = rand.nextInt(width);
		        coordinatesY[3] = rand.nextInt(height);
		        sizes[3] = rand.nextInt(90) + 20;
		        speedX[3] = rand.nextInt(5) + 1;
		        speedY[3] = rand.nextInt(5) + 1;
		    }


		    public static void createStar2() {
		        Random rand = new Random();   // for random number generator
		        R = rand.nextInt(256);
		        G = rand.nextInt(256);
		        B = rand.nextInt(256);
		        colors[4] = new Color(R, G, B);

		        coordinatesX[4] = rand.nextInt(width);
		        coordinatesY[4] = rand.nextInt(height);
		        sizes[4] = rand.nextInt(90)+20;
		        speedX[4] = rand.nextInt(5) + 1;
		        speedY[4] = rand.nextInt(5) + 1;
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

		        createCircle(g, colors[0], coordinatesX[0], coordinatesY[0], sizes[0]); //Circle1
		        createCircle(g, colors[1], coordinatesX[1], coordinatesY[1], sizes[1]); //Circle2
		        createCircle(g, colors[2], coordinatesX[2], coordinatesY[2], sizes[2]); //Circle3
		        createStar(g, colors[3], coordinatesX[3], coordinatesY[3],sizes[3]); //Star1
		        createStar(g, colors[4], coordinatesX[4], coordinatesY[4],sizes[4]); //Star2

		        //CheckCollision
		        coordinatesX[0] += speedX[0];
		        if ((coordinatesX[0] >= width-sizes[0]) || (coordinatesX[0] <= 0)) {
		            speedX[0] = speedX[0] * -1;
		        }
		        coordinatesY[0] += speedY[0];
		        if ((coordinatesY[0] >= height-sizes[0]) || (coordinatesY[0] <= 0)) {
		            speedY[0] = speedY[0] * -1;
		        }

		        coordinatesX[1] += speedX[1];
		        if ((coordinatesX[1] >= width) || (coordinatesX[1] <= 0)) {
		            speedX[1] = speedX[1] * -1;
		        }
		        coordinatesY[1] += speedY[1];
		        if ((coordinatesY[1] >= height-sizes[1]) || (coordinatesY[1] <= 0)) {
		            speedY[1] = speedY[1] * -1;
		        }

		        coordinatesX[2] += speedX[2];
		        if ((coordinatesX[2] >= width-sizes[2]) || (coordinatesX[2] <= 0)) {
		            speedX[2] = speedX[2] * -1;
		        }
		        coordinatesY[2] += speedY[2];
		        if ((coordinatesY[2] >= height-sizes[2]) || (coordinatesY[2] <= 0)) {
		            speedY[2] = speedY[2] * -1;
		        }

		        coordinatesX[3] += speedX[3];
		        if ((coordinatesX[3] >= width-sizes[3] ) || (coordinatesX[3] <= sizes[3])) {
		            speedX[3] = speedX[3] * -1;
		        }
		        coordinatesY[3] += speedY[3];
		        if ((coordinatesY[3] >= height-sizes[3] ) || (coordinatesY[3] <= sizes[3])) {
		            speedY[3] = speedY[3] * -1;
		        }

		        coordinatesX[4] += speedX[4];
		        if ((coordinatesX[4] >= width-sizes[4] ) || (coordinatesX[4] <= sizes[4])) {
		            speedX[4] = speedX[4] * -1;
		        }
		        coordinatesY[4] += speedY[4];
		        if ((coordinatesY[4] >= height-sizes[4] ) || (coordinatesY[4] <= sizes[4])) {
		            speedY[4] = speedY[4] * -1;
		        }

		        double distance = Math.hypot(coordinatesX[0] - coordinatesX[1], coordinatesY[0] - coordinatesY[1]);
		        if(distance <= (sizes[0] / 2 + sizes[1] / 2)) {
		        	speedX[0] = speedX[0] * -1;
		        	speedY[0] = speedY[0] * -1;
		        	speedX[1] = speedX[1] * -1;
		        	speedY[1] = speedY[1] * -1;
		        }

		        double distance2 = Math.hypot(coordinatesX[0] - coordinatesX[2], coordinatesY[0] - coordinatesY[2]);
		        if(distance2 <= (sizes[0] / 2 + sizes[2] / 2)) {
		            speedX[0] = speedX[0] * -1;
		            speedY[0] = speedY[0] * -1;
		            speedX[1] = speedX[1] * -1;
		            speedY[1] = speedY[1] * -1;
		        }

		        double distance3 = Math.hypot((coordinatesX[0] + sizes[0] / 2) - coordinatesX[3], (coordinatesY[0] + sizes[0] / 2) - coordinatesY[3]);
		        if(distance3 <= (sizes[0] / 2 + sizes[3] / 2)) {
		            speedX[0] = speedX[0] * -1;
		            speedY[0] = speedY[0] * -1;
		            speedX[3] = speedX[3] * -1;
		            speedX[4] = speedX[4] * -1;
		        }

		        double distance4 = Math.hypot((coordinatesX[0] + sizes[0] / 2) - coordinatesX[4], (coordinatesY[0] + sizes[0] / 2) - coordinatesY[4]);
		        if(distance4 <=(sizes[0] / 2 + sizes[4] / 2)) {
		            speedX[0] = speedX[0] * -1;
		            speedY[0] = speedY[0] * -1;
		            speedX[4] = speedX[4] * -1;
		            speedY[4] = speedY[4] * -1;
		        }

		        double distance5 = Math.hypot(coordinatesX[1] - coordinatesX[2], coordinatesY[1] - coordinatesY[2]);
		        if(distance5 <= (sizes[1] / 2 + sizes[2] / 2)) {
		        	speedX[1] = speedX[1] * -1;
		        	speedY[1] = speedY[1] * -1;
		        	speedX[2] = speedX[2] * -1;
		        	speedY[2] = speedY[2] * -1;
		        }

		        double distance6 = Math.hypot((coordinatesX[1] + sizes[1] / 2) - coordinatesX[3], (coordinatesY[1] + sizes[1] / 2) - coordinatesY[3]);
		        if(distance6 <= (sizes[1] / 2 + sizes[3] / 2)) {
		            speedX[1] = speedX[1] * -1;
		            speedY[1] = speedY[1] * -1;
		            speedX[3] = speedX[3] * -1;
		            speedY[3] = speedY[3] * -1;
		        }

		        double distance7 = Math.hypot((coordinatesX[1] + sizes[1] / 2) - coordinatesX[4], (coordinatesY[1] + sizes[1] / 2) - coordinatesY[4]);
		        if(distance7 <= (sizes[1] / 2 + sizes[4] / 2)) {
		            speedX[1] = speedX[1] * -1;
		            speedY[1] = speedY[1] * -1;
		            speedX[4] = speedX[4] * -1;
		            speedY[4] = speedY[4] * -1;
		        }

		        double distance8 = Math.hypot((coordinatesX[2] + sizes[2] / 2) - coordinatesX[3], (coordinatesY[2] + sizes[2] / 2) - coordinatesY[3]);
		        if(distance8 <= (sizes[2] / 2 + sizes[3] / 2)) {
		            speedX[2] = speedX[2] * -1;
		            speedY[2] = speedY[2] * -1;
		            speedX[3] = speedX[3] * -1;
		            speedY[3] = speedY[3] * -1;
		        }

		        double distance9 = Math.hypot((coordinatesX[2] + sizes[2] / 2) - coordinatesX[4], (coordinatesY[2] + sizes[2] / 2) - coordinatesY[4]);
		        if(distance9 <= (sizes[2] / 2 + sizes[4] / 2)) {
		            speedX[2] = speedX[2] * -1;
		            speedY[2] = speedY[2] * -1;
		            speedX[4] = speedX[4] * -1;
		            speedY[4] = speedY[4] * -1;
		        }

		        double distance10 = Math.hypot(coordinatesX[3] -coordinatesX[4], coordinatesY[3] - coordinatesY[4]);
		        if(distance10  <= (sizes[3] / 2 + sizes[4] / 2)) {
		            speedX[3] = speedX[3] * -1;
		            speedY[3] = speedY[3] * -1;
		            speedX[4] = speedX[4] * -1;
		            speedY[4] = speedY[4] * -1;
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
		        new Arrayball();
		    }
}

		

