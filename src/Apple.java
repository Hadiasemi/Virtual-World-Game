import processing.core.PImage;

import java.util.List;

public class Apple extends Entity {

    public Apple(Point position,
                 List<PImage> images,
                 int imageIndex) {
        super(position, images, imageIndex);
    }

    public String toString() {
        return "Seeb (سیب): the symbol of beauty.";
    }

}
