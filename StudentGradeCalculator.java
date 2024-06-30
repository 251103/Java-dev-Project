package project;
import java.util.*;
				// Task 2 StudentGradeCalculator
public class StudentGradeCalculator {
	static Scanner scanner = new Scanner(System.in);
    static Map<String, Student> studentRecords = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to Student Grade Calculator!");
            System.out.println("1. Enter student details and calculate grade");
            System.out.println("2. Retrieve student results by roll number and semester");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    enterStudentDetails();
                    break;
                case 2:
                    retrieveStudentResults();
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void enterStudentDetails() {
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        String rollNo = scanner.nextLine();
        System.out.print("Enter number of subjects: ");
        int numSubjects = scanner.nextInt();
        System.out.print("Enter semester number: ");
        int semester = scanner.nextInt();

        int[] marks = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        int totalMarks = calculateTotalMarks(marks);
        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);
        char grade = calculateGrade(averagePercentage);

        Student student = new Student(name, rollNo, semester, marks, totalMarks, averagePercentage, grade);
        studentRecords.put(rollNo + "-" + semester, student);

        displayResults(student);
    }

    private static int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    private static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 91) return 'O';
        if (averagePercentage >= 81) return 'A';
        if (averagePercentage >= 71) return 'B';
        if (averagePercentage >= 61) return 'C';
        if (averagePercentage >= 51) return 'D';
        return 'F';
    }

    private static void displayResults(Student student) {
        System.out.println("Results for " + student.getName() + " (Roll No: " + student.getRollNo() + ", Semester: " + student.getSemester() + ")");
        System.out.println("Total Marks: " + student.getTotalMarks());
        System.out.println("Average Percentage: " + student.getAveragePercentage());
        System.out.println("Grade: " + student.getGrade());
    }

    private static void retrieveStudentResults() {
        System.out.print("Enter roll number: ");
        String rollNo = scanner.nextLine();
        System.out.print("Enter semester number: ");
        int semester = scanner.nextInt();

        Student student = studentRecords.get(rollNo + "-" + semester);
        if (student != null) {
            displayResults(student);
        } else {
            System.out.println("No records found for Roll No: " + rollNo + " and Semester: " + semester);
        }
    }

    static class Student {
        private String name;
        private String rollNo;
        private int semester;
        private int[] marks;
        private int totalMarks;
        private double averagePercentage;
        private char grade;

        public Student(String name, String rollNo, int semester, int[] marks, int totalMarks, double averagePercentage, char grade) {
            this.name = name;
            this.rollNo = rollNo;
            this.semester = semester;
            this.marks = marks;
            this.totalMarks = totalMarks;
            this.averagePercentage = averagePercentage;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public String getRollNo() {
            return rollNo;
        }

        public int getSemester() {
            return semester;
        }

        public int getTotalMarks() {
            return totalMarks;
        }

        public double getAveragePercentage() {
            return averagePercentage;
        }

        public char getGrade() {
            return grade;
        }
    }
}
