import javax.swing.*;

public class GameObject extends Sprite{
    protected NVector2 dir;

    protected double speed;
    public GameObject(){
        dir = new NVector2();

    }

    protected void loadImage(String filename){
        var ii = new ImageIcon(filename);
        this.image = ii.getImage();
    }

    public void move(Vector2 newPos){
        x = (int)newPos.x;
        y  =(int)newPos.y;
    }

    protected void setYDir(double newYDir){
        this.dir.setY(newYDir);
    }

    protected void setXDir(double newXDir){
        this.dir.setX(newXDir);
    }

    protected double getXDir(){
        return this.dir.x;
    }

    protected double getYDir(){
        return this.dir.y;
    }
}
