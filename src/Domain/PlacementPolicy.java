package Domain;

public class PlacementPolicy {
    private Season season;
    private League league;
    private int description;

    public PlacementPolicy(int description) {
        this.description = description;
    }

    public void Set(Season season, League league) {
        this.season = season;
        this.league=league;
    }

    public int getDescription() {
        return description;
    }
}
