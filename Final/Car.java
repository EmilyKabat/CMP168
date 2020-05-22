//package Final;

public class Car extends Vehicle implements Announcements {
    private int numDoors;
    private int numWindows;

    public Car(int numDoors, int numWindows) {
        super(2, 2);
        this.numDoors = numDoors;
        this.numWindows = numWindows;
    }
    public Car(int numDoors, int numWindows, int numSeatsPerRow) {
        super(2, numSeatsPerRow);
        this.numDoors = numDoors;
        this.numWindows = numWindows;
    }
    public Car(int numDoors, int numWindows, int[] numSeatsPerRow) {
        super(numSeatsPerRow);
        this.numWindows = numWindows;
        this.numDoors = numDoors;
    }
    public Car(int numDoors, int numWindows, Person driver, int[] numSeatsPerRow) {
        super(driver, numSeatsPerRow);
        this.numDoors = numDoors;
        this.numWindows = numWindows;
    }
    public boolean canOpenDoor(Person p) {
        if ((getLocationOfPersonInVehicle(p)[1] == 0 || getLocationOfPersonInVehicle(p)[1] == getNumberOfPeopleInRow(getLocationOfPersonInVehicle(p)[0])) && p.getAge() > 5) {
            return true;
        }
        return false;
    }
    public boolean canOpenWindow(Person p) {
        if ((getLocationOfPersonInVehicle(p)[1] == 0 || getLocationOfPersonInVehicle(p)[1] == getNumberOfPeopleInRow(getLocationOfPersonInVehicle(p)[0])) && p.getAge() > 2) {
            return true;
        }
        return false;
//        consult note 6 late bc that instruction was confusing and you don't feel like dealing w it rn
    }
    public int getNumDoors() {
        return this.numDoors;
    }
    public int getNumWindows() {
        return this.numWindows;
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Car) {
            Car a = (Car)o;
            if (a.numDoors == this.numDoors && a.numWindows == this.numWindows) {
                return true;
            }
        }
        return false;
//        add all the other extra parameters for true
    }
    @Override
    public String toString() {
        int[] seatsPerRow = new int[0];
        return String.format("Car: number of doors= %02d | number of windows = %02d | number of rows= %02d | seats per row= %s | names of people on board= %s\n", numDoors, numWindows);
//      finish all the other string stuff
    }
//    public int compareTo(Doctor doctor) {
//        if (doctor.numPatients > this.numPatients) {
//            return 1;
//        }
//        if (doctor.numPatients < this.numPatients) {
//            return -1;
//        }
//        return 0;
//    }

    @Override
    public boolean loadPassenger(Person p) {
        boolean allowedInFrontSeat = true;
        if (p.getAge() < 5 || p.getHeight() < 36) {
            allowedInFrontSeat = false;
        }
        return true;
    }
    @Override
    public  int loadPassengers(Person[] peeps) {
        return -1;
    }
    @Override
    public String departure() {
        return "";
    }
    @Override
    public String arrival() {
        return "";
    }
    @Override
    public String doNotDisturbTheDriver() {
        return "";
    }
}
