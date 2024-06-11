package codsoft;

import java.util.Scanner;

public class StudentGradeCalculator {
    public String grade(int avg) {
      if(avg >=95)
          return "A+";
      else if ( avg >=90 && avg < 94 )
          return "A";
      else if (avg >= 80 && avg <90)
          return "B+";
      else if (avg >= 70 && avg < 80)
          return "C+";
      else if (avg>=60 && avg <70)
          return "C";
      else if (avg>= 50 && avg < 60)
          return "D+";
      else if (avg >= 40 && avg < 50)
          return "D";
      else if (avg >=33 && avg< 40)
          return "E";

      else
          return "Fail";

    }


    public static void main(String[] args) {
            StudentGradeCalculator g = new StudentGradeCalculator();
            Scanner sc = new Scanner(System.in);
            System.out.println(" Enter The name of the student : ");
            String name = sc.nextLine();
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
            System.out.println(" Student Name : "+name);
            System.out.println("Total marks obtained out of " + totalMarks +" :- " +totalMarksObtained);

            System.out.println("Average Percentage obtained :- " + avgPercentage+ "%");
            System.out.println("Grade obtained :- " + Grade);

            sc.close();


    }
}



    
            
