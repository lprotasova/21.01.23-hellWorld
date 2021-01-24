public class PhysicsItem {
    private Pair location;
    private Pair velocity;

    //start with 0 velocity
    public PhysicsItem(double startXLoc, double startYLoc) {
        location = new Pair(startXLoc, startYLoc);

        velocity = new Pair();
    }

    public Pair getCurrentLocation() {
        return location;
    }

    //assume in one tick (one call to move), location changes by velocity units
    public void move() {
        location.x += velocity.x;
        location.y += velocity.y;
    }

    public void move(int numTicks) {
        for (int i = 0; i < numTicks; i++) {
            move();
        }
    }

    public void modifyVelocity(Pair velocityDelta) {
        velocity.x += velocityDelta.x;
        velocity.y += velocityDelta.y;
    }

    public void testPrint() {
        System.out.println("Current location: [" + location.x + ", " + location.y + "]");
        System.out.println("Going: [" + velocity.x + ", " + velocity.y + "]");
    }
}
