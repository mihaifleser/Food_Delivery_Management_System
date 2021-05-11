package Presentation;

import javax.swing.*;
import java.awt.*;

public class ClientGUI {

    private JFrame frame;
    private JTextArea emailText;
    private JTextArea passwordText;
    private JButton loginButton;
    private JButton registerButton;

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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel1 = new JLabel("Client GUI");
        titleLabel1.setFont(new Font(Font.SERIF,  Font.BOLD, 22));
        titleLabel1.setBounds(labelWidth + labelWidth / 2, 0,labelWidth,labelHeight);
        frame.add(titleLabel1);

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


        frame.setLayout(null);
        frame.getContentPane().setBackground(frameColor);
        frame.setSize(width,height + 60);
        frame.setVisible(true);

    }
}
