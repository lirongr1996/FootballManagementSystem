package DataAccess;
import Domain.Game;
import Domain.Member;
import Domain.Team;

import java.sql.SQLException;
import java.util.*;
public interface Dao{


    ArrayList<Game> getGames();

    ArrayList<Member> getMembers();

    ArrayList<Team> getTeams();

    void update(Member user);
    }

