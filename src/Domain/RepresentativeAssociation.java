package Domain;

public class RepresentativeAssociation extends Member {
    private String name;
    private System system;

    public RepresentativeAssociation(String userName, String password, String name) {
        super(userName, password);
        this.name = name;
    }

    public void setSystem(System system) {
        this.system = system;
    }


//    public void GamesPlacement(String league,int season) {
//        system.GamesPlacement(league,season);
//    }
}