import java.util.Random;

public class Ball extends GameObject {

    public boolean isTouching = false;
    public Ball() {
        InitBall();
    }

    private void InitBall() {
        Random r = new Random();
        this.dir.x = (r.nextInt(2) > 0) ? -1 : 1;
        this.dir.y = r.nextDouble() * ((r.nextInt(2) > 0) ? -1 : 1);
        this.setX(Commons.INIT_BALL_X);
        this.setY(Commons.INIT_BALL_Y);
        this.speed = Commons.BALL_SPEED;
        loadImage(Config.ballImgPath);
        getImageDimensions();
        this.setY(Commons.INIT_BALL_Y);
        this.setX(Commons.INIT_BALL_X);
}

    public void move() {
        x += dir.x*this.speed;
        this.y += (int) (this.speed * dir.y);

        if (y <=Commons.TOP_EDGE) {
            this.setY(Commons.TOP_EDGE);
            this.setYDir(this.getYDir() * -1);
        }

        if(this.y+this.getImageHeight() >= Commons.BOTTOM_EDGE){
            this.setY(Commons.BOTTOM_EDGE-this.getImageHeight());
            this.setYDir(this.getYDir()*-1);
        }
    }

    public void resetState(){
        InitBall();
    }

    public void bounce(Racket r){
        this.setXDir(this.getXDir()*-1);
        this.setYDir(this.getMidPoint().y - r.getMidPoint().y);
        Random ran = new Random();
        if(ran.nextBoolean()){
            this.speed+= 0.5;
        }
    }
}