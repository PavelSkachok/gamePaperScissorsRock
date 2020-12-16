import java.util.Scanner;

public class Player {
    private int stepPlayer;

    public Player(String[]initialArgs) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your move: ");
            try {
                this.stepPlayer = scanner.nextInt() - 1;
                if (this.stepPlayer < -1 || this.stepPlayer > initialArgs.length - 1) throw new Exception();
                break;
            } catch (Exception e) {
                continue;
            }
        }
    }
    public int getStepPlayer() {
        return stepPlayer;
    }

}
