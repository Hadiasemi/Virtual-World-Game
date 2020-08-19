import processing.core.PImage;

import java.util.List;

public abstract class EntityImage extends ActionEntity{

    private int animationPeriod;

    public EntityImage(Point position,
                       List<PImage> images,
                       int imageIndex,
                       int actionPeriod,
                       int animationPeriod) {
        super(position, images, imageIndex, actionPeriod);
        this.animationPeriod = animationPeriod;
    }

    public void nextImage(){int imageIndex;
            imageIndex= (this.getImageIndex() + 1) % this.getImages().size();
                        this.setImageIndex(imageIndex);}
    public  int getAnimationPeriod(){return this.animationPeriod;};

    public  boolean adjacent(Point p1, Point p2) {
        return (p1.x == p2.x && Math.abs(p1.y - p2.y) == 1) || (p1.y == p2.y
                && Math.abs(p1.x - p2.x) == 1);
    }
}
