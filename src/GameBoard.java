import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameBoard extends JPanel {
    private Ball ball;
    private Racket racket1;
    private Racket racket2;
    private boolean inGame = true;
    private String message;


    public GameBoard(){
        InitBoard();
    }

    private void InitBoard(){

        addKeyListener(new TAdapter());
        setFocusable(true);
        setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));

        gameInit();
    }

    private void gameInit(){
        ball = new Ball();
        racket1 = new Racket(KeyEvent.VK_UP, KeyEvent.VK_DOWN, 1);
        racket2 = new Racket(KeyEvent.VK_W, KeyEvent.VK_S, 2);

        Timer timer = new Timer(Commons.PERIOD, new GameCycle());
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        var g2d = (Graphics2D)g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        if(this.inGame){
            drawObjects(g2d);
        }else{
            gameFinished(g2d);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics2D g2d){

        g2d.drawImage(ball.getImage(), ball.getX(), ball.getY(), ball.getImageWidth(),
                ball.getImageHeight(),this);
        g2d.drawImage(racket1.getImage(), racket1.getX(), racket1.getY(),
                racket1.getImageWidth(), racket1.getImageHeight(),this);
        g2d.drawImage(racket2.getImage(), racket2.getX(), racket2.getY(),
                racket2.getImageWidth(), racket2.getImageHeight(),this);
    }

    private void gameFinished(Graphics2D g2d){
        var font = new Font("Verdana", Font.BOLD, 18);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        g2d.setColor(Color.BLACK);
        g2d.setFont(font);
        g2d.drawString(this.message, (Commons.WIDTH - fontMetrics.stringWidth(this.message)) / 2, Commons.HEIGHT/2);
        font = new Font("Verdana", Font.BOLD, 14);
        g2d.setFont(font);
        fontMetrics = this.getFontMetrics(font);
        String restartText = "Press R to restart";
        g2d.drawString(restartText, (Commons.WIDTH-fontMetrics.stringWidth(restartText))/ 2, (Commons.HEIGHT+30)/2);

    }

    private class TAdapter extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent e){
            racket1.keyReleased(e);
            racket2.keyReleased(e);
            if(e.getKeyCode() == KeyEvent.VK_R){
                resetGame();
            }
        }

        @Override
        public void keyPressed(KeyEvent e){
            racket1.keyPressed(e);
            racket2.keyPressed(e);
        }
    }

    private class GameCycle implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            doGameCycle();
        }
    }

    private void doGameCycle(){
        checkCollision();
        ball.move();
        racket1.move();
        racket2.move();
        repaint();
    }

    private void resetGame(){
        racket1.resetState();
        racket2.resetState();
        ball.resetState();
        this.inGame = true;
    }

    private void stopGame(){
        this.inGame = false;
    }

    private void checkCollision(){
        if(ball.getX() < Commons.GOAL_BORDER){
            this.message = "Player 2 wins!";
            stopGame();
        }

        if(ball.getX() > Commons.WIDTH -Commons.GOAL_BORDER){
            this.message = "Player 1 wins!";
            stopGame();
        }

        if(!ball.isTouching){
            if(ball.getRect().intersects(racket1.getRect())){
                ball.bounce(racket1);
                ball.isTouching = true;
            }else if(ball.getRect().intersects(racket2.getRect())){
                ball.bounce(racket2);
                ball.isTouching = true;
            }
        }else{
            ball.isTouching = false;
        }

    }
}