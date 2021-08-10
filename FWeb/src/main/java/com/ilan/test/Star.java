package com.ilan.test;

public class Star {
	static final String STAR = "*";
	static final String SPACE = " ";
	static StringBuilder stars = new StringBuilder();

	public static void main(String[] args) {
//		for (int i = 3; i < 8; i++) {
//			graph(i, i % 2 == 0);
//		}
		

	}


	static void graph(int n, boolean isFill) {
		graph(n, isFill, 0);
	}


	static void graph(int n, boolean isFill, int m) {
		int idx = 0;
		boolean isProduce = true;
		while (isProduce) {
			isProduce = false;
			StringBuilder starline = new StringBuilder();
			for (int pl = 0, pr = n - 1+m; pl <= pr; pl++, pr--) {
				String s = null;
				if (pl == idx) {
					isProduce = true;
					s = STAR;
				} else {
					s = pl > idx && isFill ? STAR : SPACE;
				}

				starline.insert(pl, s);
				if (pl != pr) {
					starline.insert(pl + 1, s);
				}
			}

			if (isProduce) {
				if (idx == 0) {
					stars = starline;
				} else {
					stars.insert(0, starline + "\n").append("\n" + starline);
				}
			}

			idx++;
		}
		System.out.printf("\n%d, isFill=%s\n\n%s\n", n, isFill, stars.toString());
		
	}

}
