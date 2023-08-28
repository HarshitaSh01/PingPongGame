import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class Window extends JFrame implements Runnable
{
    Graphics2D g2;
    KL KeyListener = new KL();
    Rect playerOne;
    Rect ai;
    Rect ball;

    public Window()  //creating window and setting it up.
    {
        this.setSize(Constants.SCREEN_WIDTH,
                Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(KeyListener);
        g2 = (Graphics2D) this.getGraphics(); //get a simple Graphics object

        playerOne = new Rect(Constants.HZ_PADDING, 40, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);
        ai = new Rect(Constants.SCREEN_WIDTH - Constants.PADDLE_WIDTH - Constants.HZ_PADDING, 40, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);
        ball = new Rect(Constants.SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT / 2, Constants.BALL_WIDTH, Constants.BALL_WIDTH, Constants.PADDLE_COLOR);

    }

    public void update(double dt) //key listener and setting bg color of window.
    {  // print the delta time taken by each operation.
        //System.out.println(""+dt+" seconds passed since the last frame");
        //System.out.println(1/dt + " fps");

        g2.setColor(Color.BLACK);
        g2.fillRect(0,0,Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);

        /*if (KeyListener.isKeyPressed(KeyEvent.VK_UP)){
            System.out.println("The user is pressing the up arrow");
        }
        else if (KeyListener.isKeyPressed(KeyEvent.VK_DOWN)){
            System.out.println("The user is pressing the down arrow");
        }*/

        playerOne.draw(g2);
        ai.draw(g2);
        ball.draw(g2);
    }

    public void run()  // setting and updating time frame value.
    {
        double lastFrameTime = 0.0;
        while (true)
        {
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time; //updating to get the next value of time frame.

            update(deltaTime);

            try{
                Thread.sleep(30);
            }
            catch (Exception e){

            }
        }
    }

}
