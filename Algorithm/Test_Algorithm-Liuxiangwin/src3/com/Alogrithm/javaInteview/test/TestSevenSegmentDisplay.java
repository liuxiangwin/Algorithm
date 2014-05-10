package com.Alogrithm.javaInteview.test;

public class TestSevenSegmentDisplay {
	public static void main(String args[]) {
		int num = 9;
		String i = "", j = "", k = "";
		if (num == 1) {
			i = "";
			j = "|";
			k = "|";
		} else if (num == 2) {
			i = " __";
			j = " __|";
			k = "|__";
		} else if (num == 3) {
			i = " __";
			j = " __|";
			k = " __|";
		} else if (num == 4) {
			i = "";
			j = "|__|";
			k = "   |";
		} else if (num == 5) {
			i = " __";
			j = "|__";
			k = " __|";
		} else if (num == 6) {
			i = " __";
			j = "|__";
			k = "|__|";
		} else if (num == 7) {
			i = " __";
			j = "   |";
			k = "   |";
		} else if (num == 8) {
			i = " __";
			j = "|__|";
			k = "|__|";
		} else if (num == 9) {
			i = " __";
			j = "|__|";
			k = " __|";
		} else if (num == 0) {
			i = " __";
			j = "|  |";
			k = "|__|";
		}
		System.out.println("\t" + i);
		System.out.println("\t" + j);
		System.out.println("\t" + k);
		System.out.println("\t");
		
		String s="something";
		s.intern();
	}
	



}
