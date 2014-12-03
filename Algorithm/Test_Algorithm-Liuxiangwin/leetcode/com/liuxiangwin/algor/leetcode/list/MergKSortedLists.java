package com.liuxiangwin.algor.leetcode.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MergKSortedLists {

	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists.size() == 0)
			return null;
		return mergeKLists(lists, 0, lists.size() - 1);
	}

	public ListNode mergeKLists(List<ListNode> lists, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			return merge(
					mergeKLists(lists, left, mid),
					mergeKLists(lists, mid + 1, right));
		}
		return lists.get(left);
	}

	public ListNode merge(ListNode m, ListNode n) {
		ListNode head = new ListNode(0);
		ListNode result = head;
		while (m != null && n != null) {
			if (m.val < n.val) {
				result.next = m;
				result = result.next;
				m = m.next;
			} else {
				result.next = n;
				result = result.next;
				n = n.next;
			}
		}
		if (m != null)
			result.next = m;
		else
			result.next = n;
		return head.next;
	}
	
	public void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		MergKSortedLists merge = new MergKSortedLists();
		
		List<ListNode> lists = new ArrayList<ListNode>();
		for(int i=0;i<5;i++)
		{
			Random rand = new Random();			
			ListNode var = new ListNode(rand.nextInt(6) + rand.nextInt(3)<<1);
			lists.add(var);
			System.out.println(var.val);	     	
		}
		
		ListNode head = merge.mergeKLists(lists);
		merge.printList(head);

	}

}
