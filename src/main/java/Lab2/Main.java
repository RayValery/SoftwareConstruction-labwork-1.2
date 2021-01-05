package Lab2;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        String name = "Valerie";
        int age = 20;
        Long studBook = 1234567L;

        Student student1 = new Student(name, age, 3, studBook);
        System.out.println("\nAfter creation: " + student1.toString());

        name = "Marie";
        age = 19;

        System.out.println("\nAfter changing value of variables: " + "name=" + name + ", age=" + age + student1.toString());

        try {
            Student student4 = (Student) student1.clone();
            System.out.println("\nCompare addresses: " + (student4==student1));
            System.out.println("Compare meaning: " + (student4.equals(student1)));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Student student2 = new Student("Vladislav", 19, 4, 1234765L);
        Student student3 = new Student("Viktoriia", 19, 2, 3214567L);

        Set<Student> students = new TreeSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        System.out.println("\nDisplay order of elements in set");
        for (Student student : students){
            System.out.println("Student on course - " + student.getCourse());
        }
    }
}
