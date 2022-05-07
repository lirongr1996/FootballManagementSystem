package DataAccess;
import Domain.*;

import java.lang.System;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class UserDao implements Dao<Member> {
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Team>teams=new ArrayList<>();
    private ArrayList<League> leagues=new ArrayList<>();
    private ArrayList<Game>games=new ArrayList<>();
    private ArrayList<Season> seasons=new ArrayList<>();

    private static UserDao instance = null;// UserDao();

    //private constructor to avoid client applications to use constructor
     public static UserDao getInstance(){
         if (instance==null)
             instance=new UserDao();
        return instance;
    }

    private UserDao() {
         members.add(new SystemOwner("Moshe","M123"));
        PlacementPolicy placementPolicy=new PlacementPolicy(2);
         this.leagues.add(new League("Israel"));
         this.seasons.add(new Season("2022",leagues.get(0),placementPolicy));
        members.add(new Owner("lirongr1996","liron123","liron"));
        members.add(new Owner("shirinda","shir123","shir"));
        members.add(new Owner("annakol","anna123","anna"));
        members.add(new Owner("nirCohen","nir123","nir"));
         teams.add(new Team(new PrivatePage(),(Owner)members.get(1),new Field("Tel Aviv","Bloomfield"),leagues.get(0)));
         teams.add(new Team(new PrivatePage(),(Owner)members.get(2),new Field("Jerusalem","Tedi"),leagues.get(0)));
         teams.add(new Team(new PrivatePage(),(Owner)members.get(3),new Field("Beer Sheva","Terner"),leagues.get(0)));
         teams.add(new Team(new PrivatePage(),(Owner)members.get(4),new Field("Haifa","Sami Ofer"),leagues.get(0)));


        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        games.add(new Game(leagues.get(0),seasons.get(0),LocalDateTime.from(LocalDateTime.now()).plusDays(0).format(myFormatObj)));
        games.add(new Game(leagues.get(0),seasons.get(0),LocalDateTime.from(LocalDateTime.now()).plusDays(1).format(myFormatObj)));
        games.add(new Game(leagues.get(0),seasons.get(0),LocalDateTime.from(LocalDateTime.now()).plusDays(2).format(myFormatObj)));
        games.add(new Game(leagues.get(0),seasons.get(0),LocalDateTime.from(LocalDateTime.now()).plusDays(3).format(myFormatObj)));
        games.add(new Game(leagues.get(0),seasons.get(0),LocalDateTime.from(LocalDateTime.now()).plusDays(4).format(myFormatObj)));
        games.add(new Game(leagues.get(0),seasons.get(0),LocalDateTime.from(LocalDateTime.now()).plusDays(5).format(myFormatObj)));
        games.add(new Game(leagues.get(0),seasons.get(0),LocalDateTime.from(LocalDateTime.now()).plusDays(6).format(myFormatObj)));
        games.add(new Game(leagues.get(0),seasons.get(0),LocalDateTime.from(LocalDateTime.now()).plusDays(7).format(myFormatObj)));


        members.add(new RepresentativeAssociation("Moshe","M123","Moshe"));
    }

//    @Override
//    public Optional<Member> get(long id) {
//        return Optional.ofNullable(members.get((int) id));
//    }

    //@Override
    public ArrayList<Game> getGames() {
        return games;
    }

    public ArrayList<League> getLeagues() {
        return leagues;
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    //    @Override
    public void save(Member user) {
        members.add(user);
               System.out.println(members.toString());
    }

//    @Override
    public void update(Member user, String[] params) {
        //user.setName(Objects.requireNonNull(                 params[0], "Name cannot be null"));
        //user.setEmail(Objects.requireNonNull(                params[1], "Email cannot be null"));

        members.add(user);
        members.toString();
    }

//    @Override
    public void delete(Member user) {
        members.remove(user);
    }
}
