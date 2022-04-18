package Domain;

public class Owner extends Member{
    private String name;

    public Owner(String userName, String password, String name) {
        super(userName, password);
        this.name=name;
    }
}
