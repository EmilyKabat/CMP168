public class Food {
  private String name = "";
  private int calories = 0;

  public Food(String name, int calories) {
    this.name = name;
    this.calories = calories;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getName() {
      return this.name;
  }

  public void setCalories(int calories) {
    this.calories = calories;
  }

  public int getCalories() {
    return this.calories;
  }

  @Override
  public String toString() {
    String s = String.format("Food - name: %10s | calories: %4d", name, calories);
    return s;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Food) {
      Food a = (Food)o;
      if (a.name == this.name && a.calories == this.calories) {
        return true;
      }
    }
    return false;
  }
}
