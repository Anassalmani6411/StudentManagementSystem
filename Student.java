public class Student extends Person {

    private int studentId;
    private double marks;

    public Student(int studentId, String name, int age, double marks) {

        super(name, age);

        this.studentId = studentId;
        this.marks = marks;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}