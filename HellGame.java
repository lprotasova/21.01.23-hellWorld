import java.awt.Color;

public class HellGame extends SceneFrame{
    private static final long serialVersionUID = 1L;
    private PhysicsItem ship;

    //constants
    private final int FRAMES_PER_SECOND = 60;
    private final int BULLET_COOLDOWN = 500;
    
    public HellGame() {
        super(new ScenePanel());

        //add a ship
        ship = new PhysicsItem(200, 600, 20, 40, 0, 0, Color.BLUE, true);
        scenePanel.addItemToScene(ship);

        //loop
        while (true) {
            try {
                move();
                //modifyShipVelocity(new Pair(0, -0.05));
                fireBullet();
                Thread.sleep((long)(1000 / FRAMES_PER_SECOND));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void modifyShipVelocity(Pair velocityDelta) {
        ship.modifyVelocity(velocityDelta);
    }

    private void fireBullet() {
        //first, check if the cooldown timer is done
        /* TODO: replace "true" with check that current time is at least 
        BULLET_COOLDOWN microseconds away from lastFireInstant */
        if (true) {
            //create a new physicsItem at the location of the ship
            PhysicsItem bullet = new PhysicsItem(ship.getCurrentLocation().x, 
                ship.getCurrentLocation().y, 5, 5, ship.getCurrentVelocity().x, 
                ship.getCurrentVelocity().y - 5, Color.CYAN, true);

            //add the bullet to the scene
            scenePanel.addItemToScene(bullet);
        }
    }
}
