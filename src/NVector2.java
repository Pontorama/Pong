public class NVector2 extends Vector2 {
    public NVector2(int x, int y){
        super(x,y);
        this.x = this.x/this.getLength();
        this.y = this.y/this.getLength();
    }

    public NVector2(){
        super();
    }
    @Override
    public void setY(double y){
        this.y = y;
        this.y = this.y/this.getLength();
    }
    @Override
    public void setX(double x){
        this.x = x;
        this.x = this.x/this.getLength();
    }
}