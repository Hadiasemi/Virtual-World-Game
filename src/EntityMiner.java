import processing.core.PImage;

import java.util.List;

public  abstract class EntityMiner extends EntityResource{

    private int resourceLimit;


    public EntityMiner(Point position, List<PImage> images, int imageIndex, int actionPeriod, int animationPeriod,int resourceLimit) {
        super(position, images, imageIndex, actionPeriod, animationPeriod);
        this.resourceLimit=resourceLimit;
    }

    public int getResourceLimit() {
        return resourceLimit;
    }

    public  Point nextPosition(WorldModel world,
                               Point pos)
    {
        int horiz = Integer.signum(pos.x - this.getPosition().x);
        Point newPos = new Point(this.getPosition().x + horiz, this.getPosition().y);

        if (horiz == 0 || world.isOccupied( newPos)) {
            int vert = Integer.signum(pos.y - this.getPosition().y);
            newPos = new Point(this.getPosition().x, this.getPosition().y + vert);

            if (vert == 0 || world.isOccupied( newPos)) {
                newPos = this.getPosition();
            }
        }

        return newPos;
    }

    protected void _transform(WorldModel world,
                           EventScheduler scheduler,
                           ImageStore imageStore,EntityMiner miner){

        world.removeEntity(this);
        scheduler.unscheduleAllEvents( this);

        world.addEntity( miner);
        miner.scheduleActions( scheduler, world, imageStore);

    }

}
