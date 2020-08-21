import processing.core.*;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Factory {


    public static final int QUAKE_ACTION_PERIOD = 1100;
    public static final int QUAKE_ANIMATION_PERIOD = 100;
    private static Random rand = new Random();

    public static void createEvent(WorldModel world,
                              ImageStore imageStore,
                              EventScheduler scheduler,
                              Point pressed)
    {
        // Place fire
        Fire[]fire=new Fire[5];
        Point[] point=new Point[5];
        for(int i=1;i<5;i++){
                switch (i){
                    case 1:
                        point[i]=new Point(pressed.x, pressed.y);
                        break;
                    case 2:
                         point[i]=new Point(pressed.x+16, pressed.y );
                         break;
                    case 3:
                        point[i]=new Point(pressed.x, pressed.y+10 );
                        break;
                    case 4:
                        point[i]= new Point(pressed.x + 16, pressed.y + 10);
                        break;
                }
                fire[i]= new Fire(
                    point[i],
                    imageStore.getImageList("fire"),
                    0,
                    990,
                    100);
            world.removeEntityAt(point[i]);
            world.addEntity(fire[i]);
            fire[i].scheduleActions(scheduler, world, imageStore);

        }
//        Fire fire1 = new Fire(
//                new Point(pressed.x, pressed.y),
//                imageStore.getImageList("fire"),
//                0,
//                990,
//                100);
//
//        Fire fire2 = new Fire(
//                new Point(pressed.x + 16, pressed.y),
//                imageStore.getImageList("fire"),
//                0,
//                990,
//                100);
//
//        Fire fire3 = new Fire(
//                new Point(pressed.x, pressed.y + 10),
//                imageStore.getImageList("fire"),
//                0,
//                990,
//                100);
//
//        Fire fire4 = new Fire(
//                new Point(pressed.x + 16, pressed.y + 10),
//                imageStore.getImageList("fire"),
//                0,
//                990,
//                100);
//        world.removeEntityAt(new Point(pressed.x, pressed.y));
//        world.removeEntityAt(new Point(pressed.x + 16, pressed.y));
//        world.removeEntityAt(new Point(pressed.x, pressed.y + 10));
//        world.removeEntityAt(new Point(pressed.x + 16, pressed.y + 10));
//        world.addEntity(fire1);
//        world.addEntity(fire2);
//        world.addEntity(fire3);
//        world.addEntity(fire4);
//        fire1.scheduleActions(scheduler, world, imageStore);
//        fire2.scheduleActions(scheduler, world, imageStore);
//        fire3.scheduleActions(scheduler, world, imageStore);
//        fire4.scheduleActions(scheduler, world, imageStore);


        // Create the flag
        Flag flag = new Flag(imageStore, world);
        flag.makeFlag(
                new Point(pressed.x + 1, pressed.y + 1),
                "green", "white", "red");

        // TESTING
        // Created a static animated entity goldfish.
        Goldfish fish = new Goldfish(
                new Point(pressed.x + 3, pressed.y + 5),
                imageStore.getImageList("goldfish"),
                0,
                990,
                100);
        // Scheduling its animation.
        fish.executeActivity(world, imageStore, scheduler);
        world.addEntity(fish);

        // for loops to add dancers
        for (int i = 0; i < 10; i++) {
            Dancer dancer = new Dancer(new Point(rand.nextInt(39),
                    rand.nextInt(39)),
                    imageStore.getImageList("dancer"), 990, 100,
                    0);
            world.addEntity(dancer);
            dancer.scheduleActions(scheduler, world, imageStore);
        }
        // Static entities, non-animated
        world.addEntity(new Coin(new Point(pressed.x + 4, pressed.y + 5),
                imageStore.getImageList("coin"), 0));

        world.addEntity(new Apple(new Point(pressed.x + 5, pressed.y + 5),
                imageStore.getImageList("apple"), 0));

        world.addEntity(new Sabzeh(new Point(pressed.x + 6, pressed.y + 5),
                imageStore.getImageList("sabzeh"), 0));

        world.addEntity(new Somac(new Point(pressed.x + 7, pressed.y + 5),
                imageStore.getImageList("somac"), 0));

        world.addEntity(new Samanu(new Point(pressed.x + 8, pressed.y + 5),
                imageStore.getImageList("samanu"), 0));

        world.addEntity(new Senjed(new Point(pressed.x + 10, pressed.y + 5),
                imageStore.getImageList("senjed"), 0));

        world.addEntity(new Vinegar(new Point(pressed.x + 11, pressed.y + 5),
                imageStore.getImageList("vinegar"), 0));

        world.addEntity(new Garlic(new Point(pressed.x + 12, pressed.y + 5),
                imageStore.getImageList("garlic"), 0));

    }



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
