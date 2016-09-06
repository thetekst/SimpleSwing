package thetekst.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {
    private JFrame frame;
    private JButton button;
    private boolean flag = true;

    public static void main(String[] args) {
        Window window = new Window();
        window.go();
    }

    private void go() {
        frame = new JFrame();
        button = new JButton("click me");

        button.addActionListener(new LabelListener());

        MyDrawPanel myDrawPanel = new MyDrawPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button, BorderLayout.SOUTH);
        frame.getContentPane().add(myDrawPanel, BorderLayout.CENTER);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    class LabelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            frame.repaint();

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
