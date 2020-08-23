import processing.core.PImage;

import java.util.List;

public class Coin extends Entity {

    public Coin(Point pos,
                List<PImage> images,
                int imageIndex)
    {
        super(pos, images, imageIndex);
    }

    public String toString() {
        return "Sekkeh (سکه): the symbol of wealth and prosperity.";
    }
}
