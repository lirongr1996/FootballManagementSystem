package Domain;

import java.util.ArrayList;

public class Team {
    private PrivatePage page;
    private ArrayList<Player>players;
    private ArrayList<Owner> owners;
    private ArrayList<Field> fields;
    private League league;
    private ArrayList<Coach> coach;
    private ArrayList<TeamManager> teamManagers;
    private ArrayList<Game> games;

    public Team(PrivatePage page, Owner owner, Field field, League league) {
        this.page = page;
        this.owners=new ArrayList<>();
        this.owners.add(owner);
        owner.setTeam(this);
        this.fields=new ArrayList<>();
        this.fields.add(field);
        this.league = league;
    }

    public Field getField() {
        return this.fields.get(0);
    }

    public League getLeague() {
        return league;
    }
}
