import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class CheckBoxRadioExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("CheckBox and RadioButton Example");
            frame.setSize(400, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());
            frame.setLocationRelativeTo(null);

            // Create a JCheckBox
            JCheckBox checkBox = new JCheckBox("Subscribe to newsletter");
            checkBox.setSelected(false); // Unchecked by default

            // Create JRadioButtons with a ButtonGroup
            JRadioButton male = new JRadioButton("Male");
            JRadioButton female = new JRadioButton("Female");
            ButtonGroup genderGroup = new ButtonGroup();
            genderGroup.add(male);
            genderGroup.add(female);

            // Create an output JLabel
            JLabel output = new JLabel("Selections will appear here");

            // Add action listeners
            checkBox.addActionListener(e -> updateOutput(checkBox, male, female, output));
            male.addActionListener(e -> updateOutput(checkBox, male, female, output));
            female.addActionListener(e -> updateOutput(checkBox, male, female, output));

            // Add components to the frame
            frame.add(checkBox);
            frame.add(male);
            frame.add(female);
            frame.add(output);

            frame.setVisible(true);
        });
    }

    private static void updateOutput(JCheckBox checkBox, JRadioButton male, JRadioButton female, JLabel output) {
        StringBuilder result = new StringBuilder();
        if (checkBox.isSelected()) {
            result.append("Subscribed to newsletter. ");
        }
        if (male.isSelected()) {
            result.append("Gender: Male");
        } else if (female.isSelected()) {
            result.append("Gender: Female");
        }
        output.setText(result.length() > 0 ? result.toString() : "No selections made");
    }
}