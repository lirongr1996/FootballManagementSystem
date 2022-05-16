package Domain;

public class AppController {
    System system=new System();

    public boolean Placement(String username, String league,String season){
        return system.GamesPlacement(username,league,season);
    }


    public String login(String username,String password){
        return system.login(username,password);
    }


    public boolean RefereeRegistration(String username, String name,String training){
        return system.RefereeRegistration(username,name,training);
    }
}
