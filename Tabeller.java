package uke40;

import static javax.swing.JOptionPane.*;

public class Tabeller {
	public static String[] fillString(int length) {
		String[] array = new String[length];
		for (int i = 0; i < length; i++) {
			array[i] = showInputDialog("Skriv inn et ord, du har " + (length - i) + " igjen:");
		}
		return array;
	}

	public static void printArray(String[] array) {
		for (String v : array) {
			System.out.print(v + " ");
		}
		System.out.println("");
	}

	public static int matcher(String[] array, String pattern) {

		char[] charArray;
		String arrayToString = "";
		// array to string
		for (String v : array) {
			arrayToString += v;
		}

		int charSize = arrayToString.length();
		charArray = arrayToString.toCharArray();

		String[] stringArray = new String[charSize - pattern.length() + 1];

		// fill array with char length of pattern
		for (int i = 0; i < charSize - pattern.length() + 1; i++) {
			stringArray[i] = Character.toString(charArray[i]);
			if (pattern.length() != 1) {
				for (int j = 0; j < pattern.length() - 1; j++) {
					stringArray[i] += Character.toString(charArray[i + j + 1]);
				}
			}

		}
		// remove later
		System.out.println("stringArray: ");
		printArray(stringArray);
		//

		int counter = 0;
		// check and count pattern matches
		for (int i = 0; i < charSize - pattern.length() + 1; i++) {
			if (pattern.equals(stringArray[i])) {
				counter++;
			}

		}
		System.out.print("Number of times pattern found: ");
		return counter;
	}

	public static void main(String[] args) {
		// Pattern
		String patternToFind = "aa";

		// static setup for finding pattern
		System.out.println("Pattern to find: " + patternToFind);
		int arrayLength = Integer.parseInt(showInputDialog("Velg lengde på tabellen: "));
		String[] stringArray = new String[arrayLength];
		stringArray = fillString(arrayLength);
		printArray(stringArray);
		
		System.out.println(matcher(stringArray, patternToFind));
	}

}
