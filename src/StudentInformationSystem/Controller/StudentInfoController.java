
package StudentInformationSystem.Controller;
import StudentInformationSystem.Model.*;
import StudentInformationSystem.View.*;

import java.io.File;
import java.util.Scanner;

public class StudentInfoController {
    
    private Students students;
    private StudentInputFrame frame;

    public StudentInfoController() {
        this.students = new Students();
    }
    
    
    
    public void Start(){
        downloadStudentRegisterInfo();
        this.frame=new StudentInputFrame(this);
    }
    
    public void downloadStudentRegisterInfo(){
        try{
            File file=new File("src/students.txt");
            Scanner reader=new Scanner(file);
            while(reader.hasNextLine()){
                String[] studentsArray=reader.nextLine().split("\\|");
                students.addStudent(studentsArray[0],
                        studentsArray[1],
                        studentsArray[2],
                        studentsArray[3]);
            }
        }catch(Exception exc){
            
        }
    }
    
    public void uploadStudentRegisterInfo(){
        BufferedWriter writer=null;
        try{
            File file=new File("src/students.txt");
            FileWriter fileWriter=new FileWriter(file);
            writer=new BufferedWriter(fileWriter);
            
            StringBuilder sb=new StringBuilder();
            int i=1;
            for(Student s:students.getStudents()){    
                sb.append(s.getFirstName());
                sb.append("|");
                sb.append(s.getLastName());
                sb.append("|");
                sb.append(s.getId());
                sb.append("|");
                sb.append(s.getGender());
                if(i<students.getSize()){
                    sb.append("\n");
                }
                i++;
            }
            writer.append(sb.toString());
        }catch(Exception exc){
            exc.printStackTrace();
        }finally{
            try{
            writer.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    
    /////// HELPERS /////////////
    public String[][] getInfoArrayOfStudentWithId(String id){
        String[][] searchedStudentInfoArray=new String[1][4];
        for(Student student:students.getStudents()){
            searchedStudentInfoArray[0][0]=student.getFirstName();
            searchedStudentInfoArray[0][1]=student.getLastName();
            searchedStudentInfoArray[0][2]=student.getId();
            searchedStudentInfoArray[0][3]=student.getGender();            
        }
        return searchedStudentInfoArray;
    }
    
    public StudentsModel getStudentsModel(){
        return new StudentsModel(students);
    }
    
    
    
    ////////  GETTERS   ////////////

    public Students getStudents() {
        return students;
    }
    
    
}
