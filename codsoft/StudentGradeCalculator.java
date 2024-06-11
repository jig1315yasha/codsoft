package codsoft;

import java.util.Scanner;

public class StudentGradeCalculator {
    public String grade(int avg) {
        return switch (avg / 10) {
            case 10 -> "A+";
            case 9 -> "A";
            case 8 -> "B+";
            case 7 -> "B";
            case 6 -> "C";
            case 5 -> "D";
            default -> "F";
        };
    }

    public static void main(String[] args) {
            StudentGradeCalculator g = new StudentGradeCalculator();
            Scanner sc = new Scanner(System.in);

            //Taking input of how many subjects are there
            System.out.println("Enter the total number of subjects");
            int totalSubs = sc.nextInt();
            int totalMarksObtained = 0;
            int totalMarks = totalSubs*100;
            System.out.println("Total marks  :- " +totalMarks);

            //Taking and adding all the marks
            for (int i = 0; i < totalSubs; i++) {
                System.out.println("Enter the marks obtained in subject " + (i + 1));
                int marks = sc.nextInt();
                totalMarksObtained += marks;

            }

            //Calculating average Percentage
            int avgPercentage = totalMarksObtained / totalSubs;

            //Calculating Grades
            String Grade = g.grade(avgPercentage);

            //Displaying all the Data
            System.out.println("Total marks obtained out of" + totalMarks +" :- " +totalMarksObtained);

            System.out.println("Average Percentage obtained :- " + avgPercentage+ "%");
            System.out.println("Grade obtained :- " + Grade);

            sc.close();


    }
}

