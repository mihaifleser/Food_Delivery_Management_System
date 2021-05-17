package Presentation;

import javax.swing.*;
import java.awt.*;

public class EmployeeGUI {

    private JFrame frame;
    private JTextArea consoleText = new JTextArea();


    public void addTextOnConsole(String s)
    {
        consoleText.setText(consoleText.getText() + s);
    }
    public void setTextOnConsole(String s)
    {
        consoleText.setText(s);
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
        frame=new JFrame("Employee");//creating instance of JFrame

        JLabel titleLabel1 = new JLabel("Employee's Notification");
        titleLabel1.setFont(new Font(Font.SERIF,  Font.BOLD, 22));
        titleLabel1.setBounds(labelWidth + labelWidth / 2, 0,labelWidth,labelHeight);
        frame.add(titleLabel1);

        consoleText.setRows(20);
        consoleText.setColumns(30);
        consoleText.setBounds(leftMargin,labelHeight * 2, width / 2  + width / 3, height / 2 + height / 4);
        consoleText.setEditable(false);
        consoleText.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(leftMargin,labelHeight * 2 + labelHeight, width / 2  + width / 3, height / 2 + height / 4);
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.getViewport().add(consoleText);
        scroll.setLocation(leftMargin, labelHeight * 2);
        frame.add(scroll);

        frame.setLayout(null);
        frame.getContentPane().setBackground(frameColor);
        frame.setSize(width,height + 60);
        frame.setVisible(true);

    }
}
