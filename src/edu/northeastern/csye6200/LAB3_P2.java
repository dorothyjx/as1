package edu.northeastern.csye6200;

import java.util.Scanner;

public class LAB3_P2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of values: ");
		
		int len = input.nextInt();
		int[] a = new int [len];
		
		System.out.println("Enter the number: ");
		for (int i = 0; i < len; i++) {
			a[i] = input.nextInt();
		}

		boolean rst = isConsecutiveFour(a);
		
		if(rst) {
			System.out.println("The list has consecutive fours");
		}
		else {
			System.out.println("The list has no consecutive fours");
		}
	}

	public static boolean isConsecutiveFour(int[] values) {
		int first = values[0];
		int i = 1;
		int count = 1;
		
		while (i < values.length) {
			if (values[i] == first) {
				count += 1;
				if(count == 4) {
					return true;
				}
			}
			else {
				first = values[i];
				count = 1;
			}
			i += 1;
		}
		return false;
	}
}
