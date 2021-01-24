import java.util.ArrayList;

public class Scene {
    private ArrayList<PhysicsItem> items;

    //start empty
    public Scene() {
        items = new ArrayList<PhysicsItem>();
    }

    //start with some items already
    //do that

    public void addPhysicsItem(PhysicsItem newItem) {
        items.add(newItem);
    }

    public void testPrint() {
        System.out.println("Scene has " + items.size() + " items");

        for (int i = 0; i < items.size(); i++) {
            System.out.println("-----" + i);
            items.get(i).testPrint();
        }

        System.out.println();
    }

    public void moveAllItems() {
        for (PhysicsItem item : items) {
            item.move();
        }
    }

    public void moveAllItems(int numTicks) {
        for (PhysicsItem item : items) {
            item.move(numTicks);
        }
    }

    public boolean checkForCollisionByIndeces(int index1, int index2) {
        return items.get(index1).collidesWith(items.get(index2));
    }
}