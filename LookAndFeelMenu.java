import javax.swing.*;
class LookAndFeelMenu {
    public static void createLookAndFeelMenuItem(JMenu menu, JFrame frame) {
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo look : looks) {
            JMenuItem item = new JMenuItem(look.getName());
            item.addActionListener(e -> {
                try {
                    UIManager.setLookAndFeel(look.getClassName());
                    SwingUtilities.updateComponentTreeUI(frame);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            menu.add(item);
        }
    }
}
