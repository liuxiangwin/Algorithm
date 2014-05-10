package com.liuxiangwin.Algorithm.question.test;

import java.util.ArrayList;
import java.util.Random;

public class Hat {

	public static enum style {
		s1, s2, s3
	};

	public static enum col {
		red, green, blue
	};

	public style hatstyle;
	public col hatcol;

	public Hat(style sa, col ca) {
		hatstyle = sa;
		hatcol = ca;
	}

	public static void main(String[] args) {
		ArrayList<Hat> h = new ArrayList<Hat>();
		h.add(new Hat(style.s1, col.red));
		h.add(new Hat(style.s1, col.green));
		h.add(new Hat(style.s1, col.blue));
		h.add(new Hat(style.s2, col.green));
		h.add(new Hat(style.s2, col.red));
		h.add(new Hat(style.s3, col.blue));
		style prev = h.get(0).hatstyle;
		System.out.println("use hat with style " + prev + " and color "
				+ h.get(0).hatcol);
		int i = 0;
		while (i < 12) {
			Random rand = new Random();
			int r = rand.nextInt(h.size());
			if (h.get(r).hatstyle == prev) {
				r = rand.nextInt(h.size());
			} else {
				i++;
				prev = h.get(r).hatstyle;
				System.out.println("use hat with style " + prev + " and color "
						+ h.get(r).hatcol);
			}
		}
	}

}
