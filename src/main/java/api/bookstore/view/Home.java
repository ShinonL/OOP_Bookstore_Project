package api.bookstore.view;

import javax.swing.*;

import org.springframework.stereotype.Component;

@Component
public class Home extends AppFrame{

    @Override
    public void initialize() {
        this.setTitle("Agenda");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        panel = NavigationBar.navBar(panel, this);

        this.setContentPane(panel);
        this.setVisible(true);
    }

}
