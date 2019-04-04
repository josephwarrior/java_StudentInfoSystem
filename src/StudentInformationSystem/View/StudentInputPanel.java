package StudentInformationSystem.View;
import StudentInformationSystem.Controller.*;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.*;

public class StudentInputPanel extends JPanel {

    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField idTextField;
    private JTextField genderTextField;
    private JLabel successCheckLabel;

    private StudentInputFrame frame;

    public StudentInputPanel(StudentInputFrame frame) {
        this.frame = frame;
        setupPanel();
    }

    private void setupPanel() {
        GridLayout generalLayout = new GridLayout(4, 1);
        this.setLayout(generalLayout);

        this.add(getTitlePanel());
        this.add(getStudentFieldsPanel());
        this.add(getButtonsPanel());
    }

    private JPanel getTitlePanel() {
        JPanel titlePanel = new JPanel();
        GridLayout titleLayout = new GridLayout(1, 3);
        titlePanel.setLayout(titleLayout);

        Font titleFont = new Font("Times New Roman", 1, 18);
        JLabel titleLabel = new JLabel("STUDENT INFORMATION SYSTEM");
        titleLabel.setFont(titleFont);

        titlePanel.add(new JLabel(""));
        titlePanel.add(titleLabel);
        successCheckLabel = new JLabel("");
        titlePanel.add(successCheckLabel);

        return titlePanel;
    }

    private JPanel getStudentFieldsPanel() {
        JPanel studentFieldsPanel = new JPanel();
        GridLayout studentFieldsLayout = new GridLayout(4, 2);
        studentFieldsPanel.setLayout(studentFieldsLayout);

        JLabel firstNameLabel = new JLabel("First name:");
        firstNameTextField = new JTextField();
        JLabel lastNameLabel = new JLabel("Last name:");
        lastNameTextField = new JTextField();
        JLabel idLabel = new JLabel("id:");
        idTextField = new JTextField();
        JLabel genderLabel = new JLabel("Gender:");
        genderTextField = new JTextField();

        studentFieldsPanel.add(firstNameLabel);
        studentFieldsPanel.add(firstNameTextField);
        studentFieldsPanel.add(lastNameLabel);
        studentFieldsPanel.add(lastNameTextField);
        studentFieldsPanel.add(idLabel);
        studentFieldsPanel.add(idTextField);
        studentFieldsPanel.add(genderLabel);
        studentFieldsPanel.add(genderTextField);

        return studentFieldsPanel;
    }

    private JPanel getButtonsPanel() {
        JPanel buttonsPanel = new JPanel();
        GridLayout buttonsLayout = new GridLayout(2, 3);
        buttonsPanel.setLayout(buttonsLayout);

        JButton addButton = new JButton("ADD student");
        addButton.addActionListener(new AddStudentListener(this));

        JButton displayRegisterButton = new JButton("Display Register");
        displayRegisterButton.addActionListener(new ViewRegisterListener(this));

        JButton deleteButton = new JButton("DELETE student");
        deleteButton.addActionListener(new DeleteStudentListener(this));

        JButton searchByIdButton = new JButton("Search by ID");
        searchByIdButton.addActionListener(new ViewStudentSearchedByIdListener(this));

        buttonsPanel.add(addButton);
        buttonsPanel.add(displayRegisterButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(searchByIdButton);

        return buttonsPanel;
    }

    ///////////////GETTERS FOR THE FIELDS////////////////////
    public StudentInputFrame getFrame() {
        return frame;
    }

    public JTextField getFirstNameTextField() {
        return firstNameTextField;
    }

    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public JTextField getGenderTextField() {
        return genderTextField;
    }

    public JLabel getSuccessCheckLabel() {
        return successCheckLabel;
    }

}
