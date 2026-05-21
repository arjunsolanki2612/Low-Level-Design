package BehavioralDesignPattern.Iterator.pattern;

import java.util.List;

public class StudentIterator implements Iterator<Student> {
    private StudentCollection studentCollection;
    private int index = 0;

    public StudentIterator(StudentCollection studentCollection) {
        this.studentCollection = studentCollection;
    }


    @Override
    public boolean hasNext() {
        List<Student> studentList = studentCollection.getStudentList();
        return index < studentList.size();
    }

    @Override
    public Student next() {
        List<Student> studentList = studentCollection.getStudentList();
        return studentList.get(index++);
    }
}
