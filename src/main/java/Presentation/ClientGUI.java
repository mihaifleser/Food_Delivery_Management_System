package Presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ClientGUI {

    private JFrame frame;
    private JTextArea emailText;
    private JTextArea passwordText;

    private JTextArea searchTitle;
    private JTextArea searchRating;
    private JTextArea searchCalories;
    private JTextArea searchProtein;
    private JTextArea searchFat;
    private JTextArea searchSodium;
    private JTextArea searchPrice;

    private JButton loginButton;
    private JButton searchButton;
    private JButton registerButton;
    private JButton addButton;
    private JButton removeButton;
    private JButton orderButton;
    private JLabel accountLabel;
    private JButton logOut;

    private JTable productsTable = new JTable();

    private JTextArea consoleText = new JTextArea();


    public void addTextOnConsole(String s)
    {
        consoleText.setText(consoleText.getText() + s);
    }
    public void setTextOnConsole(String s)
    {
        consoleText.setText(s);
    }

    public JButton getAddButton()
    {
        return addButton;
    }
    public JButton getRemoveButton()
    {
        return removeButton;
    }
    public JButton getOrderButton()
    {
        return orderButton;
    }

    public JTable getProductsTable()
    {
        return productsTable;
    }

    public JButton getSearchButton()
    {
        return searchButton;
    }

    public String getSearchedTitle()
    {
        return searchTitle.getText();
    }
    public String getSearchedRating()
    {
        return searchRating.getText();
    }
    public String getSearchedCalories()
    {
        return searchCalories.getText();
    }
    public String getSearchedProteins()
    {
        return searchProtein.getText();
    }
    public String getSearchedFat()
    {
        return searchFat.getText();
    }
    public String getSearchedSodium()
    {
        return searchSodium.getText();
    }
    public String getSearchedPrice()
    {
        return searchPrice.getText();
    }

    public JButton getLogOut()
    {
        return logOut;
    }
    public JLabel getAccountLabel() {
        return accountLabel;
    }

    public String getUserEmail()
    {
        return emailText.getText();
    }

    public JTextArea getEmailTextArea()
    {
        return emailText;
    }
    public JTextArea getPasswordTextArea()
    {
        return passwordText;
    }
    public String getUserPassword()
    {
        return passwordText.getText();
    }

    public JButton getLoginButton()
    {
        return loginButton;
    }

    public JButton getRegisterButton()
    {
        return registerButton;
    }

    public void initialise()
    {
        Color frameColor = Color.decode("#4ECDC4");
        Color buttonColor = Color.decode("#1A535C");
        int width = 1024; int height = 720;
        int labelWidth = width / 4;
        int labelHeight = height / 15;
        int leftMargin = width / 60;
        int buttonWidth = width / 8;
        int buttonHeight = height / 16;
        frame=new JFrame("Client");//creating instance of JFrame

        JLabel titleLabel1 = new JLabel("Client GUI");
        titleLabel1.setFont(new Font(Font.SERIF,  Font.BOLD, 22));
        titleLabel1.setBounds(labelWidth + labelWidth / 2, 0,labelWidth,labelHeight);
        frame.add(titleLabel1);

        accountLabel = new JLabel("");
        accountLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 16));
        accountLabel.setBounds(leftMargin, labelHeight,buttonWidth,labelHeight);
        frame.add(accountLabel);

        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 16));
        emailLabel.setBounds(leftMargin, labelHeight * 2,labelWidth,labelHeight);
        frame.add(emailLabel);

        emailText = new JTextArea();
        emailText.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        emailText.setBounds(leftMargin, labelHeight * 3,labelWidth,labelHeight / 2);
        frame.add(emailText);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 16));
        passwordLabel.setBounds(leftMargin, labelHeight * 4,labelWidth,labelHeight);
        frame.add(passwordLabel);

        passwordText = new JTextArea();
        passwordText.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        passwordText.setBounds(leftMargin, labelHeight * 5,labelWidth,labelHeight / 2);
        frame.add(passwordText);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        loginButton.setBounds(leftMargin, labelHeight * 6,buttonWidth,buttonHeight);
        loginButton.setBackground(buttonColor);
        loginButton.setForeground(Color.white);
        frame.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        registerButton.setBounds(leftMargin + buttonWidth, labelHeight * 6,buttonWidth,buttonHeight);
        registerButton.setBackground(buttonColor);
        registerButton.setForeground(Color.white);
        frame.add(registerButton);

        logOut = new JButton("Log Out");
        logOut.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        logOut.setBounds(leftMargin + buttonWidth, labelHeight,buttonWidth,buttonHeight);
        logOut.setBackground(buttonColor);
        logOut.setForeground(Color.white);
        frame.add(logOut);
        logOut.setEnabled(false);

        DefaultTableModel model = (DefaultTableModel) productsTable.getModel();
        String[] columnNames = { "Title", "Rating", "Calories", "Proteins", "Fat", "Sodium", "Price" };
        for (String str: columnNames)
        {
            model.addColumn(str);
        }

        JScrollPane sp2 = new JScrollPane(productsTable);
        sp2.setBounds(emailText.getX() + labelWidth + 15,emailText.getY(),700,500);
        frame.add(sp2);

        searchTitle = new JTextArea();
        searchTitle.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        searchTitle.setBounds(sp2.getX(), sp2.getY() + 500 + 10,90,labelHeight / 2);
        frame.add(searchTitle);

        searchRating = new JTextArea();
        searchRating.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        searchRating.setBounds(sp2.getX() + 100, sp2.getY() + 500 + 10,90,labelHeight / 2);
        frame.add(searchRating);

        searchCalories = new JTextArea();
        searchCalories.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        searchCalories.setBounds(sp2.getX() + 200, sp2.getY() + 500 + 10,90,labelHeight / 2);
        frame.add(searchCalories);

        searchProtein = new JTextArea();
        searchProtein.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        searchProtein.setBounds(sp2.getX() + 300, sp2.getY() + 500 + 10,90,labelHeight / 2);
        frame.add(searchProtein);

        searchFat = new JTextArea();
        searchFat.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        searchFat.setBounds(sp2.getX() + 400, sp2.getY() + 500 + 10,90,labelHeight / 2);
        frame.add(searchFat);

        searchSodium = new JTextArea();
        searchSodium.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        searchSodium.setBounds(sp2.getX() + 500, sp2.getY() + 500 + 10,90,labelHeight / 2);
        frame.add(searchSodium);

        searchPrice = new JTextArea();
        searchPrice.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        searchPrice.setBounds(sp2.getX() + 600, sp2.getY() + 500 + 10,90,labelHeight / 2);
        frame.add(searchPrice);

        searchButton = new JButton("Search");
        searchButton.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        searchButton.setBounds(searchTitle.getX(), searchPrice.getY() + 40,buttonWidth,searchPrice.getHeight());
        searchButton.setBackground(buttonColor);
        searchButton.setForeground(Color.white);
        frame.add(searchButton);

        consoleText.setRows(6);
        consoleText.setColumns(15);
        consoleText.setBounds(leftMargin,registerButton.getY() + buttonHeight * 2, buttonWidth * 2, buttonHeight * 3);
        consoleText.setEditable(false);
        consoleText.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(leftMargin,registerButton.getY() + buttonHeight * 2, buttonWidth * 2, buttonHeight * 3);
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.getViewport().add(consoleText);
        scroll.setLocation(leftMargin,registerButton.getY() + buttonHeight * 2);
        frame.add(scroll);

        addButton = new JButton("Add");
        addButton.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        addButton.setBounds(leftMargin, scroll.getY() + scroll.getHeight() + labelHeight,buttonWidth,buttonHeight);
        addButton.setBackground(buttonColor);
        addButton.setForeground(Color.white);
        frame.add(addButton);
        addButton.setEnabled(false);

        removeButton = new JButton("Remove");
        removeButton.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        removeButton.setBounds(leftMargin + buttonWidth, addButton.getY(),buttonWidth,buttonHeight);
        removeButton.setBackground(buttonColor);
        removeButton.setForeground(Color.white);
        frame.add(removeButton);
        removeButton.setEnabled(false);

        orderButton = new JButton("Order");
        orderButton.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        orderButton.setBounds(addButton.getX(), addButton.getY() + labelHeight, buttonWidth * 2,buttonHeight);
        orderButton.setBackground(buttonColor);
        orderButton.setForeground(Color.white);
        frame.add(orderButton);
        orderButton.setEnabled(false);


        frame.setLayout(null);
        frame.getContentPane().setBackground(frameColor);
        frame.setSize(width,height + 60);
        frame.setVisible(true);

    }
}
