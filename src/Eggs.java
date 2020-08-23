import processing.core.PImage;

import java.util.List;

public class Eggs extends Entity{
    public Eggs(Point pos,
                List<PImage> images,
                int imageIndex)
    {
        super(pos, images, imageIndex);
    }

    public String toString() {
        return "Eggs (تخم\u200Cمرغ رنگی): the symbol of fertility.";
    }
}
