public class Faculty extends Employee {
  private Course[] coursesTaught = new Course[1000];
  private int numCoursesTaught;
  private boolean isTenured;

  public Faculty() {
    this.coursesTaught = new Course[1000];
    this.numCoursesTaught = 0;
    this.isTenured = false;
  }

  public Faculty(boolean isTenured) {
    this.coursesTaught = new Course[1000];
    this.numCoursesTaught = 0;
    this.isTenured = isTenured;
  }

  public Faculty(String deptName, boolean isTenured) {
    super(deptName);
    this.coursesTaught = new Course[1000];
    this.numCoursesTaught = 0;
    this.isTenured = isTenured;
  }

  public Faculty(String name, int birthYear, String deptName, boolean isTenured) {
    super(name, birthYear, deptName);
    this.coursesTaught = new Course[1000];
    this.numCoursesTaught = 0;
    this.isTenured = isTenured;
  }

  public boolean getIsTenured() {
    return this.isTenured;
  }

  public void setIsTenured(boolean isTenured) {
    this.isTenured = isTenured;
  }

  public int getNumCoursesTaught() {
    return this.numCoursesTaught;
  }

  public void setNumCoursesTaught(int numCoursesTaught) {
    this.numCoursesTaught = numCoursesTaught;
  }

  public boolean isTenured() {
    return isTenured;
  }

  public void addCourseTaught(Course course) {
    if (numCoursesTaught < coursesTaught.length) {
      this.coursesTaught[numCoursesTaught] = course;
      numCoursesTaught++;
    }
  }

  public void addCoursesTaught(Course[] course) {
    for (int i = 0; i < course.length; i++) {
      this.coursesTaught[numCoursesTaught + i] = course[i];
    }
    numCoursesTaught += course.length;
  }

  public Course getCourseTaught(int i) {
    if (i > 0 && i < numCoursesTaught) {
      return coursesTaught[i];
    }
    else {
      return null;
    }
  }

  public String getCourseTaughtAsString(int i) {
    if (i > 0 && i < numCoursesTaught) {
      return "courseDept-courseNum";
    }
    else {
      return "";
    }
  }

// you've got some work to do on this one...
public String getAllCoursesTaughtAsString() {
      String s = "";
      if (numCoursesTaught > 0) {
          for (int i = 0; i < numCoursesTaught; i++) {
              s += coursesTaught[i].toString();
          }
      }
      return s;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Faculty) {
      Faculty a = (Faculty)o;
      if (super.equals(a) && a.numCoursesTaught == this.numCoursesTaught && a.isTenured == this.isTenured && a.coursesTaught == this.coursesTaught) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    if (isTenured) {
      return String.format(super.toString() + " Faculty:  Is Tenured | Number of Courses Taught: %3d | Courses Taught: %s", numCoursesTaught, getAllCoursesTaughtAsString());
    }
    else {
      return String.format(super.toString() + " Faculty: Not Tenured | Number of Courses Taught: %3d | Courses Taught: %s", numCoursesTaught, getAllCoursesTaughtAsString());
    }
  }

  public int compareTo(Faculty c) {
    if (c.numCoursesTaught > this.numCoursesTaught) {
      return -1;
    }
    if (c.numCoursesTaught < this.numCoursesTaught) {
      return +1;
    }
    return 0;
  }
}
