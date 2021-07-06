package GTN;

import java.util.Scanner;
import java.util.ArrayList;

public class game {
    static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
        int level = 1, lives = 3, attempts = 0, totalAttempts = 0;
        int solution = (((int) (Math.random() * (level * 10))) + 1);
        ArrayList<Integer> answers = new ArrayList<>();
        utils.clearScreen();
        while (attempts < lives) {
            System.out.println("Level: " + level);
            System.out.println("Attempts: " + answers.toString());
            System.out.println("Attempts left: " + (lives - attempts));
            System.out.println("Please try to find the hidden number between 1 and " + (level * 10));
            int answer = utils.askIntRange(1, (level * 10));
            while(answers.contains(answer)) {
                System.out.println("You already typed this number! Try again");
                answer = utils.askIntRange(1, (level * 10));
            }
            answers.add(answer);
            attempts++;
            totalAttempts++;
            while ((answer != solution) && (attempts < lives)) {
                utils.clearScreen();
                System.out.println("Level: " + level);
                System.out.println("Attempts: " + answers.toString());
                System.out.println("Attempts left: " + (lives - attempts));
                System.out.println((answer < solution) ? ("Too low, try again!") : ("Too high, try again!"));
                answer = utils.askIntRange(1, (level * 10));
                while(answers.contains(answer)) {
                    System.out.println("You already typed this number! Try again");
                    answer = utils.askIntRange(1, (level * 10));
                }
                answers.add(answer);
                attempts++;
                totalAttempts++;
            }
            if (answer == solution) {
                level++;
                attempts = 0;
                answers.clear();
                switch (level) {
                    case 3:
                        lives = 4;
                        break;
                    case 5:
                        lives = 5;
                        break;
                    case 7:
                        lives = 6;
                        break;
                    case 9:
                        lives = 7;
                        break;
                    case 11:
                        lives = 8;
                        break;
                    case 13:
                        lives = 9;
                        break;
                    case 15:
                        lives = 10;
                        break;
                }
                solution = (((int) (Math.random() * (level * 10))) + 1);
                utils.clearScreen();
                System.out.print("Well done! -> ");
            }
        }
        utils.clearScreen();
        System.out.println("Game over.");
        System.out.println("Level reached: " + level);
        System.out.println("Total attempts: " + totalAttempts);
    }
}