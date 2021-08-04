import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.*;

public class GUI extends JFrame {
    public GUI(Stack<String> titles, Stack<String> pics, Stack<String> urls, Integer num) throws MalformedURLException {
        setSize(700, 700);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.white);

        JButton button = new JButton("Next");
        button.setPreferredSize(new Dimension(680, 25));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        button.addActionListener(f -> {

            FuncCall call = new FuncCall();
            try {
                call.allCall();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }

            CloseFrame();

        });

        CreateLabel clabel = new CreateLabel();
        int j = num;
        for (int i = 0; i < 4; i++) {
            String str = "" + titles.pop();
            String pic = "" + pics.pop();
            String url = "" + urls.pop();
            JLabel label = clabel.CreateLabel(str, pic, url);
            add(label);
            j++;
        }

        ImageIcon im = new ImageIcon("Icon.png");
        setIconImage(im.getImage());
        add(button);
        setVisible(true);
    }


    private void CloseFrame() {
        dispose();
    }

}