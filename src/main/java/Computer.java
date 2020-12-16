import java.util.Random;

public class Computer {
    private int stepComputer;
    private String messageComputer;

    public Computer(String[] initialArgs) {
        this.stepComputer = new Random().nextInt(initialArgs.length);
        this.messageComputer=initialArgs[this.stepComputer];
    }

    public int getStepComputer() {
        return stepComputer;
    }

    public String getMessageComputer() {
        return messageComputer;
    }

}
