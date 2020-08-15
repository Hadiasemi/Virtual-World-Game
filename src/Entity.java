import processing.core.PImage;

import java.util.List;

public abstract class Entity
{
    private Point position;
    private List<PImage> images;
    private int imageIndex;

    public Entity(Point position, List<PImage> images, int imageIndex) {
        this.position = position;
        this.images = images;
        this.imageIndex = imageIndex;
    }


    public Point getPosition(){return position;}
    public void setPosition(Point position){this.position=position;}
    public PImage getCurrentImage(){return this.images.get(this.imageIndex);}

    protected int getImageIndex() {
        return imageIndex;
    }

    protected void setImageIndex(int imageIndex) {
        this.imageIndex = imageIndex;
    }

    protected List<PImage> getImages() {
        return images;
    }
}


