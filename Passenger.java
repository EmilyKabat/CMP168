public class Passenger {
  private String name;
  private int birthYear;
  private double weight;
  private char gender;
  private int numCarryOn;
  private double height;

  public Passenger() {
    this.name = "";
    this.birthYear = 1900;
    this.weight = 0.0;
    this.height = 0.0;
    this.gender = 'u';
    this.numCarryOn = 0;
  }

  public Passenger(String name, int birthYear, double weight, double height, char gender, int numCarryOn) {
    this.name = name;
    this.birthYear = birthYear;
    if (weight < 0) {
      this.weight = -1.0;
    }
    else {
      this.weight = weight;
    }
    if (height < 0) {
      this.height = -1.0;
    }
    else {
      this.height = height;
    }
    if (gender != 'f' && gender != 'm' && gender != 'u') {
      this.gender = 'u';
    }
    else {
      this.gender = gender;
    }
    if (numCarryOn > 2) {
      this.numCarryOn = 2;
    }
    else if (numCarryOn < 0) {
      this.numCarryOn = 0;
    }

    else {
      this.numCarryOn = numCarryOn;
    }
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBirthYear() {
    return this.birthYear;
  }

  public void setBirthYear(int birthYear) {
    this.birthYear = birthYear;
  }

  public double getWeight() {
    return this.weight;
  }

  public void setWeight(double weight) {
    if (weight >= 0) {
      this.weight = weight;
    }
    else {
      this.weight = -1.0;
    }
  }

  public void setHeight(double height) {
    if (height < 0) {
      this.height = -1.0;
    }
    else {
      this.height = height;
    }
  }

  public double getHeight() {
    return this.height;
  }

  public int getNumCarryOn() {
    return this.numCarryOn;
  }

  public void setNumCarryOn(int numCarryOn) {
    this.numCarryOn = numCarryOn;
  }

  public char getGender() {
    return this.gender;
  }

  public void setGender(char gender) {
    if (gender == 'm' || gender == 'f') {
      this.gender = gender;
    }
    else {
      this.gender = 'u';
    }
  }

  public int calculateAge(int currentYear) {
    if (currentYear < birthYear) {
      return -1;
    }
    else {
      return currentYear - birthYear;
    }
  }

  public boolean isMale() {
    if (gender == 'm') {
      return true;
    }
    else {
      return false;
    }
  }

  public boolean isFemale() {
    if (gender == 'f') {
      return true;
    }
    else {
      return false;
    }
  }

  public void printDetails() {
    System.out.printf("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Height: %10.2f | Gender: %c | NumCarryOn: %2d\n", name, birthYear, weight, height, gender, numCarryOn);
  }

@Override
  public String toString() {
    String passengerObj = "Name:                " + name + " | Year of Birth: " + birthYear + " | Weight:     " + weight + " | Height:      " + Math.floor(height*100) / 100 + "0 | Gender: " + gender + " | NumCarryOn:  " + numCarryOn;
    return String.format("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Height: %10.2f | Gender: %c | NumCarryOn: %2d\n", name, birthYear, weight, height, gender, numCarryOn);
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Passenger) {
      Passenger a = (Passenger)o;
      if (a.name == this.name && a.birthYear == this.birthYear && a.weight == this.weight && a.height == this.height && a.gender == this.gender && a.numCarryOn == this.numCarryOn) {
        return true;
      }
    }
    return false;
  }

  public void gainWeight() {
    weight++;
  }

  public void gainWeight(double w) {
    if (weight + w >= 0) {
      weight += w;
    }
  }

  public void loseWeight() {
    if (weight >= 1) {
      weight--;
    }
  }

  public void loseWeight(double weight) {
	this.weight -= weight;
	if (this.weight < 0) {
	   this.weight = 0;
	}
  }

  public double calculateBMI() {
    return Math.abs((weight * 703.00) / Math.pow(height, 2));
  }
}
