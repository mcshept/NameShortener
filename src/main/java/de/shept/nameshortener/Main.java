package de.shept.nameshortener;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Main {

    private JFrame frame;
    private JTextField originalField;
    public static JTextField textField_1;

    public static String newText;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Main() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelMain = new JPanel();
        JPanel panelSettings = new JPanel();

        JTabbedPane tabpane = new JTabbedPane
                (JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

        tabpane.addTab("Main", panelMain);
        panelMain.setLayout(null);

        JLabel originalLbl = new JLabel("Original");
        originalLbl.setBounds(163, 10, 85, 13);
        panelMain.add(originalLbl);

        originalField = new JTextField();
        originalField.setBounds(92, 33, 259, 19);
        panelMain.add(originalField);
        originalField.setColumns(10);

        JButton runBtn = new JButton("Run");
        runBtn.setBounds(163, 62, 85, 21);
        runBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == runBtn) {
                    if (originalField.getText() != null) {
                        if (originalField.getText().contains("a")
                                || originalField.getText().contains("e")
                                || originalField.getText().contains("i")
                                || originalField.getText().contains("o")
                                || originalField.getText().contains("u")) {
                            newText = originalField.getText()
                                    .replaceAll("a", "")
                                    .replaceAll("e", "")
                                    .replaceAll("i", "")
                                    .replaceAll("o", "")
                                    .replaceAll("u", "");
                        }
                        String output = "";
                        for (int index = 0; index < newText.length(); index++) {
                            if (newText.charAt(index % newText.length()) != newText
                                    .charAt((index + 1) % newText.length())) {

                                output += newText.charAt(index);

                            }
                        }
                        textField_1.setText(output);
                    }
                }
            }
        });
        panelMain.add(runBtn);

        JLabel newLbl = new JLabel("Output");
        newLbl.setBounds(180, 112, 45, 13);
        panelMain.add(newLbl);

        textField_1 = new JTextField();
        textField_1.setEditable(false);
        textField_1.setBounds(92, 157, 259, 19);
        panelMain.add(textField_1);
        textField_1.setColumns(10);
        tabpane.addTab("Settings", panelSettings);
        panelSettings.setLayout(null);

        JLabel csLbl = new JLabel("Coming soon...");
        csLbl.setBounds(113, 62, 178, 59);
        panelSettings.add(csLbl);

        frame.getContentPane().add(tabpane);
        frame.setVisible(true);
    }

}

