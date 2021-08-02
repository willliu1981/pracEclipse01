package com.ilan.sessionbean;

import java.util.Arrays;

import org.junit.Test;

public class Judge implements IJudge {
	private JudgeBean bean;

	@Test
	public void test() {
		JudgeBean bean = new JudgeBean();
		bean.setN("456");
		bean.setInsertion("5");

		System.out.println(getMax());
	}

	@Override
	public void setBean(JudgeBean bean) {
		this.bean = bean;

	}


	@Override
	public String getMax() {
		boolean neg = false;
		String n = bean.getN();
		String insertion = bean.getInsertion();
		
		if(n==null || insertion==null) {
			return "input is null";
		}
		
		if(n.equals("") || insertion.equals("") || n.equals("null") || insertion.equals("null")) {
			System.out.printf("n=%s , in=%s",n,insertion);
			return "number format is not correct";
		}
		
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

		return String.valueOf(Integer.parseInt((neg ? "-" : "")
				+ Arrays.stream(ints).mapToObj(String::valueOf).reduce((x1, x2) -> x1 + "" + x2).orElse("")));

	}

}
