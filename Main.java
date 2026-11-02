
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentManager<Student> manager =
                new StudentManager<>();

        GradeCalculator calculator =
                new GradeCalculatorImpl();

        int choice = 0;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Calculate Grade");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            try {

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    // ADD STUDENT
                    case 1:

                        try {

                            System.out.print("Enter Student ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter Name: ");
                            String name = sc.nextLine();

                            System.out.print("Enter Age: ");
                            int age = sc.nextInt();

                            System.out.print("Enter Marks: ");
                            double marks = sc.nextDouble();
                            sc.nextLine();

                            if (id <= 0 || age <= 0 ||
                                    marks < 0 || marks > 100 ||
                                    name.trim().isEmpty()) {

                                throw new IllegalArgumentException(
                                        "Enter valid ID, name, age and marks!"
                                );
                            }

                            Student student =
                                    new Student(id, name, age, marks);

                            manager.addStudent(student);

                        } catch (DuplicateStudentIdException e) {

                            System.out.println(e.getMessage());

                        } catch (InputMismatchException e) {

                            System.out.println(
                                    "Please enter valid numbers."
                            );

                            sc.nextLine();

                        } catch (IllegalArgumentException e) {

                            System.out.println(e.getMessage());
                        }

                        break;

                    // DISPLAY STUDENTS
                    case 2:

                        manager.displayStudents();

                        break;

                    // SEARCH STUDENT
                    case 3:

                        try {

                            System.out.print("Enter Student ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            Student student =
                                    manager.searchStudent(id);

                            System.out.println("Student ID: "
                                    + student.getStudentId());

                            System.out.println("Name: "
                                    + student.getName());

                            System.out.println("Age: "
                                    + student.getAge());

                            System.out.println("Marks: "
                                    + student.getMarks());

                        } catch (StudentNotFoundException e) {

                            System.out.println(e.getMessage());

                        } catch (InputMismatchException e) {

                            System.out.println("Please enter a valid ID.");
                            sc.nextLine();
                        }

                        break;

                    // UPDATE STUDENT
                    case 4:

                        try {

                            System.out.print("Enter Student ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter New Name: ");
                            String name = sc.nextLine();

                            System.out.print("Enter New Age: ");
                            int age = sc.nextInt();

                            System.out.print("Enter New Marks: ");
                            double marks = sc.nextDouble();
                            sc.nextLine();

                            if (name.trim().isEmpty() ||
                                    age <= 0 ||
                                    marks < 0 || marks > 100) {

                                throw new IllegalArgumentException(
                                        "Enter valid name, age and marks!"
                                );
                            }

                            manager.updateStudent(
                                    id, name, age, marks
                            );

                        } catch (StudentNotFoundException e) {

                            System.out.println(e.getMessage());

                        } catch (InputMismatchException e) {

                            System.out.println(
                                    "Please enter valid numbers."
                            );

                            sc.nextLine();

                        } catch (IllegalArgumentException e) {

                            System.out.println(e.getMessage());
                        }

                        break;

                    // DELETE STUDENT
                    case 5:

                        try {

                            System.out.print("Enter Student ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            manager.deleteStudent(id);

                        } catch (StudentNotFoundException e) {

                            System.out.println(e.getMessage());

                        } catch (InputMismatchException e) {

                            System.out.println("Please enter a valid ID.");
                            sc.nextLine();
                        }

                        break;

                    // CALCULATE GRADE
                    case 6:

                        try {

                            System.out.print("Enter Student ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            manager.calculateStudentGrade(
                                    id, calculator
                            );

                        } catch (StudentNotFoundException e) {

                            System.out.println(e.getMessage());

                        } catch (InputMismatchException e) {

                            System.out.println("Please enter a valid ID.");
                            sc.nextLine();

                        } catch (IllegalArgumentException e) {

                            System.out.println(e.getMessage());
                        }

                        break;

                    // EXIT
                    case 7:

                        System.out.println(
                                "Thank you for using Student Management System!"
                        );

                        break;

                    default:

                        System.out.println(
                                "Invalid choice. Enter 1 to 7."
                        );
                }

            } catch (InputMismatchException e) {

                System.out.println("Please enter a number.");

                sc.nextLine();

                choice = 0;
            }

        } while (choice != 7);

        sc.close();
    }
}