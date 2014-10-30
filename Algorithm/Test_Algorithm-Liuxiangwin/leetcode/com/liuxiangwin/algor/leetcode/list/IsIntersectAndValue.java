package com.liuxiangwin.algor.leetcode.list;

import com.liuxiangwin.algor.leetcode.uitl.LinkListUtil;
import com.liuxiangwin.algor.leetcode.uitl.ListNode;

public class IsIntersectAndValue {
	/**
	 * 
	 * 
	 * �����Ǻ������ܵõ���������һ���ڵ㣬������������Ǽ򻯽ⷨ�� һ����Ҫͻ�ƿڡ���ô������ֻҪ�ж����������βָ���Ƿ���ȡ�
	 * ��ȣ��������ཻ�����������ཻ�� ���ԣ��ȱ�����һ��������ס���һ���ڵ㡣 Ȼ������ڶ������������һ���ڵ�ʱ�͵�һ�������
	 * ���һ���ڵ����Ƚϣ������ͬ�����ཻ�����򣬲��ཻ��
	 * 
	 * �������Ǿ͵õ���һ��ʱ�临�Ӷȣ���ΪO((Length(h1) + Length(h2))�� ����ֻ����һ�������ָ�����洢���һ���ڵ㡣
	 * �������ʱ�临�Ӷ�Ϊ����O(N)���ռ临�Ӷ�ΪO(1)�� ��Ȼ�Ƚⷨ����ʤһ�@param h1
	 * 
	 * @param h2
	 * @return
	 */
	// �ж����������Ƿ��ཻ
	private boolean isIntersect(ListNode h1, ListNode h2) {
		if (h1 == null || h2 == null)
			return false;
		while (h1.next != null) {
			h1 = h1.next;
		}
		while (h2.next != null) {
			h2 = h2.next;
		}
		if (h1 == h2)
			return true; // β�ڵ��Ƿ���ͬ
		else
			return false;
	}

	/**
	 * 
	 * ���������ö����˼�롣������������ĳ��� L1 , L2 �ֱ�������ָ�� p1 , p2 ָ�����������ͷ�� Ȼ�󽫽ϳ������ p1������Ϊ
	 * p1������ƶ�L2 - L1���ڵ㣬 Ȼ����ͬʱ����ƶ�p1 , p2��ֱ�� p1 = p2�������ĵ�����ཻ�ĵ�һ���ڵ㡣
	 */

	// �������ཻ�ĵ�һ�������ڵ�
	private ListNode findIntersectNode(ListNode h1, ListNode h2) {
		int len1 = getListNodeLength(h1); // ��������
		int len2 = getListNodeLength(h2);
		// ������������
		if (len1 > len2) {
			for (int i = 0; i < len1 - len2; i++)
				h1 = h1.next;
		} else {
			for (int i = 0; i < len2 - len1; i++)
				h2 = h2.next;
		}
		while (h1 != null) {
			if (h1 == h2)
				return h1;
			h1 = h1.next;
			h2 = h2.next;
		}
		return null;
	}

	// �ж��������������Ƿ��ཻ
	private boolean isIntersectWithLoop(ListNode h1, ListNode h2) {
		ListNode circleNode1, circleNode2;
		if (!LinkListUtil.hasCycle(h1)) // �ж�������������������滷�ڽڵ�
			return false; // ���������쳣�˳�
		if (!LinkListUtil.hasCycle(h2))
			return false;

		circleNode1 = LinkListUtil.getLoopOverlapNode(h1);
		circleNode2 = LinkListUtil.getLoopOverlapNode(h2);
		ListNode temp = circleNode2.next;
		while (temp != circleNode2) {
			if (temp == circleNode1)
				return true;
			temp = temp.next;
		}
		return false;
	}

	private int getListNodeLength(ListNode node) {
		int length = 1;
		while (node.next != null) {
			length++;
		}
		return length;
	}

}
