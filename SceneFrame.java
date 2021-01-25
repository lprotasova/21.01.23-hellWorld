import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SceneFrame extends JFrame{
    private static final long serialVersionUID = 2170145598407113723L;
    protected ScenePanel scenePanel;

    public SceneFrame(ScenePanel sPanel) {
        super("Hell");

        scenePanel = sPanel;
        getContentPane().add(scenePanel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200, 200);
        setSize(400, 700);
    }

    public SceneFrame(ScenePanel sPanel, String[] openingCutsceneFiles) {
        super("Hell");

        scenePanel = sPanel;
        getContentPane().add(scenePanel);

        finalizeWindow();

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

    //THIS CURRENTLY DOES NOT WORK
    private void playCutscene(String[] cutsceneFiles) {
        //for each cutscene file
        for (String file : cutsceneFiles) {
            try {
                System.out.println("displaying: " + file);
                removeAll();
                CutscenePanel cutPanel = new CutscenePanel(file);
                add(cutPanel);
                repaint();
                //Thread.sleep(500);
                //finalizeWindow();
                JOptionPane.showMessageDialog(this, file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void finalizeWindow() {
        System.out.println("finalizing window...");
        setLayout(new GridLayout(1, 1));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200, 200);
        setSize(400, 700);
    }
}
