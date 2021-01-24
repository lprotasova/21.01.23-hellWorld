public class Driver {
    public static void main(String[] args) {
        //test constructor 1, modifyVelocity, and both moves
        /* PhysicsItem item1 = new PhysicsItem(4.1, 5.2);
        item1.testPrint();
        item1.modifyVelocity(new Pair(-3, -6));
        item1.move();
        item1.testPrint();
        item1.move(5);
        item1.testPrint(); */

        //test constructor 2 and undoing velocity with multiple modify calls
        /* PhysicsItem item2 = new PhysicsItem(-5, 4, 2, 2);
        item2.testPrint();
        item2.modifyVelocity(new Pair(2, 1));
        item2.testPrint();
        item2.modifyVelocity(new Pair(-2, -1));
        item2.testPrint(); */

        //test constructor 3 and collision
        PhysicsItem item3Ship = new PhysicsItem(5.5, 15, .5, .5, 0, 0);
        PhysicsItem item4Asteroid = new PhysicsItem(5, 2.5, .5, .5, 0, .5);

        for (int i = 0; i < 24; i++) {
            System.out.println("-----Ship Status:");
            item3Ship.testPrint();
            System.out.println("-----Asteroid Status:");
            item4Asteroid.testPrint();

            System.out.println("-----Collision Status: " + item3Ship.collidesWith(item4Asteroid));

            System.out.println("-----Moving...");
            item3Ship.move();
            item4Asteroid.move();
        }
    }
}