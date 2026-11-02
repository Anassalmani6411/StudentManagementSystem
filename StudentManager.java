import java.util.ArrayList;

public class StudentManager<T extends Student> {

    private ArrayList<T> students = new ArrayList<>();

    // Add Student
    public void addStudent(T student)
            throws DuplicateStudentIdException {

        for (T s : students) {

            if (s.getStudentId() == student.getStudentId()) {

                throw new DuplicateStudentIdException(
                        "Student ID already exists!"
                );
            }
        }

        students.add(student);

        System.out.println("Student added successfully!");
    }

    // Display All Students
    public void displayStudents() {

        if (students.isEmpty()) {

            System.out.println("No students found.");
            return;
        }

        for (T s : students) {

            System.out.println("--------------------");

            System.out.println("Student ID: " + s.getStudentId());
            System.out.println("Name: " + s.getName());
            System.out.println("Age: " + s.getAge());
            System.out.println("Marks: " + s.getMarks());
        }
    }

    // Search Student
    public T searchStudent(int id)
            throws StudentNotFoundException {

        for (T s : students) {

            if (s.getStudentId() == id) {
                return s;
            }
        }

        throw new StudentNotFoundException(
                "Student not found!"
        );
    }

    // Update Student
    public void updateStudent(int id, String name,
                              int age, double marks)
            throws StudentNotFoundException {

        T student = searchStudent(id);

        student.setName(name);
        student.setAge(age);
        student.setMarks(marks);

        System.out.println("Student updated successfully!");
    }

    // Delete Student
    public void deleteStudent(int id)
            throws StudentNotFoundException {

        T student = searchStudent(id);

        students.remove(student);

        System.out.println("Student deleted successfully!");
    }

    // Calculate Student Grade
    public void calculateStudentGrade(
            int id, GradeCalculator calculator)
            throws StudentNotFoundException {

        T student = searchStudent(id);

        String grade = calculator.calculateGrade(
                student.getMarks()
        );

        System.out.println("Student Name: " + student.getName());
        System.out.println("Marks: " + student.getMarks());
        System.out.println("Grade: " + grade);
    }
}