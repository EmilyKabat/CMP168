public class Infant extends Person{
  static class Toys{
    private String infantToyName;
    private int infantToyRating;
  }

  private Infant.Toys toys = new Infant.Toys();
  private int numInfantToys;
  private String infantToyName;
  private int infantToyRating;
  private Infant.Toys[] infantToys = new Infant.Toys[10];

  public Infant() {
    this.toys = new Infant.Toys();
    this.numInfantToys = 0;
    this.infantToyName = "";
    this.infantToyRating = 0;
  }

  public Infant(String name, int birthYear, double weight, double height, char gender, int numCarryOn) {
    super(name, birthYear, weight, height, gender, numCarryOn, 0);
    this.toys = new Infant.Toys();
    this.numInfantToys = 0;
    this.infantToyName = toys.infantToyName;
    this.infantToyRating = toys.infantToyRating;
  }

  public void addInfantToy(String name, int rating) {
    Infant.Toys thisToy = new Infant.Toys();
    thisToy.infantToyName = name;
    thisToy.infantToyRating = rating;
    if (numInfantToys < 10) {
      infantToys[numInfantToys] = thisToy;
      numInfantToys++;
    }
    else {
      System.out.println("toys has reached capacity of 10");
    }
  }

  public int getNumInfantToys() {
    return numInfantToys;
  }

  public void setNumInfantToys(int numInfantToys) {
    this.numInfantToys = numInfantToys;
  }

  public String getInfantToyName(int i) {
    if (i >= 0 && i < numInfantToys) {
      return infantToys[i].infantToyName;
    }
    return "invalid index " + i;
  }

  public int getInfantToyRating(int i) {
    if (i >= 0 && i < numInfantToys) {
      return infantToys[i].infantToyRating;
    }
    return -1;
  }

  @Override
    public String toString() {
        String s = super.toString() + String.format("Infant: Number of Toys: %4d | Infant Toys:\n", numInfantToys);
        for (int i = 0; i < numInfantToys; i++) {
            s += infantToys[i].infantToyName + ", " + infantToys[i].infantToyRating + "; ";
        }
        return s;
    }

    public String getInfantToyAsString(int i) {
        if (i >= 0 && i < numInfantToys) {
             return super.toString() + String.format("Infant: Number of Toys: %4d | \n", numInfantToys) + String.format("InfantToy: Toy Name: %20s | Rating %4d\n", infantToys[i].infantToyName, infantToys[i].infantToyRating);
        }
        else {
            return "invalid index " + i;
       }
    }

  public int getHighestInfantToyRating() {
    int maxRating = -1000000;
    for (int i = 0; i < numInfantToys; i++) {
      if (infantToys[i].infantToyRating > maxRating) {
        maxRating = infantToys[i].infantToyRating;
      }
    }
    return maxRating;
  }
}
