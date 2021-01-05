package Lab2;

import lombok.Getter;

import java.util.Comparator;
import java.util.Objects;

@Getter
public final class Student implements Cloneable, Comparable<Student>, Comparator<Student> {

    private final String name;
    private final Integer age;
    private final Integer course;
    private final Long studentBookNumber;

    public Student(String name, Integer age, Integer course, Long studentBookNumber) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.studentBookNumber = studentBookNumber;
    }

    @Override
    public int compareTo(Student student) {
        if (student == null) {
            return 1;
        }
        return this.course.compareTo(student.course);
    }

    @Override
    public int compare(Student student, Student t1) {
        return student.compareTo(t1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(age, student.age) &&
                Objects.equals(course, student.course) &&
                Objects.equals(studentBookNumber, student.studentBookNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, course, studentBookNumber);
    }

    @Override
    public String toString() {
        return "\nStudent: " +
                "\n  name: " + name +
                "\n  age: " + age +
                "\n  course: " + course +
                "\n  studentBookNumber: " + studentBookNumber;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
