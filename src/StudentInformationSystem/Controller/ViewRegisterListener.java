
package StudentInformationSystem.Controller;
import StudentInformationSystem.View.StudentInputPanel;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

public class ViewRegisterListener implements ActionListener {

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField idField;
    private JTextField genderField;
    private JLabel successCheckLabel;

    private StudentInputPanel studentInputPanel;

    public ViewRegisterListener(StudentInputPanel studentInputPanel) {
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
            JTable registerViewTable = new JTable(studentInputPanel.getFrame().getController().getStudentsModel());
            JScrollPane jsp = new JScrollPane(registerViewTable);
            JFrame frame = new JFrame();
            Container con = frame.getContentPane();
            con.add(jsp);
            frame.setSize(400, 400);
            frame.setVisible(true);
            resetTextFields();
            successCheckLabel.setText("");
    }

}
