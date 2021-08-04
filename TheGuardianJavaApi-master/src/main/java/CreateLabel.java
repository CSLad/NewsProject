import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class CreateLabel {
    public JLabel CreateLabel(String Title, String Im, String URL) throws MalformedURLException {       // Probably a category has multiple inputs but one out
        Border border = BorderFactory.createLineBorder(Color.black, 3);
        JLabel label = new JLabel("<html><p>"+Title+"</p></html>", SwingConstants.CENTER);
        label.setBounds(0,0,700,100);
        ImageCreate image = new ImageCreate();
        ImageIcon imageIcon = new ImageIcon(image.ImageCreated(Im));
        label.setIcon(imageIcon);
        label.setIconTextGap(20);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setHorizontalTextPosition(JLabel.RIGHT);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setBackground(Color.white);
        label.setBorder(border);
        label.setOpaque(true);
        label.setPreferredSize(new Dimension(680,150));

        label.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(URL));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                label.setText(Title);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("<html><a href=''>" + Title + "</a></html>");
            }
        });
        return label;
    }
}
