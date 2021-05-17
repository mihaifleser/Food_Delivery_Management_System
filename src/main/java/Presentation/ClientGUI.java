package Presentation;

import javax.swing.*;
import java.awt.*;

public class ClientGUI {

    private JFrame frame;
    private JTextArea emailText;
    private JTextArea passwordText;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel accountLabel;
    private JButton logOut;

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


        frame.setLayout(null);
        frame.getContentPane().setBackground(frameColor);
        frame.setSize(width,height + 60);
        frame.setVisible(true);

    }
}
