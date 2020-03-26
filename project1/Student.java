public class Student extends Person {
  private static int numStudents;
  private int studentID = numStudents;
  private Course[] coursesTaken = new Course[1000];
  private int numCoursesTaken;
  private boolean isGraduate;
  private String major;

  public Student() {
    this.numStudents = 0;
    this.studentID++;
    this.coursesTaken = new Course[1000];
    this.numCoursesTaken = 0;
    this.isGraduate = false;
    this.major = "undeclared";
  }

  public Student(boolean isGraduate) {
    this.numStudents = 0;
    this.studentID++;
    this.coursesTaken = new Course[1000];
    this.numCoursesTaken = 0;
    this.isGraduate = isGraduate;
    this.major = "undeclared";
  }

  public Student(String major, boolean isGraduate) {
    this.numStudents = 0;
    this.studentID++;
    this.coursesTaken = new Course[1000];
    this.numCoursesTaken = 0;
    this.isGraduate = isGraduate;
    this.major = major;
  }

  public Student(String name, int birthYear, String major, boolean isGraduate) {
    super(name, birthYear);
    this.numStudents = 0;
    this.studentID++;
    this.coursesTaken = new Course[1000];
    this.numCoursesTaken = 0;
    this.isGraduate = isGraduate;
    this.major = major;
  }

  public static int getNumStudents() {
    return numStudents;
  }

  public int getStudentID() {
    return this.studentID;
  }

  public void setStudentID(int studentID) {
    this.studentID = studentID;
  }

  public Course[] getCoursesTaken() {
    return this.coursesTaken;
  }

  public void setCoursesTaken(Course[] coursesTaken) {
    this.coursesTaken = coursesTaken;
  }

  public int getNumCoursesTaken() {
    return this.numCoursesTaken;
  }

  public void setNumCoursesTaken(int numCoursesTaken) {
    this.numCoursesTaken = numCoursesTaken;
  }

  public boolean getIsGraduate() {
    return this.isGraduate;
  }

  public void setIsGraduate(boolean isGraduate) {
    this.isGraduate = isGraduate;
  }

  public String getMajor() {
    return this.major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public boolean isGraduate() {
    return this.isGraduate;
  }

  public void addCourseTaken(Course course) {
    if (numCoursesTaken > 0 && numCoursesTaken < coursesTaken.length) {
      coursesTaken[numCoursesTaken] = course;
      numCoursesTaken++;
    }
  }

  public void addCoursesTaken(Course[] course) {
    for (int i = 0; i < numCoursesTaken; i++) {
      this.coursesTaken[numCoursesTaken + i] = course[i];
    }
    numCoursesTaken += course.length;
  }

  public Course getCourseTaken(int i) {
    if (i > 0 && i < numCoursesTaken) {
      return coursesTaken[i];
    }
    else {
      return null;
    }
  }

  public String getCourseTakenAsString(int i) {
    if (i > 0 && i < numCoursesTaken) {
      return "deptName-" + i;
    }
    else {
      return "";
    }
  }

  public String getAllCoursesTakenAsString() {
    String s = "";
    return s;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Student) {
      Student a = (Student)o;
      if (super.equals(a) && a.numStudents == this.numStudents && a.studentID == this.studentID && a.coursesTaken == this.coursesTaken && a.numCoursesTaken == this.numCoursesTaken && a.isGraduate == this.isGraduate && a.major == this.major) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    if (isGraduate) {
      return String.format(super.toString() + " Student: studentID: %04d | Major %20s |       Graduate | Number of Courses Taken: %3d | Courses Taken: %s", studentID, major, numCoursesTaken, getAllCoursesTakenAsString());
    }
    else {
      return String.format(super.toString() + " Student: studentID: %04d | Major %20s |  Undergraduate | Number of Courses Taken: %3d | Courses Taken: %s", studentID, major, numCoursesTaken, getAllCoursesTakenAsString());
    }
  }

  public int compareTo(Student c) {
    if (c.numCoursesTaken > this.numCoursesTaken) {
      return 1;
    }
    if (c.numCoursesTaken < this.numCoursesTaken) {
      return -1;
    }
    return 0;
  }
}
