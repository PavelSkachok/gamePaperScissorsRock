import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PresenterTest {
    Presenter presenter;
    static String[] str1, str2, str3, str4, str5, str6, str7, str8;
    static String[] modArr1, modArr2, modArr3;

    @BeforeAll
    static void beforeAll() {
        str1 = new String[]{""};
        str2 = new String[]{"Paper", "Scissors"};
        str3 = new String[]{"Paper", "Scissors", "Rock", "Spock"};
        str4 = new String[]{"Paper", "Scissors", "Rock", "Spock", "Snack", "Rabbit"};
        str5 = new String[]{"Paper", "Scissors", "Rock", "Spock", "Paper"};
        str6 = new String[]{"Paper", "Scissors", "Rock"};
        str7 = new String[]{"Paper", "Scissors", "Rock", "Snake", "Rabbit"};
        str8 = new String[]{"Paper", "Scissors", "Rock", "Snake", "Rabbit", "Bird", "Tiger"};
        modArr1 = new String[]{"Scissors", "Rock", "Snake", "Rabbit", "Paper"};
        modArr2 = new String[]{"Rock", "Snake", "Rabbit", "Paper","Scissors"};
        modArr3 = new String[]{ "Snake", "Rabbit", "Paper","Scissors","Rock"};


    }

    @BeforeEach
    void createPresenter() {
        presenter = new Presenter();
    }

    @Test
    void whenArgsEqualEmpty_thenFalse() {
        boolean actual = presenter.checkArgs(str1);
        assertFalse(actual);
    }

    @Test
    void whenArgsEqualTwo_thenFalse() {
        boolean actual = presenter.checkArgs(str2);
        assertFalse(actual);
    }

    @Test
    void whenArgsEqualEvenFour_thenFalse() {
        boolean actual = presenter.checkArgs(str3);
        assertFalse(actual);
    }

    @Test
    void whenArgsEqualEvenSix_thenFalse() {
        boolean actual = presenter.checkArgs(str4);
        assertFalse(actual);
    }

    @Test
    void whenArgsEqualRepeat_thenFalse() {
        boolean actual = presenter.checkArgs(str5);
        assertFalse(actual);
    }

    @Test
    void whenArgsEqualThreeUnRepeat_thenTrue() {
        boolean actual = presenter.checkArgs(str6);
        assertTrue(actual);
    }

    @Test
    void whenArgsEqualFifeUnRepeat_thenTrue() {
        boolean actual = presenter.checkArgs(str7);
        assertTrue(actual);
    }

    @Test
    void whenArgsEqualSevenUnRepeat_thenTrue() {
        boolean actual = presenter.checkArgs(str8);
        assertTrue(actual);
    }
    @Test
    void whenStepComputerEqualOne_thenTrue() {
        String[] actual = presenter.modifyArgs(str7,1);
        assertArrayEquals(modArr1,actual);
    }
    @Test
    void whenStepComputerEqualTwo_thenTrue() {
        String[] actual = presenter.modifyArgs(str7,2);
        assertArrayEquals(modArr2,actual);
    }
    @Test
    void whenStepComputerEqualThree_thenTrue() {
        String[] actual = presenter.modifyArgs(str7,3);
        assertArrayEquals(modArr3,actual);
    }
    @Test
    void whenStepComputerRabbitStepPlayerPaper_thenTrue() {
        String actual = presenter.adjudicate(str7, 4, 0);
        String except="You win!";
        assertEquals(except,actual);
    }
    @Test
    void whenStepComputerRabbitStepPlayerScissors_thenTrue() {
        String actual = presenter.adjudicate(str7, 4, 1);
        String except="You win!";
        assertEquals(except,actual);
    }
    @Test
    void whenStepComputerRabbitStepPlayerRock_thenTrue() {
        String actual = presenter.adjudicate(str7, 4, 2);
        String except="You lost!";
        assertEquals(except,actual);
    }
    @Test
    void whenStepComputerRabbitStepPlayerSnake_thenTrue() {
        String actual = presenter.adjudicate(str7, 4, 3);
        String except="You lost!";
        assertEquals(except,actual);
    }
    @Test
    void whenStepComputerRabbitStepPlayerRabbit_thenTrue() {
        String actual = presenter.adjudicate(str7, 4, 4);
        String except="Dead heat!";
        assertEquals(except,actual);
    }

}