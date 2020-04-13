import java.io.*;
import java.util.Scanner;

public class InputTextToOutputFile{
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
					 FileWriter fileWriter = new FileWriter(userFile);
					 if (scnr.nextLine().contains("STOP!")) {
						 s += scnr.nextLine();
						 s += "\n";
					 }
					 fileWriter.write(s);
					 fileWriter.close();
					 cont = 'n';
			 }
			 catch (Exception FileNotFoundException){
					 System.out.println("File Not Found " + userFile);
			 }
	 }
}
