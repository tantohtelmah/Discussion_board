import java.util.Scanner;


public class lab1 {
	public static void main(String[] args) {
		//Arrays
		int[] values;
		values = new int[5];
		System.out.println(values.length);

		//Strings
		String myString = "Hello";
		System.err.println(myString.compareTo("World"));

		//Loops
		int[] myArray = new int[5];
		myArray[0] = 1;
		myArray[1] = 2;
		myArray[2] = 3;
		for(int myInt : myArray) {
			System.err.println(myInt);
		}

		//Input
		Scanner scanner = new Scanner(System.in);
		String myInput = scanner.nextLine();
		System.out.println(myInput);


	}
}
