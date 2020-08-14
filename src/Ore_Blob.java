import processing.core.PImage;

import java.util.List;
import java.util.Optional;

public class Ore_Blob extends EntityResource{

    private final String QUAKE_KEY = "quake";

    public Ore_Blob(
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
        Optional<Entity> blobTarget =
                world.findNearest( this.getPosition(), Vein.class);
        long nextPeriod = this.getActionPeriod();

        if (blobTarget.isPresent()) {
            Point tgtPos = blobTarget.get().getPosition();

            if (move( world, blobTarget.get(), scheduler)) {
                Quake quake = Factory.createQuake(tgtPos,
                        imageStore.getImageList( QUAKE_KEY));

                world.addEntity( quake);
                nextPeriod += this.getActionPeriod();
                quake.scheduleActions( scheduler, world, imageStore);
            }
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
        if (adjacent(this.getPosition(), target.getPosition())) {
            world.removeEntity(target);
            scheduler.unscheduleAllEvents( target);
            return true;
        }
        else {
            Point nextPos = nextPositionOreBlob( world, target.getPosition());

           _move(world,scheduler,nextPos);
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
                == Ore.class)))
        {
            int vert = Integer.signum(destPos.y - this.getPosition().y);
            newPos = new Point(this.getPosition().x, this.getPosition().y + vert);
            occupant = world.getOccupant( newPos);

            if (vert == 0 || (occupant.isPresent() && !(occupant.get().getClass()
                    == Ore.class)))
            {
                newPos = this.getPosition();
            }
        }

        return newPos;
    }
}
