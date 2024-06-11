package codsoft;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}

class Quiz {
    private ArrayList<Question> questions;
    private int score;
    private int currentQuestionIndex;
    private ArrayList<Boolean> answers;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        currentQuestionIndex = 0;
        answers = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Question getNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex++);
        }
        return null;
    }

    public void submitAnswer(int chosenAnswer) {
        Question currentQuestion = questions.get(currentQuestionIndex - 1);
        boolean isCorrect = (chosenAnswer == currentQuestion.getCorrectAnswerIndex());
        answers.add(isCorrect);
        if (isCorrect) {
            score++;
        }
    }

    public int getScore() {
        return score;
    }

    public ArrayList<Boolean> getAnswers() {
        return answers;
    }

    public int getTotalQuestions() {
        return questions.size();
    }
}

public class QuizWithTimer {
    private static final int QUESTION_TIME_LIMIT = 15; // 15 seconds per question
    private static Timer timer;
    private static boolean timeUp;

    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Adding sample questions
        quiz.addQuestion(new Question("The luminous coloured ring, surrounding the sun is called the?", new String[]{"Nebula", "Comet", "Asteroid", "corona"}, 3));
        quiz.addQuestion(new Question("The longest ship canal in the world is the?", new String[]{"St. Laurence Seaway (USA and Canada)", "Suez canal, Egypt", "Kiel canal, Germany", "Panama canal, Central America"}, 0));
        quiz.addQuestion(new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Lisbon"}, 2));
        quiz.addQuestion(new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 1));
        quiz.addQuestion(new Question("What is the largest ocean on Earth?", new String[]{"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"}, 3));
        quiz.addQuestion(new Question("Which country did India discuss revitalizing \"Energy Sector Cooperation\" with?", new String[]{"Libya", "Iran", "Iraq", "Kuwait"}, 0));
        quiz.addQuestion(new Question("Which country received $1 million in aid from India for relief, rehabilitation, and reconstruction efforts after a devastating landslide?", new String[]{"Solomon Islands","Papua New Guinea", "Samoa", "Fiji"}, 1));
        quiz.addQuestion(new Question("To avoid the race condition, the number of processes that may be simultaneously inside their critical section is?", new String[]{"8","16", "32", "1"}, 3));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            Question question = quiz.getNextQuestion();
            if (question == null) {
                break;
            }
            displayQuestion(question);
            startTimer();

            timeUp = false;
            int answer = getAnswer(scanner);

            if (!timeUp) {
                timer.cancel();
            }
            quiz.submitAnswer(answer);

            System.out.println();
        }

        displayResults(quiz);
    }

    private static void displayQuestion(Question question) {
        System.out.println(question.getQuestionText());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    private static void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up!");
                timeUp = true;
                timer.cancel();
            }
        }, QUESTION_TIME_LIMIT * 1000);
    }

    private static int getAnswer(Scanner scanner) {
        System.out.print("Enter your choice (1-4): ");
        int answer = -1;
        long startTime = System.currentTimeMillis();

        while ((System.currentTimeMillis() - startTime) < (QUESTION_TIME_LIMIT * 1000)) {
            if (scanner.hasNextInt()) {
                answer = scanner.nextInt() - 1; // Adjust for 0-based index
                if (answer >= 0 && answer < 4) {
                    break;
                } else {
                    System.out.print("Invalid choice. Enter your choice (1-4): ");
                }
            } else {
                scanner.next(); // clear the invalid input
                System.out.print("Invalid input. Enter your choice (1-4): ");
            }
        }
        return answer;
    }

    private static void displayResults(Quiz quiz) {
        System.out.println("Quiz Over!");
        System.out.println("Your score: " + quiz.getScore() + " out of " + quiz.getTotalQuestions());
        ArrayList<Boolean> answers = quiz.getAnswers();
        for (int i = 0; i < answers.size(); i++) {
            System.out.println("Question " + (i + 1) + ": " + (answers.get(i) ? "Correct" : "Incorrect"));
        }
    }
}
