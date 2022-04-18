package Domain;

public class TeamManager extends Member{
    private String name;

    public TeamManager(String userName, String password, String name) {
        super(userName, password);
        this.name=name;
    }
}
