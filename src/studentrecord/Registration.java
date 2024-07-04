package studentrecord;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Registration extends JFrame implements ActionListener {
    private JTextField idField, lastNameField, firstNameField, middleNameField, courseField, yearField, addressField, contactNumberField, positionField, organizationField;
    private JPasswordField passwordField;
    private JButton registerButton, backButton;

    public Registration() {
        setTitle("Student Registration");
        setSize(800, 600);
        setLayout(new GridLayout(12, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Registration form
        add(new JLabel("Student ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        add(lastNameField);

        add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        add(firstNameField);

        add(new JLabel("Middle Name:"));
        middleNameField = new JTextField();
        add(middleNameField);

        add(new JLabel("Course:"));
        courseField = new JTextField();
        add(courseField);

        add(new JLabel("Year:"));
        yearField = new JTextField();
        add(yearField);

        add(new JLabel("Address:"));
        addressField = new JTextField();
        add(addressField);

        add(new JLabel("Contact Number:"));
        contactNumberField = new JTextField();
        add(contactNumberField);

        add(new JLabel("Position:"));
        positionField = new JTextField();
        add(positionField);

        add(new JLabel("Organization:"));
        organizationField = new JTextField();
        add(organizationField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        add(registerButton);

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        add(backButton);

        // Add action listener to fields for Enter key (already implemented as per previous code)
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            // Perform registration logic here (to be implemented)
            // For now, simulate loading and move back to login
            showProgressBar(new Login());
        } else if (e.getSource() == backButton) {
            showProgressBar(new Login());
        }
    }

    private void showProgressBar(JFrame nextFrame) {
        JDialog progressDialog = new JDialog(this, "Loading", true);
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressDialog.add(BorderLayout.CENTER, progressBar);
        progressDialog.setSize(300, 75);
        progressDialog.setLocationRelativeTo(this);

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
                dispose(); // Close the current frame after loading
            }
        };

        worker.execute();
        progressDialog.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Registration registration = new Registration();
            registration.setVisible(true);
        });
    }
}
