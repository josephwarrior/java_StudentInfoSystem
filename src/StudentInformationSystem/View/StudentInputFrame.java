
package StudentInformationSystem.View;
import StudentInformationSystem.Controller.*;

import javax.swing.*;

public class StudentInputFrame extends JFrame{
    
    private StudentInputPanel studentInputPanel;
    private StudentInfoController controller;
    
    public StudentInputFrame(StudentInfoController controller){
        this.controller=controller;
        studentInputPanel=new StudentInputPanel(this);
        setupFrame();
    }
    
    public void setupFrame(){
        this.setContentPane(studentInputPanel);
        this.setSize(1000,400);
        this.setVisible(true);
    }
    
    
    
    /////////GETTERS///////////////////

    public StudentInfoController getController() {
        return controller;
    }

    public StudentInputPanel getStudentInputPanel() {
        return studentInputPanel;
    }
}
