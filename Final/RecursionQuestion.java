//package Final;

import java.util.Scanner;

public class RecursionQuestion {

    public static void main(String[] args) {

        Car [] cars = new Car[10];
        int [][] seatConfigurations = {new int[]{2,2}, new int[]{2,3},
                new int[]{2,2,3}, new int[]{2,3,3}, new int[]{2,3,4}, new int[]{2,4,3},
                new int[]{2,3,5}, new int[]{2,4,4}, new int[]{2,4,5}, new int[]{3,4,5}};
        for(int i=0; i<cars.length; i++){
            cars[i] = new Car(2, 4, seatConfigurations[i]);
        }
        Scanner kb = new Scanner(System.in);
// 		System.out.print("enter seat info");
        String [] input = kb.nextLine().split(" ");
        int [] rowSeats = new int[input.length];
        for(int i=0; i<input.length; i++){
            rowSeats[i] = Integer.parseInt(input[i]);
        }





    }

















}
