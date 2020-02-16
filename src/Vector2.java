import java.lang.Math;
public class Vector2 {
    protected double x;
    protected double y;

    public Vector2(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Vector2(){
        this.x = 0;
        this.y = 0;
    }

    public double getLength(){
        return Math.sqrt(x*x + y*y);
    }

    public String toString(){
        return "X: " + this.x + " Y: " +this.y;
    }

    public boolean equals(Vector2 v){
        return this.x == v.x && this.y == v.y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }
}