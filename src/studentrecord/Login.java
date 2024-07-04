package studentrecord;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    private JPanel loginPanel; 

    private JTextField idField;
    private JPasswordField passwordField;
    private JCheckBox showPassword;
    private JButton loginButton;
    private JLabel registrationLink;

    public Login() {
        setTitle("Student Record Management System");
        setSize(650, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Logo and title
        ImageIcon logoIcon = new ImageIcon("Ibits/logo.png");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(10, 10, 100,100);
        add(logoLabel);

        JLabel titleLabel1 = new JLabel("Student Record Management System");
        titleLabel1.setBounds(153, 35, 500, 30);
        titleLabel1.setForeground(Color.WHITE);
        titleLabel1.setFont(new Font("Arial", Font.BOLD, 35));
        add(titleLabel1);

        JLabel titleLabel2 = new JLabel("LOGIN TO YOUR ACCOUNT");
        titleLabel2.setBounds(153, 80, 500, 30);
        titleLabel2.setForeground(Color.WHITE);
        titleLabel2.setFont(new Font("Arial", Font.PLAIN, 18));
        add(titleLabel2);

        // Login form
        idField = new JTextField();
        idField.setBounds(150, 200, 350, 45);
        add(idField);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 270, 350, 45);
        add(passwordField);

        showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(150, 320, 150, 30);
        showPassword.addActionListener(this);
        add(showPassword);

        loginButton = new JButton("LOGIN");
        loginButton.setBounds(175, 380, 300, 40);
        loginButton.addActionListener(this);
        add(loginButton);

        registrationLink = new JLabel("Register Here");
        registrationLink.setBounds(290, 430, 300, 25);
        registrationLink.setFont(new Font("Arial", Font.PLAIN, 15));
        registrationLink.setForeground(Color.BLUE.darker());
        registrationLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registrationLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showProgressBar(new Registration());
            }
        });
        add(registrationLink);

        // Background image
        ImageIcon bgIcon = new ImageIcon("Ibits/Picture.png"); // Corrected path
        JLabel bgLabel = new JLabel(bgIcon);
        bgLabel.setBounds(0, 0, 650, 800);
        add(bgLabel);

        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('•');
            }
        } else if (e.getSource() == loginButton) {
            // Implement login logic here
            showProgressBar(new StudentInformation());
        }
    }

    private void showProgressBar(JFrame nextFrame) {
        // Simulated loading dialog
        JDialog progressDialog = new JDialog(this, "Loading", true);
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressDialog.add(BorderLayout.CENTER, progressBar);
        progressDialog.setSize(300, 75);
        progressDialog.setLocationRelativeTo(this);

        // Simulate some background work
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(2000); // Simulate loading time
                return null;
            }

            @Override
            protected void done() {
                progressDialog.dispose();
                nextFrame.setVisible(true);
                dispose(); // Close the login frame after login
            }
        };

        worker.execute();
        progressDialog.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Login login = new Login();
            login.setVisible(true);
        });
    }
}
