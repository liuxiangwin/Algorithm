package com.liuxiangwin.algor.leetcode.number;

public class CopyOfBitMap {
	
	private byte[] bits;
    private int size;


    public CopyOfBitMap(int n) {
        size = n;
        bits = new byte[(int) Math.ceil(
        		(double) n / (double) 8)];
     
    }

    private void set1(int pos) {
        bits[pos /8] = (byte) ((bits[pos /8] | (byte) (1 << (pos % 8))));        
    }
 
    private boolean get(int pos) {
        return ((byte) ((bits[pos /8] & (byte) (1 << (pos % 8))))) == 0?false :true;
    	
    }
	
  
    private boolean get2(int i) {
        int index = i / Byte.SIZE;
        byte mask = (byte) ((bits[index] & (byte) (1 << (Byte.SIZE - 1 - (i % Byte.SIZE)))));
        return (bits[index] & mask) != 0;
    }
	
	public static void main(String[] args) {
		CopyOfBitMap bitMap = new CopyOfBitMap(33);
		int sortArray[] = new int[] { 1, 4, 32, 2, 6, 9};
		for (int num: sortArray) {
			bitMap.set1(num);
		}
		//After sort
		for (int i = 0; i < bitMap.size; i++) {
			if (bitMap.get(i)) {
		     //if(bitMap.get2(i) !=0){  	
				System.out.print((i) + " ");
			}			
		}
		System.out.println("");
        //Search function
		int searchNum1 = 32;
		int searchNum2 = 54;
		boolean result1= bitMap.get(32);
		//boolean result2= bitMap.get(54);
	    System.out.println("the number "+searchNum1+" "+ result1+ " in array");
	    //System.out.println("the number "+searchNum2+" "+ result2+ " in array");
	}
}
