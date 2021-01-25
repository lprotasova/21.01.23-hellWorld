import javax.swing.JFrame;

public class SceneFrame extends JFrame{
    private ScenePanel scenePanel;

    public SceneFrame(ScenePanel sPanel) {
        super("Hell");

        scenePanel = sPanel;
        getContentPane().add(scenePanel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200, 200);
        setSize(500, 500);
    }

    public void move() {
        scenePanel.move();
        reDraw();
    }

    public void move(int numTicks) {
        scenePanel.move(numTicks);
        reDraw();
    }

    private void reDraw() {
        getContentPane().removeAll();
        getContentPane().add(scenePanel);
        repaint();
    }
}
