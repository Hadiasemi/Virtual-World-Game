import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

import processing.core.PImage;

public final class ImageStore
{
    private final int PROPERTY_KEY = 0;

    private final String BGND_KEY = "background";
    public static final String OBSTACLE_KEY = "obstacle";
    private final String MINER_KEY = "miner";
    private final String ORE_KEY = "ore";
    private  final String SMITH_KEY = "blacksmith";
    private final String VEIN_KEY = "vein";


    private Map<String, List<PImage>> images;
    private List<PImage> defaultImages;

    public ImageStore(PImage defaultImage) {
        this.images = new HashMap<>();
        defaultImages = new LinkedList<>();
        defaultImages.add(defaultImage);
    }

    public Map<String, List<PImage>> getImages() { return images; }

    public  List<PImage> getImageList(String key) {
        return this.images.getOrDefault(key, this.defaultImages);
    }




}
