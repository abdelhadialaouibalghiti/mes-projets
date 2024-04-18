package vue;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.io.Serial;

public class SetBackGroundImage {
    public static JPanel setBackgroundImage(JFrame frame, final File img) throws IOException {
        JPanel panel = new JPanel(null) {
            @Serial
            private static final long serialVersionUID = 1;

            private final BufferedImage buf = ImageIO.read(img);

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(buf, 0, 0, null);
            }
        };

        frame.setContentPane(panel);

        return panel;
    }
}