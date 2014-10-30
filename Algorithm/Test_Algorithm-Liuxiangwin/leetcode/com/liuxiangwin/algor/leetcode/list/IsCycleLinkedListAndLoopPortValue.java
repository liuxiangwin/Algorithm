package com.liuxiangwin.algor.leetcode.list;
// Author:   Li Long, 1988lilong@163.com
// Date:     Apr 18, 2014
// Source:   http://oj.leetcode.com/problems/linked-list-cycle-ii/
// Analysis: http://blog.csdn.net/lilong_dream/article/details/20074373

// Given a linked list, return the node where the cycle begins. 
//If there is no cycle, return null.
//
// Follow up:
////ʹ�ÿ���ָ�롣��������ڻ�����ָ����ڻ�����������ʱ����ָ���ƻ�ͷ��㣬
//��ָ������ͬ���ٶ��ƶ����ڻ���ʼ�Ľڵ㴦�ٴ���������֤���ԣ�

public class IsCycleLinkedListAndLoopPortValue {
	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode fast,slow; 
		fast = slow = head;

		while (fast!=null &&fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				break;
			}
		}
		
		if (fast != slow)	return null;
			fast = head;
		while (fast != slow) {// ��ָ���ͷ��ʼ�ߣ�������Ϊ1
			fast = fast.next; // //����������Ϊ��ڵ�
			slow = slow.next;
		}
		return fast;
		
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n2;

		IsCycleLinkedListAndLoopPortValue slt = new IsCycleLinkedListAndLoopPortValue();
		ListNode result = slt.detectCycle(n1);
		System.out.println(result.val);
	}
}