import processing.core.PImage;

import java.util.List;

public class Candle extends EntityImage {

    public Candle(Point position,
                  List<PImage> images,
                  int imageIndex,
                  int actionPeriod,
                  int animationPeriod)
    {
        super(position, images, imageIndex, actionPeriod, animationPeriod);
    }
    public void executeActivity(WorldModel world,
                                ImageStore imageStore,
                                EventScheduler scheduler) {
        this.scheduleActions(scheduler, world, imageStore);
    }


}
