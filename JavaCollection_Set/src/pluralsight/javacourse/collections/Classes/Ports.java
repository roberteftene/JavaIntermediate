package pluralsight.javacourse.collections.Classes;

public class Ports implements Comparable<Ports>{

    public String name;
    public int noShips;
    public boolean isFree;

    private static final int MAXIMUM_NUMBER_SHIPS = 30;

    public Ports(String name, int noShips, boolean isFree) {
        this.name = name;
        this.noShips = noShips;
        this.isFree = isFree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoShips() {
        return noShips;
    }

    public void setNoShips(int noShips) {
        this.noShips = noShips;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    @Override
    public String toString() {
        return "Ports{" +
                "name='" + name + '\'' +
                ", noShips=" + noShips +
                ", isFree=" + isFree +
                '}';
    }

    @Override
    public int compareTo(Ports o) {
        return this.noShips - o.getNoShips();
    }
}
