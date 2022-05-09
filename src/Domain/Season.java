package Domain;

import java.util.HashMap;

public class Season {
    private String year;
    private HashMap<League,PlacementPolicy> leaguePlacementPolicy;

    public Season(String year, League l,PlacementPolicy p) {
        this.year = year;
        leaguePlacementPolicy=new HashMap<>();
        leaguePlacementPolicy.put(l,p);
        l.setSeasonPlacementPolicyHashMap(this,p);
        p.Set(this,l);
    }

    public String getYear() {
        return year;
    }
}
