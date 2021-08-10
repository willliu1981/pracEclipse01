package com.ilan.test;

public class MyR {
	static int index = 0;

	public static void R(int n, int t, String x) {
		if (n == 0) {
			System.out.println(t + " ," + x);
			return;
		}
		R(n - 1, 3 * t, x + ">1");
		R(n - 1, 3 * t + 2, x + ">2");
		R(n - 1, 3 * t + 1, x + ">3");
	}

	public static void main(String args[]) {
		R(5, 0, "0");
		System.out.println();
	}
}
