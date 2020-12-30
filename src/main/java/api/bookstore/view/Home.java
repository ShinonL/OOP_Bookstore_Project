package api.bookstore.view;

import javax.swing.*;

import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class Home extends AppFrame{

    @Override
    public void initialize() {
        this.setResizable(false);
        this.setTitle("Bookstore");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth() * 70/100;
        double height = screenSize.getHeight() * 90/100;
        this.setSize((int)width, (int)height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        NavigationBar.navBar(panel, this);
        panel.setBackground(Color.CYAN);
        JPanel panelInside = new JPanel();
        panelInside.setLayout(null);
        panelInside.setBounds(this.getSize().width/8,2*this.getSize().height/22,
                           3*this.getSize().width/4,this.getHeight()-5*this.getSize().height/20);
        panelInside.setBackground(new Color(225, 198, 153));
        initializeInside(panelInside);
        panel.add(panelInside);

        this.setContentPane(panel);
        this.setVisible(true);
    }

    private void initializeInside(JPanel panelInside)
    {
        JPanel bestPanel = new JPanel();
        JPanel newPanel = new JPanel();
        JPanel promotionsPanel = new JPanel();

        bestPanel.setBackground(Color.BLACK);
        newPanel.setBackground(Color.BLACK);
        promotionsPanel.setBackground(Color.BLACK);

        bestPanel.setBounds(panelInside.getBounds().width/20,10,panelInside.getBounds().width-2*panelInside.getBounds().width/20,panelInside.getBounds().height/3-30);
        newPanel.setBounds(panelInside.getBounds().width/20,10+panelInside.getBounds().height/3,panelInside.getBounds().width-2*panelInside.getBounds().width/20,panelInside.getBounds().height/3-30);
        promotionsPanel.setBounds(panelInside.getBounds().width/20,10+2*panelInside.getBounds().height/3,panelInside.getBounds().width-2*panelInside.getBounds().width/20,panelInside.getBounds().height/3-30);

        initializeBest(bestPanel);
        initializeNew(newPanel);
        initializePromotions(promotionsPanel);

        panelInside.add(bestPanel);
        panelInside.add(newPanel);
        panelInside.add(promotionsPanel);
    }

    private void initializeBest(JPanel bestPanel)
    {
    }
    private void initializeNew(JPanel newPanel)
    {
    }
    private void initializePromotions(JPanel promotionsPanel)
    {
    }

}
