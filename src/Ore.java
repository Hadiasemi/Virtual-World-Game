import processing.core.PImage;

import java.util.List;
import java.util.Optional;

public class Ore extends ActionEntity {

    private final String BLOB_KEY = "blob";
    private final String BLOB_ID_SUFFIX = " -- blob";
    private final int BLOB_PERIOD_SCALE = 4;
    private final int BLOB_ANIMATION_MIN = 50;
    private final int BLOB_ANIMATION_MAX = 150;

    private String id;

    public Ore(Point position, List<PImage> images, int imageIndex, int actionPeriod, String id) {
        super(position, images, imageIndex, actionPeriod);
        this.id = id;
    }

    protected void executeActivity(

            WorldModel world,
            ImageStore imageStore,
            EventScheduler scheduler)
    {
        Point pos = this.getPosition();

        world.removeEntity(this);
        scheduler.unscheduleAllEvents( this);

        Ore_Blob blob = Factory.createOreBlob(

        this.id + BLOB_ID_SUFFIX, pos,
        this.getActionPeriod() / BLOB_PERIOD_SCALE,
        BLOB_ANIMATION_MIN +
                Functions.rand.nextInt(BLOB_ANIMATION_MAX - BLOB_ANIMATION_MIN),
                imageStore.getImageList(BLOB_KEY));

        world.addEntity( blob);
        blob.scheduleActions( scheduler, world, imageStore);
    }

}
