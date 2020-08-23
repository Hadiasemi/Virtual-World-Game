import processing.core.PImage;
import java.util.List;

public class Garlic extends Entity {

    public Garlic(Point pos,
                List<PImage> images,
                int imageIndex)
    {
        super(pos, images, imageIndex);
    }

    public String toString() {
        return "Seer (سیر): the symbol of health and medicine.";
    }
}
