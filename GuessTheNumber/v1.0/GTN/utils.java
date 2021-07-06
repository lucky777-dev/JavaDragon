package GTN;

import java.util.Scanner;
import java.io.IOException;

public class utils {

    static Scanner kb = new Scanner(System.in);

    public static int askIntRange(int min, int max) {
        System.out.print(">");
        while (!kb.hasNextInt()) {
            System.out.println("! Please enter a valid number !");
            kb.next();
        }
        int result = kb.nextInt();
        kb.nextLine(); /* Delete '\n' char in 'kb' buffer */
        while (result < min || result > max) {
            System.out.println("! Please enter a number between " + min + " and " + max + " !");
            System.out.print(">");
            while (!kb.hasNextInt()) {
                System.out.println("! Please enter a valid number !");
                System.out.print(">");
                kb.next();
            }
            result = kb.nextInt();
            kb.nextLine(); /* Delete '\n' char in 'kb' buffer */
        }
        return result;
    }

    public static void clearScreen() {
        String os = System.getProperty("os.name");
        try {
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("<error> [clearScreen()]");
        }
    }
}
