package Presentation;

import javax.swing.*;
import java.awt.*;

public class GenerateReportsGUI {

    private JFrame frame = new JFrame("Generate Reports");
    private JTextArea startHour;
    private JTextArea endHour;
    private JTextArea numberOfTimesOrder;
    private JTextArea clientsNumber;
    private JTextArea valueHigher;
    private JTextArea day;

    private JButton report1;
    private JButton report2;
    private JButton report3;
    private JButton report4;

    public void initialise()
    {
        Color frameColor = Color.decode("#4ECDC4");
        Color buttonColor = Color.decode("#1A535C");
        int width = 1024; int height = 720;
        int labelWidth = width / 5;
        int labelHeight = height / 20;
        int leftMargin = width / 60;
        int buttonWidth = width / 3;
        int buttonHeight = height / 16;


        JLabel titleLabel1 = new JLabel("Generate Reports");
        titleLabel1.setFont(new Font(Font.SERIF,  Font.BOLD, 22));
        titleLabel1.setBounds(labelWidth + labelWidth / 2, 0,labelWidth,labelHeight);
        frame.add(titleLabel1);

        JLabel startHourLabel = new JLabel("Start Hour: ");
        startHourLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 16));
        startHourLabel.setBounds(leftMargin, labelHeight * 2,labelWidth,labelHeight);
        frame.add(startHourLabel);

        startHour = new JTextArea();
        startHour.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        startHour.setBounds(leftMargin, labelHeight * 3,labelWidth,labelHeight / 2);
        frame.add(startHour);

        JLabel endHourLabel = new JLabel("End Hour: ");
        endHourLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 16));
        endHourLabel.setBounds(leftMargin, labelHeight * 4,labelWidth,labelHeight);
        frame.add(endHourLabel);

        endHour = new JTextArea();
        endHour.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        endHour.setBounds(leftMargin, labelHeight * 5,labelWidth,labelHeight / 2);
        frame.add(endHour);

        report1 = new JButton("Report 1");
        report1.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        report1.setBounds(leftMargin, labelHeight * 6,labelWidth,buttonHeight);
        report1.setBackground(buttonColor);
        report1.setForeground(Color.white);
        frame.add(report1);


        JLabel numberOfTimesLabel = new JLabel("Products Ordered More Than: ");
        numberOfTimesLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 16));
        numberOfTimesLabel.setBounds(startHourLabel.getX() + leftMargin + labelWidth, startHourLabel.getY(),labelWidth,labelHeight);
        frame.add(numberOfTimesLabel);

        numberOfTimesOrder = new JTextArea();
        numberOfTimesOrder.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        numberOfTimesOrder.setBounds(numberOfTimesLabel.getX(), labelHeight * 3,labelWidth,labelHeight / 2);
        frame.add(numberOfTimesOrder);

        report2 = new JButton("Report 2");
        report2.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        report2.setBounds(numberOfTimesLabel.getX(), labelHeight * 6,labelWidth,buttonHeight);
        report2.setBackground(buttonColor);
        report2.setForeground(Color.white);
        frame.add(report2);

        JLabel clientsNumberLabel = new JLabel("Clients ordered more than: ");
        clientsNumberLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 16));
        clientsNumberLabel.setBounds(numberOfTimesLabel.getX() + leftMargin + labelWidth, labelHeight * 2,labelWidth,labelHeight);
        frame.add(clientsNumberLabel);

        clientsNumber = new JTextArea();
        clientsNumber.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        clientsNumber.setBounds(clientsNumberLabel.getX(), labelHeight * 3,labelWidth,labelHeight / 2);
        frame.add(clientsNumber);

        JLabel valueHigherLabel = new JLabel("Value Higher Than: ");
        valueHigherLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 16));
        valueHigherLabel.setBounds(clientsNumberLabel.getX(), labelHeight * 4,labelWidth,labelHeight);
        frame.add(valueHigherLabel);

        valueHigher = new JTextArea();
        valueHigher.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        valueHigher.setBounds(clientsNumberLabel.getX(), labelHeight * 5,labelWidth,labelHeight / 2);
        frame.add(valueHigher);

        report3 = new JButton("Report 3");
        report3.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        report3.setBounds(clientsNumberLabel.getX(), labelHeight * 6,labelWidth,buttonHeight);
        report3.setBackground(buttonColor);
        report3.setForeground(Color.white);
        frame.add(report3);


        JLabel dayLabel = new JLabel("Products in day: ");
        dayLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 16));
        dayLabel.setBounds(clientsNumberLabel.getX() + leftMargin + labelWidth, startHourLabel.getY(),labelWidth,labelHeight);
        frame.add(dayLabel);

        day = new JTextArea();
        day.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        day.setBounds(dayLabel.getX(), labelHeight * 3,labelWidth,labelHeight / 2);
        frame.add(day);

        report4 = new JButton("Report 4");
        report4.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        report4.setBounds(dayLabel.getX(), labelHeight * 6,labelWidth,buttonHeight);
        report4.setBackground(buttonColor);
        report4.setForeground(Color.white);
        frame.add(report4);


        frame.setSize(width,height + 60);
        frame.setLayout(null);//using no layout managers
        frame.getContentPane().setBackground(frameColor);
        frame.setVisible(true);//making the frame visible
    }
}
