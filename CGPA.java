import java.util.Scanner;

public class CGPACalculator {

    static final String[] GRADES = {"O", "A+", "A", "B+", "B", "C", "P"};
    static final int[] POINTS = {10, 9, 8, 7, 6, 5, 4};
    static final String[] MARKS_RANGE = {
        "90-100",
        "80-89",
        "70-79",
        "60-69",
        "50-59",
        "40-49",
        "30-39"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("CGPA Calculator");

        System.out.println("Enter Your CGPA up to the previous semester:");
        double previousCGPA = scanner.nextDouble();

        System.out.println("Enter the total number of credits you have taken up to the previous semester:");
        double previousCredit = scanner.nextDouble();

        System.out.println("Enter the number of subjects you are taking this semester:");
        int numberOfSubjects = scanner.nextInt();

        double[] grades = new double[numberOfSubjects];
        double[] credits = new double[numberOfSubjects];

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.println("Subject #" + (i + 1));

            System.out.println("Enter marks (0-100):");
            int marks = scanner.nextInt();
            grades[i] = marksToPoint(marks);

            System.out.println("Enter credit:");
            credits[i] = scanner.nextDouble();
        }

        double semesterGPA = calculateCGPA(grades, credits, 0, 0);
        double cumulativeGPA = calculateCGPA(grades, credits, previousCGPA, previousCredit);

        System.out.printf("Your semester GPA is %.2f%n", semesterGPA);
        System.out.printf("Your Cumulative GPA is %.2f%n", cumulativeGPA);

        scanner.close();
    }

    public static double calculateCGPA(double[] grades, double[] credits, double previousCGPA, double previousCredit) {
        double totalCredit = sum(credits) + previousCredit;
        double totalGrade = weightedSum(grades, credits) + previousCGPA * previousCredit;
        return totalGrade / totalCredit;
    }

    public static double marksToPoint(int marks) {
        if (marks >= 90 && marks <= 100) return POINTS[0];
        if (marks >= 80 && marks <= 89) return POINTS[1];
        if (marks >= 70 && marks <= 79) return POINTS[2];
        if (marks >= 60 && marks <= 69) return POINTS[3];
        if (marks >= 50 && marks <= 59) return POINTS[4];
        if (marks >= 40 && marks <= 49) return POINTS[5];
        if (marks >= 30 && marks <= 39) return POINTS[6];
        return 0; // Return 0 for marks below 30 (Failing grade)
    }

    public static double sum(double[] array) {
        double sum = 0;
        for (double v : array) {
            sum += v;
        }
        return sum;
    }

    public static double weightedSum(double[] grades, double[] credits) {
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i] * credits[i];
        }
        return sum;
    }
}
