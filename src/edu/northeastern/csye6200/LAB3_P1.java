package edu.northeastern.csye6200;

import java.util.Scanner;

public class LAB3_P1 {
	public static void main(String[] args) {
		// TODO: write your code here
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a credit card number as a long integer: ");
		long cardNum = input.nextLong();
		
		boolean rst = isValid(cardNum);
		if (rst) {
			System.out.println(cardNum + " is valid");
		} else {
			System.out.println(cardNum + " is invalid");
		}
	}

	/** Return true if the card number is valid */
	public static boolean isValid(long number) {
		// TODO: write your code here
		int oddSum = sumOfOddPlace(number);
		int evenSum = sumOfDoubleEvenPlace(number);
		
		if((oddSum + evenSum) % 10 == 0) {
			if (prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 37) || prefixMatched(number, 6)) {
				return true;
			}
		}
		return false;
	}

	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number) {
		// TODO: write your code here
		int len = getSize(number);
		String n = number + "";
		
		int sum = 0;
		
		for(int i = len - 2; i >= 0; i -= 2) {
			char digit = n.charAt(i);
			int currentNum = Character.getNumericValue(digit) * 2;  
			sum += getDigit(currentNum);
		} 
		System.out.println("step 2: "+ sum);
		return sum;
	}

	/**
	 * Return this number if it is a single digit, otherwise, return the sum of
	 * the two digits
	 */
	public static int getDigit(int number) {
		// TODO: write your code here
		int s = 0;
		if(number / 10 == 1) {
			s = number / 10 + number % 10;
		}
		else {
			s = number;
		}
		return s;
	}

	/** Return sum of odd place digits in number */
	public static int sumOfOddPlace(long number) {
		// TODO: write your code here
		String n = number + "";
		int len = getSize(number);
		
		int sum = 0;
		for(int i = len - 1; i >= 0; i -= 2) {
			char digit = n.charAt(i);
			int currentNum = Character.getNumericValue(digit);  
			sum += currentNum;
		}
		System.out.println("step 3: "+ sum);
		return sum;
	}

	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number, int d) {
		// TODO: write your code here
		long prefix1 = getPrefix(number, 1); 
		long prefix2 = getPrefix(number, 2);
		
		if((int)prefix1 == d || (int)prefix2 == d) {
			return true;
		} 
		else {
			System.out.println("Prefix is not match");
			return false;
		}
	}

	/** Return the number of digits in d */
	public static int getSize(long d) {
		// TODO: write your code here
		String n = d + "";
		return n.length();
	}

	/**
	 * Return the first k number of digits from number. If the number of digits
	 * in number is less than k, return number.
	 */
	public static long getPrefix(long number, int k) {
		// TODO: write your code here
		String n = number + "";
		int len = getSize(number);
		if(len > k) {
			String prefix = n.substring(0, k);
			int p = Integer.parseInt(prefix);
			return p;
		}
		else {
			return number;
		}
	}
}
