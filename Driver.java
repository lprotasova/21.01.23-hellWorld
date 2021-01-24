public class Driver {
    public static void main(String[] args) {
        PhysicsItem item1 = new PhysicsItem(4.1, 5.2);
        item1.testPrint();
        item1.modifyVelocity(new Pair(-3, -6));
        item1.move();
        item1.testPrint();
        item1.move(5);
        item1.testPrint();
    }
}