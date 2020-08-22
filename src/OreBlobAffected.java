import processing.core.PImage;

import java.util.List;
import java.util.Optional;

public class OreBlobAffected extends EntityResource{


    public OreBlobAffected(
            Point position,
            List<PImage> images,
            int actionPeriod,
            int animationPeriod,int imageIndex)
    {
        super(position, images, imageIndex, actionPeriod, animationPeriod);
    }

    protected   void executeActivity(

            WorldModel world,
            ImageStore imageStore,
            EventScheduler scheduler)
    {

        Optional<Entity> blobFire =
                world.findNearest(this.getPosition(), Fire.class);

        long nextPeriod = this.getAnimationPeriod();
        if (move(world, blobFire.get(), scheduler))
        {
            ;
        }
        scheduler.scheduleEvent( this,
                Factory.createActivityAction(this, world, imageStore),
                nextPeriod);
    }

    protected   boolean move(

            WorldModel world,
            Entity target,
            EventScheduler scheduler)
    {
        Optional<Entity> target2 = world.findNearest(this.getPosition(), Dancer.class);

        if (target2.isPresent())
        {
            if(adjacent(this.getPosition(), target2.get().getPosition()))
            {
                world.removeEntity(this);
                scheduler.unscheduleAllEvents(this);
                return true;
            }
        }
        if (adjacent(this.getPosition(), target.getPosition()))
        {
            world.removeEntity(this);
            scheduler.unscheduleAllEvents(this);
            return true;
        }
        else
            {
                Point nextPos = nextPositionOreBlob(world, target.getPosition());
                _move(world, scheduler, nextPos);
                return false;
            }
    }

    public  Point nextPositionOreBlob(
            WorldModel world, Point destPos)
    {
        int horiz = Integer.signum(destPos.x - this.getPosition().x);
        Point newPos = new Point(this.getPosition().x + horiz, this.getPosition().y);

        Optional<Entity> occupant = world.getOccupant(newPos);

        if (horiz == 0 || (occupant.isPresent() && !(occupant.get().getClass()
                == Fire.class)))
        {
            int vert = Integer.signum(destPos.y - this.getPosition().y);
            newPos = new Point(this.getPosition().x, this.getPosition().y + vert);
            occupant = world.getOccupant( newPos);

            if (vert == 0 || (occupant.isPresent() && !(occupant.get().getClass()
                    == Fire.class)))
            {
                newPos = this.getPosition();
            }
        }

        return newPos;
    }
}
