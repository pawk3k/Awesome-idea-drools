package com.sample;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class Main {
    JDialog dialog;
    int result = -1;
    ArrayList<String> variants;
    String title;
    private void displayGUI() {
        JOptionPane optionPane = new JOptionPane(getPanel(),
                JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null,
                new Object[] {}, null);
        dialog = optionPane.createDialog("Question");
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    private JPanel getPanel() {
        JPanel panel = new JPanel(new GridLayout(0,2));
        JLabel label = new JLabel(this.title);
        JLabel labele = new JLabel("");
        panel.add(label);
        panel.add(labele);
        for( int i = 0 ;i< variants.size(); i++){
            JButton button = new JButton(variants.get(i));
            int finalI = i;
            button.addActionListener(e -> {
                this.result = finalI;
                dialog.dispose();
            });
            panel.add(button);

        }
        return panel;
    }
    public Main(ArrayList<String> variants , String title){
        this.variants = variants;
        this.title = title;
        displayGUI();
    }

    public int getResult() {
        return result;
    }
}
