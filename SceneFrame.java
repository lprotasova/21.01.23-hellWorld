import javax.swing.JFrame;

public class SceneFrame extends JFrame{
    private static final long serialVersionUID = 2170145598407113723L;
    private ScenePanel scenePanel;

    public SceneFrame(ScenePanel sPanel) {
        super("Hell");

        scenePanel = sPanel;
        getContentPane().add(scenePanel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200, 200);
        setSize(400, 800);
    }

    public SceneFrame(ScenePanel sPanel, String[] openingCutsceneFiles) {
        super("Hell");

        scenePanel = sPanel;
        getContentPane().add(scenePanel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200, 200);
        setSize(400, 800);

        playCutscene(openingCutsceneFiles);
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

    private void playCutscene(String[] cutsceneFiles) {
        //for each cutscene file
        for (String file : cutsceneFiles) {
            try {
                CutscenePanel cutPanel = new CutscenePanel(file);
                getContentPane().removeAll();
                getContentPane().add(cutPanel);
                repaint();
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
