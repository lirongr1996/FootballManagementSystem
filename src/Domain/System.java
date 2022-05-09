package Domain;

import DataAccess.Dao;
import DataAccess.UserDao;
import Service.UserService;

import java.util.ArrayList;
import java.util.List;

public class System {
    UserDao ud;
    public System() {
        ud = UserDao.getInstance();
        ArrayList<Member> members=ud.getMembers();
        for (Member m:members){
            if(m instanceof RepresentativeAssociation)
                ((RepresentativeAssociation)m).setSystem(this);
        }
    }
    public boolean CheckRepresentative(String username){
        ArrayList<Member> members=ud.getMembers();
        for (Member m:members){
            if(m.getUserName().equals(username) && m instanceof RepresentativeAssociation) {
                return true;
            }
        }
        return false;
    }
    public String login(String username,String password){// הפונקציה מחזירה ל-UserService את השם משתמש כמחרוזת ,וכך מסמל את ההתחברות
        ArrayList<Member> members=ud.getMembers();
        for (Member m:members){
            if(m.getUserName().equals(username) && m.getPassword().equals(password)) {
                return username;
            }
        }
        return null;
    }

    public void RefereeRegistration(String username, String name,String training){
        if (!CheckRepresentative(username))//בודק אם המשתמש הוא נציג התאחדות
            return;
        Member mem = null;
        ArrayList<Member> members=ud.getMembers();
        for (Member m:members){
            if(m.getUserName().equals(name))
                mem=m;
        }
        if (mem==null){
            return;
        }
        Referee ref = new Referee(mem, name, training);
        ud.update(ref,null);
    }




    public boolean GamesPlacement(String username, String league,String season) {
        ArrayList<Team> teams=ud.getTeams();
        ArrayList<Game> games=ud.getGames();
        ArrayList <Game> inSeason=new ArrayList<>();
        if (!CheckRepresentative(username))
            return false;
        if(teams.isEmpty())
            return false;
        for (Game g:games){
            if(g.getSeason().getYear().equals(season) && g.getLeague().getName().equals(league)){
                inSeason.add(g);
            }
        }
        if (inSeason.isEmpty())
            return false;
        int policy=inSeason.get(0).getLeague().getPolicy(inSeason.get(0).getSeason()).getDescription();
        int i=0;
        for (Team t1: teams)
        {
            if (!t1.getLeague().equals(league))
                continue;
            for(Team t2:teams){
                if (! t2.getLeague().equals(league))
                    continue;
                if (t1!=t2){
                    if (policy==2) {
                        inSeason.get(i).setDetails(t1, t2);
                        inSeason.get(i + 1).setDetails(t2, t1);
                        i += 2;
                    }
                    if (policy==1) {
                        inSeason.get(i).setDetails(t1, t2);
                        i ++;
                    }
                }
            }
        }
        return  true;
    }
}
