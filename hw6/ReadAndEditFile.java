import java.io.*;
import java.util.Scanner;

public class ReadAndEditFile{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner scnr = new Scanner(System.in);
    FileInputStream fileByteStream = null;
    Scanner inFS = null;
    char cont = 'y';

    while (cont == 'y') {
      System.out.println("What is the name of your file?");
      String userFile = scnr.nextLine();

      try {
        String s = "";
        fileByteStream = new FileInputStream(userFile);
        inFS = new Scanner(fileByteStream);

        FileOutputStream fileStream = null;
        PrintWriter outFS = null;

        fileStream = new FileOutputStream("HomeworkOutput6-2.txt");
        outFS = new PrintWriter(fileStream);

        while (inFS.hasNextLine()) {
          s += inFS.nextLine();
          s += "\n";
        }
        fileByteStream.close();
        s = s.substring(0, 1).toUpperCase() + s.substring(1);
        for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) == '.') {
            s = s.substring(0, i+2) + s.substring(i+2, i+3).toUpperCase() + s.substring(i+3);
          }
          s = s.replace("  ", " ");
        }

        outFS.println(s);
        cont = 'n';
        outFS.flush();

        fileStream.close();
      }
      catch (Exception FileNotFoundException){
        System.out.println("File Not Found " + userFile);
      }
    }
  }
}
