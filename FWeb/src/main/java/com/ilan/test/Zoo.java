package com.ilan.test;

public class Zoo {
	static int minLimit = 30;// 團體折扣最少人數
	static int priceType1 = 60;
	static int priceType2 = 30;
	static int priceType3 = 0;
	static double priceTypeX = 0.8;// 假如團體打8折

	public static void main(String[] args) {
		int[] group1 = new int[30];
		int[] group2 = new int[10];
		int[] group3 = new int[1];

		creatGroup(group1);
		creatGroup(group2);
		creatGroup(group3);

		info(group1);
		System.out.println("group1 的總金額=" + calcPriceForeachMember(group1));

		System.out.println();
		info(group2);
		System.out.println("group2 的總金額=" + calcPriceForeachMember(group2));

		System.out.println();
		info(group3);
		System.out.println("group3 的總金額=" + calcPriceForeachMember(group3));

	}

	static void creatGroup(int[] group) {
		for (int g = 0; g < group.length; g++) {
			group[g] = (int) (Math.random() * 3 + 1);
		}
	}

	static void info(int[] group) {
		for (int i = 0; i < group.length; i++) {
			if (i % 10 == 0) {
				System.out.println();
			}
			System.out.printf("%d[%d=%d] ", i, group[i], calcPrice(group[i], group.length >= minLimit));
		}
		System.out.println();
	}

	static int calcPriceForeachMember(int[] group) {
		int total = 0;
		for (int member : group) {
			total += calcPrice(member, group.length >= minLimit);
		}
		return total;
	}

	static int calcPrice(int type, boolean isExceed) {

		int price = 0;

		switch (type) {
		case 3:
			price = priceType3;
			break;
		case 2:
			price = priceType2;
			break;
		case 1:
			price = isExceed ? (int) (priceType1 * priceTypeX) : priceType1;
			break;
		default:
			price = priceType1;
			break;
		}

		return price;
	}

}
