import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AppPDF extends JFrame { 
	private static final int WIDTH = 500;
	protected String name;
	
	public AppPDF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, WIDTH);
		setLocationRelativeTo(null);	

		// Set the header
		JLabel header = new JLabel("Генератор на оферти");
		Font font = new Font("Times New Roman", Font.BOLD, 20);
		header.setFont(font);
		add(header, BorderLayout.NORTH);
		header.setHorizontalAlignment(SwingConstants.CENTER);

		// Create panel for all the fields 
		JPanel panel = new JPanel(new GridBagLayout());
		JLabel nameLabel = new JLabel("Име");
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.5;
		panel.add(nameLabel, c);

		JTextField nameField = new JTextField();
		nameField.setPreferredSize(new Dimension(300, 30));
		c.gridx = 1;
		panel.add(nameField, c);
		
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
