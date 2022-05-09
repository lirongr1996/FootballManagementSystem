import Domain.AppController;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AppTest {
    private AppController appController;

    @BeforeEach
    public void setup() {
        System.out.println("Instantiating AppController");
        appController = new AppController();
    }

    @Test
    @DisplayName("Should not schedule game")
    public void ScheduleWithoutUsername() {
        boolean flag= appController.Placement(null,"Israel","2022");
        assertEquals(false, flag);
    }

    @Test
    @DisplayName("Should not schedule game")
    public void ScheduleNotRepresentative() {
        boolean flag= appController.Placement("shir","Israel","2022");
        assertEquals(false, flag);
    }

    @Test
    @DisplayName("Should not schedule game")
    public void ScheduleWithoutLeague() {
        boolean flag= appController.Placement("Moshe","Canada","2022");
        assertEquals(false, flag);
    }

    @Test
    @DisplayName("Should not schedule game")
    public void ScheduleWithoutSeason() {
        boolean flag= appController.Placement("Moshe","Israel","2021");
        assertEquals(false, flag);
    }

    @Test
    @DisplayName("Should schedule game")
    public void ScheduleGame() {
        boolean flag= appController.Placement("Moshe","Israel","2022");
        assertEquals(true, flag);
    }

    @Test
    @DisplayName("integration- login and schedule game")
    public void LoginAndSchedule() {
        String name=appController.login("Moshe","M123");
        boolean flag= appController.Placement(name,"Israel","2022");
        assertEquals(true, flag);
    }

    @Test
    @DisplayName("integration- login and schedule game incorrect")
    public void LoginAndScheduleIncorrect() {
        String name=appController.login("Liron","M123");
        boolean flag= appController.Placement(name,"Israel","2022");
        assertEquals(false, flag);
    }
}
