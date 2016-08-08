package com.liuxiangwin.algor.leetcode.number;

public class BitMap {
	/*
	 * .bitmap原理 所谓的Bit-map就是用一个bit位来标记某个元素对应的Value，
	 * 而Key即是该元素。由于采用了Bit为单位来存储数据，因此在存储空间方面，可以大大节省。
	 * 假设我们要对0-7内的5个元素(4,7,2,5,3)排序（
	 * 这里假设这些元素没有重复）。那么我们就可以采用Bit-map的方法来达到排序的目的。要表示8个数
	 * ，我们就只需要8个Bit（1Bytes），首先我们开辟1Byte的空间，将这些空间的所有Bit位都置为0，如下图：
	 * 
	 *	http://blog.csdn.net/qll125596718/article/details/6905476
	 * 
	 * 然后遍历这5个元素，首先第一个元素是4，那么就把4对应的位置为1（可以这样操作 p+(i/8)|(0×01<<(i%8))
	 * 当然了这里的操作涉及到Big
	 * -ending和Little-ending的情况，这里默认为Big-ending）,因为是从零开始的，所以要把第五位置为一（如下图）：
	 * 
	 * 
	 * 
	 * 然后再处理第二个元素7，将第八位置为1,，接着再处理第三个元素，一直到最后处理完所有的元素，将相应的位置为1，这时候的内存的Bit位的状态如下：
	 * 
	 * 
	 * 
	 * 然后我们现在遍历一遍Bit区域，将该位是一的位的编号输出（2，3，4，5，7），这样就达到了排序的目的。下面的代码给出了一个BitMap的用法：排序
	 * 。
	 */
	private int numSize;
	private int array[];
	public BitMap(final int size) {
		this.numSize = size;
		int sLen = ((numSize % 32) == 0) ? numSize / 32 : numSize / 32 + 1;
		this.array = new int[sLen];
	}

	public void set1(int pos) {
		array[pos >> 5] = array[pos >> 5] | (1 << (pos % 32)); // 给相应位置1
		//等同于 array[pos/32]= array[pos/32] | (1 << (31 - pos % 32));
		//                     槽位号                         |  当前数字按32分，看在那个位置有
	}

	public boolean get(int pos) {
		return (((array[pos >> 5]>>(pos % 32))) & 0x0001)==1?true:false;

		//这里面的值可能是1 也可能是2 ,0x0001表示1		
		//return (array[pos >> 5] & (1 << (pos % 32)))== 0?false :true;				
	}
	
	public int get2(int pos) {
		return array[pos >> 5] & (1 << (pos % 32));
	}
	
	// 比如要将当前4对应的bit位置0的话，只需要1左移4位取反与B[0] & 即可。

	// Index 4
	// B[0] |0|1|1|1|0|1|0|0|
	// &    |1|1|1|0|1|1|1|1| 这个是1左移4位取反
	// ——————————————————————————————————————————
	//      |0|1|1|0|0|1|0|0| //4需要的这个bit位上置为0了

	public static Byte Clear(int idex) {
		// 相当于 i%8 的功能
		// int shift = i & 0x07;
		Byte byt = Byte.valueOf("+01110100");

		// 计算应该放数组的下标
		// int arrindex = i >> 3;

		// 则将当前byte中的指定bit位取0，&后其他对方数组bit位必然不变，这就是 1 的妙用
		int bitPos = ~(1 << idex);
		int bytValue = byt.intValue();
		bytValue &= bitPos;

		return byt;
	}
	
	public static void main(String[] args) {
		System.out.println(1/32);
		System.out.println(1%32);
		// 也可以使用bitset
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
