public class AnimationAction implements Action {


    private EntityImage entity;
    private int repeatCount;

    public AnimationAction(

            EntityImage entity,
            int repeatCount) {

        this.entity = entity;
        this.repeatCount = repeatCount;
    }


    public void executeAction(
            EventScheduler scheduler) {
        this.entity.nextImage();

        if (this.repeatCount != 1) {
            scheduler.scheduleEvent(this.entity,
                    Factory.createAnimationAction(this.entity,
                            Math.max(this.repeatCount - 1,
                                    0)),
                    this.entity.getAnimationPeriod());
        }
    }
}