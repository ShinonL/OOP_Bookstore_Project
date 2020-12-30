package api.bookstore.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

@Component
public class NavigationBar {

    public static JPanel navBar(JPanel myPanel, AppFrame prevFrame) {

        JButton homeButton = new JButton("Home");
        homeButton.setBounds(10, 10, 120, 30);
        homeButton.addActionListener(e -> {
            Home myHome = new Home();
            myHome.initialize();
            myHome.setVisible(true);
            prevFrame.setVisible(false);
        });
        myPanel.add(homeButton);


        JButton aboutUsButton = new JButton("AboutUS");
        aboutUsButton.setBounds(10, 45, 120, 30);
        aboutUsButton.addActionListener(e -> {
            AboutUs aboutUs = new AboutUs();
            aboutUs.initialize();
            aboutUs.setVisible(true);
            prevFrame.setVisible(false);
        });
        myPanel.add(aboutUsButton);


        JButton myAccountButton = new JButton("My Account");
        myAccountButton.setBounds(10, 105, 120, 30);
        myAccountButton.addActionListener(e -> {
            MyAccount myAccount = new MyAccount();
            myAccount.initialize();
            myAccount.setVisible(true);
            prevFrame.setVisible(false);
        });
        myPanel.add(myAccountButton);


        JButton categoryButton = new JButton("Categories");
        categoryButton.setBounds(10, 135, 120, 30);
        categoryButton.addActionListener(e -> {
            Category category = new Category();
            category.initialize();
            category.setVisible(true);
            prevFrame.setVisible(false);
        });
        myPanel.add(categoryButton);



        return myPanel;
    }
}
