
import java.awt.Image;
import java.awt.Rectangle;

public class Sprite {
    int x,y;
    int imageWidth, imageHeight;

    Image image;

    protected void setX(int x){
        this.x = x;
    }

    int getX(){
        return this.x;
    }


    protected void setY(int y){
        this.y = y;
    }

    int getY(){
        return this.y;
    }

    int getImageWidth(){
        return this.imageWidth;
    }

    int getImageHeight(){
        return this.imageHeight;
    }

    Image getImage(){
        return this.image;
    }

    Rectangle getRect(){
        return new Rectangle(this.x, this.y, this.image.getWidth(null), this.image.getHeight(null));
    }


    void getImageDimensions() {

        this.imageWidth = image.getWidth(null);
        this.imageHeight = image.getHeight(null);
    }

    public Vector2 getMidPoint(){
        return new Vector2((this.getX()+this.imageWidth)/2,(this.getY()+this.imageHeight)/2 );
    }

}
