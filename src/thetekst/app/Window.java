package thetekst.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private JButton button;
    private boolean flag;

    public Window() {
        super("My Window");
        flag = true;
        go();
    }

    private void go() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                button = new JButton("click me");

                button.addActionListener(new LabelListener());

                MyDrawPanel myDrawPanel = new MyDrawPanel();

                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                getContentPane().add(button, BorderLayout.SOUTH);
                getContentPane().add(myDrawPanel, BorderLayout.CENTER);
                setSize(300, 300);
                setVisible(true);
            }
        });
    }

    private class LabelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            repaint();

            if (flag) {
                button.setText("I'v been clicked");
                flag = false;
            } else {
                button.setText("click me");
                flag = true;
            }
        }
    }

}
