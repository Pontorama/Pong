import java.awt.event.KeyEvent;

public class Racket extends GameObject{

    private int upkey;
    private int downkey;
    private int racketnr;

    public Racket(int upkey, int downkey, int racketnr) {
        this.upkey = upkey;
        this.downkey = downkey;
        this.racketnr = racketnr;
        this.speed = Commons.RACKET_SPEED;
        InitRacket();
    }

    void InitRacket(){

        loadImage(Config.racket1ImgPath);
        getImageDimensions();

        resetState();
    }

    void move(){
        this.y += (int)(this.speed * this.dir.y);
    }

    void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if(key == this.upkey){
            this.dir.y = -1;
        }else if(key == this.downkey){
            this.dir.y = 1;
        }
    }

    void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if(key == this.upkey || key == this.downkey){
            this.dir.y = 0;
        }
    }

    public void resetState(){
        this.setY(Commons.INIT_PEDAL1_Y);
        if(this.racketnr == 1){
            this.setX(Commons.INIT_PEDAL1_X);
        }else{
            this.setX(Commons.INIT_PEDAL2_X);

        }
    }

}
