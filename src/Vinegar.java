import processing.core.PImage;

import java.util.List;

public class Vinegar extends Entity {

    public Vinegar(Point pos,
                  List<PImage> images,
                  int imageIndex)
    {
        super(pos, images, imageIndex);
    }

    public String toString() {
        return "Vinegar (سرکه): symbolizing age and patience";
    }
}
