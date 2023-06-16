
import org.w3c.dom.ls.LSOutput;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

class Home extends JFrame {

    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    Statement statement;

    public Home() {
        connection = javaconnect.setconnection();
        firstScreen();
    }

    // =-=-=-=  The Starting Screen -=-=-=-
    public void firstScreen() {
        JButton patientSec, empSec, departmentSec, doctorSec, roomSec;

        JLabel signature, image;

        ImageIcon image1 = new ImageIcon("startingScreenImage.jpeg");

        image = new JLabel(image1);

        patientSec = new JButton("Patient");
        empSec = new JButton("Employee");
        departmentSec = new JButton("Department");
        doctorSec = new JButton("Room");
        roomSec = new JButton("Doctor");

        JFrame frame = new JFrame();

        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);

        Font f2 = new Font("Arial", Font.PLAIN, 10);

        signature = new JLabel("<html><body>Done by:"
                + "<br>- Nawaf Abdulaziz AlGhamdi | 2037159"
                + "<br>- Tareq Fuad Bajaber | 2035796"
                + "<br>- Faisal Omar Balamash | 2036827"
                + "<br>- Naif Askul  | 2035052"
                + "</body></html>");
        signature.setFont(f2);
        int x = 100;
        int y = 450;
        patientSec.setBounds(25 + x, y, 100, 50);
        roomSec.setBounds(525 + x + 10, y, 100, 50);
        empSec.setBounds(150 + x, y, 100, 50);
        departmentSec.setBounds(275 + x, y, 110, 50);
        doctorSec.setBounds(400 + x + 10, y, 100, 50);

        signature.setBounds(20, 490, 200, 200);
        image.setBounds(0, 0, 911, 400);

        frame.add(patientSec);
        frame.add(empSec);
        frame.add(departmentSec);
        frame.add(doctorSec);
        frame.add(roomSec);
        frame.add(signature);
        frame.add(separator);
        frame.add(image);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(911, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //-----------------------------------------------------
        //------------------ BUTTON ACTIONS -------------------
        //-----------------------------------------------------
        patientSec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                PatientScreen();
                frame.setVisible(false);
            }
        });

        empSec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                empScreen();
                frame.setVisible(false);
            }
        });

        departmentSec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                departmentScreen();
                frame.setVisible(false);
            }
        });

        doctorSec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                roomScreen();
                frame.setVisible(false);
            }
        });

        roomSec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                doctorScreen();
                frame.setVisible(false);
            }
        });
    }

    //-----------------------------------------------------
    //------------------ Patient SECTION ------------------
    //-----------------------------------------------------
    public void PatientScreen() {
        JFrame PatientFrame = new JFrame();

        JLabel l1, l2, l4, l5, l6, l7, l8, l9;
        JLabel idLabel, fnameLabel, lnameLabel, addressLabel, sexLabel, dobLabel;
        JTextField t1;
        JButton searchButton, backButton;

        backButton = new JButton("Back");
        Font f = new Font("Arial", Font.BOLD, 24);
        l1 = new JLabel("Patient Information");
        l1.setFont(f);

        /*
        
        
                SEARCH INFORMATION SECTION
        
        
         */
        l2 = new JLabel("Patient ID");
        t1 = new JTextField();

        searchButton = new JButton("Search");

        l4 = new JLabel("ID");
        l5 = new JLabel("Fname");
        l6 = new JLabel("Lname");
        l7 = new JLabel("Address");
        l8 = new JLabel("Dob");
        l9 = new JLabel("Sex");

        idLabel = new JLabel("");
        fnameLabel = new JLabel("");
        lnameLabel = new JLabel("");
        addressLabel = new JLabel("");
        sexLabel = new JLabel("");
        dobLabel = new JLabel("");

        backButton.setBounds(10, 10, 90, 20);
        l1.setBounds(30, 40, 500, 40);
        l2.setBounds(30, 100, 200, 20);//UserName Label
        t1.setBounds(30, 120, 200, 30);//TextField

        searchButton.setBounds(80, 180, 100, 30);

        l4.setBounds(30, 290, 70, 50);
        l5.setBounds(30, 340, 70, 50);
        l6.setBounds(30, 390, 70, 50);
        l7.setBounds(30, 440, 70, 50);
        l8.setBounds(30, 490, 70, 50);
        l9.setBounds(30, 540, 70, 50);

        idLabel.setBounds(140, 290, 110, 50);
        fnameLabel.setBounds(140, 340, 110, 50);
        lnameLabel.setBounds(140, 390, 110, 50);
        addressLabel.setBounds(140, 440, 110, 50);
        dobLabel.setBounds(140, 490, 75, 50);
        sexLabel.setBounds(140, 540, 110, 50);

        /*
        
        
                ADD NEW SECTION
        
        
         */
        JLabel title, id, fname, sex, address, dob, lname;
        JTextField idT, fnameT, sexT, addressT, dobT, lnameT;
        JButton addButton;

        title = new JLabel("Add a New Patient");
        title.setFont(f);

        id = new JLabel("Patient ID");
        idT = new JTextField();
        fname = new JLabel("Patient First Name");
        fnameT = new JTextField();
        lname = new JLabel("Patient Last Name");
        lnameT = new JTextField();
        sex = new JLabel("Patient Sex");
        sexT = new JTextField();
        address = new JLabel("Patient Address");
        addressT = new JTextField();
        dob = new JLabel("Patient Date of Birth");
        dobT = new JTextField();

        addButton = new JButton("ADD");

        title.setBounds(350, 40, 350, 40);

        id.setBounds(350, 100, 120, 30);
        idT.setBounds(470, 100, 200, 30);

        fname.setBounds(350, 140, 120, 30);
        fnameT.setBounds(470, 140, 200, 30);

        lname.setBounds(350, 180, 120, 30);
        lnameT.setBounds(470, 180, 200, 30);

        sex.setBounds(350, 220, 120, 30);
        sexT.setBounds(470, 220, 200, 30);

        address.setBounds(350, 260, 120, 30);
        addressT.setBounds(470, 260, 200, 30);

        dob.setBounds(350, 300, 120, 30);
        dobT.setBounds(470, 300, 200, 30);

        addButton.setBounds(450, 340, 100, 30);


        /*
        
        
                DELETE SECTION
        
        
         */
        JLabel deleteL, dID;
        JTextField deleteID;
        JButton deleteButton;

        deleteL = new JLabel("Delete a Patient");
        deleteL.setFont(f);
        int o = 40;
        dID = new JLabel("Patient ID");
        deleteID = new JTextField();
        deleteButton = new JButton("Delete");

        deleteL.setBounds(350, 330 + o, 350, 40);
        dID.setBounds(350, 380 + o, 120, 30);
        deleteID.setBounds(470, 380 + o, 120, 30);
        deleteButton.setBounds(600, 380 + o, 100, 30);


        /*
        
        
                UPDATE SECTION
        
        
        m*/
        JLabel updateL, updateID, updateAddress;
        JTextField idTF, addressTF;
        JButton updateButton;

        updateL = new JLabel("Update Patient Information");
        updateL.setFont(f);

        updateID = new JLabel("Patient's ID");
        idTF = new JTextField();

        updateAddress = new JLabel("New Address");
        addressTF = new JTextField();

        updateButton = new JButton("Update");

        updateL.setBounds(700, 40, 350, 40);

        updateID.setBounds(700, 100, 120, 30);
        idTF.setBounds(820, 100, 120, 30);

        updateAddress.setBounds(700, 140, 120, 30);
        addressTF.setBounds(820, 140, 120, 30);

        updateButton.setBounds(800, 220, 100, 30);

        PatientFrame.add(backButton);
        PatientFrame.add(l1);
        PatientFrame.add(l2);
        PatientFrame.add(t1);
        PatientFrame.add(searchButton);
        PatientFrame.add(l4);
        PatientFrame.add(l5);
        PatientFrame.add(l6);
        PatientFrame.add(l7);
        PatientFrame.add(l8);
        PatientFrame.add(l9);

        l4.setVisible(false);
        l5.setVisible(false);
        l6.setVisible(false);
        l7.setVisible(false);
        l8.setVisible(false);
        l9.setVisible(false);

        PatientFrame.add(idLabel);
        PatientFrame.add(fnameLabel);
        PatientFrame.add(lnameLabel);
        PatientFrame.add(addressLabel);
        PatientFrame.add(dobLabel);
        PatientFrame.add(sexLabel);
        PatientFrame.add(title);
        PatientFrame.add(id);
        PatientFrame.add(fname);
        PatientFrame.add(lname);
        PatientFrame.add(sex);
        PatientFrame.add(address);
        PatientFrame.add(dob);
        PatientFrame.add(idT);
        PatientFrame.add(fnameT);
        PatientFrame.add(lnameT);
        PatientFrame.add(sexT);
        PatientFrame.add(addressT);
        PatientFrame.add(dobT);
        PatientFrame.add(addButton);
        PatientFrame.add(deleteL);
        PatientFrame.add(dID);
        PatientFrame.add(deleteID);
        PatientFrame.add(deleteButton);

        PatientFrame.add(updateL);
        PatientFrame.add(updateID);
        PatientFrame.add(idTF);

        PatientFrame.add(updateAddress);
        PatientFrame.add(addressTF);
        PatientFrame.add(updateButton);

        PatientFrame.setLayout(null);
        PatientFrame.setVisible(true);
        PatientFrame.setSize(1100, 700);
        PatientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //-----------------------------------------------------
        //------------------ BUTTON ACTIONS -------------------
        //-----------------------------------------------------
        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                PatientFrame.setVisible(false);
                firstScreen();
            }
        });

        searchButton.addActionListener(new ActionListener() {
////////////////////////////////////////////
            public void actionPerformed(ActionEvent ae) {         // Search //
                String inputID = t1.getText();
                try {
                    String query = "select * from patient where Patient_ID = '" + inputID + "'";
                    preparedStatement = connection.prepareStatement(query);
                    ResultSet rezult = preparedStatement.executeQuery();

                    l4.setVisible(true);
                    l5.setVisible(true);
                    l6.setVisible(true);
                    l7.setVisible(true);
                    l8.setVisible(true);
                    l9.setVisible(true);
                    rezult.next();
                    idLabel.setText(rezult.getString("Patient_ID"));
                    fnameLabel.setText(rezult.getString("Fname"));
                    lnameLabel.setText(rezult.getString("Lname"));
                    addressLabel.setText(rezult.getString("Address"));
                    sexLabel.setText(rezult.getString("Sex"));
                    dobLabel.setText(rezult.getString("Dob"));

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(PatientFrame, "Wrong ID",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {              // Insert //
                try {

                    String update = "insert into patient values('" + idT.getText() + "', '" + fnameT.getText() + "', '" + lnameT.getText()
                            + "', '" + dobT.getText() + "', '" + addressT.getText() + "', '" + sexT.getText() + "')";

                    statement = connection.createStatement();
                    statement.executeUpdate(update);

                    JOptionPane.showMessageDialog(null, "The Patient Was Added Successfully!");
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(PatientFrame, "Incorrect information, or Patient already exists",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {                  // Delete //
                try {

                    String update = "delete from patient where Patient_ID ='" + deleteID.getText() + "'";

                    statement = connection.createStatement();

                    statement.executeUpdate(update);

                    JOptionPane.showMessageDialog(null, "The Patient Was Deleted Successfully!");
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(PatientFrame, "Wrong ID" + e2.getMessage(),
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {                   // Update //
                try {

                    String update = "update Patient set Address ='" + addressTF.getText() + "' where Patient_ID ='" + idTF.getText() + "'";

                    statement = connection.createStatement();
                    statement.executeUpdate(update);

                    JOptionPane.showMessageDialog(null, "The Patient Was Updated Successfully!");
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(PatientFrame, "Wrong ID",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    //-----------------------------------------------------
    //------------------- EMP SECTION -------------------
    //-----------------------------------------------------
    public void empScreen() {
        JFrame empFrame = new JFrame();

        JLabel empTitle, idField, idL, fnameL, salaryL, sexL, supervisorL, lnameL, dobL, deptL, addressL;
        JLabel idLabel, fnameLabel, salaryLabel, sexLabel, supervisorLabel, lnameLabel, dobLabel, deptLabel, addressLabel;
        JTextField t1;
        JButton searchButton, backButton;

        backButton = new JButton("Back");

        Font f = new Font("Arial", Font.BOLD, 24);
        empTitle = new JLabel("Employee Information");
        empTitle.setFont(f);

        /*
        |
        |
                INFORMATION SECTION
        |
        |
         */
        idField = new JLabel("Employee ID");
        t1 = new JTextField();

        searchButton = new JButton("Search");

        idL = new JLabel("ID");
        fnameL = new JLabel("Fname");
        lnameL = new JLabel("Lname");
        dobL = new JLabel("Dob");
        salaryL = new JLabel("Salary");
        sexL = new JLabel("Sex");
        supervisorL = new JLabel("Supervisor's ID");
        deptL = new JLabel("Department's ID");
        addressL = new JLabel("Address");

        idLabel = new JLabel("");
        fnameLabel = new JLabel("");
        lnameLabel = new JLabel("");
        dobLabel = new JLabel("");
        salaryLabel = new JLabel("");
        sexLabel = new JLabel("");
        supervisorLabel = new JLabel("");
        deptLabel = new JLabel("");
        addressLabel = new JLabel("");

        backButton.setBounds(10, 10, 90, 20);

        empTitle.setBounds(30, 40, 500, 40);
        idField.setBounds(30, 100, 200, 20);
        t1.setBounds(30, 120, 200, 30);

        searchButton.setBounds(80, 180, 100, 30);
        int z = 50;
        idL.setBounds(30, 240, 100, 50);
        fnameL.setBounds(30, 290, 100, 50);
        lnameL.setBounds(30, 340, 100, 50);
        dobL.setBounds(30, 390, 100, 50);
        salaryL.setBounds(30, 440, 100, 50);
        sexL.setBounds(30, 490, 100, 50);
        supervisorL.setBounds(30, 540, 100, 50);
        deptL.setBounds(30, 590, 100, 50);
        addressL.setBounds(30, 610, 100, 50);

        idLabel.setBounds(140, 240, 110, 50);
        fnameLabel.setBounds(140, 290, 110, 50);
        lnameLabel.setBounds(140, 340, 110, 50);
        dobLabel.setBounds(140, 390, 75, 50);
        salaryLabel.setBounds(140, 440, 110, 50);
        sexLabel.setBounds(140, 490, 110, 50);
        supervisorLabel.setBounds(140, 540, 110, 50);
        deptLabel.setBounds(140, 590, 110, 50);
        addressLabel.setBounds(140, 610, 110, 50);

        /*
        |
        |
                ADD NEW SECTION
        |
        |
         */
        JLabel title, id, fname, salary, address, supervisor, lname, dob, sex, dept;
        JTextField idT, fnameT, salaryT, addressT, supervisorT, lnameT, dobT, sexT, deptT;
        JButton addButton;

        title = new JLabel("Add a New Employee");
        title.setFont(f);

        id = new JLabel("ID");
        idT = new JTextField();
        fname = new JLabel("Fname");
        fnameT = new JTextField();
        lname = new JLabel("Lname");
        lnameT = new JTextField();
        dob = new JLabel("Dob");
        dobT = new JTextField();
        salary = new JLabel("Salary");
        salaryT = new JTextField();
        address = new JLabel("Address");
        addressT = new JTextField();
        sex = new JLabel("Sex");
        sexT = new JTextField();
        supervisor = new JLabel("Supervisor ID");
        supervisorT = new JTextField();
        dept = new JLabel("Department");
        deptT = new JTextField();

        addButton = new JButton("ADD");

        title.setBounds(350, 40, 350, 40);

        id.setBounds(350, 100, 120, 30);
        idT.setBounds(470, 100, 200, 30);

        fname.setBounds(350, 140, 120, 30);
        fnameT.setBounds(470, 140, 200, 30);
        int b = 40;
        lname.setBounds(350, 180, 120, 30);
        lnameT.setBounds(470, 180, 200, 30);

        salary.setBounds(350, 180 + b, 120, 30);
        salaryT.setBounds(470, 180 + b, 200, 30);

        address.setBounds(350, 220 + b, 120, 30);
        addressT.setBounds(470, 220 + b, 200, 30);

        sex.setBounds(350, 260 + b, 120, 30);
        sexT.setBounds(470, 260 + b, 200, 30);

        dob.setBounds(350, 300 + b, 120, 30);
        dobT.setBounds(470, 300 + b, 200, 30);

        supervisor.setBounds(350, 340 + b, 120, 30);
        supervisorT.setBounds(470, 340 + b, 200, 30);

        dept.setBounds(350, 380 + b, 120, 30);
        deptT.setBounds(470, 380 + b, 200, 30);

        addButton.setBounds(450, 420 + b, 100, 30);


        /*
        |
        |
                DELETE SECTION
        |
        |
         */
        JLabel deleteL, dID;
        JTextField deleteID;
        JButton deleteButton;

        deleteL = new JLabel("Delete a Employee");
        deleteL.setFont(f);

        dID = new JLabel("Employee ID");
        deleteID = new JTextField();
        deleteButton = new JButton("Delete");

        deleteL.setBounds(350, 330 + b + b + b + b, 350, 40);
        dID.setBounds(350, 380 + b + b + b + b, 120, 30);
        deleteID.setBounds(470, 380 + b + b + b + b, 120, 30);
        deleteButton.setBounds(600, 380 + b + b + b + b, 100, 30);

        /*
        |
        |
                UPDATE SECTION
        |
        |
         */
        JLabel updateL, updateID, updateSalary, updateAddress, updateSup, updatedept;
        JTextField idTF, salaryTF, addressTF, supTF, deptTF;
        JButton updateButton;

        updateL = new JLabel("Update Employee Information");
        updateL.setFont(f);

        updateID = new JLabel("Employee's ID");
        idTF = new JTextField();
        updateSalary = new JLabel("New salary");
        salaryTF = new JTextField();
        updateAddress = new JLabel("new address");
        addressTF = new JTextField();

        updateSup = new JLabel("new Supervisor");
        supTF = new JTextField();

        updatedept = new JLabel("new Department");
        deptTF = new JTextField();

        updateButton = new JButton("Update");

        updateL.setBounds(700, 40, 350, 40);

        updateID.setBounds(700, 100, 120, 30);
        idTF.setBounds(820, 100, 120, 30);

        updateSalary.setBounds(700, 140, 120, 30);
        salaryTF.setBounds(820, 140, 120, 30);

        updateAddress.setBounds(700, 180, 120, 30);
        addressTF.setBounds(820, 180, 120, 30);

        updateSup.setBounds(700, 220, 120, 30);
        supTF.setBounds(820, 220, 120, 30);

        updatedept.setBounds(700, 260, 120, 30);
        deptTF.setBounds(820, 260, 120, 30);

        updateButton.setBounds(800, 300, 100, 30);

        empFrame.add(backButton);
        empFrame.add(empTitle);
        empFrame.add(idField);
        empFrame.add(t1);
        empFrame.add(searchButton);
        empFrame.add(idL);

        empFrame.add(fnameL);
        empFrame.add(lnameL);
        empFrame.add(salaryL);
        empFrame.add(sexL);
        empFrame.add(supervisorL);
        empFrame.add(dobL);

        idL.setVisible(false);
        fnameL.setVisible(false);
        lnameL.setVisible(false);
        salaryL.setVisible(false);
        sexL.setVisible(false);
        supervisorL.setVisible(false);
        dobL.setVisible(false);
        deptL.setVisible(false);
        addressL.setVisible(false);

        empFrame.add(idLabel);
        empFrame.add(fnameLabel);
        empFrame.add(lnameLabel);
        empFrame.add(dobLabel);
        empFrame.add(salaryLabel);
        empFrame.add(sexLabel);
        empFrame.add(supervisorLabel);
        empFrame.add(title);
        empFrame.add(id);
        empFrame.add(fname);
        empFrame.add(lname);
        empFrame.add(salary);
        empFrame.add(address);
        empFrame.add(supervisor);
        empFrame.add(dob);
        empFrame.add(sex);
        empFrame.add(dept);
        empFrame.add(idT);
        empFrame.add(fnameT);
        empFrame.add(lnameT);
        empFrame.add(salaryT);
        empFrame.add(addressT);
        empFrame.add(supervisorT);
        empFrame.add(dobT);
        empFrame.add(sexT);
        empFrame.add(deptT);
        empFrame.add(addButton);
        empFrame.add(deleteL);
        empFrame.add(dID);
        empFrame.add(deleteID);
        empFrame.add(deleteButton);

        empFrame.add(updateL);
        empFrame.add(updateID);
        empFrame.add(idTF);
        empFrame.add(updateSalary);
        empFrame.add(salaryTF);
        empFrame.add(updateAddress);
        empFrame.add(addressTF);
        empFrame.add(updateSup);
        empFrame.add(supTF);
        empFrame.add(updatedept);
        empFrame.add(deptTF);
        empFrame.add(updateButton);

        empFrame.setLayout(null);
        empFrame.setVisible(true);
        empFrame.setSize(1100, 700);
        empFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //-----------------------------------------------------
        //------------------ BUTTON ACTIONS -------------------
        //-----------------------------------------------------
        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                empFrame.setVisible(false);
                firstScreen();
            }
        });

        searchButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                String inputID = t1.getText();

                try {
                    String query = "select * from Employee where Employee_ID='" + inputID + "'";
                    preparedStatement = connection.prepareStatement(query);
                    resultSet = preparedStatement.executeQuery();
                    resultSet.next();
                    idLabel.setText(resultSet.getString("Employee_ID"));
                    fnameLabel.setText(resultSet.getString("Fname"));
                    lnameLabel.setText(resultSet.getString("Lname"));
                    salaryLabel.setText(resultSet.getString("salary"));
                    sexLabel.setText(resultSet.getString("Sex"));
                    addressLabel.setText(resultSet.getString("Address"));
                    supervisorLabel.setText(resultSet.getString("Supervisor_ID"));
                    dobLabel.setText(resultSet.getString("Dob"));
                    deptLabel.setText(resultSet.getString("Department_ID"));

                    idL.setVisible(true);
                    fnameL.setVisible(true);
                    lnameL.setVisible(true);
                    salaryL.setVisible(true);
                    sexL.setVisible(true);
                    supervisorL.setVisible(true);
                    dobL.setVisible(true);
                    deptL.setVisible(true);
                    addressL.setVisible(true);
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(empFrame, "Wrong ID",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String update = "insert into Employee values('" + idT.getText() + "', '" + fnameT.getText() + "', '" + lnameT.getText()
                            + "', '" + dobT.getText() + "', '" + salaryT.getText() + "', '" + addressT.getText()
                            + "', '" + sexT.getText() + "', '" + supervisorT.getText() + "', '" + deptT.getText() + "')";

                    statement = connection.createStatement();
                    statement.executeUpdate(update);

                    JOptionPane.showMessageDialog(null, "The Employee Was Added Successfully!");
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(empFrame, "Wrong ID" + e2.getMessage(),
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String update = "delete from Employee where Employee_ID='" + deleteID.getText() + "'";

                    statement = connection.createStatement();
                    statement.executeUpdate(update);

                    JOptionPane.showMessageDialog(null, "The Employee Was Deleted Successfully!");
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(empFrame, "Wrong ID",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String s = addressTF.getText();
                    String update = "update Employee set salary ='" + salaryTF.getText() + "', Address = '"
                            + addressTF.getText()
                            + "',Supervisor_ID=" + supTF.getText() + ",Department_ID='" + deptTF.getText() + "' where Employee_ID='" + idTF.getText() + "'";
                    s = update;
                    statement = connection.createStatement();
                    statement.executeUpdate(update);

                    JOptionPane.showMessageDialog(null, "The Employee Was Updated Successfully!");
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(empFrame, "Wrong ID" + e2.getMessage(),
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    //-----------------------------------------------------
    //------------------- DEPARTMENT SECTION -------------------
    //-----------------------------------------------------
    public void departmentScreen() {
        JFrame departmentFrame = new JFrame();

        JLabel sectionTitle, inputIDLabel, deptIDLabel, deptNameLabel, depmanagerIDLabel;
        JLabel deptIDLabel2, deptNameLabel2, deptmanagerIDLabel2;

        JTextField inputID;
        JButton searchButton, backButton;

        backButton = new JButton("Back");
        Font f = new Font("Arial", Font.BOLD, 24);
        sectionTitle = new JLabel("Department Information");
        sectionTitle.setFont(f);

        /*
        |
        |
                INFORMATION SECTION
        |
        |
         */
        inputIDLabel = new JLabel("Department ID");
        inputID = new JTextField();

        searchButton = new JButton("Search");

        deptIDLabel = new JLabel("ID");
        deptNameLabel = new JLabel("Name");
        depmanagerIDLabel = new JLabel("Manager's ID");

        deptIDLabel2 = new JLabel("");
        deptNameLabel2 = new JLabel("");
        deptmanagerIDLabel2 = new JLabel("");

        backButton.setBounds(10, 10, 90, 20);
        sectionTitle.setBounds(30, 40, 500, 40);
        inputIDLabel.setBounds(30, 100, 200, 20);
        inputID.setBounds(30, 120, 200, 30);

        searchButton.setBounds(80, 180, 100, 30);

        deptIDLabel.setBounds(30, 290, 120, 50);
        deptNameLabel.setBounds(30, 340, 120, 50);
        depmanagerIDLabel.setBounds(30, 390, 120, 50);

        deptIDLabel2.setBounds(140, 290, 110, 50);
        deptNameLabel2.setBounds(140, 340, 200, 50);
        deptmanagerIDLabel2.setBounds(140, 390, 200, 50);


        /*
        |
        |
                ADD NEW SECTION
        |
        |
         */
        JLabel title, id, name, manager;
        JTextField idT, nameT, managerT;
        JButton addButton;

        title = new JLabel("Add a New Department");
        title.setFont(f);

        id = new JLabel("Department ID");
        idT = new JTextField();
        name = new JLabel("Department Name");
        nameT = new JTextField();

        manager = new JLabel("Manager ID");
        managerT = new JTextField();

        addButton = new JButton("ADD");

        title.setBounds(350, 40, 350, 40);

        id.setBounds(350, 100, 120, 30);
        idT.setBounds(470, 100, 200, 30);

        name.setBounds(350, 140, 120, 30);
        nameT.setBounds(470, 140, 200, 30);

        manager.setBounds(350, 180, 120, 30);
        managerT.setBounds(470, 180, 200, 30);

        addButton.setBounds(450, 250, 100, 30);


        /*
        |
        |
                DELETE SECTION
        |
        |
         */
        JLabel deleteL, dID;
        JTextField deleteID;
        JButton deleteButton;

        deleteL = new JLabel("Delete a Department");
        deleteL.setFont(f);

        dID = new JLabel("Department ID");
        deleteID = new JTextField();
        deleteButton = new JButton("Delete");

        deleteL.setBounds(350, 330, 350, 40);
        dID.setBounds(350, 380, 120, 30);
        deleteID.setBounds(470, 380, 120, 30);
        deleteButton.setBounds(600, 380, 100, 30);

        ///////////////////////////////////////////////////
        JLabel updateL, updateID, updateManager;
        JTextField idTF, managerTF;
        JButton updateButton;

        updateL = new JLabel("Update Department Information");
        updateL.setFont(f);

        updateID = new JLabel("Department's ID");
        idTF = new JTextField();

        updateManager = new JLabel("New Manager");
        managerTF = new JTextField();

        updateButton = new JButton("Update");
        int v = 50;
        updateL.setBounds(700 + v, 40, 400, 40);

        updateID.setBounds(700 + v, 100, 120, 30);
        idTF.setBounds(820 + v, 100, 120, 30);

        updateManager.setBounds(700 + v, 140, 120, 30);
        managerTF.setBounds(820 + v, 140, 120, 30);

        updateButton.setBounds(800 + v, 220, 100, 30);
        ////////////////////////

        departmentFrame.add(backButton);
        departmentFrame.add(sectionTitle);
        departmentFrame.add(inputIDLabel);
        departmentFrame.add(inputID);
        departmentFrame.add(searchButton);
        departmentFrame.add(deptIDLabel);
        departmentFrame.add(deptNameLabel);
        departmentFrame.add(depmanagerIDLabel);

        deptIDLabel.setVisible(false);
        deptNameLabel.setVisible(false);
        depmanagerIDLabel.setVisible(false);

        departmentFrame.add(deptIDLabel2);
        departmentFrame.add(deptNameLabel2);
        departmentFrame.add(deptmanagerIDLabel2);

        departmentFrame.add(title);
        departmentFrame.add(id);
        departmentFrame.add(name);
        departmentFrame.add(manager);

        departmentFrame.add(idT);
        departmentFrame.add(nameT);
        departmentFrame.add(managerT);

        departmentFrame.add(addButton);
        departmentFrame.add(deleteL);
        departmentFrame.add(dID);
        departmentFrame.add(deleteID);
        departmentFrame.add(deleteButton);

        departmentFrame.add(updateL);
        departmentFrame.add(updateID);
        departmentFrame.add(updateManager);
        departmentFrame.add(idTF);
        departmentFrame.add(managerTF);
        departmentFrame.add(updateButton);

        departmentFrame.setLayout(null);
        departmentFrame.setVisible(true);
        departmentFrame.setSize(1200, 600);
        departmentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
        ----------------------------------
        ---------- BUTTON ACTIONS --------
        ----------------------------------
         */
        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                departmentFrame.setVisible(false);
                firstScreen();
            }
        });

        searchButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                String inputID2 = inputID.getText();
                try {
                    String query = "select * from department where Department_ID='" + inputID2 + "'";
                    preparedStatement = connection.prepareStatement(query);
                    resultSet = preparedStatement.executeQuery();

                    deptIDLabel.setVisible(true);
                    deptNameLabel.setVisible(true);
                    depmanagerIDLabel.setVisible(true);
                    resultSet.next();
                    deptIDLabel2.setText(resultSet.getString("Department_ID"));
                    deptNameLabel2.setText(resultSet.getString("Department_Name"));
                    deptmanagerIDLabel2.setText(resultSet.getString("Manager_ID"));
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String update = "insert into department values('" + idT.getText() + "', '" + nameT.getText()
                            + "', '" + managerT.getText() + "')";

                    statement = connection.createStatement();
                    statement.executeUpdate(update);

                    JOptionPane.showMessageDialog(null, "The Department Was Added Successfully!");
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(departmentFrame, "Wrong ID",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String update = "delete from department where Department_ID ='" + deleteID.getText() + "'";

                    statement = connection.createStatement();
                    statement.executeUpdate(update);

                    JOptionPane.showMessageDialog(null, "The Department Was Deleted Successfully!");
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(departmentFrame, "Wrong Code or Unavailable department",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String update = "update department set Manager_ID='" + managerTF.getText()
                            + "' where Department_ID ='" + idTF.getText() + "'";

                    statement = connection.createStatement();
                    statement.executeUpdate(update);

                    JOptionPane.showMessageDialog(null, "The Department Was Updated Successfully!");
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(departmentFrame, "Wrong Code or Unavailable Department",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    //-----------------------------------------------------
    //---------------- ROOM SECTION -----------------
    //-----------------------------------------------------
    public void roomScreen() {
        JFrame roomFrame = new JFrame();

        JLabel sectionTitle, inputIDLabel, roomIDLabel, roomLocationLabel;
        JLabel roomIDLabel2, roomLocationLabel2;

        JTextField inputID;
        JButton searchButton, backButton;

        backButton = new JButton("back");
        Font f = new Font("Arial", Font.BOLD, 24);
        sectionTitle = new JLabel("Room Information");
        sectionTitle.setFont(f);

        /*
        |
        |
                INFORMATION SECTION
        |
        |
         */
        inputIDLabel = new JLabel("Room ID");
        inputID = new JTextField();

        searchButton = new JButton("Search");

        roomIDLabel = new JLabel("ID");
        roomLocationLabel = new JLabel("location");

        roomIDLabel2 = new JLabel("");
        roomLocationLabel2 = new JLabel("");

        backButton.setBounds(10, 10, 90, 20);
        sectionTitle.setBounds(30, 40, 500, 40);
        inputIDLabel.setBounds(30, 100, 200, 20);
        inputID.setBounds(30, 120, 200, 30);

        searchButton.setBounds(80, 180, 100, 30);

        roomIDLabel.setBounds(30, 290, 120, 50);
        roomLocationLabel.setBounds(30, 340, 120, 50);

        roomIDLabel2.setBounds(140, 290, 110, 50);
        roomLocationLabel2.setBounds(140, 340, 200, 50);

        /*
        |
        |
                ADD NEW ROOM
        |
        |
         */
        JLabel title, id, location;
        JTextField idT, locationT;
        JButton addButton;

        title = new JLabel("Add a New Room");
        title.setFont(f);

        id = new JLabel("Room ID");
        idT = new JTextField();
        location = new JLabel("Room location");
        locationT = new JTextField();

        addButton = new JButton("ADD");

        title.setBounds(350, 40, 350, 40);

        id.setBounds(350, 100, 120, 30);
        idT.setBounds(470, 100, 200, 30);

        location.setBounds(350, 140, 120, 30);
        locationT.setBounds(470, 140, 200, 30);

        addButton.setBounds(450, 250, 100, 30);


        /*
        |
        |
                DELETE SECTION
        |
        |
         */
        JLabel deleteL, dID;
        JTextField deleteID;
        JButton deleteButton;

        deleteL = new JLabel("Delete a Room");
        deleteL.setFont(f);

        dID = new JLabel("Room ID");
        deleteID = new JTextField();
        deleteButton = new JButton("Delete");

        deleteL.setBounds(350, 330, 350, 40);
        dID.setBounds(350, 380, 120, 30);
        deleteID.setBounds(470, 380, 120, 30);
        deleteButton.setBounds(600, 380, 100, 30);

        /*
        |
        |
                UPDATE SECTION
        |
        |
         */
        JLabel updateL, updateID, locationUpdate;
        JTextField idTF, updatelocationTF;
        JButton updateButton;

        updateL = new JLabel("Update room Information");
        updateL.setFont(f);

        updateID = new JLabel("Room's ID");
        idTF = new JTextField();
        locationUpdate = new JLabel("New location");
        updatelocationTF = new JTextField();

        updateButton = new JButton("Update");

        updateL.setBounds(700, 40, 350, 40);

        updateID.setBounds(700, 100, 120, 30);
        idTF.setBounds(820, 100, 120, 30);

        locationUpdate.setBounds(700, 140, 120, 30);
        updatelocationTF.setBounds(820, 140, 120, 30);

        updateButton.setBounds(800, 220, 100, 30);

        roomFrame.add(backButton);
        roomFrame.add(sectionTitle);
        roomFrame.add(inputIDLabel);
        roomFrame.add(inputID);
        roomFrame.add(searchButton);
        roomFrame.add(roomIDLabel);
        roomFrame.add(roomLocationLabel);

        roomIDLabel.setVisible(false);
        roomLocationLabel.setVisible(false);

        roomFrame.add(roomIDLabel2);
        roomFrame.add(roomLocationLabel2);

        roomFrame.add(title);
        roomFrame.add(id);
        roomFrame.add(location);

        roomFrame.add(idT);
        roomFrame.add(locationT);

        roomFrame.add(addButton);
        roomFrame.add(deleteL);
        roomFrame.add(dID);
        roomFrame.add(deleteID);
        roomFrame.add(deleteButton);

        roomFrame.add(updateL);
        roomFrame.add(updateID);
        roomFrame.add(idTF);
        roomFrame.add(locationUpdate);
        roomFrame.add(updatelocationTF);
        roomFrame.add(updateButton);

        roomFrame.setLayout(null);
        roomFrame.setVisible(true);
        roomFrame.setSize(1100, 600);
        roomFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
        ----------------------------------
        ---------- BUTTON ACTIONS --------
        ----------------------------------
         */
        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                roomFrame.setVisible(false);
                firstScreen();
            }
        });

        searchButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                String inputID2 = inputID.getText();
                try {
                    /*
                        
                     */
                    String query = "select * from room where Room_ID ='" + inputID2 + "'";
                    preparedStatement = connection.prepareStatement(query);
                    resultSet = preparedStatement.executeQuery();

                    roomIDLabel.setVisible(true);
                    roomLocationLabel.setVisible(true);
                    resultSet.next();
                    roomIDLabel2.setText(resultSet.getString("Room_ID"));
                    roomLocationLabel2.setText(resultSet.getString("Location"));

                } catch (SQLException e) {

                    JOptionPane.showMessageDialog(roomFrame, "Wrong Code or Unavailable Room",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    /*
                        
                     */
                    String update = "insert into room values('" + idT.getText() + "', '" + locationT.getText() + "')";

                    statement = connection.createStatement();
                    statement.executeUpdate(update);

                    JOptionPane.showMessageDialog(null, "The Room Was Added Successfully!");
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(roomFrame, "Wrong Code or Unavailable Room",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    /*
                        
                     */
                    String update = "delete from room where Room_ID ='" + deleteID.getText() + "'";

                    statement = connection.createStatement();
                    statement.executeUpdate(update);

                    roomIDLabel.setVisible(false);
                    roomLocationLabel.setVisible(false);

                    roomIDLabel2.setVisible(false);
                    roomLocationLabel2.setVisible(false);

                    JOptionPane.showMessageDialog(null, "The Room Was Deleted Successfully!");
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(roomFrame, "Wrong Code or Unavailable Room",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {

                    String update = "update room set Location ='" + updatelocationTF.getText()
                            + "' where Room_ID ='" + idTF.getText() + "'";

                    statement = connection.createStatement();
                    statement.executeUpdate(update);

                    JOptionPane.showMessageDialog(null, "The Room Was Updated Successfully!");
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(roomFrame, e2);
                }
            }
        });

    }

    //-----------------------------------------------------
    //---------------- DOCTOR SECTION -----------------
    //-----------------------------------------------------
    public void doctorScreen() {
        JFrame doctorFrame = new JFrame();

        JLabel doctorTitle, inputIDLabel, doctorIDLabel, doctorFnameLabel, doctorSexLabel, doctordeptLabel;
        JLabel doctorDoBLabel, doctorSalaryLabel, doctorAddressLabel, doctorLnameLabel, doctorRoomLabel;

        JLabel doctorIDLabel2, doctorFnameLabel2, doctorSexLabel2, doctorLnameLabel2, doctordeptLabel2;
        JLabel doctorDoBLabel2, doctorSalaryLabel2, doctorAddressLabel2, doctorRoomLabel2;

        JTextField inputID;
        JButton searchButton, backButton;

        backButton = new JButton("Back");
        Font f = new Font("Arial", Font.BOLD, 24);
        doctorTitle = new JLabel("Doctor Information");
        doctorTitle.setFont(f);

        /*
        |
        |
                INFORMATION SECTION
        |
        |
         */
        inputIDLabel = new JLabel("Doctor ID");
        inputID = new JTextField();

        searchButton = new JButton("Search");

        doctorIDLabel = new JLabel("ID");
        doctorFnameLabel = new JLabel("Fname");
        doctorLnameLabel = new JLabel("Lname");
        doctorSexLabel = new JLabel("Sex");
        doctorDoBLabel = new JLabel("DoB");
        doctorSalaryLabel = new JLabel("Salary");
        doctorAddressLabel = new JLabel("Address");
        doctorRoomLabel = new JLabel("Room_ID");
        doctordeptLabel = new JLabel("Department");

        doctorIDLabel2 = new JLabel("");
        doctorFnameLabel2 = new JLabel("");
        doctorLnameLabel2 = new JLabel("");
        doctorSexLabel2 = new JLabel("");
        doctorDoBLabel2 = new JLabel("");
        doctorSalaryLabel2 = new JLabel("");
        doctorAddressLabel2 = new JLabel("");
        doctorRoomLabel2 = new JLabel("");
        doctordeptLabel2 = new JLabel("");

        backButton.setBounds(10, 10, 90, 20);
        doctorTitle.setBounds(30, 40, 500, 40);
        inputIDLabel.setBounds(30, 100, 200, 20);
        inputID.setBounds(30, 120, 200, 30);

        searchButton.setBounds(80, 180, 100, 30);
        int a = 50;
        doctorIDLabel.setBounds(30, 290, 120, 50);
        doctorFnameLabel.setBounds(30, 340, 120, 50);
        doctorLnameLabel.setBounds(30, 390, 120, 50);
        doctorSexLabel.setBounds(30, 390 + a, 120, 50);
        doctorDoBLabel.setBounds(30, 440 + a, 120, 50);
        doctorSalaryLabel.setBounds(30, 490 + a, 120, 50);
        doctorAddressLabel.setBounds(30, 540 + a, 120, 50);
        doctorRoomLabel.setBounds(30, 590 + a, 120, 50);
        doctordeptLabel.setBounds(30, 640 + a, 120, 50);

        doctorIDLabel2.setBounds(140, 290, 110, 50);
        doctorFnameLabel2.setBounds(140, 340, 200, 50);
        doctorLnameLabel2.setBounds(140, 390, 200, 50);
        doctorSexLabel2.setBounds(140, 390 + a, 200, 50);
        doctorDoBLabel2.setBounds(140, 440 + a, 75, 50);
        doctorSalaryLabel2.setBounds(140, 490 + a, 200, 50);
        doctorAddressLabel2.setBounds(140, 540 + a, 200, 50);
        doctorRoomLabel2.setBounds(140, 590 + a, 200, 50);
        doctordeptLabel2.setBounds(140, 640 + a, 120, 50);
        /*
        |
        |
                ADD NEW SECTION
        |
        |
         */
        JLabel title, id, Fname, sex, dob, salary, dAddress, Lname, room, dept;
        JTextField idT, FnameT, sexT, dobT, salaryT, dAddressT, LnameT, roomT, deptT;
        JButton addButton;

        title = new JLabel("Add a New Doctor");
        title.setFont(f);

        id = new JLabel("Doctor ID");
        idT = new JTextField();
        Fname = new JLabel("Doctor Fname");
        FnameT = new JTextField();
        Lname = new JLabel("Doctor Lname");
        LnameT = new JTextField();
        sex = new JLabel("Doctor Sex");
        sexT = new JTextField();
        dob = new JLabel("Doctor DoB");
        dobT = new JTextField();
        salary = new JLabel("Doctor Salary");
        salaryT = new JTextField();
        dAddress = new JLabel("Doctor Address");
        dAddressT = new JTextField();
        room = new JLabel("Doctor Room");
        roomT = new JTextField();
        dept = new JLabel("Department");
        deptT = new JTextField();

        addButton = new JButton("ADD");

        title.setBounds(350, 40, 350, 40);

        id.setBounds(350, 100, 120, 30);
        idT.setBounds(470, 100, 200, 30);

        Fname.setBounds(350, 140, 120, 30);
        FnameT.setBounds(470, 140, 200, 30);
        int y = 40;
        Lname.setBounds(350, 180, 120, 30);
        LnameT.setBounds(470, 180, 200, 30);

        sex.setBounds(350, 180 + y, 120, 30);
        sexT.setBounds(470, 180 + y, 200, 30);

        dob.setBounds(350, 220 + y, 120, 30);
        dobT.setBounds(470, 220 + y, 200, 30);

        salary.setBounds(350, 260 + y, 120, 30);
        salaryT.setBounds(470, 260 + y, 200, 30);

        dAddress.setBounds(350, 300 + y, 120, 30);
        dAddressT.setBounds(470, 300 + y, 200, 30);

        room.setBounds(350, 340 + y, 120, 30);
        roomT.setBounds(470, 340 + y, 200, 30);

        dept.setBounds(350, 380 + y, 120, 30);
        deptT.setBounds(470, 380 + y, 200, 30);

        addButton.setBounds(450, 460 + y, 100, 30);


        /*
        |
        |
                DELETE SECTION
        |
        |
         */
        JLabel deleteL, dID;
        JTextField deleteID;
        JButton deleteButton;

        deleteL = new JLabel("Delete a Doctor");
        deleteL.setFont(f);

        dID = new JLabel("Doctor ID");
        deleteID = new JTextField();
        deleteButton = new JButton("Delete");

        deleteL.setBounds(350, 400 + y + y + y, 350, 40);
        dID.setBounds(350, 450 + y + y + y, 120, 30);
        deleteID.setBounds(470, 450 + y + y + y, 120, 30);
        deleteButton.setBounds(600, 450 + y + y + y, 100, 30);

        /*
        |
        |
                UPDATE SECTION
        |
        |
         */
        JLabel updateL, updateID, updateSalary, updateRoom, updateDAddress, updateDdept;
        JTextField idTF, updateSalaryTF, updateRoomTF, updateDAddressTF, updateDdeptTF;
        JButton updateButton;

        updateL = new JLabel("Update Doctor Information");
        updateL.setFont(f);

        updateID = new JLabel("Doctor ID");
        idTF = new JTextField();
        updateSalary = new JLabel("New Salary");
        updateSalaryTF = new JTextField();

        updateRoom = new JLabel("New Room");
        updateRoomTF = new JTextField();

        updateDAddress = new JLabel("New Address");
        updateDAddressTF = new JTextField();

        updateDdept = new JLabel("New  Department");
        updateDdeptTF = new JTextField();

        updateButton = new JButton("Update");

        updateL.setBounds(700, 40, 350, 40);

        updateID.setBounds(700, 100, 120, 30);
        idTF.setBounds(820, 100, 120, 30);

        updateRoom.setBounds(700, 140, 120, 30);
        updateRoomTF.setBounds(820, 140, 120, 30);

        updateSalary.setBounds(700, 180, 120, 30);
        updateSalaryTF.setBounds(820, 180, 120, 30);

        updateDAddress.setBounds(700, 220, 120, 30);
        updateDAddressTF.setBounds(820, 220, 120, 30);

        updateDdept.setBounds(700, 260, 120, 30);
        updateDdeptTF.setBounds(820, 260, 120, 30);

        updateButton.setBounds(800, 340, 100, 30);

        doctorFrame.add(backButton);
        doctorFrame.add(doctorTitle);
        doctorFrame.add(inputIDLabel);
        doctorFrame.add(inputID);
        doctorFrame.add(searchButton);
        doctorFrame.add(doctorIDLabel);
        doctorFrame.add(doctorFnameLabel);
        doctorFrame.add(doctorLnameLabel);
        doctorFrame.add(doctorSexLabel);
        doctorFrame.add(doctorDoBLabel);
        doctorFrame.add(doctorSalaryLabel);
        doctorFrame.add(doctorAddressLabel);
        doctorFrame.add(doctorRoomLabel);
        doctorFrame.add(doctordeptLabel);

        doctorIDLabel.setVisible(false);
        doctorFnameLabel.setVisible(false);
        doctorLnameLabel.setVisible(false);
        doctorSexLabel.setVisible(false);
        doctorDoBLabel.setVisible(false);
        doctorSalaryLabel.setVisible(false);
        doctorAddressLabel.setVisible(false);
        doctorRoomLabel.setVisible(false);
        doctordeptLabel.setVisible(false);

        doctorFrame.add(doctorIDLabel2);
        doctorFrame.add(doctorFnameLabel2);
        doctorFrame.add(doctorLnameLabel2);
        doctorFrame.add(doctorSexLabel2);
        doctorFrame.add(doctorDoBLabel2);
        doctorFrame.add(doctorSalaryLabel2);
        doctorFrame.add(doctorAddressLabel2);
        doctorFrame.add(doctorRoomLabel2);
        doctorFrame.add(doctordeptLabel2);

        doctorFrame.add(title);
        doctorFrame.add(id);
        doctorFrame.add(Fname);
        doctorFrame.add(Lname);
        doctorFrame.add(sex);
        doctorFrame.add(dob);
        doctorFrame.add(salary);
        doctorFrame.add(dAddress);
        doctorFrame.add(room);
        doctorFrame.add(dept);

        doctorFrame.add(idT);
        doctorFrame.add(FnameT);
        doctorFrame.add(LnameT);
        doctorFrame.add(sexT);
        doctorFrame.add(dobT);
        doctorFrame.add(salaryT);
        doctorFrame.add(dAddressT);
        doctorFrame.add(roomT);
        doctorFrame.add(deptT);

        doctorFrame.add(addButton);
        doctorFrame.add(deleteL);
        doctorFrame.add(dID);
        doctorFrame.add(deleteID);
        doctorFrame.add(deleteButton);

        doctorFrame.add(updateL);
        doctorFrame.add(updateID);
        doctorFrame.add(idTF);
        doctorFrame.add(updateSalary);
        doctorFrame.add(updateRoom);
        doctorFrame.add(updateDAddress);
        doctorFrame.add(updateDdept);
        doctorFrame.add(updateSalaryTF);
        doctorFrame.add(updateRoomTF);
        doctorFrame.add(updateDAddressTF);
        doctorFrame.add(updateDdeptTF);
        doctorFrame.add(updateButton);

        doctorFrame.setLayout(null);
        doctorFrame.setVisible(true);
        doctorFrame.setSize(1100, 900);
        doctorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
        ----------------------------------
        ---------- BUTTON ACTIONS --------
        ----------------------------------
         */
        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                doctorFrame.setVisible(false);
                firstScreen();
            }
        });

        searchButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                String inputID2 = inputID.getText();
                try {
                    /*
                        
                     */
                    String query = "select * from Doctor where Doctor_ID ='" + inputID2 + "'";
                    preparedStatement = connection.prepareStatement(query);
                    resultSet = preparedStatement.executeQuery();

                    doctorIDLabel.setVisible(true);
                    doctorFnameLabel.setVisible(true);
                    doctorLnameLabel.setVisible(true);
                    doctorSexLabel.setVisible(true);
                    doctorDoBLabel.setVisible(true);
                    doctorSalaryLabel.setVisible(true);
                    doctorAddressLabel.setVisible(true);
                    doctordeptLabel.setVisible(true);
                    doctorRoomLabel.setVisible(true);
                    resultSet.next();
                    doctorIDLabel2.setText(resultSet.getString("Doctor_ID"));
                    doctorFnameLabel2.setText(resultSet.getString("Fname"));
                    doctorLnameLabel2.setText(resultSet.getString("Lname"));
                    doctorSexLabel2.setText(resultSet.getString("Sex"));
                    doctorDoBLabel2.setText(resultSet.getString("Dob"));
                    doctorSalaryLabel2.setText(resultSet.getString("salary"));
                    doctorAddressLabel2.setText(resultSet.getString("Address"));
                    doctordeptLabel2.setText(resultSet.getString("Department_ID"));
                    doctorRoomLabel2.setText(resultSet.getString("Room_ID"));

                } catch (SQLException e) {

                    JOptionPane.showMessageDialog(doctorFrame, "Wrong Code",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    /*
                        
                     */
                    String update = "insert into Doctor values('" + idT.getText() + "', '" + FnameT.getText() + "', '" + LnameT.getText()
                            + "', '" + dobT.getText() + "', '" + salaryT.getText() + "', '" + dAddressT.getText() + "', '"
                            + sexT.getText() + "', '" + roomT.getText() + "', '" + deptT.getText() + "')";
                    String commit = "commit";
                    statement = connection.createStatement();
                    statement.executeUpdate(update);
                    statement.executeUpdate(commit);
                    JOptionPane.showMessageDialog(null, "The Doctor Was Added Successfully!");
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(doctorFrame, "Wrong Code",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    /*
                        
                     */
                    String update = "delete from doctor where Doctor_ID ='" + deleteID.getText() + "'";

                    statement = connection.createStatement();
                    statement.executeUpdate(update);

                    JOptionPane.showMessageDialog(null, "The Doctor Was Deleted Successfully!");
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(doctorFrame, "Wrong Code" + e2.getMessage(),
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {

                    String update = "update Doctor set salary ='" + updateSalaryTF.getText() + "', Room_ID= '" + updateRoomTF.getText()
                            + "', Address = '" + updateDAddressTF.getText() + "', Department_ID = '" + updateDdeptTF.getText()
                            + "' where Doctor_ID ='" + idTF.getText() + "'";

                    statement = connection.createStatement();
                    statement.executeUpdate(update);

                    JOptionPane.showMessageDialog(null, "The Doctor Was Updated Successfully!");
                } catch (SQLException e2) {
                    JOptionPane.showMessageDialog(doctorFrame, "Wrong Code" + e2.getMessage(),
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    public static void main(String[] args) {
        Home home = new Home();
    }
}
