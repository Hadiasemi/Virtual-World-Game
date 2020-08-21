import java.util.List;
import processing.core.*;

public class Flag {
    private ImageStore imageStore;
    private WorldModel world;
    public Flag(ImageStore imageStore, WorldModel world)
    {
        this.imageStore = imageStore;
        this.world = world;
    }

    public void makeFlag(Point pos, String color1,
                         String color2, String color3)
    {
        Background green = new Background(color1,
                imageStore.getImageList(color1));
        Background white = new Background(color2,
                imageStore.getImageList(color2));
        Background red = new Background(color3,
                imageStore.getImageList(color3));

        Point point = new Point(pos.x, pos.y);
        for (int i = 0; i < 15; i++)
        {
            world.removeEntityAt(point);

            world.removeEntityAt(
                    new Point(point.x, point.y + 1)
            );
            world.removeEntityAt(
                    new Point(point.x, point.y + 2)
            );
            world.removeEntityAt(
                    new Point(point.x, point.y + 3)
            );

            world.removeEntityAt(
                    new Point(point.x, point.y + 4)
            );

            world.removeEntityAt(
                    new Point(point.x, point.y + 5)
            );
            world.removeEntityAt(
                    new Point(point.x, point.y + 6)
            );
            world.removeEntityAt(
                    new Point(point.x, point.y + 7)
            );
            world.removeEntityAt(
                    new Point(point.x, point.y + 8)
            );
            point.x += 1;
        }
        for (int i = 0; i < 15; i++)
        {

            green.setBackground(world, pos);

            green.setBackground(world,
                    new Point(pos.x, pos.y + 1));

            green.setBackground(world,
                    new Point(pos.x, pos.y + 2));

            white.setBackground(world,
                    new Point(pos.x, pos.y + 3));

            white.setBackground(world,
                    new Point(pos.x, pos.y + 4));

            white.setBackground(world,
                    new Point(pos.x, pos.y + 5));

            red.setBackground(world,
                    new Point(pos.x, pos.y + 6));

            red.setBackground(world,
                    new Point(pos.x, pos.y + 7));

            red.setBackground(world,
                    new Point(pos.x, pos.y + 8));
            pos.x += 1;
        }
    }


}
