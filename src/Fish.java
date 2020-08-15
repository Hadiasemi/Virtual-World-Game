import java.util.List;
import processing.core.*;

public class Fish extends Obstacle {

    public Fish(Point pos,
                List<PImage> images,
                int imageIndex)
    {
        super(pos, images, imageIndex);
    }

    // Write the history of the fish
    public String toString()
    {
        return "The fish represents movement and life.Goldfish is also the sign of the last month in Persian calendar (Esfand) and it turning around the bowl is a sign of turning and changing of the year.";
    }




}
