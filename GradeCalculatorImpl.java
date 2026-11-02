

public class GradeCalculatorImpl implements GradeCalculator {

    @Override
    public String calculateGrade(double marks) {

        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Invalid marks!");
        }

        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 40) {
            return "D";
        } else {
            return "F";
        }
    }
}