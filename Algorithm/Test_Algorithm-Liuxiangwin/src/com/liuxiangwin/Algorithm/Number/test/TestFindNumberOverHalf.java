package com.liuxiangwin.Algorithm.Number.test;

public class TestFindNumberOverHalf {
     /**
      * 举个例子，假定数组为{0, 1, 2, 1, 1}，按照上述思路执行的步骤如下：

	1.开始时，candidate保存数字0，nTimes初始化为1；
	
	2.然后遍历到数字1，与数字0不同，则nTimes减1变为0；
	
	3.因为nTimes变为了0，故candidate保存下一个遍历到的数字2，
	且nTimes被重新设为1；
	
	4.继续遍历到第4个数字1，与之前candidate保存的数字2不同，
	故nTimes减1变为0；
	
	5.因nTimes再次被变为了0，故我们让candidate保存下一个遍历到的数字1，
	且nTimes被重新设为1。最后返回的就是最后一次把nTimes设为1的数字1。
      * @param numbers
      * @param length
      * @return
      */
	private int FindOneNumber(int[] numbers, int length) {
		int candidate = numbers[0];
		int nTimes = 1;
		for (int i = 1; i < length; i++) {
			if (nTimes == 0) {
				candidate = numbers[i];
				nTimes = 1;
			} else {
				if (candidate == numbers[i])
					nTimes++;
				else
					nTimes--;
			}
		}
		return candidate;
	}
	
	
	 public static void main(String args[])
	 {
		 TestFindNumberOverHalf teHalf = new TestFindNumberOverHalf();
		 int[] numbers ={0, 1, 2,1,1};
		 int result = teHalf.FindOneNumber(numbers, numbers.length);
		 System.out.println(result);
		 
		 int[] numbers2 ={5, 1, 2, 5, 2, 5, 5};
		 int result2 = teHalf.FindOneNumber(numbers2, numbers2.length);
		 System.out.println(result2);
		  
	 }
	 
	 //字符串匹配的Boyer-Moore算法
	 //http://www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html
		 
	//字符串匹配的KMP算法
	//http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html

	 

}
