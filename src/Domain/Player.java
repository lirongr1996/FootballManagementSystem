package Domain;

import java.util.Date;

public class Player extends Member {
    private String name;
    private String role;
    private Date birthdate;

    public Player(String userName, String password, String name, String role, Date birthdate) {
        super(userName, password);
        this.name=name;
        this.birthdate=birthdate;
        this.role=role;
    }
}
