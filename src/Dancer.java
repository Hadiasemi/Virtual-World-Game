import processing.core.PImage;

import java.util.List;
import java.util.Optional;

public class Dancer extends EntityResource {

        public Dancer(
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
            long nextPeriod = this.getActionPeriod();
            Optional<Entity> target =
                    world.findNearest(this.getPosition(), Goldfish.class);

            if (target.isPresent())
            {
                if (move(world, target.get(), scheduler))
                {
                    ;
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
                return true;
            }
            else {
                Point nextPos = nextPosition( world, target.getPosition());

                _move(world,scheduler,nextPos);
                return false;
            }
        }

        public  Point nextPosition(
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
