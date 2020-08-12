import processing.core.PImage;

import java.util.List;
import java.util.Optional;

public class Miner_Not_Full extends EntityMiner {

    private String id;

    private int resourceCount;

    public Miner_Not_Full(

            String id,
            Point position,
            List<PImage> images,
            int resourceLimit,
            int resourceCount,
            int actionPeriod,
            int animationPeriod,int imageIndex)
    {
        super(position, images, imageIndex, actionPeriod, animationPeriod,resourceLimit);
        this.id = id;
        this.resourceCount = resourceCount;

    }




    protected   void executeActivity(

            WorldModel world,
            ImageStore imageStore,
            EventScheduler scheduler)
    {
        Optional<Entity> notFullTarget =
                world.findNearest(this.getPosition(), Ore.class);

        if (!notFullTarget.isPresent() || !move( world,
                notFullTarget.get(),
                scheduler)
                || !transformNotFull( world, scheduler, imageStore))
        {
            scheduler.scheduleEvent( this,
                    Factory.createActivityAction(this, world, imageStore),
                    this.getActionPeriod());
        }
    }


    protected boolean move(

            WorldModel world,
            Entity target,
            EventScheduler scheduler)
    {
        if (adjacent(this.getPosition(), target.getPosition())) {
            this.resourceCount += 1;
            world.removeEntity(target);
            scheduler.unscheduleAllEvents( target);

            return true;
        }
        else {
            Point nextPos = nextPosition(world, target.getPosition());

            _move(world,scheduler,nextPos);
            return false;
        }
    }

    public boolean transformNotFull(

            WorldModel world,
            EventScheduler scheduler,
            ImageStore imageStore)
    {
        if (this.resourceCount >= this.getResourceLimit()) {
            Miner_Full miner = Factory.createMinerFull(this.id,this.getResourceLimit(),this.getPosition(),this.getActionPeriod(),this.getAnimationPeriod(),this.getImages());

            _transform(world,scheduler,imageStore,miner);

            return true;
        }

        return false;
    }

}
