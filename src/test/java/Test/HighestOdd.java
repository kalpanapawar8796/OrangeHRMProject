package Test;

import java.util.Scanner;

public class HighestOdd {

	private static Scanner sc;

	public static void main(String[] args) {

		int Size, i;
		int positiveCount = 0, negativeCount = 0;
		sc = new Scanner(System.in);

		System.out.print(" Please Enter Number of elements in an array : ");
		Size = sc.nextInt();

		int[] a = new int[Size];

		System.out.print(" Please Enter " + Size + " elements of an Array  : ");
		for (i = 0; i < Size; i++) {

			if (a[i] >= 0) {
				a[i] = sc.nextInt();
			} else {
				break;
			}
		}

		int HighestOddnum = recursiveMax(a, a.length);
		System.out.println("Maximum element: " + HighestOddnum);
	}

	static int recursiveMax(int[] arr, int length) {
		if (length == 1)
			return arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0)
				return max(recursiveMax(arr, length - 1), arr[length - 1]);
		}
		return max(recursiveMax(arr, length - 1), arr[length - 1]);
	}

	private static int max(int n1, int n2) {
		return n1 > n2 ? n1 : n2;
	}
}
