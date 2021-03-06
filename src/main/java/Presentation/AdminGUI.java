package Presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.reflect.Field;

/**
 * Administrator GUI.
 */
public class AdminGUI{


    private JFrame frame;
    private JButton importButton;
    private JButton addButton;
    private JButton deleteButton;
    private JButton editButton;
    private JButton composeButton;
    private JButton generateReports;
    private JTextArea newMenu;

    private JTable productsTable = new JTable();

    public JButton getGenerateReports()
    {
        return generateReports;
    }

    public JFrame getFrame()
    {
        return frame;
    }

    public JTable getProductsTable()
    {
        return productsTable;
    }

    public String getNewMenuTitle()
    {
        return newMenu.getText();
    }

    public JButton getImportButton()
    {
        return importButton;
    }

    public JButton getAddButton()
    {
        return addButton;
    }

    public JButton getDeleteButton()
    {
        return deleteButton;
    }

    public JButton getEditButton()
    {
        return editButton;
    }

    public JButton getComposeButton()
    {
        return composeButton;
    }

    public void initialise()
    {
        Color frameColor = Color.decode("#4ECDC4");
        Color buttonColor = Color.decode("#1A535C");
        int width = 1024; int height = 720;
        int labelWidth = width / 4;
        int labelHeight = height / 15;
        int leftMargin = width / 60;
        int buttonWidth = width / 6;
        int buttonHeight = height / 8;
        frame=new JFrame("Admin");//creating instance of JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel1 = new JLabel("Admin GUI");
        titleLabel1.setFont(new Font(Font.SERIF,  Font.BOLD, 22));
        titleLabel1.setBounds(labelWidth + labelWidth / 2, 0,labelWidth,labelHeight);
        frame.add(titleLabel1);

        importButton = new JButton("Import");
        importButton.setFont(new Font(Font.SERIF,  Font.PLAIN, 20));
        importButton.setBounds(leftMargin, buttonHeight,buttonWidth,buttonHeight);
        importButton.setBackground(buttonColor);
        importButton.setForeground(Color.white);
        frame.add(importButton);

        addButton = new JButton("Add");
        addButton.setFont(new Font(Font.SERIF,  Font.PLAIN, 20));
        addButton.setBounds(leftMargin, buttonHeight * 2,buttonWidth,buttonHeight);
        addButton.setBackground(buttonColor);
        addButton.setForeground(Color.white);
        frame.add(addButton);

        deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font(Font.SERIF,  Font.PLAIN, 20));
        deleteButton.setBounds(leftMargin, buttonHeight * 3,buttonWidth,buttonHeight);
        deleteButton.setBackground(buttonColor);
        deleteButton.setForeground(Color.white);
        frame.add(deleteButton);

        editButton = new JButton("Edit");
        editButton.setFont(new Font(Font.SERIF,  Font.PLAIN, 20));
        editButton.setBounds(leftMargin, buttonHeight * 4,buttonWidth,buttonHeight);
        editButton.setBackground(buttonColor);
        editButton.setForeground(Color.white);
        frame.add(editButton);

        composeButton = new JButton("Compose Menu");
        composeButton.setFont(new Font(Font.SERIF,  Font.PLAIN, 20));
        composeButton.setBounds(leftMargin, buttonHeight * 6,buttonWidth,buttonHeight);
        composeButton.setBackground(buttonColor);
        composeButton.setForeground(Color.white);
        frame.add(composeButton);

        DefaultTableModel model = (DefaultTableModel) productsTable.getModel();
        String[] columnNames = { "Title", "Rating", "Calories", "Proteins", "Fat", "Sodium", "Price" };
        for (String str: columnNames)
        {
            model.addColumn(str);
        }

        JScrollPane sp2 = new JScrollPane(productsTable);
        sp2.setBounds(importButton.getX() + labelWidth,importButton.getY(),700,500);
        frame.add(sp2);

        newMenu = new JTextArea();
        newMenu.setFont(new Font(Font.SERIF,  Font.PLAIN, 17));
        newMenu.setBounds(composeButton.getX(), composeButton.getY() + buttonHeight,buttonWidth,labelHeight - labelHeight / 3);
        newMenu.setText("New Menu");
        frame.add(newMenu);

        generateReports = new JButton("Generate Reports");
        generateReports.setFont(new Font(Font.SERIF,  Font.PLAIN, 20));
        generateReports.setBounds(leftMargin + buttonWidth * 2, newMenu.getY(),buttonWidth * 2,buttonHeight);
        generateReports.setBackground(buttonColor);
        generateReports.setForeground(Color.white);
        frame.add(generateReports);

        frame.setLayout(null);
        frame.getContentPane().setBackground(frameColor);
        frame.setSize(width,height + 60);
        frame.setVisible(true);

    }

}
