import javax.swing.JPanel;
import java.awt.*;

public class ScenePanel extends JPanel{
    private static final long serialVersionUID = 2687594532713290240L;
    private Scene scene;

    //create with empty scene
    public ScenePanel() {
        scene = new Scene();
    }

    //create with existing scene
    public ScenePanel(Scene startScene) {
        scene = startScene;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        //go through each component
        for (PhysicsItem item : scene.getItems()) {
            //first, set the color
            graphics.setColor(item.getColor());

            //then, decide if we're going filled or unfilled, and draw
            if (item.getFilled() == true) {
                graphics.fillRect((int)(item.getCurrentLocation().x - 
                    item.getRadius().x), (int)(item.getCurrentLocation().y - 
                    item.getRadius().y), (int)(item.getRadius().x * 2), 
                    (int)(item.getRadius().y * 2));
            } else {
                graphics.drawRect((int)(item.getCurrentLocation().x - 
                    item.getRadius().x), (int)(item.getCurrentLocation().y - 
                    item.getRadius().y), (int)(item.getRadius().x * 2), 
                    (int)(item.getRadius().y * 2));
            }
        }
    }

    public void move() {
        scene.moveAllItems();
    }

    public void move(int numTicks) {
        scene.moveAllItems(numTicks);
    }
}