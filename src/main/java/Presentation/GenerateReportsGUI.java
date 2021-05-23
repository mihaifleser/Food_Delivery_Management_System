package Presentation;

import javax.swing.*;
import java.awt.*;


/**
 * GUI used by the administrator to generate the reports.
 */

public class GenerateReportsGUI {

    private JFrame frame = new JFrame("Generate Reports");
    private JTextArea startHour;
    private JTextArea endHour;
    private JTextArea minProducts;
    private JTextArea minClients;
    private JTextArea valueHigher;
    private JTextArea day;

    private JButton report1 = new JButton("Report 1");;
    private JButton report2 = new JButton("Report 2");;
    private JButton report3 = new JButton("Report 3");;
    private JButton report4 = new JButton("Report 4");;

    public JButton getReportButton1()
    {
        return report1;
    }

    public JButton getReportButton2()
    {
        return report2;
    }

    public JButton getReportButton3()
    {
        return report3;
    }

    public JButton getReportButton4()
    {
        return report4;
    }

    public String getStartHour()
    {
        return startHour.getText();
    }

    public String getEndHour()
    {
        return endHour.getText();
    }

    public String getMinProducts()
    {
        return minProducts.getText();
    }
    public String getMinClients()
    {
        return minClients.getText();
    }
    public String getValueHigher()
    {
        return valueHigher.getText();
    }
    public String getDay()
    {
        return day.getText();
    }

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

        report1.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        report1.setBounds(leftMargin, labelHeight * 6,labelWidth,buttonHeight);
        report1.setBackground(buttonColor);
        report1.setForeground(Color.white);
        frame.add(report1);


        JLabel numberOfTimesLabel = new JLabel("Products Ordered More Than: ");
        numberOfTimesLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 16));
        numberOfTimesLabel.setBounds(startHourLabel.getX() + leftMargin + labelWidth, startHourLabel.getY(),labelWidth,labelHeight);
        frame.add(numberOfTimesLabel);

        minProducts = new JTextArea();
        minProducts.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        minProducts.setBounds(numberOfTimesLabel.getX(), labelHeight * 3,labelWidth,labelHeight / 2);
        frame.add(minProducts);


        report2.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        report2.setBounds(numberOfTimesLabel.getX(), labelHeight * 6,labelWidth,buttonHeight);
        report2.setBackground(buttonColor);
        report2.setForeground(Color.white);
        frame.add(report2);

        JLabel minClientsLabel = new JLabel("Clients ordered more than: ");
        minClientsLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 16));
        minClientsLabel.setBounds(numberOfTimesLabel.getX() + leftMargin + labelWidth, labelHeight * 2,labelWidth,labelHeight);
        frame.add(minClientsLabel);

        minClients = new JTextArea();
        minClients.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        minClients.setBounds(minClientsLabel.getX(), labelHeight * 3,labelWidth,labelHeight / 2);
        frame.add(minClients);

        JLabel valueHigherLabel = new JLabel("Value Higher Than: ");
        valueHigherLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 16));
        valueHigherLabel.setBounds(minClientsLabel.getX(), labelHeight * 4,labelWidth,labelHeight);
        frame.add(valueHigherLabel);

        valueHigher = new JTextArea();
        valueHigher.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        valueHigher.setBounds(minClientsLabel.getX(), labelHeight * 5,labelWidth,labelHeight / 2);
        frame.add(valueHigher);


        report3.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        report3.setBounds(minClientsLabel.getX(), labelHeight * 6,labelWidth,buttonHeight);
        report3.setBackground(buttonColor);
        report3.setForeground(Color.white);
        frame.add(report3);


        JLabel dayLabel = new JLabel("Products in day: ");
        dayLabel.setFont(new Font(Font.SERIF,  Font.ITALIC, 16));
        dayLabel.setBounds(minClientsLabel.getX() + leftMargin + labelWidth, startHourLabel.getY(),labelWidth,labelHeight);
        frame.add(dayLabel);

        day = new JTextArea();
        day.setFont(new Font(Font.SERIF,  Font.PLAIN, 16));
        day.setBounds(dayLabel.getX(), labelHeight * 3,labelWidth,labelHeight / 2);
        frame.add(day);


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
