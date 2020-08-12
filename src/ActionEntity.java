import processing.core.PImage;

import java.util.List;

public abstract class ActionEntity extends Entity {
    private int actionPeriod;

    public ActionEntity(Point position, List<PImage> images, int imageIndex, int actionPeriod) {
        super(position, images, imageIndex);
        this.actionPeriod = actionPeriod;
    }

    protected abstract void executeActivity(WorldModel world,
                                         ImageStore imageStore,
                                         EventScheduler scheduler);

       public  void scheduleActions(
                EventScheduler scheduler,
                WorldModel world,
                ImageStore imageStore){
           scheduler.scheduleEvent( this,
                   Factory.createActivityAction(this, world, imageStore),
                   this.actionPeriod);
       }

    protected int getActionPeriod() {
        return actionPeriod;
    }
}
