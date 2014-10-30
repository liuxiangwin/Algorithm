package com.liuxiangwin.algor.leetcode.list;

public class LinkListIsIntersect {
	/**
	 * 
	 * 进一步考虑“如果两个没有环的链表相交于某一节点，
	 * 那么在这个节点之后的所有节点都是两个链表共有的”这个特点，\
	 * 我们可以知道，如果它们相交，则最后一个节点一定是共有的。
	 * 
	 * 而我们很容易能得到链表的最后一个节点，所以这成了我们简化解法的
	 * 一个主要突破口。那么，我们只要判断两个链表的尾指针是否相等。
	 * 相等，则链表相交；否则，链表不相交。
		所以，先遍历第一个链表，记住最后一个节点。
             然后遍历第二个链表，到最后一个节点时和第一个链表的
             最后一个节点做比较，如果相同，则相交，否则，不相交。
             这样我们就得到了一个时间复杂度，它为O((Length(h1) + Length(h2))，
             而且只用了一个额外的指针来存储最后一个节点。
             这个方法时间复杂度为线性O(N)，空间复杂度为O(1)，
             显然比解法三更胜一筹。@param h1
	 * @param h2
	 * @return
	 */
	
	private boolean isIntersect(ListNode h1,ListNode h2)
	{
		if (h1 == null || h2 == null)
			return false; // 异常判断
		while (h1.next != null) {
			h1 = h1.next;
		}
		while (h2.next != null) {
			h2 = h2.next;
		}
		if (h1 == h2)
			return true; // 尾节点是否相同
		else
			return false;
	}

}
