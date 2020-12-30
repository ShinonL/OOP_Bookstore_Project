package api.bookstore.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import api.bookstore.controller.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NavigationBar {

    public static JPanel navBar(JPanel myPanel) {
        JButton dummyButton = new JButton("Home");
        dummyButton.setBounds(10, 10, 120, 30);
        JButton dummyButton2 = new JButton("AboutUS");
        dummyButton2.setBounds(10, 45, 120, 30);

        dummyButton.addActionListener(e -> {
            Home myHome = new Home();
            myHome.initialize();
        });
        dummyButton2.addActionListener(e -> {
            System.out.println("hei");
            AboutUs aboutUs = new AboutUs();
            aboutUs.initialize();
        });


        myPanel.add(dummyButton);
        myPanel.add(dummyButton2);

        return myPanel;
    }
}
