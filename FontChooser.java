import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FontChooser {
    private JDialog dialog;
    private JComboBox<String> fontCombo;
    private JComboBox<Integer> sizeCombo;
    private JTextArea sample;

    public FontChooser(Font initialFont) {
        dialog = new JDialog();
        dialog.setTitle("Font Chooser");
        dialog.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(2, 2));
        topPanel.add(new JLabel("Font:"));
        fontCombo = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        fontCombo.setSelectedItem(initialFont.getFamily());
        topPanel.add(fontCombo);

        topPanel.add(new JLabel("Size:"));
        sizeCombo = new JComboBox<>(new Integer[]{8, 10, 12, 14, 16, 18, 20, 24, 28, 32, 36, 40, 44, 48});
        sizeCombo.setSelectedItem(initialFont.getSize());
        topPanel.add(sizeCombo);

        dialog.add(topPanel, BorderLayout.NORTH);

        sample = new JTextArea("Sample Text");
        sample.setFont(initialFont);
        dialog.add(new JScrollPane(sample), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> dialog.setVisible(false));
        bottomPanel.add(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dialog.setVisible(false));
        bottomPanel.add(cancelButton);

        dialog.add(bottomPanel, BorderLayout.SOUTH);
        dialog.pack();
    }

    public boolean showDialog(Component parent, String title) {
        dialog.setTitle(title);
        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);
        return true;
    }

    public Font createFont() {
        String fontName = (String) fontCombo.getSelectedItem();
        int fontSize = (Integer) sizeCombo.getSelectedItem();
        return new Font(fontName, Font.PLAIN, fontSize);
    }
}
