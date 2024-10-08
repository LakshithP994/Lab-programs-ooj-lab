import java.util.Scanner;

class Subject {
    private int subjectMarks;
    private int credits;
    private int grade;

    public Subject(int subjectMarks, int credits) {
        this.subjectMarks = subjectMarks;
        this.credits = credits;
        this.grade = calculateGrade(subjectMarks);
    }

    private int calculateGrade(int marks) {
        if (marks >= 90) return 10;
        else if (marks >= 80) return 9;
        else if (marks >= 70) return 8;
        else if (marks >= 60) return 7;
        else if (marks >= 50) return 6;
	else if (marks >= 40) return 5;
        else return 0;
    }

    public int getSubjectMarks() {
        return subjectMarks;
    }

    public int getCredits() {
        return credits;
    }

    public int getGrade() {
        return grade;
    }

    public void display() {
        System.out.println("Subject Marks: " + subjectMarks);
        System.out.println("Credits: " + credits);
        System.out.println("Grade: " + grade);
    }
}

class Student {
    private String usn;
    private String name;
    private Subject[] subjects; 

    public Student() {
        subjects = new Subject[3]; 
    }

    void getDetails(Scanner sc) {
        System.out.print("Enter USN: ");
        usn = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();

        System.out.println("Enter marks for 3 subjects:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Marks for subject " + (i + 1) + ": ");
            int marks = sc.nextInt();
            subjects[i] = new Subject(marks, 4); 
        }
    }

    double calculateSGPA() {
        double totalPoints = 0;
        double totalCredits = 0;
        for (Subject subject : subjects) {
            totalPoints += subject.getGrade() * subject.getCredits();
            totalCredits += subject.getCredits();
        }
        return totalCredits > 0 ? totalPoints / totalCredits : 0;
    }

    void display() {
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Subjects:");
        for (Subject subject : subjects) {
            subject.display();
            System.out.println();
        }
        System.out.printf("SGPA: %.2f%n", calculateSGPA());
    }
}

public class SGPAcalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[3];

        for (int j = 0; j < 3; j++) {
            System.out.println("Enter the details of student " + (j + 1) + ":");
            students[j] = new Student();
            students[j].getDetails(sc);
        }

        System.out.println("\nStudent Details:");
        for (Student student : students) {
            student.display();
            System.out.println();
        }
	System.out.println("Lakshith P");
	System.out.println("1BM23CS164");

        sc.close();
    }
}
