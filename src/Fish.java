import java.util.List;
import processing.core.*;

public class Fish extends EntityImage {

    public Fish(Point position, List<PImage> images, int imageIndex, int actionPeriod, int animationPeriod) {
        super(position, images, imageIndex, actionPeriod, animationPeriod);
    }

    // Write the history of the fish
    public String toString()
    {
        return "The fish represents movement and life. Goldfish is also the sign of the last month in Persian calendar (Esfand) and it turning around the bowl is a sign of turning and changing of the year.";
    }

    protected  void executeActivity(

            WorldModel world,
            ImageStore imageStore,
            EventScheduler scheduler)
    {
        scheduleActions(scheduler,world,imageStore);

    }


    public  void scheduleActions(
            EventScheduler scheduler,
            WorldModel world,
            ImageStore imageStore)
    {
        super.scheduleActions(scheduler,world,imageStore);
        scheduler.scheduleEvent( this,
                Factory.createAnimationAction(this, 0),
                this.getAnimationPeriod());

    }


}
