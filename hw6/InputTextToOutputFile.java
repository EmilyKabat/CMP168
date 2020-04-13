// package hw6;

import java.io.*;
import java.util.Scanner;

public class InputTextToOutputFile{
	 public static void main(String[] args) throws FileNotFoundException {
			 Scanner scnr = new Scanner(System.in);
			 String userFile = "";
			 char cont = 'y';

			 System.out.println("What is the name of your output file?");
			 if (scnr.hasNext()) {
					 userFile = scnr.nextLine();
			 }
			 try {
					 String s = "";
					 FileWriter fileWriter = new FileWriter(userFile);
					 boolean c = true;
					 while (c) {
							 s += scnr.nextLine();
							 s+="\n";
							 if (scnr.nextLine().contains("STOP!")) {
									 c = false;
							 }
					 }
					 // System.out.println(s);
					 fileWriter.write(s);
					 fileWriter.close();
					 cont = 'n';
			 }
			 catch (Exception FileNotFoundException){
					 System.out.println("File Not Found " + userFile);
			 }
	 }
}
