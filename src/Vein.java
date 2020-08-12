import processing.core.PImage;

import java.util.List;
import java.util.Optional;

public class Vein extends ActionEntity{



    private final String ORE_ID_PREFIX = "ore -- ";
    private final int ORE_CORRUPT_MIN = 20000;
    private final int ORE_CORRUPT_MAX = 30000;
    private final String ORE_KEY = "ore";
    private String id;

    public Vein(

            String id,
            Point position,
            List<PImage> images,

            int actionPeriod,int imageIndex)
    {
        super(position, images, imageIndex, actionPeriod);
        this.id = id;


    }
    protected void executeActivity(

            WorldModel world,
            ImageStore imageStore,
            EventScheduler scheduler)
    {
        Optional<Point> openPt = world.findOpenAround( this.getPosition());

        if (openPt.isPresent()) {
            Ore ore = Factory.createOre(ORE_ID_PREFIX + this.id, openPt.get(),
                    ORE_CORRUPT_MIN + Functions.rand.nextInt(
                            ORE_CORRUPT_MAX - ORE_CORRUPT_MIN),
                    imageStore.getImageList( ORE_KEY));
            world.addEntity( ore);
            ore.scheduleActions( scheduler, world, imageStore);
        }
        scheduler.scheduleEvent( this,
                Factory.createActivityAction(this, world, imageStore),
                this.getActionPeriod());
    }

}
