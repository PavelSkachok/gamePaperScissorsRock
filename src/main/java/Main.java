import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Presenter presenter = new Presenter();
        presenter.validateInputData(args);
        Computer computer = new Computer(args);
        Authentication authentication = new Authentication(computer.getMessageComputer());
        presenter.giveChoicePlayer(authentication, args);
        Player player = new Player(args);
        presenter.generateResultGame(args,computer,player,authentication);
    }
}
