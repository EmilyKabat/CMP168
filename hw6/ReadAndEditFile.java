import java.io.*;
import java.util.Scanner;

public class ReadAndEditFile{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner scnr = new Scanner(System.in);
    FileInputStream fileByteStream = null;
    Scanner inFS = null;
    FileOutputStream fileStream = null;
    PrintWriter outFS = null;
    char cont = 'y';
    int caps = 0;

    while (cont == 'y') {
      System.out.println("What is the name of your file?");
      String userFile = scnr.nextLine().replace(" ", "");

      try {
        String s = "";
        fileByteStream = new FileInputStream(userFile);
        inFS = new Scanner(fileByteStream);
        fileStream = new FileOutputStream("HomeworkOutput6-2.txt");
        outFS = new PrintWriter(fileStream);
        while (inFS.hasNextLine()) {
          s += inFS.nextLine();
        }
        for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) == '.') {
            s = s.substring(0, i+1) + s.substring(1+2, i+3).toUpperCase() + s.substring(i+3);
          }
          s = s.replace("  ", " ");
        }
        outFS.println(s);
        cont = 'n';
      }
      catch (Exception FileNotFoundException){
        System.out.println("File Not Found " + userFile);
      }
    }
  }
}
