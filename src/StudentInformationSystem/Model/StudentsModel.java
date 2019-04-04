package StudentInformationSystem.Model;

import java.util.Collection;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class StudentsModel implements TableModel {

    private Students students;

    public StudentsModel(Students students) {
        this.students = students;
    }

    @Override
    public int getRowCount() {
        return students.getSize();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "FIRST NAME";
        } else if (columnIndex == 1) {
            return "LAST NAME";
        } else if (columnIndex == 2) {
            return "ID";
        } else if (columnIndex == 3) {
            return "GENDER";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Collection<Student> s = students.getStudents();
        int row=-1;
        for (Student student : s) {
            row++;
            if (row == rowIndex) {
                if (columnIndex == 0) {
                    return student.getFirstName();
                }

                if (columnIndex == 1) {
                    return student.getLastName();
                }

                if (columnIndex == 2) {
                    return student.getId();
                }

                if (columnIndex == 3) {
                    return student.getGender();
                }else{
                    
                }
            }
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       //////
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        //////
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        //////
    }

}
