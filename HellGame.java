import java.awt.Color;

public class HellGame extends SceneFrame{
    private static final long serialVersionUID = 1L;
    private PhysicsItem ship;
    
    public HellGame() {
        super(new ScenePanel());

        //add a ship
        ship = new PhysicsItem(200, 600, 20, 40, 0, 0, Color.BLUE, true);
        scenePanel.addItemToScene(ship);

        //loop
        while (true) {
            try {
                move();
                modifyShipVelocity(new Pair(0, -1));
                Thread.sleep((long)100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void modifyShipVelocity(Pair velocityDelta) {
        ship.modifyVelocity(velocityDelta);
    }
}
