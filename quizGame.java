import java.util.ArrayList;
import java.util.Scanner;

class Question {

    private String questionText;
    private String[] options;
    private int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean askQuestion(Scanner scanner) {

        System.out.println("\n" + questionText);

        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        System.out.print("Enter your answer (1-4): ");
        int userAnswer = scanner.nextInt();

        return userAnswer == correctAnswer;
    }

    public String getCorrectAnswerText() {
        return options[correctAnswer - 1];
    }
}

public class QuizGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "Which language is primarily used for Android development?",
                new String[]{"Python", "Java", "C++", "Swift"},
                2));

        questions.add(new Question(
                "What does OOP stand for?",
                new String[]{
                        "Object Oriented Programming",
                        "Online Operating Program",
                        "Open Output Process",
                        "Object Output Programming"
                },
                1));

        questions.add(new Question(
                "Which collection allows dynamic resizing?",
                new String[]{
                        "Array",
                        "String",
                        "ArrayList",
                        "Pointer"
                },
                3));

        questions.add(new Question(
                "Who developed Java?",
                new String[]{
                        "Microsoft",
                        "Apple",
                        "Sun Microsystems",
                        "Google"
                },
                3));

        questions.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                new String[]{
                        "implements",
                        "extends",
                        "inherit",
                        "super"
                },
                2));

        boolean playAgain = true;

        while (playAgain) {

            int score = 0;

            System.out.println("\n=================================");
            System.out.println("      JAVA QUIZ APPLICATION");
            System.out.println("=================================");

            for (Question question : questions) {

                boolean correct = question.askQuestion(scanner);

                if (correct) {
                    System.out.println("✅ Correct!");
                    score++;
                } else {
                    System.out.println("❌ Wrong Answer!");
                    System.out.println("Correct Answer: "
                            + question.getCorrectAnswerText());
                }
            }

            System.out.println("\n=================================");
            System.out.println("Quiz Completed!");
            System.out.println("Your Score: " + score + "/" + questions.size());

            double percentage =
                    ((double) score / questions.size()) * 100;

            System.out.printf("Percentage: %.2f%%\n", percentage);

            if (percentage >= 80) {
                System.out.println("🏆 Grade: Excellent");
            } else if (percentage >= 60) {
                System.out.println("👍 Grade: Good");
            } else {
                System.out.println("📚 Grade: Keep Practicing");
            }

            System.out.println("=================================");

            System.out.print("\nDo you want to play again? (Y/N): ");
            String choice = scanner.next();

            playAgain = choice.equalsIgnoreCase("Y");
        }

        System.out.println("\nThank you for playing!");
        scanner.close();
    }
}
