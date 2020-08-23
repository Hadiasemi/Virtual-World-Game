import processing.core.PImage;

import java.util.List;

public class Mirror extends Entity{
    public Mirror(Point pos,
                  List<PImage> images,
                  int imageIndex)
    {
        super(pos, images, imageIndex);
    }

    public String toString() {
        return "Mirror (آینه): the symbol of self-reflection.";
    }
}
