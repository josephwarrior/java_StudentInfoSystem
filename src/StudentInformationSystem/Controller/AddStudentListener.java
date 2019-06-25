package StudentInformationSystem.Controller;

import StudentInformationSystem.View.*;

import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

public class AddStudentListener implements ActionListener {

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField idField;
    private JTextField genderField;
    private JLabel successCheckLabel;

    private StudentInputPanel studentInputPanel;

    public AddStudentListener(StudentInputPanel studentInputPanel) {
        this.firstNameField = studentInputPanel.getFirstNameTextField();
        this.lastNameField = studentInputPanel.getLastNameTextField();
        this.idField = studentInputPanel.getIdTextField();
        this.genderField = studentInputPanel.getGenderTextField();
        this.successCheckLabel = studentInputPanel.getSuccessCheckLabel();
        this.studentInputPanel = studentInputPanel;
    }

    private void resetTextFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        idField.setText("");
        genderField.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String statusString = null;
        if (!firstNameField.getText().equals("")
                && !lastNameField.getText().equals("")
                && !idField.getText().equals("")
                && !genderField.getText().equals("")) {
            if (studentInputPanel.getFrame().getController().getStudents().addStudent(firstNameField.getText(),
                        lastNameField.getText(), idField.getText(), genderField.getText())) {
                studentInputPanel.getFrame().getController().uploadStudentRegisterInfo();
                statusString = "Student with id " + idField.getText() + " SUCCESSFULLY registered !";
            } else {
                statusString = "xxx id " + idField.getText() + " is already registered xxx";
            }
        } else {
            statusString = "xxx Not Registered. Incomplete Information xxx";
        }
        successCheckLabel.setText(statusString);
        resetTextFields();
    }

}
