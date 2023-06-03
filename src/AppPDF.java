import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class AppPDF extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 500;
    private String name;
    private String date;

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
	c.insets = new Insets(0, 0, 10, 0);
	// c.anchor = GridBagConstraints.WEST; // Set anchor to the left c.gridx = 0;
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

	JLabel typeLabel = new JLabel("Вид продукт");
	c.gridx = 0;
	c.gridy = 3;
	c.weightx = 0.5;
	panel.add(typeLabel, c);

	JTextArea typeField = new JTextArea();
	typeField.setPreferredSize(new Dimension(300, 30));
	typeField.setLineWrap(true);
	typeField.setWrapStyleWord(true);
	JScrollPane scrollPane = new JScrollPane(typeField);
	scrollPane.setPreferredSize(new Dimension(300, 60));

	c.gridx = 1;
	c.gridy = 3;
	panel.add(scrollPane, c);

	JLabel priceLabel = new JLabel("Цена");
	c.gridx = 0;
	c.gridy = 4;
	panel.add(priceLabel, c);

	JTextField priceField = new JTextField();
	priceField.setPreferredSize(new Dimension(300, 30));
	c.gridx = 1;
	panel.add(priceField, c);

	JLabel advanceLabel = new JLabel("Аванс");
	c.gridx = 0;
	c.gridy = 5;
	panel.add(advanceLabel, c);

	JCheckBox advanceBox = new JCheckBox();
	c.gridx = 1;
	c.gridy = 5;

	panel.add(advanceBox, c);

	// Additional field for advance percentage
	JLabel advancePercentageLabel = new JLabel("Аванс (%)");
	c.gridx = 0;
	c.gridy = 6;
	panel.add(advancePercentageLabel, c);

	JTextField advancePercentageField = new JTextField();
	advancePercentageField.setPreferredSize(new Dimension(300, 30));
	c.gridx = 1;
	panel.add(advancePercentageField, c);

	advancePercentageLabel.setVisible(false);
	advancePercentageField.setVisible(false);

	advanceBox.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		boolean isSelected = advanceBox.isSelected();
		advancePercentageLabel.setVisible(isSelected);
		advancePercentageField.setVisible(isSelected);
	    }
	});

	// -------------------------------------------------------

	JButton saveButton = new JButton("Запазване");
	saveButton.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		name = nameField.getText();
		Date selectedDate = (Date) dateChooser.getDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		date = dateFormat.format(selectedDate) + " г.";
		System.out.println(date);
		try {
		    new PDF_Gen(name);
		} catch (IOException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
	    }
	});

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
