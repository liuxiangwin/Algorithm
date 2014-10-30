package com.liuxiangwin.algor.leetcode.uitl;





public class LinkListUtil {
	
	public static boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode fast,slow; 
		fast = slow = head;
        //只要有环就会在里面循环
		while (fast!=null && fast.next != null) {
			
			fast = fast.next.next;
			slow = slow.next;
			
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}
	
	public static ListNode getLoopOverlapNode(ListNode head) {
		ListNode loopOverlapNode;
		if (head == null) {
			return null;
		}
		ListNode fast,slow; 
		fast = slow = head;
		while (fast!=null && fast.next != null) {
			
			fast = fast.next.next;
			slow = slow.next;
			
			if (fast == slow) {
				loopOverlapNode = fast;
				return fast;
			}
		}
		return null;
	}
}
