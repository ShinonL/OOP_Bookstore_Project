package api.bookstore.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import api.bookstore.controller.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class Home{

    private JTextField personFullNameTextField;
    private JTextField personPhoneTextField;
    private JButton  savePersonButton;

    public void initialize() {
        Master.masterPanel.setLayout(null);

        JLabel newLabel = new JLabel("Home");
        newLabel.setBounds(10, 80, 200, 30);
        Master.masterPanel.add(newLabel);

    }

}
