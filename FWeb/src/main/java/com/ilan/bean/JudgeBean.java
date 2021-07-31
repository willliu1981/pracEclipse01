package com.ilan.bean;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class JudgeBean implements java.io.Serializable {

	private String insertion;
	private String n;

	public String getInsertion() {
		return insertion;
	}

	public void setInsertion(String insertion) {
		this.insertion = insertion;
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public String getMax() {
		boolean neg = false;
		String posstr = n;
		if (Integer.parseInt(n) < 0) {
			neg = true;
			posstr = String.valueOf(Math.abs(Integer.parseInt(n)));
		}
		int[] ints = new int[posstr.length() + 1];
		ints[0] = Integer.parseInt(insertion);

		for (int i = 1; i < ints.length; i++) {
			ints[i] = Character.getNumericValue(posstr.charAt(i - 1));
		}

		for (int i = 0; i < ints.length - 1; i++) {
			if ((!neg && ints[i] < ints[i + 1]) || (neg && ints[i] > ints[i + 1])) {
				ints[i] = ints[i] + ints[i + 1];
				ints[i + 1] = ints[i] - ints[i + 1];
				ints[i] = ints[i] - ints[i + 1];
			} else {
				break;
			}
		}

		return String.valueOf(Integer.parseInt(
				(neg ? "-" : "") + Arrays.stream(ints).mapToObj(String::valueOf).reduce("", (x1, x2) -> x1 + "" + x2)));
	}

	@Test
	public void test() {
		n = "1";
		insertion = "0";
		System.out.println(getMax());
	}

	// @Test
	public void test2() {
		n = "456";
		String _n = String.valueOf(Math.abs(Integer.parseInt(n)));
		System.out.println(_n);
	}

	// @Test
	public void test3() {
		int[] ints = { 4, 8 };
		int i = 0;
		ints[i] = ints[i] + ints[i + 1];
		ints[i + 1] = ints[i] - ints[i + 1];
		ints[i] = ints[i] - ints[i + 1];
		System.out.printf("%d , %d", ints[0], ints[1]);
	}
}
