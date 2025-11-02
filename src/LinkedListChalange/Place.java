package LinkedListChalange;

public class Place {
    private String name;
    private int distanceFromStart;

    public Place(String name, int distanceFromStart) {
        this.name = name;
        this.distanceFromStart = distanceFromStart;
    }

    public String name() {return this.name;}
    public int distanceFromStart() {return this.distanceFromStart;}
}
