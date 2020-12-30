package api.bookstore.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import api.bookstore.controller.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AboutUs{

    public void initialize() {
        Master.masterPanel.setLayout(null);

        JLabel newLabel = new JLabel("hei");
        newLabel.setBounds(10, 80, 200, 30);
        Master.masterPanel.add(newLabel);

        JButton dummyButton = new JButton("Go back");
        dummyButton.setBounds(10, 200, 120, 30);

        Master.masterPanel.add(dummyButton);
    }
}
