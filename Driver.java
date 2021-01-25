import java.awt.Color;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        //test PhysicsItem constructor 1, modifyVelocity, and both moves
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
        /* PhysicsItem item3Ship = new PhysicsItem(5.5, 15, .5, .5, 0, 0);
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
        } */

        //test Scene constructor 1, addPhysicsItem, and checkForCollisionByIndeces
        /* Scene scene1Road = new Scene();
        scene1Road.testPrint();

        scene1Road.addPhysicsItem(new PhysicsItem(2, 2, 2, 1, .5, 0));
        scene1Road.addPhysicsItem(new PhysicsItem(10, 2, 2, 1, -.5, 0));
        scene1Road.testPrint();

        while (scene1Road.checkForCollisionByIndeces(0, 1) == false) {
            scene1Road.moveAllItems();

            scene1Road.testPrint();
        } */

        //test Scene constructor 2, ScenePanel constructor 2, and SceneFrame
        PhysicsItem item5Snake = new PhysicsItem(100, 100, 50, 10, .5, 0, Color.GREEN, true);
        PhysicsItem item6Fruit = new PhysicsItem(400, 100, 5, 5, 0, 0, Color.RED, false);
        
        ArrayList<PhysicsItem> itemsArray1 = new ArrayList<PhysicsItem>();
        itemsArray1.add(item5Snake);
        itemsArray1.add(item6Fruit);

        Scene scene2 = new Scene(itemsArray1);
        scene2.testPrint();

        ScenePanel panel1 = new ScenePanel(scene2);
        SceneFrame frame1 = new SceneFrame(panel1);

        try {
            //for (int i = 0; i < 5; i++) {
            while (true) {
                frame1.move();
                Thread.sleep((long)(100));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}