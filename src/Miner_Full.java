import processing.core.PImage;

import java.util.List;
import java.util.Optional;

public class Miner_Full extends EntityMiner{

      private String id;


    public Miner_Full(Point position, List<PImage> images, int imageIndex, int actionPeriod, int animationPeriod, String id,int resourceLimit) {
        super(position, images, imageIndex, actionPeriod, animationPeriod,resourceLimit);
        this.id = id;

    }




    protected   void executeActivity(

            WorldModel world,
            ImageStore imageStore,
            EventScheduler scheduler)
    {
        Optional<Entity> fullTarget =
                world.findNearest( this.getPosition(), BlackSmith.class);

        if (fullTarget.isPresent() && move( world,
                fullTarget.get(), scheduler))
        {
            this.transformFull( world, scheduler, imageStore);
        }
        else {
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
        if (super.adjacent(this.getPosition(), target.getPosition())) {
            return true;
        }
        else {

            Point nextPos = nextPosition(world,target.getPosition());
            _move(world,scheduler,nextPos);
            return false;
        }
    }


    public void transformFull(

            WorldModel world,
            EventScheduler scheduler,
            ImageStore imageStore)
    {
        Miner_Not_Full miner = Factory.createMinerNotFull(this.id,this.getResourceLimit(),this.getPosition(),
                this.getActionPeriod(),this.getAnimationPeriod(),this.getImages());

        _transform(world,scheduler,imageStore, miner);
    }




}
