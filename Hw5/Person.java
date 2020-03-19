public abstract class Person extends Passenger {
  private int numOffspring;

  public Person() {
    this.numOffspring = 0;
  }

  public Person(int numOffspring) {
    this.numOffspring = numOffspring;
  }

  public Person(String name, int birthYear, double weight, double height, char gender, int numCarryOn, int numOffspring) {
    super(name, birthYear, weight, height, gender, numCarryOn);
    if (numOffspring < 0) {
      this.numOffspring = 0;
    }
    else {
      this.numOffspring = numOffspring;
    }
  }

  public void setNumOffspring(int num) {
    if (num >= 0) {
      this.numOffspring = num;
    }
    else {
      this.numOffspring = 0;
    }
  }

  public int getNumOffspring() {
    return this.numOffspring;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Person) {
      Person a = (Person)o;
      if (super.equals(o) && a.numOffspring == this.numOffspring) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return super.toString() + String.format(" Person: Number of Offspring: %4d\n", numOffspring);
  }

  public void printDetails() {
    System.out.println(super.toString() + String.format(" Person: Number of Offspring: %4d\n", numOffspring));
  }
}
