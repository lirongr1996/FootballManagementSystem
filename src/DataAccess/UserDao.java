package DataAccess;
import Domain.Coach;
import Domain.Member;
import Domain.Team;

import java.util.*;

public class UserDao implements Dao<Member> {

    private List<Member> members = new ArrayList<>();
    private List<Team>teams=new ArrayList<>();

    private static final UserDao instance = new UserDao();

    //private constructor to avoid client applications to use constructor
     public static UserDao getInstance(){
        return instance;
    }

    private UserDao() {
       // users.add(new User("John", "john@domain.com"));
        //users.add(new User("Susan", "susan@domain.com"));
    }

    @Override
    public Optional<Member> get(long id) {
        return Optional.ofNullable(members.get((int) id));
    }

    @Override
    public List<Member> getAll() {
        return members;
    }

    @Override

    public void save(Member user) {
        members.add(user);
               System.out.println(members.toString());
    }

    @Override
    public void update(Member user, String[] params) {
        //user.setName(Objects.requireNonNull(                 params[0], "Name cannot be null"));
        //user.setEmail(Objects.requireNonNull(                params[1], "Email cannot be null"));

        members.add(user);
        members.toString();
    }

    @Override
    public void delete(Member user) {
        members.remove(user);
    }
}
