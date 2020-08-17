import processing.core.PImage;

import java.util.List;

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
        long nextPeriod = this.getActionPeriod();
        scheduler.scheduleEvent( this,
                Factory.createActivityAction(this, world, imageStore),
                nextPeriod);
    }
    public  void scheduleActions(

            EventScheduler scheduler,
            WorldModel world,
            ImageStore imageStore)
    {
        super.scheduleActions(scheduler,world,imageStore);
        scheduler.scheduleEvent( this, Factory.createAnimationAction(this,
                10),
                this.getAnimationPeriod());

    }



}
