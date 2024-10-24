package com.metacube;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrOperation arrOperation = new ArrOperation();
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.print("Enter Size of Array : ");
			int sizeOfArray = scanner.nextInt();
			
			if (sizeOfArray <= 0) {
				throw new AssertionError("Size of Array must be greater than 0.");
			}
			
			int[] array =new int[sizeOfArray];
			
			for ( int i=0; i<sizeOfArray; i++ ) {
				System.out.print("Enter " + (i+1) + " element of array : ");
				array[i]= scanner.nextInt();
			}
			
			System.out.println("Entered Array : ");
			for(int numberEntered : array) {
				System.out.print(numberEntered + " ");
			}
			
			
			System.out.println("\n\n 1. Find Largest Mirror in Array. \n 2. Find number of Clumps present in Array. \n 3. Rearrange the array. \n 4. Split Array in 2 equal sum.");
			System.out.println("Enter a choice : ");
			int choice = scanner.nextInt();
			
			
			switch (choice) {
			case 1:
				System.out.println("Largest Mirror : " + arrOperation.maxMirror(array));
				break;
				
			case 2:
				System.out.println("Clumps present : " + arrOperation.countClumps(array));
				break;
				
			case 3:
				System.out.println("Enter X : ");
				int userInputX = scanner.nextInt();
				System.out.println("Enter Y : ");
				int userInputY = scanner.nextInt();
				System.out.print("Rearranged Array Output : " );
				for(int numberEntered : arrOperation.fixXY(array, userInputX, userInputY)) {
					System.out.print(numberEntered + " ");
				}
				break;
				
			case 4:
				System.out.println("Split Array Index : " + arrOperation.splitArray(array));
				break;
				
				default: 
					System.out.println("Please Enter Valid Input.");
			}
			
			
			
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Please Enter Only Integer greater than 0.");
		}
		finally {
			scanner.close();
		}
	}

}
