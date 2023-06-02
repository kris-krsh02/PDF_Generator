import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class AppPDF extends JFrame {
    private static final int WIDTH = 500;
    protected String name;

    public AppPDF() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(WIDTH, WIDTH);
	setLocationRelativeTo(null);

	// Set the header
	JPanel panel = new JPanel(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();

	JLabel header = new JLabel("Генератор на оферти");
	Font font = new Font("Times New Roman", Font.BOLD, 20);
	header.setFont(font);
	header.setBorder(new EmptyBorder(10, 0, 0, 0));
	add(header, BorderLayout.NORTH);
	header.setHorizontalAlignment(SwingConstants.CENTER);

	// Create panel for all the fields
	panel = new JPanel(new GridBagLayout());
	JLabel nameLabel = new JLabel("Име");
	c = new GridBagConstraints();
	c.gridx = 0;
	c.gridy = 1;
	c.weightx = 0.5;
	panel.add(nameLabel, c);

	JTextField nameField = new JTextField();
	nameField.setPreferredSize(new Dimension(300, 30));
	c.gridx = 1;
	panel.add(nameField, c);

	Locale bulgarianLocale = new Locale("bg", "BG");
	JLabel dateLabel = new JLabel("Дата");
	c.gridx = 0;
	c.gridy = 0;
	panel.add(dateLabel, c);

	JDateChooser dateChooser = new JDateChooser();
	dateChooser.setLocale(bulgarianLocale);
	dateChooser.setPreferredSize(new Dimension(300, 30));
	c.gridx = 1;
	panel.add(dateChooser, c);

	JButton saveButton = new JButton("Запазване");
	saveButton.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		name = nameField.getText();
		try {
		    new PDF_Gen(name);
		} catch (IOException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
	    }
	});

	add(panel);
	JPanel buttonPanel = new JPanel();
	buttonPanel.add(saveButton);

	add(panel);
	add(buttonPanel, BorderLayout.SOUTH);

	setVisible(true);
    }

    public static void main(String[] args) {
	new AppPDF();
    }
}
