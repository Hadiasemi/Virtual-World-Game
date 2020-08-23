import processing.core.PImage;

import java.util.List;

public class Clock extends Entity{
    public Clock(Point pos,
                List<PImage> images,
                int imageIndex)
    {
        super(pos, images, imageIndex);
    }

    public String toString() {
        return "Saat (ساعت): the symbol of time.";
    }
}
