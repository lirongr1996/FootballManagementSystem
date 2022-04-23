package Domain;

public class AppController {
    System system=new System();

    public void Placement(String username, String league,String season){
        system.GamesPlacement(username,league,season);
    }


    public String login(String username,String password){
        return system.login(username,password);
    }


    public void RefereeRegistration(String username, String name,String training){
        system.RefereeRegistration(username,name,training);
    }
}
