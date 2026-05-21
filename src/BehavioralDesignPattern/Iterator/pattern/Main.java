package BehavioralDesignPattern.Iterator.pattern;

public class Main {

    public static void main(String[] args) {

        StudentCollection collection = new StudentCollection();

        collection.addStudents(new Student(1, "Arjun"));
        collection.addStudents(new Student(2, "Rahul"));
        collection.addStudents(new Student(3, "Sneha"));

        Iterator<Student> iterator = collection.createIterator();

        while (iterator.hasNext()) {

            Student student = iterator.next();

            System.out.println(student);
        }
    }
}
