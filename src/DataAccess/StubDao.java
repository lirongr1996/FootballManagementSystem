package DataAccess;

import Domain.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class StubDao implements Dao{
    private static StubDao instance = null;

    public static StubDao getInstance(){
        if (instance==null)
            instance=new StubDao();
        return instance;
    }

    @Override
    public ArrayList<Game> getGames() {
        League l=new League("Israel");
        Season s=new Season("2022",l,new PlacementPolicy(2));
        ArrayList arr=new ArrayList();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        arr.add(new Game(l,s, LocalDateTime.from(LocalDateTime.now()).plusDays(0).format(myFormatObj)));
        arr.add(new Game(l,s,LocalDateTime.from(LocalDateTime.now()).plusDays(1).format(myFormatObj)));

        return arr;
    }

    @Override
    public ArrayList<Member> getMembers() {
        ArrayList arr=new ArrayList();
        arr.add(new SystemOwner("Moshe","M123"));
        arr.add(new RepresentativeAssociation("Emma","e123","emma"));
        return arr;
    }

    @Override
    public ArrayList<Team> getTeams() {
        ArrayList arr=new ArrayList();
        League l=new League("Israel");
        arr.add(new Team(new PrivatePage(),new Owner("lirongr1996","liron123","liron"),new Field("Tel Aviv","Bloomfield"),l));
        arr.add(new Team(new PrivatePage(),new Owner("shirinda","shir123","shir"),new Field("Jerusalem","Tedi"),l));

        return arr;
    }

    @Override
    public void update(Member user) {

    }
}
