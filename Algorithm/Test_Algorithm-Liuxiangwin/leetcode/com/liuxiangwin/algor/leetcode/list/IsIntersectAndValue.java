package com.liuxiangwin.algor.leetcode.list;

import com.liuxiangwin.algor.leetcode.uitl.LinkListUtil;
import com.liuxiangwin.algor.leetcode.uitl.ListNode;

public class IsIntersectAndValue {
	/**
	 * 
	 * 
	 * 而我们很容易能得到链表的最后一个节点，所以这成了我们简化解法的 一个主要突破口。那么，我们只要判断两个链表的尾指针是否相等。
	 * 相等，则链表相交；否则，链表不相交。 所以，先遍历第一个链表，记住最后一个节点。 然后遍历第二个链表，到最后一个节点时和第一个链表的
	 * 最后一个节点做比较，如果相同，则相交，否则，不相交。
	 * 
	 * 这样我们就得到了一个时间复杂度，它为O((Length(h1) + Length(h2))， 而且只用了一个额外的指针来存储最后一个节点。
	 * 这个方法时间复杂度为线性O(N)，空间复杂度为O(1)， 显然比解法三更胜一筹。@param h1
	 * 
	 * @param head2
	 * @return
	 */
	// 判断两个链表是否相交
	private boolean isIntersect(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null)
			return false;
		while (head1.next != null) {
			head1 = head1.next;
		}
		while (head2.next != null) {
			head2 = head2.next;
		}
		if (head1 == head2)
			return true; // 尾节点是否相同
		else
			return false;
	}

	/**
	 * 
	 * 分析：采用对齐的思想。计算两个链表的长度 L1 , L2 分别用两个指针 p1 , p2 指向两个链表的头， 然后将较长链表的 p1（假设为
	 * p1）向后移动L2 - L1个节点， 然后再同时向后移动p1 , p2，直到 p1 = p2。相遇的点就是相交的第一个节点。
	 */

	// 两链表相交的第一个公共节点
	private ListNode findIntersectNode(ListNode head1, ListNode head2) {
		int len1 = getListNodeLength(head1); // 求链表长度
		int len2 = getListNodeLength(head2);
		// 对齐两个链表
		if (len1 > len2) {
			for (int i = 0; i < len1 - len2; i++)
				head1 = head1.next;
		} else {
			for (int i = 0; i < len2 - len1; i++)
				head2 = head2.next;
		}
		while (head1 != null) {
			if (head1 == head2)
				return head1;
			head1 = head1.next;
			head2 = head2.next;
		}
		return null;
	}

	// 判断两个带环链表是否相交
	private boolean isIntersectWithLoop(ListNode h1, ListNode h2) {
		ListNode circleNode1, circleNode2;
		if (!LinkListUtil.hasCycle(h1)) // 判断链表带不带环，并保存环内节点
			return false; // 不带环，异常退出
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
