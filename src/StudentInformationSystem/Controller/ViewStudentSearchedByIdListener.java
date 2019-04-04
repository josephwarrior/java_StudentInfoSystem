
package StudentInformationSystem.Controller;
import StudentInformationSystem.View.*;

import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

public class ViewStudentSearchedByIdListener implements ActionListener {

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField idField;
    private JTextField genderField;
    private JLabel successCheckLabel;

    private StudentInputPanel studentInputPanel;

    public ViewStudentSearchedByIdListener(StudentInputPanel studentInputPanel) {
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
        String statusString=null;
        if(!idField.equals("")){
            String id = studentInputPanel.getIdTextField().getText();
            if (studentInputPanel.getFrame().getController().getStudents().containsStudentWithId(id)) {
                JTable studentSearchedByIdTable = new JTable(studentInputPanel.getFrame().getController().getInfoArrayOfStudentWithId(idField.getText()),
                        studentInputPanel.getFrame().getController().getStudents().getStudentColumnNamesArray());
                JScrollPane jsp = new JScrollPane(studentSearchedByIdTable);
                JFrame frame = new JFrame();
                Container con = frame.getContentPane();
                con.add(jsp);
                frame.setSize(400, 400);
                frame.setVisible(true);
                resetTextFields();
                statusString="";
            } else {
                statusString="xxxx  The id: " + id + " is not in the register  xxxx";
                resetTextFields();
            }
        }else{
            statusString="xxx id field is empty xxx";
        }
        successCheckLabel.setText(statusString);
    }

}
