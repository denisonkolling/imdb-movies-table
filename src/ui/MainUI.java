package ui;

import logic.Show;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.util.ArrayList;

public class MainUI {

    private JPanel rootPanel;
    private JTable showTable;
    private JComboBox genreCombo;
    private JComboBox typeCombo;
    private JTextField minVotesField;
    private JButton espisodeButton;
    private JButton imdbButton;

    public MainUI() {
        createTable();
        createGenreCombo();
        createTypeCombo();
    }

    public JPanel getRootPanel(){
        return rootPanel;
    }

    private void showShows(){
        Integer minShows = Integer.parseInt(minVotesField.getText());
        String titleType = (String)typeCombo.getSelectedItem();
        String genre = (String)genreCombo.getSelectedItem();
        ArrayList<Show> shows = Show.findShows(minShows, titleType, genre);
    }

    private void createTable() {

        Object[][] data = {
                {"Avatar", 2012, 7.6, 125329},
                {"Inception", 2010, 8.8, 1675166},
                {"Argo", 2012, 7.9, 89256}
        };

        showTable.setModel(new DefaultTableModel(
                data,
                new String[]{"Title", "Year", "Rating", "Num Votes"}
        ));

        TableColumnModel columns = showTable.getColumnModel();
        columns.getColumn(0).setMinWidth(200);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(1).setCellRenderer(centerRenderer);
        columns.getColumn(2).setCellRenderer(centerRenderer);
        columns.getColumn(3).setCellRenderer(centerRenderer);
    }
    private void createGenreCombo(){
        genreCombo.setModel(new DefaultComboBoxModel(new String[]{"Action", "Fantasy", "Drama", "Sci-fi"}));
    }

    private void createTypeCombo(){
        typeCombo.setModel(new DefaultComboBoxModel(new String[]{"Movie", "Series", "Tv Show"}));
    }

}

