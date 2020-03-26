public class Employee extends Person{
  private String deptName;
  private static int numEmployees;
  private int employeeID = 0;

  public Employee() {
    this.deptName = "";
    this.numEmployees = 0;
    this.employeeID++;
  }

  public Employee(String deptName) {
    this.deptName = deptName;
    this.numEmployees = 0;
    this.employeeID++;
  }

  public Employee(String name, int birthYear, String deptName) {
    super(name, birthYear);
    this.deptName = deptName;
    this.employeeID++;
  }

  public String getDeptName() {
    return this.deptName;
  }

  public void getDeptName(String deptName) {
    this.deptName = deptName;
  }

  static int getNumEmployees() {
    return numEmployees;
  }

  public int getEmployeeID() {
    return numEmployees + 1;
  }

  public void setEmployeeID(int employeeID) {
    this.employeeID = employeeID;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Employee) {
      Employee a = (Employee)o;
      if (super.equals(a) && a.deptName == this.deptName && a.numEmployees == this.numEmployees && a.employeeID == this.employeeID) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format(super.toString() + " Employee: Department: %20s | Employee Number: %3d", deptName, employeeID);
  }

  // figure out compareTo() here
}
