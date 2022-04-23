package Domain;

import java.util.ArrayList;
import java.util.Date;

public class Game {
    private Team hostTeam;
    private Team guestTeam;
    private Season season;
    private League league;
    private Field field;
    private EventsSchedule eventsSchedule;
    private String date;
    private int [] results;
    private ArrayList<Referee> referees;

    public Game(League league, Season season, String date) {
        this.league=league;
        this.season = season;
        this.date = date;
        this.eventsSchedule=new EventsSchedule();
        this.results=new int[2];
    }

    public void setDetails(Team hostTeam, Team guestTeam) {
        this.hostTeam = hostTeam;
        this.guestTeam=guestTeam;
        this.field=hostTeam.getField();
    }

    public Season getSeason() {
        return season;
    }

    public League getLeague() {
        return league;
    }
}
