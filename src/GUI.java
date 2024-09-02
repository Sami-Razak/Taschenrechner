import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    private JTextField display;
    private double firstnumber = 0;
    private double secondnumber = 0;
    private String operator = "";
    private boolean startnewnumber = true;

    public GUI(){

    setTitle("Taschenrechner");
    setSize(300,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    display = new JTextField();
    display.setFont(new Font("Arial",Font.ITALIC,24));
    display.setEditable(false);
    add(display,BorderLayout.NORTH);

    JPanel panel= new JPanel();
    panel.setLayout(new GridLayout(4,4,10,10));

    String[] buttons = {

            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","+",
            "0",".","=","-",
    };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 24));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);

    }
@Override
public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();

    if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
        if (startnewnumber) {
            display.setText(command);
            startnewnumber = false;
        } else {
            display.setText(display.getText() + command);
        }
    } else if (command.equals("=")) {
        secondnumber = Double.parseDouble(display.getText());
        switch (operator) {
            case "+": firstnumber += secondnumber; break;
            case "-": firstnumber -= secondnumber; break;
            case "*": firstnumber *= secondnumber; break;
            case "/": firstnumber /= secondnumber; break;
        }
        display.setText(String.valueOf(firstnumber));
        operator = "";
        startnewnumber = true;
    } else {
        if (!operator.isEmpty()) {
            secondnumber = Double.parseDouble(display.getText());
            switch (operator) {
                case "+": firstnumber += secondnumber; break;
                case "-": firstnumber -= secondnumber; break;
                case "*": firstnumber *= secondnumber; break;
                case "/": firstnumber /= secondnumber; break;
            }
            display.setText(String.valueOf(firstnumber));
        } else {
            firstnumber = Double.parseDouble(display.getText());
        }
        operator = command;
        startnewnumber = true;
    }
}


public static void main (String[] args){
    SwingUtilities.invokeLater(()->{
    GUI gui = new GUI();
    gui.setVisible(true);
    });
}}