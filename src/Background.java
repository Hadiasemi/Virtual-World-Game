import java.util.List;
import java.util.Optional;

import processing.core.PImage;

public final class Background
{
    private String id;
    private List<PImage> images;
    private int imageIndex;

    public Background(String id, List<PImage> images) {
        this.id = id;
        this.images = images;
    }


    public String getId() { return id; }

    public List<PImage> getImages() { return images; }

    public int getImageIndex() { return imageIndex; }

    public  void setBackground(
            WorldModel world, Point pos)
    {
        if (world.withinBounds(pos)) {
            world.setBackgroundCell( pos,this);
        }
    }

    public  PImage getCurrentImage() {

            return this.images.get(
                    this.imageIndex);
    }






}
