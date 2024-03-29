import processing.core.PImage;

import java.util.List;

public class Somac extends Entity {

    public Somac(Point pos,
                  List<PImage> images,
                  int imageIndex)
    {
        super(pos, images, imageIndex);
    }

    public String toString() {
        return "Somāq (سماق): the symbol of sunrise.";
    }
}
