package Domain;

public class Fan extends Member{
    private String name;

    public Fan(String userName, String password,  String name) {
        super(userName, password);
        this.name=name;
    }
}
