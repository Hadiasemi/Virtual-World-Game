import processing.core.PImage;

import java.util.List;

public class Book extends Entity{
    public Book(Point pos,
                  List<PImage> images,
                  int imageIndex)
    {
        super(pos, images, imageIndex);
    }

    public String toString() {
        return "Book (کتاب): the symbol of wisdom.";
    }
}
