import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CutscenePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private BufferedImage bgImage;

    public CutscenePanel(String imagePath) {
        try {
            bgImage = ImageIO.read(new File(imagePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
    }
}