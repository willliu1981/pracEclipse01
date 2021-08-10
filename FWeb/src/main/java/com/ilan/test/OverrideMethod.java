package com.ilan.test;

public class OverrideMethod {

	public static void main(String[] args) {
		doSum(10, new Integer(20));
		doSum(10.0, 20.0);
		doSum( new Integer(10), new Integer(10));

	}

	public static void doSum(Integer x, Integer y) {
		System.out.println("Integer sum is " + (x + y));
	}

	public static void doSum(Double x, Double y) {
		System.out.println("Double sum is " + (x + y));
	}

//	public static void doSum(float x, float y) {
//		System.out.println("float sum is " + (x + y));
//	}
	
	public static void doSum(Integer x, int y) {
		System.out.println("I and i sum1 is " + (x + y));
	}
	
	public static void doSum(int x, Integer y) {
		System.out.println("I and i sum2 is " + (x + y));
	}

}
