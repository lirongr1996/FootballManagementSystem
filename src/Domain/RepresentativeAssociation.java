package Domain;

public class RepresentativeAssociation extends Member {
    private String name;

    public RepresentativeAssociation(String userName, String password, String name) {
        super(userName, password);
        this.name = name;
    }

//    public void setSystem(SystemApp systemApp) {
//        this.systemApp = systemApp;
//    }


//    public void GamesPlacement(String league,int season) {
//        system.GamesPlacement(league,season);
//    }
}