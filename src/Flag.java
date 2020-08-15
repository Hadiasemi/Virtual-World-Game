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
