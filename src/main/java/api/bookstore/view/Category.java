package api.bookstore.view;

import javax.swing.*;
import java.awt.*;

public class Category extends AppFrame{
    @Override
    public void initialize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth() * 70/100;
        double height = screenSize.getHeight() * 90/100;
        this.setSize((int)width, (int)height);
        this.setResizable(false);
        this.setTitle("Bookstore");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        NavigationBar.navBar(panel, this);
        panel.setBackground(Color.CYAN);

        JPanel panelInside = new JPanel();
        panelInside.setLayout(null);
        panelInside.setBounds(this.getSize().width/8,2*this.getSize().height/20,
                3*this.getSize().width/4,this.getSize().height-30);
        panelInside.setBackground(new Color(225, 198, 153));
        //initializeInside(panelInside);

        JScrollPane scrollPane = new JScrollPane(panel);

        panel.add(panelInside);



        this.setContentPane(panel);
        this.setVisible(true);
    }
}
