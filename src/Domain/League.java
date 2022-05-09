package Domain;

import java.util.HashMap;

public class League {
    private String name;
    private HashMap<Season,PlacementPolicy> seasonPlacementPolicy;

    public League(String name) {
        this.name=name;
        seasonPlacementPolicy=new HashMap<>();
    }

    public void setSeasonPlacementPolicyHashMap(Season s,PlacementPolicy p) {
        this.seasonPlacementPolicy.put(s,p);
    }

    public PlacementPolicy getPolicy(Season s){
        return seasonPlacementPolicy.get(s);
    }

    public String getName() {
        return name;
    }
}
