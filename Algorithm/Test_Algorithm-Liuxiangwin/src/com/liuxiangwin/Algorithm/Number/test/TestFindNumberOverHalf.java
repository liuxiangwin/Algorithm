package com.liuxiangwin.Algorithm.Number.test;

public class TestFindNumberOverHalf {
     /**
      * �ٸ����ӣ��ٶ�����Ϊ{0, 1, 2, 1, 1}����������˼·ִ�еĲ������£�

	1.��ʼʱ��candidate��������0��nTimes��ʼ��Ϊ1��
	
	2.Ȼ�����������1��������0��ͬ����nTimes��1��Ϊ0��
	
	3.��ΪnTimes��Ϊ��0����candidate������һ��������������2��
	��nTimes��������Ϊ1��
	
	4.������������4������1����֮ǰcandidate���������2��ͬ��
	��nTimes��1��Ϊ0��
	
	5.��nTimes�ٴα���Ϊ��0����������candidate������һ��������������1��
	��nTimes��������Ϊ1����󷵻صľ������һ�ΰ�nTimes��Ϊ1������1��
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
		 int[] numbers ={0, 1, 2,1};
		 int result = teHalf.FindOneNumber(numbers, numbers.length);
		 System.out.println(result);
	 }
}
