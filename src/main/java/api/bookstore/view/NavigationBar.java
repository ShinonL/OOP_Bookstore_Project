package api.bookstore.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class NavigationBar {

    public static JPanel navBar(JPanel myPanel, AppFrame prevFrame) {
        JPanel panelInside = new JPanel();
        panelInside.setLayout(null);
        panelInside.setBounds(prevFrame.getSize().width/8,0,
                3*prevFrame.getSize().width/4,prevFrame.getBounds().height/20+20);
        panelInside.setBackground(new Color(225, 198, 153));

        JButton homeButton = new JButton("Home");
        homeButton.setBounds(panelInside.getBounds().width/6, 10, panelInside.getBounds().width/6-10, panelInside.getBounds().height-20);
        homeButton.addActionListener(e -> {
            Home myHome = new Home();
            myHome.initialize();
            myHome.setVisible(true);
            prevFrame.setVisible(false);
        });
        panelInside.add(homeButton);

        JButton categoryButton = new JButton("Categories");
        categoryButton.setBounds(2*panelInside.getBounds().width/6, 10, panelInside.getBounds().width/6-10, panelInside.getBounds().height-20);
        categoryButton.addActionListener(e -> {
            Category category = new Category();
            category.initialize();
            category.setVisible(true);
            prevFrame.setVisible(false);
        });
        panelInside.add(categoryButton);

        JButton aboutUsButton = new JButton("AboutUS");
        aboutUsButton.setBounds(3*panelInside.getBounds().width/6, 10, panelInside.getBounds().width/6-10, panelInside.getBounds().height-20);
        aboutUsButton.addActionListener(e -> {
            AboutUs aboutUs = new AboutUs();
            aboutUs.initialize();
            aboutUs.setVisible(true);
            prevFrame.setVisible(false);
        });
        panelInside.add(aboutUsButton);


        JButton myAccountButton = new JButton("My Account");
        myAccountButton.setBounds(4*panelInside.getBounds().width/6, 10, panelInside.getBounds().width/6-10, panelInside.getBounds().height-20);
        myAccountButton.addActionListener(e -> {
            MyAccount myAccount = new MyAccount();
            myAccount.initialize();
            myAccount.setVisible(true);
            prevFrame.setVisible(false);
        });
        panelInside.add(myAccountButton);




        myPanel.add(panelInside);

        return myPanel;
    }
}
