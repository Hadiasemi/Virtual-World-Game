import processing.core.PImage;

import java.util.List;
import java.util.Optional;

public class Quake extends EntityImage{

    public static final int QUAKE_ANIMATION_REPEAT_COUNT = 10;


    public Quake(Point position, List<PImage> images, int imageIndex, int actionPeriod, int animationPeriod) {
        super(position, images, imageIndex, actionPeriod, animationPeriod);
    }



    public  void scheduleActions(

            EventScheduler scheduler,
            WorldModel world,
            ImageStore imageStore)
    {
                super.scheduleActions(scheduler,world,imageStore);
                scheduler.scheduleEvent( this, Factory.createAnimationAction(this,
                        QUAKE_ANIMATION_REPEAT_COUNT),
                        this.getAnimationPeriod());

    }

    protected   void executeActivity(

            WorldModel world,
            ImageStore imageStore,
            EventScheduler scheduler) {
        scheduler.unscheduleAllEvents(this);
        world.removeEntity(this);
    }


}
