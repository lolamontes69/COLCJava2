/**
 * Filename:    ComboBoxExample.java
 * Author:      Andrew Laing
 * Email:       parisianconnections@gmail.com
 * Date:        08/02/2018
 * Description:
 */

package uk.ac.livcol.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBoxExample implements ActionListener
{
    public final int HEIGHT = 370;
    public final int WIDTH  = 600;
    public final int COLS   =   2;
    public final int ROWS   =   0;
    public final int HORIZONTAL = 20;
    public final int VERTICAL   = 20;

    JRadioButton radNo = new JRadioButton("No");
    JRadioButton radYes = new JRadioButton("Yes");
    JRadioButton radUnk = new JRadioButton("Unknown");

    JLabel lblEmpNo      = new JLabel("Employee Number");
    JTextField txtEmpNo  = new JTextField(8);
    JLabel lblFName      = new JLabel("First Name");
    JTextField txtFName  = new JTextField(20);
    JLabel lblSName      = new JLabel("Last Name");
    JTextField txtSName  = new JTextField(20);

    /* Define Combobox component */
    JComboBox cboJobs;

    JButton btnView = new JButton("View");
    JButton btnInsert = new JButton("Insert");

    public ComboBoxExample()
    {
        JFrame frm = new JFrame();
        frm.setSize(WIDTH, HEIGHT);
        frm.setResizable(false);

        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frm.setLayout(new GridLayout(ROWS, COLS, HORIZONTAL, VERTICAL));

        /* Define a string array for the combobox contents */
        String[] jobs = {   "Programmer",
                            "Designer",
                            "Project Manager",
                            "System Tester",
                            "System Support Operative"};

        cboJobs = new JComboBox(jobs);

        /* Add radiobuttons to group */
        ButtonGroup bg = new ButtonGroup();

        bg.add(radNo);
        bg.add(radYes);
        bg.add(radUnk);

        frm.add(lblEmpNo);
        frm.add(txtEmpNo);
        frm.add(lblFName);
        frm.add(txtFName);
        frm.add(lblSName);
        frm.add(txtSName);


        /* Add radiobuttons to a panel */
        JPanel pnlMan = new JPanel();

        pnlMan.setLayout(new GridLayout(0,1,10,10));

        pnlMan.add(radNo);
        pnlMan.add(radYes);
        pnlMan.add(radUnk);

        frm.add(pnlMan);

        /* Add the other components */
        frm.add(cboJobs);
        frm.add(btnView);
        frm.add(btnInsert);

        btnInsert.addActionListener(this);
        btnView.addActionListener(this);

        frm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String action =  (String) ae.getActionCommand();

        switch (action)
        {
            case "Insert":
                insert();
                break;
            case "View":
                view();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Unknown Action!");
        }
    }


    private void view()
    {
        String manager = "";
        /* Determine which radio button has been selected */
        if(radUnk.isSelected())
            manager = "Managerial Status Unknown";
        if(radNo.isSelected())
            manager = "is not a manager";
        if(radYes.isSelected())
            manager = "is a manager";

        String job = (String) cboJobs.getSelectedItem();

        String output =  txtFName.getText() + " " + txtSName.getText() + " " +
                         manager + ". Works as a " + job;

        JOptionPane.showMessageDialog(null, output);
    }


    private void insert()
    {
        if(txtFName.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "First name blank");
        }
        if(txtSName.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Surname blank");
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ComboBoxExample cbe = new ComboBoxExample();
            }
        });
    }

}
