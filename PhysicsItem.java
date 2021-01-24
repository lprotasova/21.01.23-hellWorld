public class PhysicsItem {
    private Pair location;
    private Pair velocity;
    private Pair radius;

    //start with 0 velocity and 0 radius
    public PhysicsItem(double startXLoc, double startYLoc) {
        location = new Pair(startXLoc, startYLoc);

        velocity = new Pair();

        radius = new Pair();
    }

    //start with 0 velocity
    public PhysicsItem(double startXLoc, double startYLoc, double xRadius, 
        double yRadius) {
        location = new Pair(startXLoc, startYLoc);
        radius = new Pair(xRadius, yRadius);
        velocity = new Pair();
    }

    //start with location, velocity, and radius set
    public PhysicsItem(double startXLoc, double startYLoc, double xRadius, 
        double yRadius, double startXVel, double startYVel) {
        location = new Pair(startXLoc, startYLoc);
        velocity = new Pair(startXVel, startYVel);
        radius = new Pair(xRadius, yRadius);
    }

    public Pair getCurrentLocation() {
        return location;
    }

    public Pair getRadius() {
        return radius;
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

    public void setRadius(Pair newRadius) {
        radius = newRadius;
    }

    /** this function finds collisions. an item collides with this item
     * if the centers of the items (denoted by the location pair) are
     * within the x radii away from each other, and the same on the y
     * axis
     */
    public boolean collidesWith(PhysicsItem otherItem) {
        boolean isCollidingX = false;
        boolean isCollidingY = false;

        //first the x calculation
        double distanceBetweenCentersX = Math.abs(location.x - 
            otherItem.getCurrentLocation().x);
        double sumOfXRadii = Math.abs(radius.x) + 
            Math.abs(otherItem.getRadius().x);
        isCollidingX = distanceBetweenCentersX <= sumOfXRadii;

        //only calculate the y axis if the x axis is already colliding
        if (isCollidingX) {
            double distanceBetweenCentersY = Math.abs(location.y - 
                otherItem.getCurrentLocation().y);
            double sumOfYRadii = Math.abs(radius.y) + 
                Math.abs(otherItem.getRadius().y);
            isCollidingY = distanceBetweenCentersY <= sumOfYRadii;
        }

        return isCollidingX && isCollidingY;
    }

    public void testPrint() {
        System.out.println("Current location: [" + location.x + ", " + location.y + "]");
        System.out.println("Going: [" + velocity.x + ", " + velocity.y + "]");
        System.out.println("Radius (1/2 of size): [" + radius.x + ", " + radius.y + "]");
    }
}
