package calculator;

import java.awt.event.*;
import java.util.HashMap;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class Calculator extends JFrame implements ActionListener {
	public static final long serialVersionUID = 1L;
	double first, second;
	String operation;
	// Panels for each type of button
	JPanel numbers = new JPanel(new GridLayout(4, 3, 10, 10));
	JPanel operations = new JPanel(new GridLayout(4, 1, 0, 10));
	JPanel delClr = new JPanel(new GridLayout(1, 2, 10, 10));
	JTextPane screen = new JTextPane();
	// "Dictionaries" to keep track of buttons
	HashMap<String, JButton> numberButtons = addKeys(numbers, "7", "8", "9", "4", "5", "6", "1", "2", "3", ".", "0", "=");
	HashMap<String, JButton> operationButtons = addKeys(operations, "+", "-", "x", "÷");
	HashMap<String, JButton> delClrButtons = addKeys(delClr, "del", "clr");

	public Calculator() {
		// Configuring the window (JFrame)
		setTitle("Calculator");
		setSize(220, 270);
		setLayout(new BorderLayout(10, 5));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		// Configuring the screen (JTextPane)
		SimpleAttributeSet attribs = new SimpleAttributeSet();
		StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_RIGHT);
		StyleConstants.setFontSize(attribs, 20);
		screen.setParagraphAttributes(attribs, true);
		screen.setEditable(false);
		// Positioning the panels on the window
		add(screen, BorderLayout.PAGE_START);
		add(numbers, BorderLayout.CENTER);
		add(operations, BorderLayout.LINE_END);
		add(delClr, BorderLayout.PAGE_END);
	}
	// Method to add several keys group to a panel
	HashMap<String, JButton> addKeys(JPanel panel, String... keyList) {
		HashMap<String, JButton> buttonMap = new HashMap<String, JButton>();
		for (String key : keyList) {
			JButton button = new JButton(key);
			buttonMap.put(key, button);
			panel.add(button);
			button.addActionListener(this);
		}
		return buttonMap;
	}
	// Listens for a key press
	public void actionPerformed(ActionEvent e) {
		// Check if number key was pressed
		for (String numberString : numberButtons.keySet()) {
			if (e.getSource().equals(numberButtons.get(numberString))) {
				if (numberString.equals("=")) {
					second = Double.parseDouble(screen.getText());
					switch (operation) {
					case "+" -> first += second;
					case "-" -> first -= second;
					case "÷" -> first /= second;
					case "x" -> first *= second;
					}
					screen.setText(first + "");
				} else if (numberString.equals("."))
					screen.setText(screen.getText().concat("."));
				else if (!(numberString.equals("0") && screen.getText().equals("")))
					screen.setText(screen.getText() + numberString);
			}
		}
		// Check if +, -, x or ÷ was pressed
		for (String operationString : operationButtons.keySet()) {
			if (e.getSource().equals(operationButtons.get(operationString))) {
				first = Double.parseDouble(screen.getText());
				operation = operationString;
				screen.setText("");
			}
		}
		// Check if DEL was pressed
		if (e.getSource().equals(delClrButtons.get("del")))
			screen.setText(screen.getText().substring(0, Math.max(screen.getText().length() - 1, 0)));
		// Check if CLEAR was pressed
		if (e.getSource().equals(delClrButtons.get("clr"))) {
			first = 0;
			second = 0;
			screen.setText("");
		}
	}
}