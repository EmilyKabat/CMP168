public class Teen extends Person implements Mover {
  @Override
  public String move() {
    return "run fast and jump";
  }

  @Override
  public  String move(int times) {
    String s = "";
    if (times > 0) {
      for (int i = 0; i < times; i++) {
        s += "run fast and jump\n";
      }
    }
    return s;
  }

  @Override
  public double metabolizeAcculumatedCalories(){
    double weightGain = 0.0;
    int calories = getCaloriesAccumulator();
    while (calories - 1200 >= 0) {
      weightGain++;
    }
    return weightGain;
  }

  @Override
  public void eat(Food food) {
    this.setCaloriesConsumed(food.getCalories() + this.getCaloriesConsumed());
    this.setCaloriesAccumulator(food.getCalories() + this.getCaloriesAccumulator());
  }

  @Override
  public void eat(Food[] food) {
    int calories = 0;
    for (Food a : food) {
      calories += a.getCalories();
    }
    this.setCaloriesConsumed(this.getCaloriesConsumed() + calories);
    this.setCaloriesAccumulator(this.getCaloriesAccumulator() + calories);
  }
}
