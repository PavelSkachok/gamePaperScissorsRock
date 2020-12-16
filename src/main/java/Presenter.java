import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Presenter{
    public void validateInputData(String[] initialArgs) {
        if (!checkArgs(initialArgs)) {
            System.out.println("You input incorrect data!");
            System.out.println("Arguments count must be >=3, odd and non-recurring!");
            System.out.println("EXAMPLE: paper scissors rock");
            System.exit(0);
        }
    }

    public void giveChoicePlayer(Authentication key, String[] initialArgs) {
        System.out.println(key.getFieldHMAC());
        System.out.println("Available moves:");
        for (int i = 0; i < initialArgs.length; i++) {
            System.out.println((i + 1) + " - " + initialArgs[i]);
        }
        System.out.println("0 - exit");
    }

    public void generateResultGame(String[] args, Computer computer, Player player, Authentication key) {
        int stepComputer = computer.getStepComputer();
        int stepPlayer = player.getStepPlayer();
        System.out.print("Your move: ");
        if (stepPlayer == -1) {
            System.out.println("exit");
            System.exit(0);
        }
        System.out.println(args[stepPlayer]);
        System.out.print("Computer move: ");
        System.out.println(args[stepComputer]);
        System.out.println(adjudicate(args, stepComputer, stepPlayer));
        System.out.println(key.getFieldKeyHMAC());
    }


     protected boolean checkArgs(String[] seq) {
        return (seq.length >= 3 && seq.length % 2 != 0 && !checkRepeat(seq));
    }

    private boolean checkRepeat(String[] seq) {
        List argsIgnoreCase = Arrays.stream(seq).map(v -> v.toLowerCase()).collect(Collectors.toList());
        Boolean ais = argsIgnoreCase.stream().anyMatch(i -> Collections.frequency(argsIgnoreCase, i) > 1);
        return ais;
    }

    protected String adjudicate(String[] initialArr, int stepComputer, int stepPlayer) {
        List listArg = new ArrayList();
        Collections.addAll(listArg, modifyArgs(initialArr,stepComputer));
        int medium = (initialArr.length - 1) / 2;
        if (listArg.indexOf(initialArr[stepPlayer]) > medium) {
           return  "You lost!";
        } else if (stepComputer == stepPlayer) {
            return "Dead heat!";
        } else {
            return  "You win!";
        }
    }

    protected String[] modifyArgs(String[] arr, int step) {
        String[] myArr = new String[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i + step < arr.length) {
                myArr[i] = arr[step + i];
            } else {
                myArr[i] = arr[j++];
            }
        }
        return myArr;
    }
}
