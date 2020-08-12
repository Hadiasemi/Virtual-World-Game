import processing.core.PImage;

import java.util.*;

public final class WorldModel
{

    private final String ORE_ID_PREFIX = "ore -- ";
    private final int ORE_CORRUPT_MIN = 20000;
    private final int ORE_CORRUPT_MAX = 30000;
    private final int ORE_REACH = 1;

    private int numRows;
    private int numCols;
    private Background background[][];
    private Entity occupancy[][];
    private Set<Entity> entities;

    public WorldModel(int numRows, int numCols, Background defaultBackground) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.background = new Background[numRows][numCols];
        this.occupancy = new Entity[numRows][numCols];
        this.entities = new HashSet<>();

        for (int row = 0; row < numRows; row++) {
            Arrays.fill(this.background[row], defaultBackground);
        }
    }

    public int getNumRows() { return numRows; }

    public int getNumCols() { return numCols; }

    public Set<Entity> getEntities() { return entities; }

    public  void setOccupancyCell(
             Point pos, Entity entity)
    {
        this.occupancy[pos.y][pos.x] = entity;
    }

    public  void setBackgroundCell(
         Point pos, Background background)
    {
        this.background[pos.y][pos.x] = background;
    }

    public  Background getBackgroundCell( Point pos) {
        return this.background[pos.y][pos.x];
    }

    public  Entity getOccupancyCell( Point pos) {
        return this.occupancy[pos.y][pos.x];
    }

    public  boolean withinBounds(Point pos) {
        return pos.y >= 0 && pos.y < this.numRows && pos.x >= 0
                && pos.x < this.numCols;
    }


    public  boolean isOccupied( Point pos) {
        return withinBounds(pos) && this.getOccupancyCell( pos) != null;
    }

    public  Optional<Entity> getOccupant( Point pos) {
        if (isOccupied( pos)) {
            return Optional.of(this.getOccupancyCell(pos));
        }
        else {
            return Optional.empty();
        }
    }




    public void moveEntity( Entity entity, Point pos) {
        Point oldPos = entity.getPosition();
        if (this.withinBounds(pos) && !pos.equals(oldPos)) {
            this.setOccupancyCell(oldPos, null);
            removeEntityAt( pos);
            this.setOccupancyCell( pos, entity);
            entity.setPosition(pos);
        }
    }

    public  void removeEntity(Entity entity) {
        removeEntityAt( entity.getPosition());
    }

    public  void removeEntityAt( Point pos) {
        if (this.withinBounds(pos) && this.getOccupancyCell( pos) != null) {
            Entity entity = this.getOccupancyCell( pos);

            /* This moves the entity just outside of the grid for
             * debugging purposes. */
            entity.setPosition(new Point(-1,-1));
            this.entities.remove(entity);
            this.setOccupancyCell( pos, null);
        }
    }

    private   int distanceSquared(Point p1, Point p2)
    {
        int deltaX = p1.x - p2.x;
        int deltaY = p1.y - p2.y;

        return deltaX * deltaX + deltaY * deltaY;
    }

    public  Optional<Entity> nearestEntity(
            List<Entity> entities, Point pos)
    {
        if (entities.isEmpty()) {
            return Optional.empty();
        }
        else {
            Entity nearest = entities.get(0);
            int nearestDistance = distanceSquared(nearest.getPosition(), pos);

            for (Entity other : entities) {
                int otherDistance = distanceSquared(other.getPosition(), pos);

                if (otherDistance < nearestDistance) {
                    nearest = other;
                    nearestDistance = otherDistance;
                }
            }

            return Optional.of(nearest);
        }
    }
    public  Optional<Entity> findNearest(
             Point pos, Class kind)
    {
        List<Entity> ofType = new LinkedList<>();
        for (Entity entity : this.entities) {
            if (entity.getClass() == kind) {
                ofType.add(entity);
            }
        }

        return nearestEntity(ofType, pos);
    }

    public  void addEntity( Entity entity) {
        if (withinBounds(entity.getPosition())){
            setOccupancyCell( entity.getPosition(), entity);
            entities.add(entity);
        }
    }


    public  Optional<Point> findOpenAround( Point pos) {
        for (int dy = -ORE_REACH; dy <= ORE_REACH; dy++) {
            for (int dx = -ORE_REACH; dx <= ORE_REACH; dx++) {
                Point newPt = new Point(pos.x + dx, pos.y + dy);
                if (this.withinBounds(newPt) && !this.isOccupied( newPt)) {
                    return Optional.of(newPt);
                }
            }
        }

        return Optional.empty();
    }


    public  void tryAddEntity(Entity entity) {
        if (isOccupied( entity.getPosition())){
            // arguably the wrong type of exception, but we are not
            // defining our own exceptions yet
            throw new IllegalArgumentException("position occupied");
        }

        addEntity(entity);
    }



    public  Optional<PImage> getBackgroundImage(
             Point pos)
    {
        if (this.withinBounds(pos)) {
            return Optional.of(this.getBackgroundCell( pos).getCurrentImage());
        }
        else {
            return Optional.empty();
        }
    }
}
