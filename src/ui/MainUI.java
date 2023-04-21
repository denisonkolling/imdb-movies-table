package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainUI {

    private JPanel rootPanel;
    private JTable showTable;
    private JComboBox gnreCombo;
    private JComboBox typeConbo;
    private JTextField minVotesField;
    private JButton espisodeButton;
    private JButton imdbButton;

    public MainUI() {
        createTable();
    }

    public JPanel getRootPanel(){
        return rootPanel;
    }

    private void createTable() {
        Object [][] data = {
                {"Avatar", 2012, 7.6, 125329},
                {"Inception", 2010, 8.8, 1675166},
                {"Argo", 2012, 7.9, 89256}
        };
        showTable.setModel(new DefaultTableModel(
                data,
                new String[]{"Title", "Year", "Rating", "Num Votes"}
        ));


    }
}
