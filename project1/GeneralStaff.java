public class GeneralStaff extends Employee {
  private String duty;

  public GeneralStaff() {
    this.duty = "";
  }

  public GeneralStaff(String duty) {
    this.duty = duty;
  }

  public GeneralStaff(String deptName, String duty) {
    super(deptName);
    this.duty = duty;
  }

  public GeneralStaff(String name, int birthYear, String deptName, String duty) {
    super(name, birthYear, deptName);
    this.duty = duty;
  }

  public String getDuty() {
    return this.duty;
  }

  public void setDuty(String duty) {
    this.duty = duty;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof GeneralStaff) {
      GeneralStaff a = (GeneralStaff)o;
      if (super.equals(a) && a.duty == this.duty) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format(super.toString() + " GeneralStaff: Duty: %10s", duty);
  }
}
