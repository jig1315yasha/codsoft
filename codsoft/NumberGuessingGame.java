package codsoft;

import java.util.Random;
import java.util.Scanner;

import java.util.*;


public class NumberGuessingGame{
    static List<Integer> myList = new ArrayList<>();
    public int number;
    public int inputNumber;
    public int noOfGuesses = 0;
    private static final int  MAX_ATTEMPTS = 10;
    public int totalScore = 100;
    private static final int MAX_ROUNDS = 3;

    //constructor to generate random number
    NumberGuessingGame() {
        Random rand = new Random();
        this.number = rand.nextInt(100);
    }
   //taking user input
    void takeUserInput() {
        System.out.println("Guess the number : ");
        Scanner sc = new Scanner(System.in);
        inputNumber = sc.nextInt();
    }
    //Method to check if the guessed no. is correct or not
    boolean isCorrectNumber() {
        noOfGuesses++;
        if (inputNumber == number) {
            System.out.format("Yes you guessed it right, it was %d\nYou guessed it in %d attempts\n", number, noOfGuesses);

            System.out.printf("Total Score : %d\n", totalScore- 10*noOfGuesses);
            System.out.println("added successfully");
            myList.add(totalScore- 10*noOfGuesses);

            return true;

        } else if (inputNumber < number) {
            System.out.println("Too low...");
            System.out.println("Number Of attempts left = "+ (MAX_ATTEMPTS-noOfGuesses));
        } else  {
            System.out.println("Too high...");
            System.out.println("Number Of attempts left = "+ (MAX_ATTEMPTS-noOfGuesses));
        }
        if(noOfGuesses == MAX_ATTEMPTS){
            System.out.println("You Failed..");
            System.out.println("The Correct Answer Was "+number);
            System.out.println("Total Score is 0.");
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i;
        for ( i = 1; i<= MAX_ROUNDS;i++) {
            NumberGuessingGame g = new NumberGuessingGame();
            boolean b = false;
            while (!b) {
                g.takeUserInput();
                b = g.isCorrectNumber();

            }

            System.out.println("Do you want to play next Round...");

            System.out.println("If Yes enter 1 else 0");
            int choice = s.nextInt();
            System.out.println("Round Left = "+(MAX_ROUNDS-i));
            if(choice == 1 && MAX_ROUNDS-i>0){

                System.out.println("Playing Again..");
            }
            else{
                int max1=Collections.max(myList);
                System.out.println("The highest score so far is : "+max1);
                return;
            }

        }

    }
}