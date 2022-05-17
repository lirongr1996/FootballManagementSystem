package Domain;

public class AppController {
    SystemApp systemApp =new SystemApp();

    public boolean Placement(String username, String league,String season){
        return systemApp.GamesPlacement(username,league,season);
    }


    public String login(String username,String password){
        return systemApp.login(username,password);
    }


    public boolean RefereeRegistration(String username, String name,String training){
        return systemApp.RefereeRegistration(username,name,training);
    }
}
