package StudentInformationSystem.Controller;
import StudentInformationSystem.View.*;

import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

public class DeleteStudentListener implements ActionListener {

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField idField;
    private JTextField genderField;
    private JLabel successCheckLabel;

    private StudentInputPanel studentInputPanel;

    public DeleteStudentListener(StudentInputPanel studentInputPanel) {
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
        if (!idField.getText().equals("")) {
            if (studentInputPanel.getFrame().getController().getStudents().deleteStudentWithKnownId(idField.getText())) {
                studentInputPanel.getFrame().getController().uploadStudentRegisterInfo();
                statusString = "xxx Student with id " + idField.getText() + " SUCCESSFULLY deleted xxx";
            } else {
                statusString = "id " + idField.getText() + " is not registered !";
            }
        } else {
            statusString = "xxx id field is empty xxx";
        }
        successCheckLabel.setText(statusString);
        resetTextFields();
    }

}
