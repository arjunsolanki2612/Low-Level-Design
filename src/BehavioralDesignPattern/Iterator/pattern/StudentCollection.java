package BehavioralDesignPattern.Iterator.pattern;

import java.util.ArrayList;
import java.util.List;

public class StudentCollection implements Collection<Student> {
    private List<Student> studentList = new ArrayList<>();

   public void addStudents(Student student) {
       studentList.add(student);
   }

    public List<Student> getStudentList() {
        return studentList;
    }

    @Override
   public Iterator<Student> createIterator() {
       return new StudentIterator(this);
   }
}
