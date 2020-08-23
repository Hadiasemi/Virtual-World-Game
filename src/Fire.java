import processing.core.PImage;
import java.util.List;

public class Fire extends EntityImage {
    public Fire(Point position,
                List<PImage> images,
                int imageIndex,
                int actionPeriod,
                int animationPeriod)
    {
        super(position, images, imageIndex, actionPeriod, animationPeriod);
    }

    protected void executeActivity(
            WorldModel world,
            ImageStore imageStore,
            EventScheduler scheduler)
    {
        this.scheduleActions(scheduler, world, imageStore);
    }

    public void scheduleActions(

            EventScheduler scheduler,
            WorldModel world,
            ImageStore imageStore)
    {
        super.scheduleActions(scheduler,world,imageStore);
        scheduler.scheduleEvent( this, Factory.createAnimationAction(this,
                0),
                this.getAnimationPeriod());

    }
    public String toString()
    {
        return "\"My yellow is yours, your red is mine.\" \n" +
                "Is a Zoroastrian purification chant sung as you hop over\n" +
                "a fire. Symbolically this means to get rid of any sickness\n" +
                "and bad luck, and wish good luck and health in the new year.";
    }
}
