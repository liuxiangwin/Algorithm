package com.liuxiangwin.algor.leetcode.number;

public class BitMap {
	private int numSize;
	private int array[];
	public BitMap(final int size) {
		this.numSize = size;
		int sLen = ((numSize % 32) == 0) ? numSize / 32 : numSize / 32 + 1;
		this.array = new int[sLen];
	}

	public void set1(int pos) {
		array[pos >> 5] = array[pos >> 5] | (1 << (pos % 32)); // ����Ӧλ��1
		//��ͬ�� array[pos/32]= array[pos/32] | (1 << (31 - pos % 32));
	}

	public boolean get(int pos) {
		return (((array[pos >> 5]>>(pos % 32))) & 0x0001)==1?true:false;

		//�������ֵ������1 Ҳ������2 ,0x0001��ʾ1		
		//return (array[pos >> 5] & (1 << (pos % 32)))== 0?false :true;				
	}
	
	public int get2(int pos) {
		return array[pos >> 5] & (1 << (pos % 32));
	}
	
	// ����Ҫ����ǰ4��Ӧ��bitλ��0�Ļ���ֻ��Ҫ1����4λȡ����B[0] & ���ɡ�

	// Index 4
	// B[0] |0|1|1|1|0|1|0|0|
	// & |1|1|1|0|1|1|1|1| �����1����4λȡ��
	// ������������������������������������������������������������������������������������
	// |0|1|1|0|0|1|0|0| //4��Ҫ�����bitλ����Ϊ0��

	public static Byte Clear(int idex) {
		// �൱�� i%8 �Ĺ���
		// int shift = i & 0x07;
		Byte byt = Byte.valueOf("+01110100");

		// ����Ӧ�÷�������±�
		// int arrindex = i >> 3;

		// �򽫵�ǰbyte�е�ָ��bitλȡ0��&�������Է�����bitλ��Ȼ���䣬����� 1 ������
		int bitPos = ~(1 << idex);
		int bytValue = byt.intValue();
		bytValue &= bitPos;

		return byt;
	}
	
	public static void main(String[] args) {
		// Ҳ����ʹ��bitset
		BitMap bitMap = new BitMap(1024);
		int sortArray[] = new int[] { 1, 4, 32, 2, 6, 9 ,4};
		for (int num: sortArray) {
			bitMap.set1(num);
		}
		//After sort
		for (int i = 0; i < bitMap.numSize; i++) {
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
		boolean result2= bitMap.get(54);
	    System.out.println("the number "+searchNum1+" "+ result1+ " in array");
	    System.out.println("the number "+searchNum2+" "+ result2+ " in array");
	}
}
