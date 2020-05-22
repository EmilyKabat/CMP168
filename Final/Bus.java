//package Final;

public class Bus extends Car {
    public Bus(int[] numSeatsPerRow) {
        super(2, 2 * numSeatsPerRow.length - 1, numSeatsPerRow);
    }
    public Bus(Person driver, int[] numSeatsPerRow) {
        super(2, 2 * numSeatsPerRow.length - 1, driver, numSeatsPerRow);
    }
    public boolean canOpenDoor(Person p) {
        return true;
    }
    public boolean canOpenWindow(Person p) {
        return true;
    }
    public String toString() {
        return "Bus is an extension of " + super.toString();
    }
}
