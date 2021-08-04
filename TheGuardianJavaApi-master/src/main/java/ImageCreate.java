import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class ImageCreate {
    public Image ImageCreated(String name) throws MalformedURLException {   // a category in which a function(Image Created = an arrow)
        URL url = new URL(name);                                            // takes an A (String name) and returns a B(Image) the 2 object in between the arrow
        BufferedImage im = null;
        try{
            im = ImageIO.read(url);
        } catch (IOException e){
            e.printStackTrace();
        }
        JLabel label = new JLabel();
        label.setBounds(0,0,120,120);
        return im.getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_SMOOTH); // the return statement also calls a function
    }

}