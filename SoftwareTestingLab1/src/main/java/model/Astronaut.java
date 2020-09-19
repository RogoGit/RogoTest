package model;

public class Astronaut {

    private String name;
    private Location location;


    public Astronaut(String name, Location currentLocation) {
        this.name = name;
        this.location = currentLocation;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
