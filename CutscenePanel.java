import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
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
        System.out.println(bgImage.getWidth() + " " + bgImage.getHeight());
        g.drawImage(bgImage, 0, 0, null);

        /* g.setColor(Color.RED);
        g.fillRect(0, 0, 100, 100); */
    }
}