import processing.core.PImage;

import java.util.List;
import java.util.Optional;

public class BlackSmith extends Entity{

    public BlackSmith(

            Point position,
            List<PImage> images, int imageIndex
            )
    {
        super(position,images,imageIndex);
    }


    public Point getPosition() { return super.getPosition(); }
    public void setPosition(Point position) { super.setPosition(position); }

    public PImage getCurrentImage() {
        return super.getCurrentImage();
    }

}
