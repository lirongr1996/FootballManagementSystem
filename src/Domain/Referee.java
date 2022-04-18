package Domain;

public class Referee extends Member{
    private String name;
    private String training;

    public Referee(String userName, String password, String name, String training) {
        super(userName, password);
        this.name=name;
        this.training=training;
    }
}
