// package hw6;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputTextToOutputFile {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scnr = new Scanner(System.in);
        String userFile = "";
        char cont = 'y';

        System.out.println("What is the name of your output file?");
        if (scnr.hasNext()) {
            userFile = scnr.nextLine().replace(" ",  "");
        }
        try {
            String s = "";
            FileOutputStream fileStream = null;
            PrintWriter outFS = null;

            fileStream = new FileOutputStream(userFile);
            outFS = new PrintWriter(fileStream);
            s += scnr.nextLine();
            s += "\n";
            while (!s.substring(s.length() - 5, s.length() - 1).contentEquals("STOP")) {
                s += scnr.nextLine();
                s += "\n";
            }
            s = s.substring(0, s.length()-5);
            System.out.println(s);
//            outFS.println(s);
            cont = 'n';
            outFS.flush();

            fileStream.close();
        }
        catch (Exception FileNotFoundException){
            System.out.println("File Not Found " + userFile);
        }
    }
}
