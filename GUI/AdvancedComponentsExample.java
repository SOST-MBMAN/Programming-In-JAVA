import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class AdvancedComponentsExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create a JFrame
            JFrame frame = new JFrame("JFrame, JPanel, JTree, JTable Example");
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.setLocationRelativeTo(null);

            // Create a JPanel for grouping components
            JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));

            // Create a JTree
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
            DefaultMutableTreeNode folder1 = new DefaultMutableTreeNode("Folder 1");
            DefaultMutableTreeNode folder2 = new DefaultMutableTreeNode("Folder 2");
            folder1.add(new DefaultMutableTreeNode("File 1"));
            folder1.add(new DefaultMutableTreeNode("File 2"));
            root.add(folder1);
            root.add(folder2);
            JTree tree = new JTree(root);
            JScrollPane treeScroll = new JScrollPane(tree);

            // Create a JTable
            String[] columns = {"ID", "Name", "Age"};
            Object[][] data = {
                {1, "Alice", 25},
                {2, "Bob", 30},
                {3, "Charlie", 35}
            };
            JTable table = new JTable(data, columns);
            JScrollPane tableScroll = new JScrollPane(table);

            // Add tree and table to the panel
            panel.add(treeScroll);
            panel.add(tableScroll);

            // Add panel to the frame
            frame.add(panel, BorderLayout.CENTER);

            // Make the frame visible
            frame.setVisible(true);
        });
    }
}