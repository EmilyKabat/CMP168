package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class Driver_SchoolDBMenu {
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        FileInputStream fileByteStream = null;
        Scanner inFS = null;

        fileByteStream = new FileInputStream("SchoolDB_Initial.txt");
        inFS = new Scanner(fileByteStream);

        Course[] courses = new Course[100];
        int numCourses = 0;
        Faculty[] faculties = new Faculty[100];
        int numFaculties = 0;
        Student[] students = new Student[100];
        int numStudents = 0;
        GeneralStaff[] generalStaffs = new GeneralStaff[100];
        int numGeneralStaffs = 0;


        while (inFS.hasNextLine()) {
            String objType = inFS.next();
            if (objType.equals("Course:")) {
                String[] s = inFS.nextLine().split(",");
                if (s[0].equals(" true") || s[0].equals(" false")) {
                    Boolean objIsGraduate = false;
                    if (s[0].equals(" true")) {
                        objIsGraduate = true;
                    }
                    if (s.length > 1) {
                        int objCourseNum = parseInt(s[1].replace(" ", ""));
                        String objCourseDept = s[2].replace(" ", "");
                        int objNumCredits = parseInt(s[3].replace(" ", ""));
                        Course course = new Course(objIsGraduate, objCourseNum, objCourseDept, objNumCredits);
                        courses[numCourses] = course;
                        numCourses++;
                    } else {
                        Course course = new Course();
                        courses[numCourses] = course;
                        numCourses++;
                    }
                }
            } else if (objType.equals("Faculty:")) {
                String[] s = inFS.nextLine().split(",");
                if (s[0].equals(" true") || s[0].equals(" false")) {
                    if (s[0].equals(" true")) {
                        Faculty faculty = new Faculty(true);
                        faculties[numFaculties] = faculty;
                        numFaculties++;
                    }
                } else if (s.length > 1) {
                    if (s[1].replace(" ", "").equals("true") || s[1].replace(" ", "").equals("false")) {
                        String objDeptName = s[0];
                        Boolean objIsTenured = false;
                        if (s[1].equals(" true")) {
                            objIsTenured = true;
                        }
                        Faculty faculty = new Faculty(objDeptName, objIsTenured);
                        faculties[numFaculties] = faculty;
                        numFaculties++;
                    } else {
                        String objName = s[0];
                        s[1] = s[1].replace(" ", "");
                        int objBirthYear = Integer.parseInt(s[1]);
                        String objDeptName = s[2].replace(" ", "");
                        Boolean objIsTenured = false;
                        if (s[3].replace(" ", "").equals("true")) {
                            objIsTenured = true;
                        }
                        Faculty faculty = new Faculty(objName, objBirthYear, objDeptName, objIsTenured);
                        faculties[numFaculties] = faculty;
                        numFaculties++;
                    }
                } else {
                    Faculty faculty = new Faculty();
                    faculties[numFaculties] = faculty;
                    numFaculties++;
                }
            } else if (objType.equals("Student:")) {
                String[] s = inFS.nextLine().split(",");
                if (s[0].equals("true")) {
                    Student student = new Student(true);
                    students[numStudents] = student;
                    numStudents++;
                }
                if (s[0].equals("false")) {
                    Student student = new Student(false);
                    students[numStudents] = student;
                    numStudents++;
                }
                if (s.length > 1) {
                    if (s[1].replace(" ", "").equals("true")) {
                        String objMajor = s[0];
                        Student student = new Student(objMajor, true);
                        students[numStudents] = student;
                        numStudents++;
                    }
                    if (s[1].replace(" ", "").equals("false")) {
                        String objMajor = s[0];
                        Student student = new Student(objMajor, false);
                        students[numStudents] = student;
                        numStudents++;
                    } else {
                        String objName = s[0];
                        int objBirthYear = Integer.parseInt(s[1].replace(" ", ""));
                        String objMajor = s[2].replace(" ", "");
                        Boolean objIsGraduate = false;
                        if (s[3].replace(" ", "").equals("true")) {
                            objIsGraduate = true;
                        }
                        Student student = new Student(objName, objBirthYear, objMajor, objIsGraduate);
                        students[numStudents] = student;
                        numStudents++;
                    }
                } else {
                    Student student = new Student();
                    students[numStudents] = student;
                    numStudents++;
                }
            } else if (objType.equals("GeneralStaff:")) {
                String[] s = inFS.nextLine().split(",");
                if (s.length == 0) {
                    GeneralStaff generalStaff = new GeneralStaff();
                    generalStaffs[numGeneralStaffs] = generalStaff;
                    numGeneralStaffs++;
                }
                if (s.length == 1) {
                    s[0] = s[0].trim();
                    GeneralStaff generalStaff = new GeneralStaff(s[0]);
                    generalStaffs[numGeneralStaffs] = generalStaff;
                    numGeneralStaffs++;
                }
                if (s.length == 2) {
                    GeneralStaff generalStaff = new GeneralStaff(s[0], s[1]);
                    generalStaffs[numGeneralStaffs] = generalStaff;
                    numGeneralStaffs++;
                }
                if (s.length == 4) {
                    GeneralStaff generalStaff = new GeneralStaff(s[0], Integer.parseInt(s[1].replace(" ", "")), s[2], s[3]);
                    generalStaffs[numGeneralStaffs] = generalStaff;
                    numGeneralStaffs++;
                }
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader("SchoolDB_Initial.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        System.out.println("\n**************************************************************\nSCHOOL DATABASE INFO:\n\n************************************************\nCOURSES:");

        if (numCourses > 0) {
            for (int i = 0; i < numCourses; i++) {
                System.out.println(courses[i].toString());
            }
            System.out.println("************************************************\n************************************************\nPERSONS:\n************************************************\n************************************************\nEMPLOYEES:\n************************************************\n************************************************\nGENERAL STAFF:");
        }
        if (numGeneralStaffs > 0) {
            for (int j = 0; j < numGeneralStaffs; j++) {
                System.out.println(generalStaffs[j].toString());
            }
            System.out.println("************************************************\n************************************************\nFACULTY:");
        }
        if (numFaculties > 0) {
            for (int w = 0; w < numFaculties; w++) {
                System.out.println(faculties[w].toString());
            }
            System.out.println("************************************************\n************************************************\nSTUDENTS:");
        }
        if (numStudents > 0) {
            for (int l = 0; l < numStudents; l++) {
                System.out.println(students[l].toString());
            }
            System.out.println("************************************************\n**************************************************************\n");
        }
        fileByteStream.close();
        System.out.println("Would you like to perform an operation? If yes, type y. If no, type n");
        char cont = scnr.next().charAt(0);
        while (cont =='y') {
            System.out.println("Which operation would you like to perform? Type the letter from the list below.");
            System.out.println(String.format("a.  Create 3 new Course objects based on input\nb.  Create 3 new Faculty objects based on input\nc.  Create 3 new GeneralStaff objects based on input\nd.  Create 3 new Student objects based on input\ne.  Add 2 new Courses to a Faculty object\nf.  Add 2 new Courses to a Student object\ng.  Add an array of 2 Courses to a Faculty object\nh.  Add an array of 2 Courses to a Student object\ni.  Get the Course at index from a Faculty object\nj. Get the Course at index from a Student object\nk. Select a Faculty object and a Course object from menus and query the Faculty object for the Course to determine whether the Faculty object teaches it or not\nl.  Determine which Faculty object teaches the most and the least courses\nm.  Determine which Course is the minimum and which is the maximum of all Course objects in the catalog\nn.  Determine which Student has the most and least credits"));
            char userChoice = scnr.next().charAt(0);
            if (userChoice == 'a') {
                if (courses.length - numCourses < 3) {
                    Course[] newCourses = new Course[courses.length * 2];
                    for (int i = 0; i < courses.length; i++) {
                        newCourses[i] = courses[i];
                    }
                    courses = newCourses;
                }

                boolean isGraduateCourse = false;
                int courseNum = 0;
                String courseDept = "";
                int numCredits = 0;

                for (int i = 0; i < 3; i++) {
                    if (i == 0) {
                        System.out.println("First course:");
                    }
                    if (i == 1) {
                        System.out.println("Second course:");
                    }
                    if (i == 2) {
                        System.out.println("Third course:");
                    }
                    System.out.println("Would you like to enter information about the course? Type 'y' for yes and 'n' for no.");
                    if (scnr.next().charAt(0) == 'y') {
                        System.out.println("Is this course a graduate course? Type 'y' for yes and 'n' for no.");
                        if (scnr.next().charAt(0) == 'y') {
                            isGraduateCourse = true;
                        }
                        System.out.println("What is the course's number?");
                        courseNum = scnr.nextInt();
                        System.out.println("What is the course's department?");
                        courseDept = scnr.next();
                        System.out.println("How many credits is this course worth?");
                        numCredits = scnr.nextInt();
                        Course course = new Course(isGraduateCourse, courseNum, courseDept, numCredits);
                        courses[numCourses + i] = course;
                    }
                    else {
                        Course course = new Course();
                        courses[numCourses + i] = course;
                    }
                }
                numCourses += 3;
                for (int i = 0; i < numCourses; i++) {
                    System.out.println(courses[i].toString());
                }
            }
            if (userChoice == 'b') {
                if (faculties.length - numFaculties < 3) {
                    Faculty[] newFaculties = new Faculty[faculties.length * 2];
                    for (int i = 0; i < faculties.length; i++) {
                        newFaculties[i] = faculties[i];
                    }
                    faculties = newFaculties;
                }
                boolean isTenured = true;
                String deptName = "";
                String name = "";
                int birthYear = 0;
                for (int i = 0; i < 3; i++) {
                    int numParameters = 0;
                    if (i == 0) {
                        System.out.println("First faculty: ");
                    }
                    if (i == 1) {
                        System.out.println("Second faculty: ");
                    }
                    if (i == 2) {
                        System.out.println("Third faculty: ");
                    }
                    System.out.println("Would you like to enter information about the faculty's tenure? If yes, type 'y'. Else, type 'n'.");
                    if (scnr.next().charAt(0) == 'y') {
                        System.out.println("Is the faculty tenured? Type 'y' for yes and 'n' for no");
                        if (scnr.next().charAt(0) == 'n') {
                            isTenured = false;
                        }
                        numParameters++;
                    }
                    if (numParameters > 0) {
                        System.out.println("Would you like to enter information about the faculty's department? If yes, type 'y'. Else, type 'n'.");
                        if (scnr.next().charAt(0) == 'y') {
                            System.out.println("Enter the name of the faculty's department:");
                            deptName = scnr.next();
                            numParameters++;
                        }
                        if (numParameters > 1) {
                            System.out.println("Would you like to enter information about the faculty's name and birth year? If yes, type 'y'. Else, type 'n'.");
                            if (scnr.next().charAt(0) == 'y') {
                                System.out.println("Enter the faculty's name:");
                                name = scnr.next();
                                System.out.println("Enter the faculty's birth year:");
                                birthYear = scnr.nextInt();
                                numParameters++;
                            }
                        }
                    }
                    if (numParameters == 0) {
                        Faculty faculty = new Faculty();
                        faculties[numFaculties + i] = faculty;
                    }
                    if (numParameters == 1) {
                        Faculty faculty = new Faculty(isTenured);
                        faculties[numFaculties + i] = faculty;
                    }
                    if (numParameters == 2) {
                        Faculty faculty = new Faculty(deptName, isTenured);
                        faculties[numFaculties + i] = faculty;
                    }
                    if (numParameters == 3) {
                        Faculty faculty = new Faculty(name, birthYear, deptName, isTenured);
                        faculties[numFaculties + i] = faculty;
                    }
                }
                numFaculties += 3;
                for (int i = 0; i < numFaculties; i++) {
                    System.out.println(faculties[i]);
                }
            }
            if (userChoice == 'c') {
                if (generalStaffs.length - numGeneralStaffs < 3) {
                    GeneralStaff[] newGeneralStaffs = new GeneralStaff[generalStaffs.length * 2];
                    for (int i = 0; i < generalStaffs.length; i++) {
                        newGeneralStaffs[i] = generalStaffs[i];
                    }
                    generalStaffs = newGeneralStaffs;
                }

                String duty = "";
                String deptName = "";
                String name = "";
                int birthYear = 0;
                int numParameters = 0;

                for (int i = 0; i < 3; i++) {
                    if (i == 0) {
                        System.out.println("First General Staff:");
                    }
                    if (i == 1) {
                        System.out.println("Second General Staff:");
                    }
                    if (i == 2) {
                        System.out.println("Third General Staff:");
                    }
                    System.out.println("Would you like to enter information about the general staff's duty? Type 'y' for yes and 'n' for no.");
                    if (scnr.next().charAt(0) == 'y') {
                        String s = scnr.nextLine();
                        System.out.println("What is the general staff's duty?");
                        duty = scnr.nextLine();
                        numParameters++;
                        System.out.println("Would you like to enter information about the general staff's department? Type 'y' for yes and 'n' for no");
                        if (scnr.next().charAt(0) == 'y') {
                            System.out.println("What is the general staff's department?");
                            deptName = scnr.next();
                            numParameters++;
                            System.out.println("Would you like to enter information about the general staff's name and birth year? Type 'y' for yes and 'n' for no");
                            if (scnr.next().charAt(0) == 'y') {
                                System.out.println("What is the general staff's name?");
                                name = scnr.next();
                                System.out.println("What is the general staff's birth year?");
                                birthYear = scnr.nextInt();
                                numParameters++;
                            }
                        }
                    }
                    if (numParameters == 0) {
                        GeneralStaff generalStaff = new GeneralStaff();
                        generalStaffs[numGeneralStaffs + i] = generalStaff;
                    }
                    if (numParameters == 1) {
                        GeneralStaff generalStaff = new GeneralStaff(duty);
                        generalStaffs[numGeneralStaffs + i] = generalStaff;
                    }
                    if (numParameters == 2) {
                        GeneralStaff generalStaff = new GeneralStaff(deptName, duty);
                        generalStaffs[numGeneralStaffs + i] = generalStaff;
                    }
                    else {
                        GeneralStaff generalStaff = new GeneralStaff(name, birthYear, deptName, duty);
                        generalStaffs[numGeneralStaffs + i] = generalStaff;
                    }
                }
                numGeneralStaffs += 3;
                for (int i = 0; i < numGeneralStaffs; i++) {
                    System.out.println(generalStaffs[i]);
                }

            }
            if (userChoice == 'd') {
                if (students.length - numStudents < 3) {
                    Student[] newStudents = new Student[students.length * 2];
                    for (int i = 0; i < students.length; i++) {
                        newStudents[i] = students[i];
                    }
                    students = newStudents;
                }

                int numParameters = 0;
                boolean isGraduate = true;
                String major = "";
                String name = "";
                int birthYear = 0;

                for (int i = 0; i < 3; i++) {
                    if (i == 0) {
                        System.out.println("First student:");
                    }
                    if (i == 1) {
                        System.out.println("Second student:");
                    }
                    if (i == 2) {
                        System.out.println("Third student:");
                    }
                    System.out.println("Would you like to enter information about the type of student? Type 'y' for yes and 'n' for no.") ;
                    if (scnr.next().charAt(0) == 'y') {
                        numParameters++;
                        System.out.println("Is the student a graduate student or undergraduate? Type 'y' for graduate and 'n' for undergraduate.");
                        if (scnr.next().charAt(0) == 'n') {
                            isGraduate = false;
                        }
                        System.out.println("Would you like to enter information about the student's major? Type 'y' for yes and 'n' for no.");
                        if (scnr.next().charAt(0) == 'y') {
                            numParameters++;
                            System.out.println("What is the student's major?");
                            major = scnr.next();
                            System.out.println("Would you like to enter information about the student's name and birth year? Type 'y' for yes and 'n' for no.");
                            if (scnr.next().charAt(0) =='y') {
                                numParameters++;
                                System.out.println("What is the student's name?");
                                name = scnr.next();
                                System.out.println("What is the student's birth year?");
                                birthYear = scnr.nextInt();
                            }
                        }
                    }
                    if (numParameters == 0) {
                        Student student = new Student();
                        students[numStudents + i] = student;
                    }
                    if (numParameters == 1) {
                        Student student = new Student(isGraduate);
                        students[numStudents + i] = student;
                    }
                    if (numParameters == 2) {
                        Student student = new Student(major, isGraduate);
                        students[numStudents + i] = student;
                    }
                    else {
                        Student student = new Student(name, birthYear, major, isGraduate);
                        students[numStudents + i] = student;
                    }
                }
                numStudents += 3;
                for (int i = 0; i < numStudents; i++) {
                    System.out.println(students[i]);
                }
            }
            if (userChoice == 'e') {
                Course[] newCourses = new Course[2];
                boolean isGraduateCourse = false;
                int courseNum = 0;
                String courseDept = "";
                int numCredits = 0;

                for (int i = 0; i < 2; i++) {
                    if (i == 0) {
                        System.out.println("First course:");
                    }
                    if (i == 1) {
                        System.out.println("Second course:");
                    }
                    if (i == 2) {
                        System.out.println("Third course:");
                    }
                    System.out.println("Would you like to enter information about the course? Type 'y' for yes and 'n' for no.");
                    if (scnr.next().charAt(0) == 'y') {
                        System.out.println("Is this course a graduate course? Type 'y' for yes and 'n' for no.");
                        if (scnr.next().charAt(0) == 'y') {
                            isGraduateCourse = true;
                        }
                        System.out.println("What is the course's number?");
                        courseNum = scnr.nextInt();
                        System.out.println("What is the course's department?");
                        courseDept = scnr.next();
                        System.out.println("How many credits is this course worth?");
                        numCredits = scnr.nextInt();
                        Course course = new Course(isGraduateCourse, courseNum, courseDept, numCredits);
                        newCourses[i] = course;
                        courses[numCourses + i] = course;
                    }
                    else {
                        Course course = new Course();
                        newCourses[i] = course;
                        courses[numCourses + i] = course;
                    }
                }
                numCourses += 2;
                char fail = 'y';
                System.out.println("Enter the ID of the faculty teaching these courses:");
                int facultyID = scnr.nextInt();
                Faculty faculty = new Faculty();
                while (fail == 'y') {
                    for (int i = 0; i < numFaculties; i++) {
                        if (faculties[i].getEmployeeID() == facultyID) {
                            faculty = faculties[i];
                            fail = 'n';
                        }
                    }
                    if (fail =='y') {
                        System.out.println("Invalid ID. Enter the ID of the faculty teaching these courses:");
                        facultyID = scnr.nextInt();
                    }
                }
                faculty.addCoursesTaught(newCourses);
                for (int i = 0; i < numFaculties; i++) {
                    System.out.println(faculties[i].toString());
                }
            }
            if (userChoice == 'f') {
                Course[] newCourses = new Course[2];
                boolean isGraduateCourse = false;
                int courseNum = 0;
                String courseDept = "";
                int numCredits = 0;

                for (int i = 0; i < 2; i++) {
                    if (i == 0) {
                        System.out.println("First course:");
                    }
                    if (i == 1) {
                        System.out.println("Second course:");
                    }
                    if (i == 2) {
                        System.out.println("Third course:");
                    }
                    System.out.println("Would you like to enter information about the course? Type 'y' for yes and 'n' for no.");
                    if (scnr.next().charAt(0) == 'y') {
                        System.out.println("Is this course a graduate course? Type 'y' for yes and 'n' for no.");
                        if (scnr.next().charAt(0) == 'y') {
                            isGraduateCourse = true;
                        }
                        System.out.println("What is the course's number?");
                        courseNum = scnr.nextInt();
                        System.out.println("What is the course's department?");
                        courseDept = scnr.next();
                        System.out.println("How many credits is this course worth?");
                        numCredits = scnr.nextInt();
                        Course course = new Course(isGraduateCourse, courseNum, courseDept, numCredits);
                        newCourses[i] = course;
                    }
                    else {
                        Course course = new Course();
                        newCourses[i] = course;
                    }
                }
                numCourses += 2;
                char fail = 'y';
                System.out.println("Enter the ID of the student taking these courses:");
                int studentID = scnr.nextInt();
                while (fail == 'y') {
                    for (int i = 0; i < numStudents; i++) {
                        if (students[i].getStudentID() == studentID) {
                            students[i].addCoursesTaken(newCourses);
                            fail = 'n';
                        }
                    }
                    if (fail =='y') {
                        System.out.println("Invalid ID. Enter the ID of the student taking these courses:");
                        studentID = scnr.nextInt();
                    }
                }
                for (int i = 0; i < numStudents; i++) {
                    System.out.println(students[i].toString());
                }
            }
            if (userChoice == 'g') {
                Course[] newCourses = new Course[2];
                boolean isGraduateCourse = false;
                int courseNum = 0;
                String courseDept = "";
                int numCredits = 0;

                for (int i = 0; i < 2; i++) {
                    if (i == 0) {
                        System.out.println("First course:");
                    }
                    if (i == 1) {
                        System.out.println("Second course:");
                    }
                    if (i == 2) {
                        System.out.println("Third course:");
                    }
                    System.out.println("Would you like to enter information about the course? Type 'y' for yes and 'n' for no.");
                    if (scnr.next().charAt(0) == 'y') {
                        System.out.println("Is this course a graduate course? Type 'y' for yes and 'n' for no.");
                        if (scnr.next().charAt(0) == 'y') {
                            isGraduateCourse = true;
                        }
                        System.out.println("What is the course's number?");
                        courseNum = scnr.nextInt();
                        System.out.println("What is the course's department?");
                        courseDept = scnr.next();
                        System.out.println("How many credits is this course worth?");
                        numCredits = scnr.nextInt();
                        Course course = new Course(isGraduateCourse, courseNum, courseDept, numCredits);
                        newCourses[i] = course;
                        courses[numCourses + i] = course;
                    }
                    else {
                        Course course = new Course();
                        newCourses[i] = course;
                        courses[numCourses + i] = course;
                    }
                }
                numCourses += 2;
                char fail = 'y';
                System.out.println("Enter the ID of the faculty teaching these courses:");
                int facultyID = scnr.nextInt();
                Faculty faculty = new Faculty();
                while (fail == 'y') {
                    for (int i = 0; i < numFaculties; i++) {
                        if (faculties[i].getEmployeeID() == facultyID) {
                            faculty = faculties[i];
                            fail = 'n';
                        }
                    }
                    if (fail =='y') {
                        System.out.println("Invalid ID. Enter the ID of the faculty teaching these courses:");
                        facultyID = scnr.nextInt();
                    }
                }
                faculty.addCoursesTaught(newCourses);
                for (int i = 0; i < numFaculties; i++) {
                    System.out.println(faculties[i].toString());
                }
            }
            if (userChoice == 'h') {
                Course[] newCourses = new Course[2];
                boolean isGraduateCourse = false;
                int courseNum = 0;
                String courseDept = "";
                int numCredits = 0;

                for (int i = 0; i < 2; i++) {
                    if (i == 0) {
                        System.out.println("First course:");
                    }
                    if (i == 1) {
                        System.out.println("Second course:");
                    }
                    if (i == 2) {
                        System.out.println("Third course:");
                    }
                    System.out.println("Would you like to enter information about the course? Type 'y' for yes and 'n' for no.");
                    if (scnr.next().charAt(0) == 'y') {
                        System.out.println("Is this course a graduate course? Type 'y' for yes and 'n' for no.");
                        if (scnr.next().charAt(0) == 'y') {
                            isGraduateCourse = true;
                        }
                        System.out.println("What is the course's number?");
                        courseNum = scnr.nextInt();
                        System.out.println("What is the course's department?");
                        courseDept = scnr.next();
                        System.out.println("How many credits is this course worth?");
                        numCredits = scnr.nextInt();
                        Course course = new Course(isGraduateCourse, courseNum, courseDept, numCredits);
                        newCourses[i] = course;
                    }
                    else {
                        Course course = new Course();
                        newCourses[i] = course;
                    }
                }
                numCourses += 2;
                char fail = 'y';
                System.out.println("Enter the ID of the student taking these courses:");
                int studentID = scnr.nextInt();
                while (fail == 'y') {
                    for (int i = 0; i < numStudents; i++) {
                        if (students[i].getStudentID() == studentID) {
                            students[i].addCoursesTaken(newCourses);
                            fail = 'n';
                        }
                    }
                    if (fail =='y') {
                        System.out.println("Invalid ID. Enter the ID of the student taking these courses:");
                        studentID = scnr.nextInt();
                    }
                }
                for (int i = 0; i < numStudents; i++) {
                    System.out.println(students[i].toString());
                }
            }
            if (userChoice == 'i') {
                System.out.println("Enter the ID of the faculty you would like to select:");
                int facultyID = scnr.nextInt();
                Faculty faculty = new Faculty();
                int worked = 0;
                while (worked == 0) {
                    for (int i = 0; i < numFaculties; i++) {
                        if (faculties[i].getEmployeeID() == facultyID) {
                            faculty = faculties[i];
                            worked = 1;
                            System.out.println(faculty.toString());
                        }
                    }
                    if (worked == 0) {
                        System.out.println("Invalid ID. Enter the ID of the faculty you would like to select:");
                        facultyID = scnr.nextInt();
                    }
                }
                System.out.println(faculty.toString());
                System.out.println("Enter the index of the course you would like to select:");
                int index = scnr.nextInt();
                while (worked == 1) {
                    if (index >= 0 && index < numCourses) {
                        if (faculty.getCourseTaught(index) == null) {
                            System.out.println("There is no course at that index. Enter the index of the course you would like to select:");
                            index = scnr.nextInt();
                        }
                        else {
                            System.out.println(faculty.getCourseTaught(index).toString());
                            worked = 2;
                        }
                    }
                    else {
                        System.out.println("Invalid index. Enter the index of the course you would like to select:");
                        index = scnr.nextInt();
                    }
                }
            }
            if (userChoice == 'j') {
                System.out.println("Enter the ID of the student you would like to select:");
                int studentID = scnr.nextInt();
                Student student = new Student();
                int worked = 0;
                while (worked == 0) {
                    for (int i = 0; i < numStudents; i++) {
                        if (students[i].getStudentID() == studentID) {
                            student = students[i];
                            worked = 1;
                            System.out.println(student.toString());
                        }
                    }
                    if (worked == 0) {
                        System.out.println("Invalid ID. Enter the ID of the student you would like to select:");
                        studentID = scnr.nextInt();
                    }
                }
                System.out.println(student.toString());
                System.out.println("Enter the index of the course you would like to select:");
                int index = scnr.nextInt();
                while (worked == 1) {
                    if (index >= 0 && index < numCourses) {
                        if (student.getCourseTaken(index) == null) {
                            System.out.println("There is no course at that index. Enter the index of the course you would like to select:");
                            index = scnr.nextInt();
                        }
                        else {
                            System.out.println(student.getCourseTaken(index).toString());
                            worked = 2;
                        }
                    }
                    else {
                        System.out.println("Invalid index. Enter the index of the course you would like to select:");
                        index = scnr.nextInt();
                    }
                }
            }
            if (userChoice == 'k') {
                System.out.println("FACULTIES:");
                for (int i = 0; i < numFaculties; i++) {
                    System.out.println(faculties[i].toString());
                }
                System.out.println("\nCOURSES:");
                for (int i = 0; i < numCourses; i++) {
                    System.out.println(courses[i].toString());
                }
                System.out.println("\nEnter the ID of the faculty you would like to select:");
                int facultyID = scnr.nextInt();
                Boolean failure = true;
                Faculty faculty = new Faculty();
                while (failure) {
                    if (facultyID < 0 || facultyID > numFaculties) {
                        System.out.println("Invalid ID. Enter the ID of the faculty you would like to select:");
                        facultyID = scnr.nextInt();
                    } else {
                        failure = false;
                        for (int i = 0; i < numFaculties; i++) {
                            if (faculties[i].getEmployeeID() == facultyID) {
                                faculty = faculties[i];
                            }
                        }
                    }
                }
                System.out.println("\nEnter the number of the course you would like to select:");
                int courseID = scnr.nextInt();
                Course course = new Course();
                while (!failure) {
                    for (int i = 0; i < numCourses; i++) {
                        if (courses[i].getCourseNum() == courseID) {
                            course = courses[i];
                            failure = true;
                        }
                    }
                    if (!failure) {
                        System.out.println("Invalid course number. Enter the number of the course you would like to select:");
                        courseID = scnr.nextInt();
                    }
                }
                int taught = 0;
                for (int i = 0; i < numCourses; i++) {
                    if (faculty.getCourseTaught(i) == course) {
                        System.out.println("This course is taught by this faculty.");
                        taught = 1;
                    }
                }
                if (taught == 0) {
                    System.out.println("This course is not taught by this faculty.");
                }
            }
            if (userChoice == 'l') {
                int maxNumCoursesTaught = 0;
                Faculty faculty = new Faculty();
                for (int i = 0; i < numFaculties; i++) {
                    if (faculties[i].getNumCoursesTaught() > 0) {
                        maxNumCoursesTaught = faculties[i].getNumCoursesTaught();
                        faculty = faculties[i];
                    }
                }
                System.out.println("Faculty with the most courses taught: \n" + faculty.toString());
            }
            if (userChoice == 'm') {
                int maxNumCredits = 0;
                Course course = new Course();
                for (int i = 0; i < numCourses; i++) {
                    if (courses[i].getNumCredits() > 0) {
                        maxNumCredits = courses[i].getNumCredits();
                        course = courses[i];
                    }
                }
                System.out.println("Course with the most credits: \n" + course.toString());
            }
            if (userChoice == 'n') {
                int maxNumCoursesTaken = 0;
                Student student = new Student();
                for (int i = 0; i < numStudents; i++) {
                    if (students[i].getNumCoursesTaken() > 0) {
                        maxNumCoursesTaken = students[i].getNumCoursesTaken();
                        student = students[i];
                    }
                }
                System.out.println("Student with the most courses taken: \n" + student.toString());
            }
            System.out.println("Would you like to perform an operation? If yes, type y. If no, type n");
            cont = scnr.next().charAt(0);
        }
    }
}

