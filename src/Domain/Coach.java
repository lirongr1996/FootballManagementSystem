package Domain;

public class Coach extends Member{
    private String name;
    private String training;

    public Coach(String userName, String password, String name, String training) {
        super(userName, password);
        this.name=name;
        this.training=training;
    }
}
