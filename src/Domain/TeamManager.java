package Domain;

public class TeamManager extends Member{
    private String name;
    private Team team;

    public TeamManager(String userName, String password, String name,Team team) {
        super(userName, password);
        this.name=name;
        this.team=team;
    }
}
