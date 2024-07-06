import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FindDialog extends JDialog implements ActionListener {
    private JTextArea textArea;
    private JTextField findField;
    private JTextField replaceField;
    private boolean isFind;

    public FindDialog(JTextArea textArea) {
        this.textArea = textArea;
        setupDialog();
    }

    private void setupDialog() {
        setTitle("Find/Replace");
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Find:"));
        findField = new JTextField(20);
        add(findField);

        add(new JLabel("Replace:"));
        replaceField = new JTextField(20);
        add(replaceField);

        JButton findButton = new JButton("Find");
        findButton.setActionCommand("Find");
        findButton.addActionListener(this);
        add(findButton);

        JButton replaceButton = new JButton("Replace");
        replaceButton.setActionCommand("Replace");
        replaceButton.addActionListener(this);
        add(replaceButton);

        pack();
        setModal(false);
    }

    public void showDialog(Frame parent, boolean isFind) {
        this.isFind = isFind;
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    public void findNextWithSelection() {
        // Implement your find logic here
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Find")) {
            // Implement your find logic here
        } else if (command.equals("Replace")) {
            // Implement your replace logic here
        }
    }
}
