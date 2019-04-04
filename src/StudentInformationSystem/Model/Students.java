package StudentInformationSystem.Model;

import java.util.*;

public class Students {

    Collection<Student> students;

    public Students() {
        this.students = new ArrayList<>();
    }

    public boolean addStudent(String firstName,
            String lastName,
            String id,
            String gender) {
        Student e = new Student(firstName, lastName, id, gender);
        return addStudent(e);
    }

    public boolean addStudent(Student e) {
        if (students.contains(e)) {
            return false;
        }
        students.add(e);
        return true;
    }
    
    public boolean containsStudentWithId(String id){
        for(Student student:students){
            if(student.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public boolean deleteStudentWithKnownId(String id) {

        Student studentToBeDeleted = null;
        for (Student student : students) {
            if (student.getId().equals(id)) {
                studentToBeDeleted = student;
            }
        }
        if (studentToBeDeleted == null) {
            return false;
        }
        students.remove(studentToBeDeleted);
        return true;
    }

    @Override
    public String toString() {
        String studentsString = "";
        int i = 1;
        String lineBreak = "\n";
        for (Student student : students) {
            if (i == students.size()) {
                lineBreak = "";
            }
            studentsString = studentsString + student.toString() + lineBreak;
            i++;
        }
        return studentsString;
    }

    public int getSize() {
        return this.students.size();
    }

    public String[] getStudentColumnNamesArray() {
        String[] studentColumnNamesArray = new String[4];
        studentColumnNamesArray[0] = "FIRST NAME";
        studentColumnNamesArray[1] = "LAST NAME";
        studentColumnNamesArray[2] = "ID";
        studentColumnNamesArray[3] = "GENDER";

        return studentColumnNamesArray;
    }

}
