public class Elder extends Person implements Mover {
  @Override
  public String move() {
    return "ouch my back wait for me";
  }

  @Override
  public  String move(int times) {
    String s = "";
    if (times > 0) {
      for (int i = 0; i < times; i++) {
        s += "ouch my back wait for me\n";
      }
    }
    return s;
  }
}
