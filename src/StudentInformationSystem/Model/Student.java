package StudentInformationSystem.Model;

import java.util.Objects;

public class Student {

    private String firstName;
    private String lastName;
    private String id;
    private String gender;

    enum gender {
        MALE, FEMALE
    }

    public Student(String firstName, String lastName, String id, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return firstName + "|" + lastName + "|" + id + "|" + gender;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.lastName);
        hash = 19 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String[][] getStudentInfoArray() {
        String[][] studentInfo = new String[1][4];
        studentInfo[0][0] = firstName;
        studentInfo[0][1] = lastName;
        studentInfo[0][2] = id;
        studentInfo[0][3] = gender;

        return studentInfo;
    }



}
