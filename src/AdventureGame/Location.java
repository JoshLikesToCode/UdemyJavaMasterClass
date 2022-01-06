package AdventureGame;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if(exits != null)
            this.exits = new HashMap<String, Integer>(exits);
        else
            this.exits = new HashMap<String, Integer>(); // empty exits b/c of null
        exits.put("Q", 0); // every location has an exit, easier to just add exit in ctor
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        /* defensive programing, return copy not actual map */
        return new HashMap<String, Integer>(exits);
    }


}
