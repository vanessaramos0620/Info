package studentrecord;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class StudentInformation extends JFrame implements ActionListener {
    private DefaultTableModel model;
    private JTable table;
    private JButton addButton, deleteButton, editButton, logoutButton;

    public StudentInformation() {
        setTitle("Student Information");
        setSize(800, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(100, 0, 0));
        JLabel headerLabel = new JLabel("Student Record Management System");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Table
        model = new DefaultTableModel(new Object[]{"Student ID", "LastName", "FirstName", "MiddleName", "Course", "Year", "Address", "Contact Number", "Position", "Organization"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add Record");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        deleteButton = new JButton("Delete Record");
        deleteButton.addActionListener(this);
        buttonPanel.add(deleteButton);

 
        logoutButton = new JButton("Back");
        logoutButton.addActionListener(this);
        buttonPanel.add(logoutButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            model.addRow(new Object[]{"", "", "", "" ,"", "","", "", "", ""});
        } else if (e.getSource() == deleteButton) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
            }
        } else if (e.getSource() == editButton) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                table.editCellAt(selectedRow, 0);
            }
        } else if (e.getSource() == logoutButton) {
            new Login().setVisible(true);
            dispose();
        }
    }}

   
