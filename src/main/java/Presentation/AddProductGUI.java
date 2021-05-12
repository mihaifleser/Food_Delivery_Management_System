package Presentation;

import javax.swing.*;
import java.awt.*;

public class AddProductGUI {

    private JFrame frame = new JFrame("Insert new Product");

    private JTextArea title = new JTextArea();
    private JTextArea rating = new JTextArea();
    private JTextArea calories = new JTextArea();
    private JTextArea proteins = new JTextArea();
    private JTextArea fat = new JTextArea();
    private JTextArea sodium = new JTextArea();
    private JTextArea price = new JTextArea();
    private JButton add = new JButton("ADD");

    public AddProductGUI()
    {

    }

    public JButton getAddButton()
    {
        return add;
    }

    public String getTitle() {
        return title.getText();
    }

    public String getRating() {
        return rating.getText();
    }

    public String getCalories() {
        return calories.getText();
    }

    public String getProteins() {
        return proteins.getText();
    }

    public String getFat() {
        return fat.getText();
    }

    public String getSodium() {
        return sodium.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public void initialise()
    {
        Color frameColor = Color.decode("#4ECDC4");
        Color buttonColor = Color.decode("#1A535C");
        int width = 400; int height = 720;
        int labelWidth = width / 4;
        int labelHeight = height / 20;
        int leftMargin = width / 60;
        int buttonWidth = width / 3;
        int buttonHeight = height / 8;

        JLabel titleLabel = new JLabel("Title: ");
        titleLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 18));
        titleLabel.setBounds(leftMargin, labelHeight,labelWidth,labelHeight);
        frame.add(titleLabel);

        title.setFont(new Font(Font.SERIF,  Font.PLAIN, 17));
        title.setBounds(titleLabel.getX(), titleLabel.getY() + labelHeight,labelWidth * 2,labelHeight - labelHeight / 3);
        frame.add(title);

        JLabel ratingLabel = new JLabel("Rating:");
        ratingLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 18));
        ratingLabel.setBounds(leftMargin, labelHeight * 3,labelWidth,labelHeight);
        frame.add(ratingLabel);

        rating.setFont(new Font(Font.SERIF,  Font.PLAIN, 17));
        rating.setBounds(ratingLabel.getX(), ratingLabel.getY() + labelHeight,labelWidth * 2,labelHeight - labelHeight / 3);
        frame.add(rating);

        JLabel caloriesLabel = new JLabel("Calories:");
        caloriesLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 18));
        caloriesLabel.setBounds(leftMargin, labelHeight * 5,labelWidth,labelHeight);
        frame.add(caloriesLabel);

        calories.setFont(new Font(Font.SERIF,  Font.PLAIN, 17));
        calories.setBounds(caloriesLabel.getX(), caloriesLabel.getY() + labelHeight,labelWidth * 2,labelHeight - labelHeight / 3);
        frame.add(calories);

        JLabel proteinsLabel = new JLabel("Proteins:");
        proteinsLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 18));
        proteinsLabel.setBounds(leftMargin, labelHeight * 7,labelWidth,labelHeight);
        frame.add(proteinsLabel);

        proteins.setFont(new Font(Font.SERIF,  Font.PLAIN, 17));
        proteins.setBounds(proteinsLabel.getX(), proteinsLabel.getY() + labelHeight,labelWidth * 2,labelHeight - labelHeight / 3);
        frame.add(proteins);

        JLabel fatLabel = new JLabel("Fat:");
        fatLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 18));
        fatLabel.setBounds(leftMargin, labelHeight * 9,labelWidth,labelHeight);
        frame.add(fatLabel);

        fat.setFont(new Font(Font.SERIF,  Font.PLAIN, 17));
        fat.setBounds(fatLabel.getX(), fatLabel.getY() + labelHeight,labelWidth * 2,labelHeight - labelHeight / 3);
        frame.add(fat);

        JLabel sodiumLabel = new JLabel("Sodium:");
        sodiumLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 18));
        sodiumLabel.setBounds(leftMargin, labelHeight * 11,labelWidth,labelHeight);
        frame.add(sodiumLabel);

        sodium.setFont(new Font(Font.SERIF,  Font.PLAIN, 17));
        sodium.setBounds(sodiumLabel.getX(), sodiumLabel.getY() + labelHeight,labelWidth * 2,labelHeight - labelHeight / 3);
        frame.add(sodium);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 18));
        priceLabel.setBounds(leftMargin, labelHeight * 13,labelWidth,labelHeight);
        frame.add(priceLabel);

        price.setFont(new Font(Font.SERIF,  Font.PLAIN, 17));
        price.setBounds(priceLabel.getX(), priceLabel.getY() + labelHeight,labelWidth * 2,labelHeight - labelHeight / 3);
        frame.add(price);


        add.setBounds(leftMargin,price.getY() + labelHeight,buttonWidth, buttonHeight);//x axis, y axis, width, height
        add.setBackground(buttonColor);
        add.setFont(new Font(Font.SERIF,  Font.BOLD, 16));
        add.setForeground(Color.white);
        frame.add(add);

        frame.setSize(width,height + 60);
        frame.setLayout(null);//using no layout managers
        frame.getContentPane().setBackground(frameColor);
        frame.setVisible(true);//making the frame visible
    }
}
