import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {

    // create components
    TextField inputField;
    Button[] numberButtons = new Button[10];
    Button addButton, subButton, mulButton, divButton, eqButton, clrButton;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    // construct ui
    public Calculator() {
        setLayout(new FlowLayout());

        // create input field
        inputField = new TextField(20);
        inputField.setEditable(false);
        add(inputField);

        // create buttons for numbers
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new Button(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            add(numberButtons[i]);
        }

        // operation buttons
        addButton = new Button("+");
        subButton = new Button("-");
        mulButton = new Button("x");
        divButton = new Button("/");
        eqButton = new Button("=");
        clrButton = new Button("Clear");

        // add buttons to frame and the action listeners
        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);
        add(eqButton);
        add(clrButton);

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        eqButton.addActionListener(this);
        clrButton.addActionListener(this);

        // frame setup
        setSize(250, 400);
        setVisible(true);
        setTitle("Calculator");

        // close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    // ActionListener method for button clicks
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // number buttons
        for (int i = 0; i < 10; i++) {
            if (command.equals(String.valueOf(i))) {
                inputField.setText(inputField.getText() + i);
            }
        }

        // operator buttons
        if (command.equals("+")) {
            num1 = Double.parseDouble(inputField.getText());
            operator = '+';
            inputField.setText("");
        } else if (command.equals("-")) {
            num1 = Double.parseDouble(inputField.getText());
            operator = '-';
            inputField.setText("");
        } else if (command.equals("x")) {
            num1 = Double.parseDouble(inputField.getText());
            operator = 'x';
            inputField.setText("");
        } else if (command.equals("/")) {
            num1 = Double.parseDouble(inputField.getText());
            operator = '/';
            inputField.setText("");
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(inputField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case 'x':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        inputField.setText("Error: Div by 0");
                        return;
                    }
                    break;
            }
            inputField.setText(String.valueOf(result));
        } else if (command.equals("Clear")) {
            inputField.setText("");
        }
    }

    // main method
    public static void main(String[] args) {
        new Calculator();
    }
}
