import processing.core.PImage;

import java.util.List;

public class Candle extends Entity{
    public Candle(Point pos,
                  List<PImage> images,
                  int imageIndex)
    {
        super(pos, images, imageIndex);
    }

    public String toString() {
        return "Candle (شمع): the symbol of enlightenment.";
    }
}
