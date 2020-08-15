import processing.core.PImage;

import java.util.List;
import java.util.Optional;

public class Goldfish extends EntityImage {

    public Goldfish(Point position,
                    List<PImage> images,
                    int imageIndex,
                    int actionPeriod,
                    int animationPeriod)
    {
        super(position, images, imageIndex, actionPeriod, animationPeriod);
    }
    protected   void executeActivity(

            WorldModel world,
            ImageStore imageStore,
            EventScheduler scheduler)
    {
        scheduler.scheduleEvent(this,
                Factory.createAnimationAction(this, 4),0);
    }

}
