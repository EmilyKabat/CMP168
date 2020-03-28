import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class Driver_SchoolDB {
    public static void main(String[] args) throws IOException {
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
                    }
                    else {
                        Course course = new Course();
                        courses[numCourses] = course;
                        numCourses++;
                    }
                }
            }
            else if (objType.equals("Faculty:")) {
                String[] s = inFS.nextLine().split(",");
                if (s[0].equals(" true") || s[0].equals(" false")) {
                    if (s[0].equals(" true")) {
                        Faculty faculty = new Faculty(true);
                        faculties[numFaculties] = faculty;
                        numFaculties++;
                    }
                }
                else if (s.length > 1) {
                    if (s[1].replace(" ", "").equals("true") || s[1].replace(" ", "").equals("false")) {
                        String objDeptName = s[0];
                        Boolean objIsTenured = false;
                        if (s[1].equals(" true")) {
                            objIsTenured = true;
                        }
                        Faculty faculty = new Faculty(objDeptName, objIsTenured);
                        faculties[numFaculties] = faculty;
                        numFaculties++;
                    }
                    else {
                        String objName = s[0] ;
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
                }
                else {
                    Faculty faculty = new Faculty();
                    faculties[numFaculties] = faculty;
                    numFaculties++;
                }
            }
            else if (objType.equals("Student:")) {
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
                    }
                    else {
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
                }
                else {
                    Student student = new Student();
                    students[numStudents] = student;
                    numStudents++;
                }
            }

            else if (objType.equals("GeneralStaff:")) {
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
    }
}
