import processing.core.PImage;

import java.util.List;

public class MinerStatic extends EntityImage{




        public MinerStatic(Point position,
                        List<PImage> images,
                        int imageIndex,
                        int actionPeriod,
                        int animationPeriod)
        {
            super(position, images, imageIndex, actionPeriod, animationPeriod);
        }

        @Override
        public String toString() {
            return "Flag Guard";
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
    }


