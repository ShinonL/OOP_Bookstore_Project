package api.bookstore.controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import api.bookstore.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Master extends AppFrame{
    @Autowired
    private AboutUs aboutUs;
    private Home myHome;

    public static JPanel masterPanel = new JPanel();

    @Override
    public void initialize() {
        Master.masterPanel.setLayout(null);

        JButton dummyButton = new JButton("About Us");
        dummyButton.setBounds(10, 200, 120, 30);

        Master.masterPanel.add(dummyButton);
        this.setTitle("Bookstore");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        masterPanel = new JPanel();
        masterPanel.setLayout(null);
        masterPanel = NavigationBar.navBar(masterPanel);

        if(masterPanel.equals(new JPanel()))
        {
            Home newHome = new Home();
            newHome.initialize();
        }

        this.setContentPane(masterPanel);
        this.setVisible(true);
    }
}
