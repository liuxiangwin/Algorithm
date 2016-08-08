package com.liuxiangwin.algor.leetcode.number;

public class BitMap {
	/*
	 * .bitmapԭ�� ��ν��Bit-map������һ��bitλ�����ĳ��Ԫ�ض�Ӧ��Value��
	 * ��Key���Ǹ�Ԫ�ء����ڲ�����BitΪ��λ���洢���ݣ�����ڴ洢�ռ䷽�棬���Դ���ʡ��
	 * ��������Ҫ��0-7�ڵ�5��Ԫ��(4,7,2,5,3)����
	 * ���������ЩԪ��û���ظ�������ô���ǾͿ��Բ���Bit-map�ķ������ﵽ�����Ŀ�ġ�Ҫ��ʾ8����
	 * �����Ǿ�ֻ��Ҫ8��Bit��1Bytes�����������ǿ���1Byte�Ŀռ䣬����Щ�ռ������Bitλ����Ϊ0������ͼ��
	 * 
	 *	http://blog.csdn.net/qll125596718/article/details/6905476
	 * 
	 * Ȼ�������5��Ԫ�أ����ȵ�һ��Ԫ����4����ô�Ͱ�4��Ӧ��λ��Ϊ1�������������� p+(i/8)|(0��01<<(i%8))
	 * ��Ȼ������Ĳ����漰��Big
	 * -ending��Little-ending�����������Ĭ��ΪBig-ending��,��Ϊ�Ǵ��㿪ʼ�ģ�����Ҫ�ѵ���λ��Ϊһ������ͼ����
	 * 
	 * 
	 * 
	 * Ȼ���ٴ���ڶ���Ԫ��7�����ڰ�λ��Ϊ1,�������ٴ��������Ԫ�أ�һֱ������������е�Ԫ�أ�����Ӧ��λ��Ϊ1����ʱ����ڴ��Bitλ��״̬���£�
	 * 
	 * 
	 * 
	 * Ȼ���������ڱ���һ��Bit���򣬽���λ��һ��λ�ı�������2��3��4��5��7���������ʹﵽ�������Ŀ�ġ�����Ĵ��������һ��BitMap���÷�������
	 * ��
	 */
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
		//                     ��λ��                         |  ��ǰ���ְ�32�֣������Ǹ�λ����
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
	// &    |1|1|1|0|1|1|1|1| �����1����4λȡ��
	// ������������������������������������������������������������������������������������
	//      |0|1|1|0|0|1|0|0| //4��Ҫ�����bitλ����Ϊ0��

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
		System.out.println(1/32);
		System.out.println(1%32);
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
