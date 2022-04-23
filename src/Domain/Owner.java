package Domain;

public class Owner extends Member{
    private String name;
    private Team team;

    public Owner(String userName, String password, String name) {
        super(userName, password);
        this.name=name;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
