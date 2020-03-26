public class Person {
  private String name;
  private int birthYear;

  public Person() {
    this.name = "";
    this.birthYear = 0;
  }

  public Person(String name, int birthYear){
    this.name = name;
    this.birthYear = birthYear;
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

  @Override
  public boolean equals(Object o) {
    if (o instanceof Person) {
      Person a = (Person)o;
      if (a.name == this.name && a.birthYear == this.birthYear) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format("Person: Name: %30s | Birth Year: %4d", name, birthYear);
  }

  public int compareTo(Person c) {
    if (c.birthYear > this.birthYear) {
      return -1;
    }
    if (c.birthYear < this.birthYear) {
      return 1;
    }
    return 0;
  }
}
