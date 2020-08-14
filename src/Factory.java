import processing.core.PImage;

import java.util.List;

public class Factory {


    public static final int QUAKE_ACTION_PERIOD = 1100;
    public static final int QUAKE_ANIMATION_PERIOD = 100;
    public static Miner_Full createMinerFull(
            String id,
            int resourceLimit,
            Point position,
            int actionPeriod,
            int animationPeriod,
            List<PImage> images)
    {
        return new Miner_Full(position,images,0,actionPeriod,animationPeriod,id,resourceLimit);
    }
    public  static Miner_Not_Full createMinerNotFull(
            String id,
            int resourceLimit,
            Point position,
            int actionPeriod,
            int animationPeriod,
            List<PImage> images)
    {
        return new Miner_Not_Full(id,position,images,resourceLimit,0,actionPeriod,animationPeriod,0);
    }

    public  static Ore_Blob createOreBlob(
            String id,
            Point position,
            int actionPeriod,
            int animationPeriod,
            List<PImage> images)
    {
        return new Ore_Blob(position, images, actionPeriod, animationPeriod,0);
    }


    public static BlackSmith createBlacksmith(
            Point position, List<PImage> images)
    {
        return new BlackSmith(  position, images,0);
    }


    public static Obstacle createObstacle(
             Point position, List<PImage> images)
    {
        return new Obstacle( position, images,0);
    }


    public static Vein createVein(
            String id, Point position, int actionPeriod, List<PImage> images)
    {
        return new Vein( id, position, images ,actionPeriod,0);
    }


    public static Action createActivityAction(
            ActionEntity entity, WorldModel world, ImageStore imageStore)
    {
        return new ActivityAction( entity, world, imageStore);
    }

    public  static Quake createQuake(
            Point position, List<PImage> images)
    {
        return new Quake( position, images, 0,QUAKE_ACTION_PERIOD, QUAKE_ANIMATION_PERIOD);
    }

    public  static Ore createOre(
            String id, Point position, int actionPeriod, List<PImage> images)
    {
        return new Ore( position, images, 0,actionPeriod,id);
    }

    public static Action createAnimationAction(EntityImage entity, int repeatCount) {
        return new AnimationAction( entity, repeatCount);
    }
}
