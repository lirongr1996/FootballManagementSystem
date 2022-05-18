import DataAccess.StubDao;
import Domain.AppController;
import Domain.StubSystem;
import Domain.SystemApp;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private AppController appController;
    private SystemApp systemApp;
    private StubSystem systemStub;

    @BeforeEach
    public void setup() {
        System.out.println("Instantiating AppController");
        appController = new AppController();
        systemApp =new SystemApp();
        systemStub=new StubSystem();
    }

    //=======================Unit====================================//

    @Test
    @DisplayName("Check Representative Valid")
    public void CheckRepresentativeValid() {
        boolean flag= systemApp.CheckRepresentative("Moshe");
        assertEquals(true, flag);
    }

    @Test
    @DisplayName("Check Representative Invalid")
    public void CheckRepresentativeInvalid() {
        boolean flag= systemApp.CheckRepresentative("liron");
        assertEquals(false, flag);
    }

    @Test
    @DisplayName("Should schedule game")
    public void ScheduleGameStub() {
        boolean flag= systemStub.GamesPlacement("Emma","Israel","2022");
        assertEquals(true, flag);
    }

    @Test
    @DisplayName("Should login")
    public void loginStub() {
        String flag= systemStub.login("Moshe","M123");
        assertEquals("Moshe", flag);
    }
    
    @Test
    @DisplayName("Should Register referee")
    public void RegisterRefereeStub() {
        boolean flag = systemStub.RefereeRegistration("Emma","Moshe","Kavan");
        assertEquals(true, flag);
    }
    

    //=======================Acceptance====================================//

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
    @DisplayName("Failed to login")
    public void LoginWithoutUsername() {
        String flag= appController.login(null,"M123");
        assertEquals(null, flag);
    }
    @Test
    @DisplayName("Failed to login")
    public void LoginWithoutPassword() {
        String flag= appController.login("Anna",null);
        assertEquals(null, flag);
    }
    @Test
    @DisplayName("Login successfully")
    public void LoginSuccessfully() {
        String flag= appController.login("Moshe","M123");
        assertEquals("Moshe", flag);
    }
    @Test
    @DisplayName("Failed to login")
    public void LoginWitWrongPassword() {
        String flag= appController.login("Moshe","123");
        assertEquals(null, flag);
    }
    @Test
    @DisplayName("Failed to login")
    public void LoginWitWrongUsername() {
        String flag= appController.login("Anna","M123");
        assertEquals(null, flag);
    }
    
    @Test
    @DisplayName("Register referee success")
    public void RegisterRefereeApp() {
        boolean flag = appController.RefereeRegistration("Moshe","Moshe","Kavan");
        assertEquals(false, flag);
    }
    
    @Test
    @DisplayName("Register referee fail - username=null")
    public void RegisterRefereeNoUsernameApp() {
        boolean flag = appController.RefereeRegistration(null,"Moshe","Kavan");
        assertEquals(false, flag);
    }
    
    @Test
    @DisplayName("Register referee fail - name=null")
    public void RegisterRefereeNoNameApp() {
        boolean flag = appController.RefereeRegistration("Moshe",null,"Kavan");
        assertEquals(false, flag);
    }
    
    @Test
    @DisplayName("Register referee fail - training=null")
    public void RegisterRefereeNoTrainingApp() {
        boolean flag = appController.RefereeRegistration("Moshe","Moshe",null);
        assertEquals(false, flag);
    }


    //=======================integration====================================//

    @Test
    @DisplayName("integration- login and assign Referee")
    public void LoginAndAssignReferee() {
        String name=appController.login("Moshe","M123");
        boolean flag= appController.RefereeRegistration(name,"Adam","2022");
        assertEquals(true, flag);
    }
    @Test
    @DisplayName("integration- login and assign Referee invalid")
    public void LoginAndAssignRefereeInvalidRegister() {
        String name=appController.login("Liron","M123");
        boolean flag= appController.RefereeRegistration(name,"Adam","2022");
        assertEquals(false, flag);
    }


    @Test
    @DisplayName("integration- login and assign Referee invalid")
    public void LoginAndAssignRefereeInvalidMember() {
        String name=appController.login("Moshe","M123");
        boolean flag= appController.RefereeRegistration(name,"David","2022");
        assertEquals(false, flag);
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
