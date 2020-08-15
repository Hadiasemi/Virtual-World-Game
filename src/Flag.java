import java.util.List;
import processing.core.*;

public class Flag extends Entity {

    private List<Flag> flagList;

    public Flag(Point pos,
                List<PImage> images,
                int imageIndex)
    {
        super(pos, images, imageIndex);
    }


}
