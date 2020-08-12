import processing.core.PImage;

import java.util.List;
import java.util.Optional;

public abstract class EntityResource extends EntityImage{



    public EntityResource(Point position, List<PImage> images, int imageIndex, int actionPeriod, int animationPeriod) {
        super(position, images, imageIndex, actionPeriod, animationPeriod);

    }



    protected void  _move(WorldModel world,
                         EventScheduler scheduler,Point nextPos){

        if (!this.getPosition().equals(nextPos)) {
            Optional<Entity> occupant = world.getOccupant(nextPos);
            if (occupant.isPresent()) {
                scheduler.unscheduleAllEvents( occupant.get());
            }

            world.moveEntity( this, nextPos);
        }


    }

    protected  abstract boolean move(WorldModel world, Entity target,EventScheduler scheduler);

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


