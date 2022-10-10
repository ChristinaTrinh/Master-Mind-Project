import java.util.*;

public class MasterMind {
    public static void main(String[] args) {
        char[] codeArray = new char[4];
        char[] guessArray = new char[4];
        boolean[] track = new boolean[4];
        Scanner console = new Scanner(System.in);
        int turn = 10;
        int count = 0;
        codeArrayGenerate(codeArray);
        while (count < 4 && turn > 0) {
            count = 0;
            System.out.print("Please enter your 4-digit guess in capital: ");
            String input = console.nextLine();
            for (int i = 0; i < guessArray.length; i++)
                guessArray[i] = input.charAt(i);
            for (int i = 0; i < guessArray.length; i++) {
                if (guessArray[i] == codeArray[i]) {
                    track[i] = true;
                    System.out.print("X");
                    count++;
                }
            }
            for (int i = 0; i < guessArray.length; i++) {
                for (int j = 0; j < codeArray.length; j++) {
                    if (guessArray[i] == codeArray[j] && !track[j]) {
                        track[j] = true;
                        System.out.print("O");
                        break;
                    }
                }
            }
            System.out.println();
            if (count < 4 && turn > 0) {
                turn--;
                System.out.println("No match! Try again\n\t\t" + turn + " turn(s) left");
                for (int i = 0; i < track.length; i++)
                    track[i] = false;
            } else if (count == 4 || (turn == 0 && count < 4)) {
                if (count == 4)
                    System.out.println("Congratulation! It took " + (10 - turn + 1)
                            + " tries. Do you want to play again?(Yes/No) ");
                else if (turn == 0 && count < 4)
                    System.out.print("Game over! Do you want to play again?(Yes/No) ");
                String answer = console.nextLine();
                if (answer.equals("Yes") || answer.equals("yes") || answer.equals("YES")) {
                    turn = 10;
                    count = 0;
                    for (int i = 0; i < track.length; i++)
                        track[i] = false;
                    codeArrayGenerate(codeArray);
                }
            }
        }
    }

    public static void codeArrayGenerate(char[] codeArray) {
        int num;
        Random r = new Random();
        for (int i = 0; i < codeArray.length; i++) {
            num = r.nextInt(6) + 1;
            switch (num) {
                case 1:
                    codeArray[i] = 'K';
                    break;
                case 2:
                    codeArray[i] = 'B';
                    break;
                case 3:
                    codeArray[i] = 'Y';
                    break;
                case 4:
                    codeArray[i] = 'W';
                    break;
                case 5:
                    codeArray[i] = 'R';
                    break;
                case 6:
                    codeArray[i] = 'G';
                    break;
            }
        }
        System.out.println(Arrays.toString(codeArray));
    }
}
