public class Driver_SchoolDB {
  public static void main(String[] args) {
    Course course = new Course(true, 771, "MAT", 4);
    System.out.println("Course: " + course.isGraduateCourse() + ", " + course.getCourseNum() + ", " + course.getCourseDept() + ", " + course.getNumCredits());

    Faculty faculty = new Faculty();
    Faculty faculty1 = new Faculty(true);
    System.out.println("Faculty:");
    System.out.println("Faculty: " + faculty1.getIsTenured());
    Faculty faculty2 = new Faculty("MAT", false);
    System.out.println("Faculty: " + faculty2.getDeptName() + "," + faculty2.getIsTenured());
    Faculty faculty3 = new Faculty("Superman", 1938, "PHY", true);
    System.out.println("Faculty: " + faculty3.getName() + "," + faculty3.getBirthYear() + "," + faculty3.getDeptName() + "," + faculty3.getIsTenured());
    System.out.println();

    Student student1 = new Student();
    System.out.println("Student:");
    Student student2 = new Student(false);
    System.out.println("Student: " + student2.getIsGraduate());
    Student student3 = new Student("Math", false);
    System.out.println("Student: " + student3.getMajor() + "," + student3.getIsGraduate());
    Student student4 = new Student("Wonderwoman", 1941, "JST", true);
    System.out.println("Student: " + student4.getName() + "," + student4.getBirthYear() + "," + student4.getMajor() + "," + student4.getIsGraduate());
    System.out.println();

    System.out.println("GeneralStaff:");
    GeneralStaff generalStaff = new GeneralStaff();
    GeneralStaff generalStaff1 = new GeneralStaff("advise students");
    System.out.println("GeneralStaff: " + generalStaff1.getDuty());
    GeneralStaff generalStaff2 = new GeneralStaff("Sanitation", "clean");
    System.out.println("GeneralStaff: " + generalStaff2.getDeptName() + "," + generalStaff2.getDuty());
    GeneralStaff generalStaff3 = new GeneralStaff("Flash Gordon", 1934, "Security", "safety");
    System.out.println("GeneralStaff: " + generalStaff3.getName() + "," + generalStaff3.getBirthYear() + "," + generalStaff3.getDeptName() + "," + generalStaff3.getDuty());
    System.out.println();

    Course course1 = new Course(true, 777, "CMP", 4);
    System.out.println("Course: " + course1.isGraduateCourse() + "," + course1.getCourseNum() + "," + course1.getCourseDept() + "," + course1.getNumCredits());
    Course course2 = new Course(true, 711, "CMP", 4);
    System.out.println("Course: " + course2.isGraduateCourse() + "," + course2.getCourseNum() + "," + course2.getCourseDept() + "," + course2.getNumCredits());
    Course course3 = new Course(true, 723, "MAT", 4);
    System.out.println("Course: " + course3.isGraduateCourse() + "," + course3.getCourseNum() + "," + course3.getCourseDept() + "," + course3.getNumCredits());
    Course course4 = new Course(false, 168, "CMP", 4);
    System.out.println("Course: " + course4.isGraduateCourse() + "," + course4.getCourseNum() + "," + course4.getCourseDept() + "," + course4.getNumCredits());
    Course course5 = new Course(false, 338, "CMP", 4);
    System.out.println("Course: " + course5.isGraduateCourse() + "," + course5.getCourseNum() + "," + course5.getCourseDept() + "," + course5.getNumCredits());
    System.out.println();

    System.out.println("**************************************************************");
    System.out.println("SCHOOL DATABASE INFO:");
    System.out.println();
    System.out.println("************************************************");
    System.out.println("COURSES:");
    System.out.println(course.toString());
    System.out.println(course1.toString());
    System.out.println(course2.toString());
    System.out.println(course3.toString());
    System.out.println(course4.toString());
    System.out.println(course5.toString());
    System.out.println("************************************************");
    System.out.println("************************************************");
    System.out.println("PERSONS:");
    System.out.println("************************************************");
    System.out.println("************************************************");
    System.out.println("EMPLOYEES:");
    System.out.println("************************************************");
    System.out.println("************************************************");
    System.out.println("GENERAL STAFF:");
    System.out.println(generalStaff.toString());
    System.out.println(generalStaff1.toString());
    System.out.println(generalStaff2.toString());
    System.out.println(generalStaff3.toString());
    System.out.println("************************************************");
    System.out.println("************************************************");
    System.out.println("FACULTY:");
    System.out.println(faculty.toString());
    System.out.println(faculty1.toString());
    System.out.println(faculty2.toString());
    System.out.println(faculty3.toString());
    System.out.println("************************************************");
    System.out.println("************************************************");
    System.out.println("STUDENTS:");
    System.out.println(student1.toString());
    System.out.println(student2.toString());
    System.out.println(student3.toString());
    System.out.println(student4.toString());
    System.out.println("************************************************");
    System.out.println("**************************************************************");
    System.out.println();
  }
}
